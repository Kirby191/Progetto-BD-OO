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
