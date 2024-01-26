CREATE OR REPLACE FUNCTION DelDirAfterUpOnD()
RETURNS TRIGGER AS $$
BEGIN
    -- Verifica se FineD non è nullo
    IF NEW.FineD IS NOT NULL THEN
        -- Esegue la cancellazione dalla tabella Dirige
        DELETE FROM Dirige WHERE SSN_Dirigente = NEW.SSN;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER del_dir_after_update_on_d
AFTER UPDATE ON Dirigente
FOR EACH ROW
EXECUTE FUNCTION DelDirAfterUpOnD();