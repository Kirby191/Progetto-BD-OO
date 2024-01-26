CREATE ROLE Utente LOGIN PASSWORD ' ';
CREATE ROLE Giocatore LOGIN PASSWORD 'giocatore';
CREATE ROLE Amministratore LOGIN PASSWORD 'Amministratore';

GRANT SELECT ON TABLE Giocatore, Militanza TO Utente;
GRANT SELECT, UPDATE ON TABLE Giocatore TO Giocatore;
GRANT SELECT ON TABLE Credenziali TO Giocatore, Amministratore;
GRANT SELECT, DELETE, INSERT, UPDATE ON TABLE Giocatore TO Amministratore;