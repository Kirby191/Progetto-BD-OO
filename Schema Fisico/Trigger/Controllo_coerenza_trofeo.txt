--un trofeo che compare più volte nella tabella trofeo deve sempre essere o di squadra o individuale
CREATE OR REPLACE FUNCTION Controllo_coerenza_trofeo()
RETURNS TRIGGER AS $$
DECLARE
isSquadra BOOLEAN;
BEGIN
	--controllo prima l'esistenza del trofeo stesso nella tabella
	  SELECT Squadra INTO isSquadra
	  FROM Trofeo
	  WHERE NomeTrofeo = New.NomeTrofeo
	  LIMIT 1;

	  IF isSquadra is NOT NULL AND isSquadra <> New.Squadra THEN 
	
		RAISE EXCEPTION 'Trofeo % non del tipo giusto. Dovrebbe essere %', NEW.NomeTrofeo, isSquadra;
		
	  END IF;

	RETURN NEW;
END;
$$ Language plpgsql;

CREATE TRIGGER controllo_coerenza_trofeo
BEFORE INSERT ON Trofeo
FOR EACH ROW
EXECUTE FUNCTION Controllo_coerenza_trofeo();

