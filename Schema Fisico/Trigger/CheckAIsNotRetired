CREATE OR REPLACE FUNCTION CheckInsertOnA()
RETURNS TRIGGER AS $$
DECLARE
CheckR Allenatore%ROWTYPE;
BEGIN
	SELECT * INTO CheckR
	FROM Allenatore
	WHERE SSN = NEW.SSN_Allenatore;

	IF FOUND AND CheckR.FineA IS NOT NULL THEN
		RAISE EXCEPTION 'Impossibile inserire! Allenatore % ha terminato la sua carriera', NEW.SSN_Allenatore;
	END IF;
	
	IF NOT FOUND THEN
		RAISE EXCEPTION 'Si sta provando ad inserire un Allenatore inesistente: %', NEW.SSN_Allenatore;	
	END IF;

	RETURN NEW;
END
$$ Language plpgsql;


CREATE TRIGGER CheckInsertOnA
BEFORE INSERT ON Squadra
FOR EACH ROW
WHEN (NEW.SSN_Allenatore IS NOT NULL)
EXECUTE FUNCTION CheckInsertOnA();
