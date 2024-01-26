CREATE OR REPLACE FUNCTION DeletePInFromUpdateOnM()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.NomeSquadra <> OLD.NomeSquadra OR NEW.SSN <> OLD.SSN THEN
        RAISE EXCEPTION 'Impossibile eseguire la richiesta. Inserire una nuova riga con i dati corretti per il giocatore %', OLD.SSN;
    END IF;

    IF NEW.Data_Fine IS NULL AND OLD.Data_Fine IS NOT NULL THEN
        RAISE EXCEPTION 'Non è possibile annullare la fine di militanza % una volta inserita', NEW.ID_Militanza;
    END IF;

    IF NEW.Data_Fine IS NOT NULL THEN
        DELETE FROM Partecipa_in
        WHERE SSN = NEW.SSN AND NomeSquadra = NEW.NomeSquadra;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER DeletePInFromUpdateOnM
AFTER UPDATE ON Militanza
FOR EACH ROW
EXECUTE FUNCTION DeletePInFromUpdateOnM();

