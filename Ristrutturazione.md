# Prima Ristrutturazione

### Analisi delle Ridondanze
+ Ridondanze Possibili di _Nome_, _Cognome_, _SSN_ di un __Giocatore__ in __Allenatore__ e __Dirigente__, queste ridondanze sono fondamentali perchè se un Giocatore diventa Allenatore o Dirigente ci colleghiamo alla classe Giocatore per ricordare parte delle sue informazioni in quanto la tupla che si riferiva a quel Giocatore non viene eliminata, ma viene impostato _Ritirato_ a __TRUE__
+ Nel nostro

### Gestione Attributi Multivalore
+ Gli attributi multivalore che possiamo avere nel nostro UML sono _Abilità_ e _Ruolo_ presenti nella classe __Giocatore__. Per gestire questi attributi, abbiamo deciso di trattarli come un singolo attributo. Essi formeranno una stringa per _Ruolo_ ed una per _Abilità_ composta da tutti gli attributi loro attribuiti, separati da una virgola.

### Gestione Attributi Composti
+ Non sono presenti attributi composti.

### Gestione delle Gerarchie
+ Nel nostro UML ci sono due gerarchie:

