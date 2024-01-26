# Prima Battuta UML
![Prima Bozza UML](https://github.com/Kirby191/Progetto-BD-OO/assets/19607112/0e6fb168-3838-4e57-ac6d-e22a9fd6d436)

# Seconda Battuta UML
![seconda bozza UML](https://github.com/Kirby191/Progetto-BD-OO/assets/19607112/b9e1a54c-b6f5-4ab5-8a02-d26acd136b76)
+ Aggiunta relazione tra Giocatore e Allenatore
+ Aggiunta relazione tra Giocatore e Dirigente


Senza queste due relazioni non potremmo accedere ai dati residui di un giocatore.


+ Modificata la relazione __Trofeo Squadra__, il vincolo di partecipazione tra i due è stato modificato. (_Un trofeo potrebbe anche non essere diretto ad una squadra, ma essere individuale, e viceversa_)
+ Proposta da parte di Antonio(su cui Vittorio non si trova): Dovremmo modificare anche __Trofeo Giocatore__ in quanto se una squadra vince un trofeo lo vincono più giocatori della stessa squadra, quindi lo stesso trofeo verrebbe dato a più giocatori.
Per Vittorio invece, se un trofeo viene ottenuto da una squadra, si lancia un trigger che vada ad aggiungere quel trofeo ad ogni giocatore 


# Terza Battuta UML
![terza bozza uml](https://github.com/Kirby191/Progetto-BD-OO/assets/19607112/36870db6-113a-4230-b7bd-1c5d04c43c2d)

+ __Trofeo Giocatore__ Modificata la relazione. Prima era 0...1 - *, ora è * *. Questo poichè se un trofeo è di squadra, allora viene anche dato a tutti i giocatori per tenerne traccia. Per distinguerlo ci basta effettuare un controllo su Giocatore.
+ Cambiata gerarchia. La classe Padre __Giocatore__ ora contiene al suo interno due specializzazioni. GiocatoreDiRuolo e Portiere. In caso sia un Portiere, verranno gestiti i goal subiti.
+ Aggiunta entità __Autenticazione__ che ci gestisce gli eventuali accessi al nostro DB.
+ Aggiunta gerarchia a __Carriera__. Ora ha __Carriera Portiere__.
+ Aggiunto attributo _GoalSubiti_ a __Militanza__


# Quarta Battuta UML
![quarta bozza UML (2)](https://github.com/Kirby191/Progetto-BD-OO/assets/19607112/a457d171-3c1d-4cd0-a794-f6f81699b5ef)

+ __Carriera__ _->_ __Militanza__
+ Cambiata la relazione tra Giocatore e Squadra. Non avrà più __Militanza__ ma si potrà ricavare dalla classe __Militanza__ utilizzando delle query e vincoli semantici.
+ Aggiunta relazione tra la nuova classe __Militanza__ e __Squadra__ per tenere traccia delle Militanze. 
+ Aggiunta Attributi a __Giocatore__, __Squadra__ e __Militanza__

# Quinta Battuta UML
![Quinta bozza UML](https://github.com/Kirby191/Progetto-BD-OO/assets/19607112/7987d76a-84ec-4175-9819-f00baad774d1)

+ Modificata visivamente la gerarchia di Giocatore
+ Aggiunto attributo _DataFine_ ad __Allenatore__ e __Dirigente__

# Sesta Bozza UML
![Sesta bozza UML](https://github.com/Kirby191/Progetto-BD-OO/assets/19607112/721a56ff-0092-4150-88f0-970b4ebf286a)



+ Abilità e Ruolo sono multivalore, pertanto sono [1...N]
+ Rimosso Feature come attributo composto.

# Settima Bozza UML
![Settima bozza UML](https://github.com/Kirby191/Progetto-BD-OO/assets/19607112/b1dfcfa0-ea7d-4978-863e-a5094ac532c5)




+ Aggiunti attributi di tipo Boolean a __Giocatore__ e __Trofeo__ che ci aiutano per risolvere alcuni problemi riscontrati.
+ Rimosso __Autenticazione__. Si fa nell'SQL.
+ Errore presente nella gerarchia di Giocatore. Era <Totale, Disgiunta>, non Parziale.
+ Dal portatile fare git pull

# Ottava Bozza UML
![Ottava bozza UML](https://github.com/Kirby191/Progetto-BD-OO/assets/19607112/7dd7ead3-513c-43c1-a8e8-a9682f7af43e)

+ Cambiata relazione tra __Militanza__ e __Squadra__. N-N -> 1-N.

# Nona Bozza UML
![Nona bozza UML](https://github.com/Kirby191/Progetto-BD-OO/assets/19607112/04d9c91a-35c8-4da5-89a4-12b3b3d6173a)

+ Cambiate relazioni tra __Squadra__ e __Allenatore__ / __Dirigente__.
+ Allenatore - Squadra: _1:N_
+ Squadra - Dirigente: _N:N_

# Decima Bozza UML
![Decima bozza UML](https://github.com/Kirby191/Progetto-BD-OO/assets/19607112/0e4f6ee0-599c-46b3-b890-86d099362c76)



+ Aggiunta attributo _Sesso_ a Giocatore, Allenatore e Dirigente

# Undicesima Bozza UML
![Undicesima bozza UML](https://github.com/Kirby191/Progetto-BD-OO/assets/19607112/a757a8ff-ff7a-4494-9849-9ad45e285640)

+ Invertita cardinalità tra Giocatore e Militanza, era errata.

# Dodicesima Bozza UML
![UML_non_ristrutturatoAggiustato](https://github.com/Kirby191/Progetto-BD-OO/assets/19607112/e398abf1-f48e-4fc7-b133-699c024ed5c4)


+ Rimosso Ruolo come attributo multivalore
