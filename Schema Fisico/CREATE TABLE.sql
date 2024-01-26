CREATE TABLE Nazione(
Nome VARCHAR(50),
PRIMARY KEY (Nome));

CREATE TABLE Giocatore (
Nome VARCHAR(50) NOT NULL,
Cognome VARCHAR(50) NOT NULL,
SSN ssn_valido NOT NULL,
Nazionalita VARCHAR(50) REFERENCES Nazione(Nome) NOT NULL,
DataDiNascita eta_valida NOT NULL,
Sesso sesso_corretto NOT NULL,
Piede CHARACTER(1) NOT NULL,
Altezza NUMERIC(3,0) NOT NULL,
Peso NUMERIC(4,0) NOT NULL,
Ruolo RuoloType NOT NULL,
Ritirato BOOLEAN NOT NULL DEFAULT FALSE,
Abilita VARCHAR(50) NOT NULL,
TipoGiocatore CHARACTER(1) NOT NULL,

PRIMARY KEY (SSN),

CONSTRAINT AltezzaCorretta CHECK(Altezza > 1.50),
CONSTRAINT PesoCorretto CHECK(Peso > 40.00),
CONSTRAINT PiedeCorretto CHECK(Piede = 'D' or Piede = 'S'),
CONSTRAINT TipoGiocatoreCorretto CHECK(TipoGiocatore= 'M' or TipoGiocatore= 'P')
CONSTRAINT tipo_giocatore_corretto CHECK ((Ruolo = 'Portiere' AND TipoGiocatore = 'P') OR (Ruolo <> 'Portiere' AND TipoGiocatore = 'M'))
);

CREATE TABLE Allenatore(
Nome VARCHAR(50) NOT NULL,
Cognome VARCHAR(50) NOT NULL,
Sesso sesso_corretto NOT NULL,
SSN ssn_valido NOT NULL,
InizioA DATE NOT NULL,
FineA DATE,

PRIMARY KEY (SSN),

CONSTRAINT contr_data CHECK (InizioA < FineA));

CREATE TABLE Squadra(
Nome_Squadra VARCHAR(50) UNIQUE NOT NULL,
Nazionalità VARCHAR(50) REFERENCES Nazione(Nome) NOT NULL,
Data_Fondazione DATE NOT NULL,
SSN_Allenatore ssn_valido REFERENCES Allenatore(SSN),

PRIMARY KEY (Nome_Squadra));

CREATE TABLE Militanza(
ID_Militanza SERIAL NOT NULL,
Data_Inizio DATE NOT NULL,
Data_Fine DATE,
PartiteGiocate intero_non_negativo NOT NULL DEFAULT 0,
GoalSegnati intero_non_negativo NOT NULL DEFAULT 0,
GoalSubiti intero_non_negativo NOT NULL DEFAULT 0,
CartelliniGialli intero_non_negativo NOT NULL DEFAULT 0,
CartelliniRossi intero_non_negativo NOT NULL DEFAULT 0,
Assist intero_non_negativo NOT NULL DEFAULT 0,
TipoMilitanza CHAR(1) NOT NULL,
NomeSquadra VARCHAR(50) REFERENCES Squadra(Nome_Squadra),
SSN ssn_valido REFERENCES Giocatore(SSN),

PRIMARY KEY (ID_Militanza),

CONSTRAINT TipoMilitanzacorretto CHECK(TipoMilitanza ='M' or TipoMilitanza ='P')
CONSTRAINT contr_data CHECK (Data_Inizio < Data_Fine)
CONSTRAINT correttoGoal_Subiti CHECK ((Goal_Subiti = 0 AND TipoMilitanza = 'M') OR (Goal_Subiti >= 0 AND TipoMilitanza = 'P'));

CREATE TABLE Trofeo(
NomeTrofeo VARCHAR(30) NOT NULL,
Anno DATE NOT NULL,
Squadra BOOLEAN NOT NULL DEFAULT FALSE,

PRIMARY KEY (NomeTrofeo, Anno));

CREATE TABLE Dirigente(
Nome VARCHAR(50) NOT NULL,
Cognome VARCHAR(50) NOT NULL,
Sesso sesso_corretto NOT NULL,
SSN ssn_valido NOT NULL,
RuoloDirigente ruoloDirigente NOT NULL,
InizioD DATE NOT NULL,
FineD DATE,

PRIMARY KEY (SSN)

CONSTRAINT contr_data CHECK (InizioD < FineD));

CREATE TABLE Vincere (
    SSN ssn_valido REFERENCES Giocatore(SSN) NOT NULL,
    NomeTrofeo VARCHAR(30) NOT NULL,
    Anno DATE NOT NULL,

    PRIMARY KEY (NomeTrofeo, Anno)

    CONSTRAINT TrofeoFK FOREIGN KEY (NomeTrofeo, Anno) REFERENCES Trofeo(NomeTrofeo, Anno));

CREATE TABLE Partecipa_In(
SSN ssn_valido REFERENCES Giocatore(SSN) NOT NULL,
NomeSquadra VARCHAR(50) REFERENCES Squadra(Nome_Squadra) NOT NULL);

CREATE TABLE Ottenuto_Da(
NomeSquadra VARCHAR(50) REFERENCES Squadra(Nome_Squadra) NOT NULL,
    NomeTrofeo VARCHAR(30) NOT NULL,
    Anno DATE NOT NULL,

    PRIMARY KEY (NomeTrofeo, Anno)
	
    CONSTRAINT TrofeoFK FOREIGN KEY (NomeTrofeo, Anno) REFERENCES Trofeo(NomeTrofeo, Anno));

CREATE TABLE Dirige(
SSN_Dirigente ssn_valido REFERENCES Dirigente(SSN) NOT NULL,
NomeSquadra VARCHAR(50) REFERENCES Squadra(Nome_Squadra) NOT NULL);

CREATE TABLE Credenziali (
    Username VARCHAR(20) UNIQUE NOT NULL,
    Password VARCHAR(15) NOT NULL,
    Ruolo ruoli_ammessi NOT NULL,
    SSN ssn_valido NOT NULL,
    PRIMARY KEY(SSN),

    CONSTRAINT Username_Incorretto CHECK (LENGTH(Username) >= 5),
    CONSTRAINT Password_Incorretta CHECK (LENGTH(Password) >= 5 AND Password ~ '[A-Za-z]' AND Password ~ '[0-9]')
);

