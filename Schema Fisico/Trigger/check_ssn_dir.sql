--controllo che quando si inserisce un dirigente non abbia lo stesso ssn di un allenatore
CREATE OR REPLACE FUNCTION Check_ssn_Dir()
RETURNS TRIGGER AS $$
BEGIN 
	IF EXISTS(SELECT 1
		  FROM Allenatore 
		  WHERE SSN = New.SSN) THEN
		RAISE EXCEPTION 'Dirigente % presente in Allenatore!', NEW.SSN;
	END IF;
	RETURN NEW;
END;
$$ Language plpgsql;

CREATE TRIGGER check_ssn_Dir
BEFORE INSERT ON Dirigente
FOR EACH ROW
EXECUTE FUNCTION Check_ssn_Dir();
