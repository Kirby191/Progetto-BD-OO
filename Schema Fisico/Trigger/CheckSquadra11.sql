CREATE OR REPLACE FUNCTION CheckSquadra11()
RETURNS TRIGGER AS $$
DECLARE
Count INTEGER;
BEGIN
    SELECT COUNT(*) INTO Count
    FROM Partecipa_In
    WHERE NomeSquadra = NEW.NomeSquadra;

    IF(Count < 11) THEN

	RAISE EXCEPTION 'I giocatori devono essere almeno 11 nella squadra %', NEW.NomeSquadra;

    END IF;
	
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Creazione del trigger separatamente dalla definizione della funzione
CREATE TRIGGER CheckSquadra11
BEFORE INSERT ON Ottenuto_da
FOR EACH ROW
EXECUTE FUNCTION CheckSquadra11();