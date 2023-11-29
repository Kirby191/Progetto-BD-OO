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

__- Giocatore__
+ Nella gerarchia di __Giocatore__ abbiamo deciso di accorpare le figlie nel padre. Altrimenti, avremmo avuto due entità pressochè identiche, risultando in una complessità dello schema elevata. Utilizzando un attributo tipo che indichi se Giocatore è un Portiere. In tal caso, __Militanza__ avrà l'obbligo di gestire i _Goal Subiti_. Dato che la gerarchia è di tipo <Totale, Disgiunta>, possiamo usufruire di un attributo di tipo boolean che mi dirà, se esso è _TRUE_, che Giocatore è un Portiere. _FALSE_ se esso è un GiocatoreDiMovimento
  
__- Militanza__
+ La Gerarchia di Militanza viene gestita equivalentemente a Giocatore per i motivi sopra citati. Accorpando il figlio nel padre diciamo che, se il Giocatore è un Portiere, l'attributo tipo sarà _TRUE_ e allora _Goal Subiti_ potrà essere inserito.

+ Tale strategia ha l'ovvio svantaggio di contenere molti attributi a NULL, ma ha un vantaggio relativo all'interrogazione del DB, in quanto non abbiamo bisogno di creare il doppio delle query per ottenere informazioni, ma ci basta effettuare controlli sugli attributi tipo.
