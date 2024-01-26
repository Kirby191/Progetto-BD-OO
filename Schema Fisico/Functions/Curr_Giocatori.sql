CREATE OR REPLACE FUNCTION Curr_Giocatori(SquadraInEsame TEXT)
RETURNS TABLE(SSN_Giocatore ssn_valido)
AS $$
	
		BEGIN

			IF( NOT EXISTS ( SELECT *
					 FROM Squadra
					 WHERE Nome_Squadra = SquadraInEsame)) THEN 
				
				RAISE EXCEPTION 'La squadra indicata non esiste';
				
			END IF;

			RETURN QUERY SELECT SSN FROM Partecipa_In WHERE Squadra = SquadraInEsame;
			
		END;
$$ Language plpgsql;
