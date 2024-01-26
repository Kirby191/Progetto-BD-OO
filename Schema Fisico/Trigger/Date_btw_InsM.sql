//prima di inserire una tupla in Militanza dobbiamo controllare che la data di inizio non si trovi nel mezzo di una data di un'altra militanza 
CREATE OR REPLACE FUNCTION ControlloDataInsMBtw()
RETURNS TRIGGER AS $$
BEGIN 
	IF EXISTS (
		SELECT 1
		FROM Militanza 
		WHERE New.SSN = SSN
		  AND New.Data_Inizio BETWEEN Data_Inizio AND Data_Fine
	) THEN
		RAISE EXCEPTION 'La militanza % non può essere inserita. Il giocatore % in quella data ha già un''altra militanza', NEW.ID_Militanza, NEW.SSN;
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER controllo_ins_Data_Militanza_btw
BEFORE INSERT ON Militanza
FOR EACH ROW
EXECUTE FUNCTION ControlloDataInsMBtw();
