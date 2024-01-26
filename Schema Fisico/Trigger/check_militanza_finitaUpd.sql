//se si vuole modificare un valore di una militanza si deve controllare che quella militanza non sia finita
CREATE OR REPLACE FUNCTION militanza_finitaUpd()
RETURNS TRIGGER AS $$
BEGIN 
	IF ((SELECT Data_Fine
	    FROM Militanza
	    WHERE ID_Militanza = New.ID_Militanza) IS NOT NULL) THEN
		RAISE EXCEPTION 'Non si può modificare militanza %. Terminata.', NEW.ID_Militanza;
	END IF;
	RETURN NEW;
END;
$$ Language plpgsql;


CREATE TRIGGER militanza_finita
BEFORE UPDATE OF PartiteGiocate, GoalSegnati, GoalSubiti, CartelliniGialli, CartelliniRossi, Assist ON Militanza
FOR EACH ROW 
EXECUTE FUNCTION militanza_finitaUpd(); 
