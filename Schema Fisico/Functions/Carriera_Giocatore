CREATE OR REPLACE FUNCTION Carriera_Giocatore(SSN_Giocatore ssn_valido)
RETURNS TABLE(
    Inizio_Carr Date,
    Fine_Carr Date,
    s_part_gioc intero_non_negativo,
    s_goal_segn intero_non_negativo,
    s_goal_sub intero_non_negativo,
    s_cart_g intero_non_negativo,
    s_cart_r intero_non_negativo,
    s_assist intero_non_negativo
)
AS $$
DECLARE
    Inizio_Carr Date;
    Fine_Carr Date;
    s_part_gioc intero_non_negativo;
    s_goal_segn intero_non_negativo;
    s_goal_sub intero_non_negativo;
    s_cart_g intero_non_negativo;
    s_cart_r intero_non_negativo;
    s_assist intero_non_negativo;

BEGIN
    SELECT Data_Inizio INTO Inizio_Carr
    FROM Militanza
    WHERE SSN = SSN_Giocatore
    ORDER BY Data_Inizio ASC
    LIMIT 1;

    SELECT Sum(partitegiocate), Sum(goalsegnati), 
    Sum(goalsubiti), Sum(cartellinigialli), Sum(cartellinirossi), Sum(Assist)
    INTO s_part_gioc, s_goal_segn, s_goal_sub, s_cart_g, s_cart_r, s_assist
    FROM Militanza
    WHERE SSN = SSN_Giocatore;
        
    SELECT Data_Fine INTO Fine_Carr
    FROM Militanza
    WHERE SSN = SSN_Giocatore
    ORDER BY Data_Fine DESC
    LIMIT 1;

    RETURN QUERY SELECT
	Inizio_Carr,
	Fine_Carr,
	s_part_gioc,
	s_goal_segn,
	s_goal_sub,
	s_cart_g,
	s_cart_r,
	s_assist;

END;
$$ LANGUAGE plpgsql;

