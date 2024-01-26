CREATE OR REPLACE FUNCTION Storico_Giocatori(SquadraInEsame TEXT)
RETURNS TABLE(SSN_Giocatore ssn_valido)
AS $$
	
		BEGIN
		
			IF( NOT EXISTS ( SELECT *
					 FROM Squadra
					 WHERE Nome_Squadra = SquadraInEsame)) THEN 
				
				RAISE EXCEPTION 'La squadra indicata non esiste';
				
			END IF;

			RETURN QUERY SELECT DISTINCT SSN FROM Militanza WHERE NomeSquadra = SquadraInEsame;		
		
		END;
$$ Language plpgsql;

CREATE OR REPLACE FUNCTION Storico_Squadre(SSN_Input TEXT)
RETURNS TABLE(Squadra VARCHAR(50))
AS $$
	
		BEGIN
		
			IF( NOT EXISTS ( SELECT *
					 FROM Giocatore as G
					 WHERE G.SSN = SSN_Input)) THEN 
				
				RAISE EXCEPTION 'L''ssn indicato non esiste';
				
			END IF;

			RETURN QUERY SELECT DISTINCT M.NomeSquadra FROM Militanza AS M WHERE M.SSN = SSN_Input;		
		END;
$$ Language plpgsql;
