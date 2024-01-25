CREATE OR REPLACE FUNCTION CheckInsV()
RETURNS TRIGGER AS $$
DECLARE
    isSquadra BOOLEAN;
    SquadraApp RECORD;
    ControlloDate RECORD;
BEGIN
    SELECT * INTO SquadraApp
    FROM Partecipa_in
    WHERE SSN = NEW.SSN;
    
    
    IF SquadraApp IS NULL THEN
    
    	RAISE EXCEPTION 'Giocatore % non partecipa a nessuna squadra, impossibile inserire', NEW.SSN;
    	
    END IF;
    
    SELECT * INTO ControlloDate
    FROM Militanza
    WHERE SSN = NEW.SSN AND NomeSquadra = SquadraApp.NomeSquadra AND Data_Fine IS NULL;
    
	IF ControlloDate.Data_Inizio <= NEW.Anno THEN
    
	    SELECT Squadra INTO isSquadra
	    FROM Trofeo
	    WHERE NomeTrofeo = NEW.NomeTrofeo AND Anno = NEW.Anno;
	    
	    -- Se è vero che il trofeo è di squadra, controllo se esiste la situazione dove il trofeo è in ottenuto_da. Se ciò non fosse vero
	    -- allora sto tentando di inserire il trofeo ad un singolo giocatore, e non perchè il trofeo di squadra viene dato a tutti i giocatori.
	    
	    IF isSquadra THEN
	     
		IF NOT EXISTS (
		    SELECT 1
		    FROM Ottenuto_da
		    WHERE NomeTrofeo = NEW.NomeTrofeo AND Anno = NEW.Anno AND NomeSquadra = SquadraApp.NomeSquadra
		) THEN
		    RAISE EXCEPTION 'Trofeo % di squadra. Impossibile assegnarlo al singolo giocatore', NEW.NomeTrofeo;
		END IF;
		
	    END IF;
	    
	    RETURN NEW;
	    
	END IF;
	
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

-- Creazione del trigger separatamente dalla definizione della funzione
CREATE TRIGGER CheckInsV
BEFORE INSERT ON Vincere
FOR EACH ROW
EXECUTE FUNCTION CheckInsV();

