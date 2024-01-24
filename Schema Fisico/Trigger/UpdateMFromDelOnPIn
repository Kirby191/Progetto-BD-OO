-- Se sto eliminando da partecipa_in, allora la militanza sta terminando.

CREATE OR REPLACE FUNCTION UpdateMFromDelOnPIn()
RETURNS TRIGGER AS $$
DECLARE
    tmp Militanza%ROWTYPE;
BEGIN
    -- Utilizzare direttamente la variabile tmp senza aprire il cursore
    SELECT *
    INTO tmp
    FROM Militanza
    WHERE NomeSquadra = OLD.NomeSquadra AND SSN = OLD.SSN
    ORDER BY Data_Inizio DESC
    LIMIT 1;

    IF tmp.Data_Fine IS NULL THEN
        UPDATE Militanza
        SET Data_Fine = CURRENT_DATE
        WHERE ID_Militanza = tmp.ID_Militanza;
    END IF;

    RETURN OLD;
END;
$$ LANGUAGE plpgsql;


-- Creazione del trigger separatamente dalla definizione della funzione
CREATE TRIGGER UpdateMFromDelOnPIn
BEFORE DELETE ON Partecipa_in
EXECUTE FUNCTION UpdateMFromDelOnPIn();
