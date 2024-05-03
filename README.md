# Battaglia-Navale-3ID

**Appunti: Gruppo 1**
	- Realizzazione della battaglia navale contro un computer. 
	- Funzioni da realizzare:
> - f()==> Creazione del campo di battaglia, data la dimensione, richiamata 2 volte;
	> - Specifiche: Matrice di interi, 0=H2O, 1=Nave Presente, 2=Colpito, 3=Colpo a vuoto;
> - f()==> Posizionamento di tutte le navi e di tutte le dimensioni, richiamando le precedenti;
	> - Specifiche: Array di navi e matrice;
> - f()==> Posizionamento delle navi random in verticale o orizzontale, 3 dimensioni diverse ma non accavallabili, dato la dimensione della nave;
	> - Specifiche: Richiama un'altra funzione (posizionamento generale, successiva), data la matrice, la dimensione della nave;
>  - f()==> Controllo se colpito, data la matrice del campo di gioco e le coordinate; (Spara)
	> - Specifiche: Ritorna un intero in base alla verifica attuata (0=colpo a vuoto,1=colpito,2=colpo su una nave già colpita,3=colpo a vuoto ripetuto), contemporaneamente cambia il valore nella matrice dato quelli nella funzione 1;
> - f()==> Funzione che controlla la vittoria, che controlla se le navi sono state tutte colpite, data la matrice, l'array delle navi;
			Specifiche:
> - f()==> Stampa del campo;
	> - Specifiche: Griglia che sostituisce il numero dei fattori dati dalla funzione 1;
> - f()==> Simulazione del computer; 
	> - Specifiche: Genera numeri casuali 
 > - Unione del gioco:
> - f()==> Main
