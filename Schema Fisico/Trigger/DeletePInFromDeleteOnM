CREATE OR REPLACE FUNCTION DeletePInFromDeleteOnM()
RETURNS TRIGGER AS $$
BEGIN
    DECLARE
        Controllo RECORD;
    BEGIN
        SELECT * INTO Controllo
        FROM Partecipa_in AS P
        WHERE P.SSN = OLD.SSN AND P.NomeSquadra = OLD.NomeSquadra;

        IF Controllo.SSN IS NOT NULL THEN
            DELETE FROM Partecipa_in
            WHERE SSN = OLD.SSN AND NomeSquadra = OLD.NomeSquadra;
        END IF;

    END;
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER DeletePInFromDeleteOnM
AFTER DELETE ON Militanza
FOR EACH ROW
EXECUTE FUNCTION DeletePInFromDeleteOnM();

