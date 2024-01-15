-- Nel momento in cui faccio un UPDATE di un Allenatore e metto la fine della sua carriera, qualsiasi squadra lui stia allenando in quel momento deve essere rimossa come in carico a quell'allenatore. 

CREATE OR REPLACE FUNCTION DelOnSFromUpOnAFunction()
RETURNS TRIGGER AS $$
DECLARE
    Check CURSOR FOR SELECT Nome_Squadra FROM Squadra;
    SquadraRecord RECORD;
BEGIN
    OPEN Check;

    LOOP
        FETCH Check INTO SquadraRecord;
        EXIT WHEN NOT FOUND;

        UPDATE Squadra
        SET SSN_Allenatore = NULL
        WHERE Nome_Squadra = SquadraRecord.Nome_Squadra AND SSN_Allenatore = NEW.SSN;
    END LOOP;

    CLOSE Check;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER DelOnSFromUpOnA
AFTER UPDATE ON Allenatore
FOR EACH ROW
WHEN (NEW.FineA IS NOT NULL)
EXECUTE FUNCTION DelOnSFromUpOnAFunction();


