CREATE OR REPLACE FUNCTION InsVFromOdA()
RETURNS TRIGGER AS $$
DECLARE
    Controllo Trofeo%ROWTYPE;
    Giocatore CURSOR FOR
        SELECT SSN
        FROM Partecipa_In
        WHERE NomeSquadra = NEW.NomeSquadra;
    Scorr RECORD;
BEGIN
    SELECT * INTO Controllo
    FROM TROFEO
    WHERE NomeTrofeo = NEW.NomeTrofeo AND Anno = NEW.Anno;

    IF Controllo.Squadra IS NULL THEN
        RAISE EXCEPTION 'Trofeo % non di squadra, impossibile inserire', NEW.NomeTrofeo;
    END IF;

    OPEN Giocatore;

    LOOP
        FETCH Giocatore INTO Scorr;
        EXIT WHEN NOT FOUND;

        INSERT INTO Vincere VALUES(Scorr.SSN, NEW.NomeTrofeo, NEW.Anno);
    END LOOP;

    CLOSE Giocatore;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Creazione del trigger separatamente dalla definizione della funzione
CREATE TRIGGER InsVFromOdA
AFTER INSERT ON Ottenuto_Da
FOR EACH ROW
EXECUTE FUNCTION InsVFromOdA();

