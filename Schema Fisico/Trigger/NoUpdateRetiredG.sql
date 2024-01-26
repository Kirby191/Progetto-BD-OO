CREATE OR REPLACE FUNCTION NoUpdateRetiredG()
RETURNS TRIGGER AS $$
BEGIN
	IF (OLD.Ritirato) THEN
	
		RAISE EXCEPTION 'Impossibile eseguire la modifica. Giocatore % ritirato!', NEW.SSN;

	END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER NoUpdateRetiredG
BEFORE UPDATE ON Giocatore
FOR EACH ROW
WHEN (NEW.Ritirato = FALSE)
EXECUTE FUNCTION NoUpdateRetiredG();
