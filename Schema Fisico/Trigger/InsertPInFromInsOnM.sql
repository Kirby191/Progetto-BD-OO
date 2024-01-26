-- la logica segue una serie di step: se il giocatore è ritirato, la militanza non si può inserire. Successivamente, controllo che
-- non esista una militanza con una data_fine ancora a null. Se ciò è vero, allora non posso inserire un'altra militanza.
-- controllato anche questo, inserisco inoltre la mia militanza in partecipa_in

CREATE OR REPLACE FUNCTION InsertPInFromInsOnM()
RETURNS TRIGGER AS $$
DECLARE
    NoDouble CURSOR FOR
        SELECT Data_Fine
        FROM Militanza
        WHERE SSN = NEW.SSN AND Data_Fine IS NULL AND ID_Militanza <> NEW.ID_Militanza
        ORDER BY Data_Inizio DESC
        LIMIT 1;
    Controllo DATE;
    Rit BOOLEAN;
BEGIN
    SELECT Ritirato INTO Rit
    FROM Giocatore
    WHERE SSN = NEW.SSN;

    IF Rit THEN
        RAISE EXCEPTION 'Giocatore % ritirato, impossibile inserire la Militanza', NEW.SSN;
    END IF;

    IF NEW.Data_Fine IS NULL THEN
        OPEN NoDouble;

        FETCH NoDouble INTO Controllo;

        IF NOT FOUND THEN
            CLOSE NoDouble;
            INSERT INTO Partecipa_in(SSN, NomeSquadra) VALUES (NEW.SSN, NEW.NomeSquadra);
        ELSE
            CLOSE NoDouble;
            RAISE EXCEPTION 'Militanza in corso per il giocatore % che è stato inserito.', NEW.SSN;
        END IF;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Creazione del trigger separatamente dalla definizione della funzione
CREATE TRIGGER InsertPInFromInsOnM
AFTER INSERT ON Militanza
FOR EACH ROW
EXECUTE FUNCTION InsertPInFromInsOnM();
