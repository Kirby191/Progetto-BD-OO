CREATE OR REPLACE FUNCTION CheckDIsNotRetired()
RETURNS TRIGGER AS $$
BEGIN 
	IF((SELECT FineD
	    FROM Dirigente
	    WHERE SSN = New.SSN_Dirigente) IS NOT NULL) THEN 
		RAISE EXCEPTION 'Il Dirigente % non può essere inserito perchè si è ritirato', NEW.SSN_Dirigente;
	END IF;
	RETURN NEW;
END;
$$ Language plpgsql;

CREATE TRIGGER check_d_is_not_retired
BEFORE INSERT ON Dirige
FOR EACH ROW
EXECUTE FUNCTION CheckDIsNotRetired();