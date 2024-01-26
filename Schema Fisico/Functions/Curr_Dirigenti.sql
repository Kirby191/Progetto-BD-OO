CREATE OR REPLACE FUNCTION Curr_Dirigenti(SquadraInEsame TEXT)
RETURNS TABLE(SSN_Dirigente ssn_valido)
AS $$
	
		BEGIN
			IF( NOT EXISTS ( SELECT *
					 FROM Squadra
					 WHERE Nome_Squadra = SquadraInEsame)) THEN 
				
				RAISE EXCEPTION 'La squadra indicata non esiste';
				
			END IF;
			
			RETURN QUERY SELECT D.SSN_Dirigente FROM Dirige AS D WHERE D.NomeSquadra = SquadraInEsame;
			
		END;
$$ Language plpgsql;