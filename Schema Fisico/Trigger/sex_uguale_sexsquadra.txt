//controllo che quando inserisco un giocatore in partecipa_in sia dello stesso sesso degli altri giocatori

CREATE OR REPLACE FUNCTION CheckSexPInG()
RETURNS TRIGGER AS $$
DECLARE 
    sex_in CHAR(1);
    sex_squadra CHAR(1);
BEGIN 
    SELECT Sesso INTO sex_in
    FROM Giocatore
    WHERE SSN = NEW.SSN;

    SELECT Sesso INTO sex_squadra
    FROM Giocatore
    WHERE SSN IN (
        SELECT SSN 
        FROM Partecipa_in
        WHERE SSN <> NEW.SSN AND NomeSquadra = NEW.NomeSquadra
        LIMIT 1
    );

    IF sex_in <> sex_squadra THEN
        RAISE EXCEPTION 'Giocatore % non è dello stesso sesso dei giocatori della squadra(%)', NEW.SSN, sex_squadra;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER check_sex_pi_g
AFTER INSERT ON Partecipa_in
FOR EACH ROW
EXECUTE FUNCTION CheckSexPInG();
