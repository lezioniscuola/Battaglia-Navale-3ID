# Documentazione del Programma "Battaglia Navale"

## Introduzione
Il programma "Battaglia Navale" consente agli utenti di giocare al classico gioco da tavolo della battaglia navale in una modalità PvE (Player vs Environment), sfidando il computer, sul terminale d’esecuzione. Il gioco offre diverse opzioni di difficoltà e fornisce una spiegazione delle regole principali in caso se non si conoscessero,inoltre ad esso è stata aggiunta una modalità che si basa sempre sulla battaglia navale classica ma con un’esecuzione massima dei colpi da parte dell’utente.

## How to Use:
>   1) Scarica la cartella `navi`
>   2) Utilizzando un compilatore a tua scelta (Es. IntelliJ Idea) esegui `juegoCompleto.java`
>   3) Ora puoi seguire le istruzioni presenti nella console

## Struttura file del programma
Il programma è composto da tre file principali:
> - **JuegoCompleto.java**: Contiene la classe principale del programma che gestisce l'intera logica del gioco.
> - **FunzBattagliaNavale2.java**: Contiene le funzioni utilizzate per la gestione della battaglia navale, inclusi metodi per la creazione del campo di gioco, il posizionamento delle navi e la verifica dei colpi.
> - **Colori.java**: Contiene le metodologie per la gestione della colorazione dell’output console.

## Utilizzo del Programma
Dopo aver presentato la richiesta di inserimento del proprio nome, il programma presenta un menù principale con tre opzioni:
> - **Gioca (opzione 0)**: Avvia il gioco della battaglia navale.
> - **Ripassa le regole (opzione 1)**: Fornisce una descrizione delle regole del gioco della battaglia navale.
> - **Esci (opzione 2)**: Termina il programma.

## Modalità di Gioco
Il gioco dopo che l’opzione `Gioca` del menù principale è stata selezionata porterà ad una seconda scelta condizionata in un ulteriore menù tra le diverse difficoltà o modalità di gioco.
Le diverse modalità di gioco, o difficoltà, influenzano vari aspetti del gioco, come la quantità e le dimensioni delle navi, le dimensioni del campo di gioco e altre regole aggiuntive. Ecco una descrizione di ciascuna modalità:
> ### 1. Facile:
Questa modalità è adatta per i principianti, con un numero ragionevole di navi e un campo di gioco di dimensioni moderate.
  - __Navi__: 5 barche (dimensione 1), 3 navi (dimensione 2), 2 sottomarini (dimensione 3), sia per il giocatore sia per il pc.
  - __Campo di gioco__: 9x9.

> ### 2. Media:
Questa modalità offre una sfida leggermente maggiore rispetto a quella facile, con un campo di gioco leggermente più grande e una distribuzione di navi più equilibrata.
- __Navi__: 5 barche (dimensione 1), 3 navi (dimensione 2), 3 sottomarini (dimensione 3) per il giocatore. Per il PC, il numero di navi è inferiore, ma non specificato esplicitamente, in realtà è di: 3 barche (dimensione 1), 2 navi (dimensione 2), 2 sottomarini (dimensione 3).
- __Campo di gioco__: 11x11.

> ### 3. Difficile:
Questa modalità è più impegnativa, con una quantità inferiore di navi per il giocatore e un campo di gioco più grande.
- __Navi__: 6 barche (dimensione 1), 1 nave (dimensione 2), 2 sottomarini (dimensione 3) per il giocatore. Per il PC, il numero di navi è inferiore, ma non specificato esplicitamente, in realtà è di:3 barche (dimensione 1), 2 navi (dimensione 2), 2 sottomarini (dimensione 3)..
- __Campo di gioco__: 12x12.

> ### 4. Difficile^2:
In questa modalità, il giocatore ha solo 10 mosse possibili, aggiungendo una sfida ulteriore rispetto alle altre modalità.
- __Navi__: 1 barca (dimensione 1), 1 nave (dimensione 2), 1 sottomarino (dimensione 3) per il giocatore e il PC avrà solo 1 nave (dimensione 1).
- __Campo di gioco__: 13x13.


> ### 5. Personalizzata:
Il giocatore può specificare la dimensione del campo di gioco, che per convenzione deve essere maggiore o uguale a 9.
Il numero e le dimensioni delle navi sono corrispondenti alla modalità facile, sopra riportata.
Questa modalità consente al giocatore di personalizzare l'esperienza di gioco, scegliendo la dimensione del campo di gioco in base alle proprie preferenze.

Queste modalità offrono una gamma di sfide e permettono ai giocatori di adattare l'esperienza di gioco alle proprie abilità e preferenze.

## Sequenza di gioco
Ecco come avviene il gioco dalla scelta nei menù al gioco vero e proprio, inclusa la gestione dei turni e dei richiami delle funzioni:

> 1. **Avvio del gioco**:
  
   Il programma inizia con la presentazione del menù principale, dove il giocatore può scegliere tra tre opzioni: `Gioca`, `Ripassa le regole` ed `Esci`.

> 2. **Scelta nel menu**:
   
   Il giocatore inserisce un'opzione dal menu utilizzando l'input da tastiera.
   - Se l'opzione scelta è `Gioca` (opzione 0), il gioco procede alla configurazione della partita.
   - Se l'opzione scelta è `Ripassa le regole` (opzione 1), vengono stampate le regole del gioco.
   - Se l'opzione scelta è `Esci` (opzione 2), il gioco termina.

> 3. **Configurazione della partita**:
   
   Il giocatore è invitato a inserire il proprio nome e a selezionare una delle modalità di gioco disponibili tra `Facile` (opzione 1),`Media` (opzione 2),`Difficile` (opzione 3),`Difficile^2` (opzione 4) e `Personalizata` (opzione 5).

> 4. **Inizializzazione del campo di gioco**:
   
   In base alla modalità scelta, vengono inizializzati i campi di gioco del giocatore e del PC utilizzando la funzione `campoDiBattaglia()`.

> 5. **Posizionamento delle navi**:
   
   Le navi vengono posizionate automaticamente sia per il giocatore che per il PC utilizzando la funzione `posizionamentoTotale()`.

> 6. **Inizio del gioco**:

Il gioco procede con il turno del giocatore.
Durante il turno del giocatore, vengono visualizzati i campi di gioco del giocatore e del PC utilizzando le funzioni `stampaCampoGiocatore()` e `stampaCampoPc()`.
Il giocatore inserisce le coordinate del colpo da effettuare.
Viene eseguita la funzione `colpito()` per determinare il risultato del colpo e aggiornare il campo di gioco del PC.
Viene controllata la condizione di vittoria per verificare se il giocatore ha vinto la partita.

> 7. **Turno del PC**:

Se la partita non è finita, è il turno del PC.
Il PC genera casualmente le coordinate del colpo da effettuare utilizzando la funzione `colpoPc()`.
Viene eseguita la funzione `colpito()` per determinare il risultato del colpo e aggiornare il campo di gioco del giocatore.
Viene controllata la condizione di vittoria per verificare se il PC ha vinto la partita.

> 8. **Ripetizione dei turni**:

I turni del giocatore e del PC si alternano finché non si verifica una condizione di vittoria o finché non si raggiunge il limite di mosse (solo nella modalità "Difficile^2").

> 9. **Fine della partita**:

Quando si verifica una condizione di vittoria o si raggiunge il limite di mosse (solo nella modalità "Difficile^2"), il gioco termina.
Viene visualizzato un messaggio appropriato per indicare se il giocatore ha vinto o perso.

> 10. **Chiusura del gioco**:

Dopo la fine della partita, il programma torna al menu principale e attende una nuova scelta da parte del giocatore. Se il giocatore sceglie l'opzione "Esci", il gioco termina completamente.

In questo modo, il programma gestisce l'intero ciclo di gioco, dall'inizializzazione alla fine della partita, garantendo un'esperienza di gioco fluida e coinvolgente.

## file: JeugoCompleto.java
### Classe: juegoCompleto
### Funzione della classe : Avvia il gioco e gestisce le interazioni con l'utente.
### Metodo: main(String[] args)


### Variabili utilizzate:
+ `in`: Oggetto Scanner utilizzato per leggere l'input dall'utente.
+ `opzioneSceltaMenu`: Variabile intera che memorizza l'opzione scelta dall'utente nel menu principale del gioco, essa può assumere 3 valori differenti in base alla scelta utente, 0=Gioca, 1=Regolamento e 2=Esci.
+ `nome`: Una stringa che memorizza il nome del giocatore.
+ `isVittoriaPresente`: Variabile booleana che indica se è presente una condizione di vittoria nel gioco che quindi condurrà alla chiusura di esso, può assumere true se Pc o Giocatore ha vinto altrimenti manterrà il valore di inizializzazione false.
+ `turnoDiGioco`: Un intero che tiene traccia del turno attuale del gioco. Se il valore è 0, è il turno del giocatore; se è 1, è il turno del computer.
+ `rigaColpo`, `colonnaColpo`: Variabili intere che memorizzano le coordinate del colpo inserite dall'utente durante il suo turno, ambe saranno sempre >=0 && <dimensioneCampoDiGioco.
+ `dimensioneCampoDiGioco`: Un intero che rappresenta la dimensione del campo di gioco, dato in input nella modalità personalizzata del gioco oppure assegnato dal programma stesso in base alla difficoltà scelta, in ogni caso sarà sempre >=9.
+ `difficoltaDiGioco`: Un intero che memorizza la difficoltà scelta dall'utente, può assumere valori da 1 a 5 in base alla scelta tra le difficoltà prima riportate.
+ `mosseRimanentiOpzionali`: Un intero che tiene traccia delle mosse rimanenti durante il gioco in modalità difficile^2, inizializzato sempre a 10.
+ `colpoDaEffetuare`: Un array di interi che memorizza le coordinate del colpo generato casualmente dal computer durante il suo turno tramite la funzione colpiPc(), nella prima cella ([0]) conserverà la riga di riferimento nella seconda ([1]) la colonna di riferimento.
+ `naviGioc`, `naviPc`: Array di interi che memorizzano il numero e le dimensioni delle navi per il giocatore e il computer rispettivamente, il primo elemento con  indice 0 indicherà le navi di dimensione 1, il secondo elemento con indice 1 indicherà le navi di dimensione 2,invece il terzo quelle di dimensione 3.L’inizializzazione sarà effettuata in base alla difficoltà/modalità scelta .
+ `campoPc`, `campoGiocatore`: Matrici di interi che rappresentano i campi di gioco del computer e del giocatore rispettivamente. Nella matrice saranno contenuti interi da 0 a 3 con 0=Mare/Casella vuota,1=Nave,2=Nave colpita,3=Mare/Casella vuota colpita.

## file:funzBattaglianavale2.java

### Classe: funzBattagliaNavale2
### Funzione della classe: Questo file contiene le funzioni ausiliarie per la gestione del campo di battaglia e la logica del gioco.

### Metodi:
+ `campoDiBattaglia(int dimensioneCampoDiGioco)`: Restituisce un campo di gioco vuoto di dimensioni specificate.
+ `posizionamentoTotale(int [][] campoGiocatoreOPc,int [] navi)`: Posiziona le navi in modo casuale sul campo di gioco.
+ `posizionamento(int[][] campoGiocatoreOPc, int dimensioneNave)`: Posiziona una nave di dimensioni specificate in modo casuale sul campo di gioco.
+ `stampaCampoGiocatore(int [][] campoGiocatore)`: Restituisce una rappresentazione visiva del campo di gioco del giocatore.
+ `stampaCampoPc(int [][] campoPc)`: Restituisce una rappresentazione visiva del campo di gioco dell'avversario.
+ `colpito ( int [][] campoGiocatoreOPc, int x, int y)`: Verifica se un colpo ha colpito una nave e restituisce il risultato del colpo.
+ `vittoria(int[][] campoGiocatoreOPc)`: Controlla se tutte le navi sono state affondate, determinando così la vittoria di uno dei giocatori.
+ `colpoPc (int [][] campoGiocatore, int dimensioneCampoDiGioco, int [] colpoDaEffettuare)`: Genera casualmente le coordinate del colpo per l'avversario.
### Variabili utilizzate:
+ `campoDaAssegnare`:
   Questa variabile rappresenta il campo di gioco della battaglia navale, dove vengono posizionate le navi.Utilizzata nella funzione campoDiBattaglia ed in essa è una variabile locale.
+ `naviInserite`:
   Viene utilizzata per contare quante navi sono state inserite durante il posizionamento. Usata nella funzione posizionamentoTotale è una variabile locale ad essa.
+ `dimensioneNave`:
   Indica la dimensione della nave attualmente posizionata sul campo di gioco.Usata in posizionamentoTotale e posizionamento, nella prima è una variabile locale nella seconda un parametro formale.
+ `righe:
   Rappresenta il numero di righe nel campo di gioco della battaglia navale.Usata in posizionamento come variabile locale.
+ `colonne`:
   Indica il numero di colonne presenti nel campo di gioco della battaglia navale.Usata in posizionamento come variabile locale.
+ `x` e `y`:
   Sono le coordinate utilizzate per posizionare una nave sul campo di gioco.Usate in posizionamento come variabili locali.
+ `direzione`:
    Indica se la nave deve essere posizionata in orizzontale (0) o verticale (1).Usata in posizionamento come variabile locale.
+ `posizionato`:
    È una variabile booleana che indica se la nave è stata posizionata con successo sul campo di gioco.Usata in posizionamento come variabile locale.
+ `ritorno`:
   Rappresenta il risultato di un colpo: 0 se è stato un colpo a vuoto, 1 se è stato un colpo su una nave, 2 se è stato un ricolpimento, 3 se è stata già colpita.Usata in colpito come variabile locale.
+ `isGiaColpito`:
     Indica se la casella sul campo di gioco è già stata colpita dal PC, ovvero se contiene un valore uguale a 2 o 3, e fa ricominciare il ciclo di estrazione casuale delle coordinate del colpo da effettuare sul campo del Giocatore da parte del Pc. Usata in colpoPc come variabile locale.
+ `rigaColpo` e `colonnaColpo`:
    Rappresentano le coordinate del colpo da effettuare sul campo di gioco, salvate poi nell’array preso in input come parametro formale ColpoDaEffetuare. Usate in colpoPC come variabili locali.

+ `colpoDaEffettuare`:
  Un array di interi che memorizza le coordinate del colpo generato casualmente dal computer durante il suo turno tramite la funzione colpiPc(), nella prima cella ([0]) conserverà la riga di riferimento nella seconda ([1]) la colonna di riferimento.Usata in colpoPC come parametro formale.
+ `campoGiocatoreOPc`:
Indica una matrice presa in input come parametro formale che può essere sia quella rappresentante il campo del giocatore sia quella che rappresenta il campo del pc.Usata in tutte le funzioni meno quella di creazione dei campi.
+ `StringaCampoGiocatore` e `StringaCampoPc`:
Stringhe in cui verrà inizializzato il campo del giocatore nel primo caso e quello del pc nel secondo, queste sono create dalle funzioni di stampa e restituite come output di esse.

## Realizzazione:
**Appunti: Gruppo 1**

	- Realizzazione della battaglia navale contro un computer.
 
	- Funzioni da realizzare:
 ---
> - f()==> Creazione del campo di battaglia, data la dimensione in "input", richiamata 2 volte; - Panseri
	> - Specifiche: Matrice di interi, 0=H2O, 1=Nave Presente, 2=Colpito, 3=Colpo a vuoto;
> - f()==> Posizionamento di tutte le navi e di tutte le dimensioni, richiamando le precedenti; - D'Ortenzio
	> - Specifiche: Array di navi e matrice;
> - f()==> Posizionamento delle navi random in verticale o orizzontale, 3 dimensioni diverse ma non accavallabili, dato la dimensione della nave; - karaje
	> - Specifiche: Richiama un'altra funzione (posizionamento generale, successiva), data la matrice, la dimensione della nave;
>  - f()==> Controllo se colpito, data la matrice del campo di gioco e le coordinate; (Spara) - Locatelli
	> - Specifiche: Ritorna un intero in base alla verifica attuata (0=colpo a vuoto,1=colpito,2=colpo su una nave già colpita,3=colpo a vuoto ripetuto), contemporaneamente cambia il valore nella matrice dato quelli nella funzione 1;
> - f()==> Funzione che controlla la vittoria, che controlla se le navi sono state tutte colpite, data la matrice, l'array delle navi; - Seghezzi
	> - Specifiche: Quindi se non ci sono 1 nel campo
> - f()==> Stampa del campo; - Viapiana
	> - Specifiche: Griglia che sostituisce il numero dei fattori dati dalla funzione 1, inoltre stampa le indicazioni della griglia 1 - n(dimensione campo);
> - f()==> Simulazione del computer; - Rocchi
	> - Specifiche: Genera numeri casuali cioè il colpo che farà il computer, inoltre creerà un'altra funzione modificando quella di stampa per la stampa del campo del computer eliminando la vista delle navi ovviamente.
 > - Unione del gioco - D'Ortenzio cooperata anche da altri così che il lavoro sarà distribuito
> - f()==> Main
---
- NB: Le navi sono di dimensioni 1,2,3
---
**Le funzioni saranno da inserire nel file con il proprio cognome, il main poi sarà creato in seguito unendo le diverse funzioni. Ognuno dovra firmare con un commento la funzione che realizzerà.**
