--quando inserisco o faccio update di una tupla in militanza devo controllare che se il giocatore è un portiere allora il tipo di Militanza deve essere uguale a P,altrimenti deve essere M
CREATE OR REPLACE FUNCTION Controllo_tipo_militanza()
RETURNS TRIGGER AS $$
BEGIN
	IF(SELECT TipoGiocatore
	   FROM Giocatore
	   WHERE SSN = New.SSN) = 'M' THEN --Si attiva se il giocatore è di movimento
		IF New.TipoMilitanza <> 'M' THEN 
			RAISE EXCEPTION 'Giocatore % ha TipoMilitanza = P ma TipoGiocatore = M', NEW.SSN;
		END IF;
	ELSE --Si attiva se il giocatore è un portiere
		IF New.TipoMilitanza <> 'P' THEN 
			RAISE EXCEPTION 'Giocatore % ha TipoMilitanza = M ma TipoGiocatore = P', NEW.SSN;
		END IF;
	END IF;
	RETURN NEW;
END;
$$ Language plpgsql;

CREATE TRIGGER controllo_tipo_militanza
BEFORE INSERT OR UPDATE ON Militanza
FOR EACH ROW
EXECUTE FUNCTION Controllo_tipo_militanza();