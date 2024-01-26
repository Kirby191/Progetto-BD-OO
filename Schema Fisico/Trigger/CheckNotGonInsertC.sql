CREATE OR REPLACE FUNCTION CheckNotGonInsertC()
RETURNS TRIGGER AS $$
DECLARE
Controllo RECORD;
BEGIN
	SELECT * INTO Controllo
	FROM Giocatore
	WHERE SSN = NEW.SSN;
	
	IF Controllo IS NULL AND NEW.Ruolo = 'Giocatore' THEN
		RAISE EXCEPTION 'Il Giocatore con SSN % Non esiste.', NEW.SSN;
	END IF;
	
	IF Controllo IS NOT NULL AND NEW.Ruolo = 'Amministratore' THEN
		RAISE EXCEPTION 'Amministratore % non può essere anche un Giocatore', NEW.SSN;
	END IF;

	RETURN NEW;
END;
$$ Language plpgsql;

CREATE TRIGGER CheckCredenziali
BEFORE INSERT OR UPDATE ON Credenziali
FOR EACH ROW
EXECUTE FUNCTION CheckNotGonInsertC();