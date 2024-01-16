CREATE OR REPLACE FUNCTION NoChangesUpdatePIn()
RETURNS TRIGGER AS $$
BEGIN
    
    RAISE EXCEPTION 'Non è possibile modificare i valori inseriti';

    RETURN NEW;
    
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER NoChangesUpdatePIn
BEFORE UPDATE ON Partecipa_in
FOR EACH ROW
WHEN (OLD.SSN IS DISTINCT FROM NEW.SSN OR OLD.NomeSquadra IS DISTINCT FROM NEW.NomeSquadra)
EXECUTE FUNCTION NoChangesUpdatePIn();

