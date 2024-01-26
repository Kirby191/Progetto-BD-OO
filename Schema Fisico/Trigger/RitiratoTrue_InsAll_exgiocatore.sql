/*quando inseriamo un allenatore controlliamo se in passato è stato un giocatore, se era un giocatore controlliamo che nella tabella giocatore abbia l'attributo ritirato a TRUE, se non la tiene allora gliela inseriamo noi*/
-- Vittorio: il controllo era un po' troppo eccessivo. Ho anche modificato di poco la logica in quanto se io inserisco un giocatore come
-- allenatore devo controllare che i suoi valori vengano rispettati. Stessa cosa da fare se faccio update sul giocatore. Se elimino
-- un giocatore allora deve essere CASCADE

CREATE OR REPLACE FUNCTION ExGiocatoreA()
RETURNS TRIGGER AS $$
DECLARE
    Controllo RECORD;
BEGIN
    SELECT * INTO Controllo
    FROM Giocatore
    WHERE SSN = NEW.SSN;

    IF Controllo IS NOT NULL THEN
        IF Controllo.Nome <> NEW.Nome OR Controllo.Cognome <> NEW.Cognome OR Controllo.Sesso <> NEW.Sesso THEN
            RAISE EXCEPTION 'I dati inseriti ad SSN % non coincidono con quelli nella relazione Giocatore! Si prega di inserire i valori corretti.', NEW.SSN;
        END IF;

        UPDATE Giocatore
        SET Ritirato = TRUE
        WHERE SSN = NEW.SSN AND Ritirato = FALSE;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER ex_giocatoreA
AFTER INSERT ON Allenatore
FOR EACH ROW
EXECUTE FUNCTION ExGiocatoreA();
