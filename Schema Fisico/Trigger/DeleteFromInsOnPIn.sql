-- La funzione controlla che fondamentalmente tutto ciò che riguarda i problemi nell'inserimento di
partecipa_in venga risolto. Se la data_fine della militanza oppure 

CREATE OR REPLACE FUNCTION DeleteFromInsOnPIn()
RETURNS TRIGGER AS $$
DECLARE
    Giocatore RECORD;
BEGIN

    -- se ho due data_inizio che cominciano allo stesso momento, avrei un errore, ma quel caso non avverrà mai per il singolo giocatore.
    SELECT * INTO Giocatore
    FROM Militanza
    WHERE NomeSquadra = NEW.NomeSquadra AND SSN = NEW.SSN
    ORDER BY Data_Inizio DESC
    LIMIT 1;
    
    -- Se la tupla non esiste in Militanza, allora si sta inserendo una tupla in PartecipaIn non corretta.
    IF NOT FOUND THEN
        RAISE EXCEPTION 'Giocatore non trovato per NomeSquadra = % e SSN = %', NEW.NomeSquadra, NEW.SSN;
    END IF;

    IF Giocatore.Data_Fine IS NOT NULL THEN
        RAISE EXCEPTION 'Giocatore % ha terminato la sua militanza nella Squadra %.', NEW.SSN, NEW.NomeSquadra;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER DeleteFromInsOnPIn
AFTER INSERT ON Partecipa_in
FOR EACH ROW
EXECUTE FUNCTION DeleteFromInsOnPIn();
