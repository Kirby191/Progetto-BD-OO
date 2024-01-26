## Alcune Note Implementative
- Partecipa_In viene popolata in maniera dinamica a seconda di cosa inseriamo, eliminiamo, o modifichiamo in _Militanza_. Pertanto, non ha bisogno di essere popolata, anche se il sistema è pronto a tale evenienza con i dovuti trigger.
- Le squadre hanno almeno __11__ giocatori. Ciò viene controllato solo nel momento in cui cerchiamo di dare alla Squadra un Trofeo. Fare controlli in altre situazioni non è una buona strategia, in quanto non abbiamo un appoggio solido per decidere quando il controllo dovrebbe esser fatto.
- Un _Giocatore_ ritirato non può essere _Allenatore_ e _Dirigente_ allo stesso momento in quanto in quel caso, due tuple diverse in due tabelle diverse si riferiscono alla stessa chiave primaria. Qualora in futuro nel database sia necessario un controllo che coinvolge le 3 tabelle, ciò provocherà un errore fatale da risolvere.
- Una _Militanza_ che deve terminare per l'eliminazione in Partecipa_in viene messa alla Data Corrente. Questa è una scelta implementativa che ci aiuta a specificare che nel momento in cui viene eliminata quella tupla, la prossima militanza si riferirà al futuro, in non posso inserire Militanze che hanno una data_inizio ed una data_fine tra un'altra data_inizio e data_fine. Ciò rende Partecipa_in una tabella dinamica relativa sempre al __presente__.
- Credenziali è una tabella che ci viene in aiuto per definire un metodo di login all'interno del nostro DB per Giocatore ed Amministratore. Si è preferito usufruire di questa tabella che specifica il ruolo per la sua possibilità di essere ampliata a molti più ruoli. E.g. Allenatore, Dirigente, Arbitro...
## Spiegazione trigger
- CheckAIsNotRetired: Inserire una tupla in Squadra e aggiungere anche l'allenatore (NEW.SSN_Allenatore IS NOT NULL) attiva questo trigger. Controlliamo che l'allenatore esista e poi che non si sia ritirato dalla sua carriera di allenatore.

- CheckANotRetiredBUpdate: Aggiornare una tupla di Squadra provando a cambiare l'allenatore della Squadra (NEW.SSN_Allenatore <> OLD.SSN_Allenatore) genera una situazione dubbiosa. Si controlla che il nuovo allenatore inserito sia esistente e non abbia finito la sua carriera da allenatore.

- CheckInsV: Si attiva prima di inserire una tupla in Vincere. Se il trofeo è di squadra, controlliamo se il Giocatore è parte di una squadra. Inoltre, controlla se la squadra a cui appartiene lo ha effettivamente vinto. In tal caso la tupla si aggiunge normalmente, altrimenti è errore.

- DelDirAfterUpOnD: Fare update di un dirigente con FineD NOT NULL attiva questo Trigger. Se esiste una tupla in Dirige con ugual SSN, allora deve essere eliminata poichè il dirigente ha finito la sua carriera.

- DelOnSFromUpOnA: Quando si aggiorna la tupla di un allenatore mettendo una data di fine carriera, si controlla se esiste una squadra che ha come SSN_allenatore il nostro allenatore. In tal caso, diventa NULL.

- InsVFromOda: Inserire una tupla in Ottenuto_Da necessita di vari controlli. Controlliamo se il trofeo è di squadra (in caso contrario, EXCEPTION), una volta accertati di ciò lo inseriamo nella tabella Vincere a tutti i giocatori che stanno partecipando in quel momento nella squadra (Partecipa_In) con il nome e l'anno del trofeo.

- Check_D_non_ritirato_ins_Dirige: Prima di inserire una tupla in dirige dobbiamo controllare che il dirigente non si sia ritirato.

- Check_RitiratoTrue_InsAll_exgiocatore: Un allenatore può esser stato un giocatore. Se lo era controlliamo che nella tabella Giocatore l'attributo ritirato sia TRUE, in caso contrario viene aggiornato poichè se è diventato Allenatore, la sua carriera da Giocatore è terminata.

- Check_RitiratoTrue_InsDir_exgiocatore: L'inserimento di un dirigente ci porta a controllare se in passato è stato un giocatore. Se lo era controlliamo che nella tabella Giocatore l'attributo ritirato sia TRUE, in caso contrario viene aggiornato l'attributo.

- Check_sex_uguale_sexsquadra: Quando inserisco una tupla in Partecipa_in controllo che il sesso del giocatore inserito sia lo stesso degli altri giocatori della squadra.

- DeleteFromInsOnPIn: Inserire una tupla in Partecipa_in necessita un di un rigoroso controllo. Se il giocatore sta giocando per quella squadra, vuol dire che nella tabella Militanza ci sarà la corrispondente militanza non terminata(Presente). In caso sia terminata, non posso inserire la tupla in Partecipa_in, in quanto si riferisce al passato.

- DeletePInFromDeleteOnM: Dopo aver eliminato la militanza di un giocatore in Militanza, qualora la Data_Fine fosse NULL, devo eliminare la corrispondente tupla in Partecipa_In.

- DeletePInFromUpdateOnM: Quando viene aggiornata la militanza di un giocatore inserendo una data fine allora si deve eliminare la tupla corrispondente in Partecipa_in.

- InsertPInFromInsOnM: Per inserire una tupla in Militanza, il Giocatore non deve essere ritirato e non deve avere un'altra militanza attiva (Data_Fine = NULL), altrimenti EXCEPTION.

- NoChangesUpdatePIn: Il trigger blocca le modifiche delle tuple di Partecipa_in.

- UpdateMFromDelOnPIn: Quando si elimina una tupla da Partecipa_in allora si aggiorna la Data_Fine della Militanza corrispondente.

- UpdateMwhenGretired: Un Giocatore ritirato termina la sua carriera. Se ha una militanza attiva(Data_Fine = NULL), allora viene aggiornata alla CURRENT_DATE.

- Check_date_btw_InsM: Per inserire una tupla in Militanza, dobbiamo controllare che la sua durata non si trovi nel mezzo di un'altra militanza.

- Check_date_btw_UpdM: Modificare la data di inzio o fine di una tupla in Militanza potrebbe generare situazioni ambigue. La durata totale della Militanza non si può trovare tra una data_inizio e fine di un'altra Militanza.

- Militanza_finitaUpd: Se si vuole modificare uno dei seguenti attributi di Militanza: Partite_Giocate, Goal_Seganti, Goal_Subiti, Cartellini_Gialli, Cartellini_Rossi, Assist, si deve controllare che la militanza non sia finita.

- Controllo_tipo_militanza: Se il TipoGiocatore di Giocatore è P, tipoMilitanza deve corrispondere, e viceversa.

- CheckSquadra11: Prima di inserire una tupla in Ottenuto_Da dobbiamo controllare che la squadra ha almeno 11 giocatori nella squadra(Altrimenti la squadra non ha neanche una vera e propria formazione, impedendo di giocare ad un campionato per vincere il trofeo...etc)

- NoUpdateRetired: Quando un giocatore si è ritirato non può più tornare in gioco.

- Check_ssn_all: Un Allenatore non può essere anche un Dirigente.

- Check_ssn_dir: Un Dirigente non può essere anche un Allenatore.

- Controllo_coerenza_trofeo: Se all'inserimento di un trofeo ne trovo un altro con lo stesso nome, ma attributo Squadra diverso, EXCEPTION. Il trofeo deve essere coerente. L'unica cosa che cambia è l'anno.

## Spiegazione Funzioni
- Carriera_Giocatore: Estraggo i dati totali della carriera di un giocatore, dal suo inizio alla sua fine. Se possiede una militanza con data_fine NULL allora la carriera è ancora in corso

- Curr_Dirigenti: Estrae i Dirigenti che dirigono una squadra in tempo reale dato un nome squadra in input.

- Curr_Giocatori: Estrae i Giocatori partecipanti ad una squadra in tempo reale dato un nome squadra in input.

- Storico_Giocatori_Squadra: Due funzioni diverse che eseguono lo stesso compito ma all'inverso. Dato un Giocatore estraggo le Squadre a cui ha partecipato dall'inizio della sua carriera al CURRENT_DATE(Se la carriera è ancora in corso). Data una Squadra estraggo tutti i Giocatori che hanno partecipato a quella squadra dalla sua data_fondazione.
