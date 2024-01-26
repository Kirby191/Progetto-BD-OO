CREATE DOMAIN eta_valida AS DATE CHECK (VALUE <= CURRENT_DATE - INTERVAL '16 years');

CREATE DOMAIN ssn_valido AS VARCHAR(11) CHECK (VALUE SIMILAR TO '[0-9]{3}-[0-9]{3}-[0-9]{3}');

CREATE DOMAIN RuoloType AS VARCHAR(30) CHECK (VALUE IN ('Portiere', 'DifensoreCentrale', 'TerzinoSinistro', 'TerzinoDestro', 'CentrocampistaDifensivo', 'CentrocampistaCentrale', 'EsternoSinistro', 'EsternoDestro', 'CentrocampistaOffensivo', 'AlaSinistra', 'AlaDestra', 'Trequartista', 'Punta'));

CREATE DOMAIN intero_non_negativo AS INTEGER CHECK (VALUE >= 0);
CREATE DOMAIN sesso_corretto AS CHAR CHECK (VALUE = 'F' OR VALUE = 'M');

CREATE DOMAIN ruoloDirigente AS VARCHAR(30)
  CHECK(VALUE IN ('Presidente', 'Amministratore delegato', 'Dirigente sportivo', 
                  'Dirigente tecnico', 'Preparatore atletico', 'Preparatore dei portieri',
                  'Medico sportivo', 'Mental coach', 'Fisioterapista', 'Osservatore', 
                  'Magazziniere') OR VALUE IS NULL);

CREATE DOMAIN ruoli_ammessi AS VARCHAR(15) CHECK (VALUE IN ('Giocatore','Amministratore'));