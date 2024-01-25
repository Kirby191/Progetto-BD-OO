CREATE OR REPLACE FUNCTION CheckANotRetiredBUpdate()
RETURNS TRIGGER AS $$
DECLARE
Controllo Allenatore%ROWTYPE;
BEGIN
	SELECT * INTO Controllo
	FROM Allenatore
	WHERE SSN = NEW.SSN_Allenatore;
	
	IF FOUND AND Controllo.FineA IS NOT NULL THEN
		RAISE EXCEPTION 'Allenatore % ha terminato la sua carriera, non può allenare la squadra', NEW.SSN_Allenatore;
	END IF;
	
	IF NOT FOUND THEN
		RAISE EXCEPTION 'Si sta provando ad inserire SSN_Allenatore inesistente: %', NEW.SSN_Allenatore;
	END IF;

	RETURN NEW;
END;
$$ Language plpgsql

CREATE TRIGGER CheckANotRetiredBUpdate
BEFORE UPDATE ON Squadra
FOR EACH ROW
WHEN (NEW.SSN_Allenatore <> OLD.SSN_Allenatore)
EXECUTE FUNCTION CheckANotRetiredBUpdate();











