# etapa2proiectPOO
etapa2 proiect POO

321CD- Ionescu Stefan

							README ETAPA II


Descrierea claselor auxiliare :
Clasa Print- aceasta clasa contine 2 metode, una dintre ele printeaza credentialele
userului curent(nume, tara, tipul de cont, parola, bani in cont), iar cealalta 
printeaza caracteristicile filmelor(anul aparitiei, numele, durata, genurile filmului, 
actorii care participa, tarile in care este interzis, rating-ul, numarul de aprecieri,
numarul de rating-uri ale filmului).


Clasa Legal - contine o metoda care verifica legalitatea filmelor primite ca input in 
functie si de userul curent, functioneaza prin a lua tarile in care filmele sunt 
interzise si a le verifica daca, corespund cu tara userului curent.


Clasele GoingThroughLikedMovies, GoingThroughPurchasedMovies, GoingThroughWatchedMovies,
GoingThroughRatedMovies - fiecare dintre aceasta clasa impartaseste acelasi principiu: 
navigheaza prin un arraylist primit ca parametru de intrare al metodei, numele au fost 
alese in mod specific pentru a ma putea orienta mai usor printre filmele cumparate, 
vizionate, apreciate si filmele care au primit rating. Metodele din interiorul claselor
contin si o variabila de tipul Print(explicata mai sus), care printeaza specificatiile
filmelor si returneaza un objectnode.


Clasele SortForFilterIncreasingIncreasing, SortingForFilterDecreasingDecreasing. 
SortForFilterIncreasingDecreasing, SortForFilterDecreasingIncreasing - fiecare dintre
aceste clase contine 2 metode : una dintre ele printeaza felul in care arraylist-ul
a fost sortat in functie de Duration si Rating, iar cealalta foloseste Bubble-Sort
ca sa sorteze arraylsit-ul primit ca parametru la intrare in functie de Rating si 
Duration, conform cerintei de la etapa 1. Deasemenea, tind sa mentionez faptul ca
aceste doua metode sunt folosite pentru doua design patterns : Command si Strategy
metoda care printeaza felul in care arraylist-ul a fost sortat este pentru design
pattern-ul Command iar, cealalta metoda care efectiv sorteaza arraylist-ul este 
pentru design pattern-ul Strategy. Pentru aceste doua design pattern-uri am creat
cate 4 interfete: pentru design pattern-ul Strategy am creat interfetele : 
SortForFilterDecreasingDecreasing, SortingForFilterDecreasingIncreasing, 
SortingForFilterIncreasingDecreasing, SortingForFilterIncreasingIncreasing.
Fiecare contine cate un antet de metoda care primeste ca paramtru de intrare un
arraylist si este de tipul void. In mod asemanator pentru design pattern-ul Command
am creat alte 4 interfete : InterfaceForfilterDecreasingDecreasing,
InterfaceForfilterDecreasingIncreasing, InterfaceForfilterIncreasingDecreasing,
InterfaceForfilterIncreasingIncreasing. In mod asemanator ca la Strategy, fiecare
dintrea ceste interfete contone un antet de metoda de data aceasta fara parametrii
de intrare si este de tipul void. Inca un lucru de mentionat la aceste clase de
sortare: in primul rand sunt pentru actiunea filter si sunt apelate in functie de 
cazul de sortare de la input. Deasemenea am folosit si edsign pattern-ul Singleton
pentru userul curent : in clasa Inputforusers gasim metoda getInstance care 
functioneaza conform design pattern-ului Singleton.


Clasele de input, inclusiv clasa Filters : clasele de input sunt facute conform
cerintei etapei 1 de pe ocw, doar ca la aceasta etapa am mai adaugat niste
metode in plus clasei Inputforusers, anume : pentru fiecare user am decis sa
adaug o metoda in care se pune in cate un arraylist separat filmele achizitionate,
filmele vizionate, filmele apreciate si filmele la care a dat rate. Deasemenea gasim
si de cate ori un user s-a logat prin intermediul variabilei numlogins.


Clasa Main - La actiunile de login si register, procesul este intr-un fel asemanator
pentru login caut sa vad daca numele userului si parola acestuia coinicide cu numele
si parola unuia dintre userii primiti la input. La register adaug userul cu numele 
si parola in lista de useri, in caz contrar, userul exista deja. Pentru comanda 
filter verific daca filmele primite de la input sunt legale si abia dupa le fac 
sortarea in functie de cum s-a cerut in inputul actiunii. La comanda buytokens 
scad din banii userului curent pentru a cumpara niste token-uri. Pentru comanda 
buypremiumaccount scad din numarul de tokens ai user-ului curent pentru a 
cumpara un cont de tipul premium. La aceste doua actiuni nu afisez nimic,
insa setez valorile si tipul contului. La actiunile de login si register pe 
de alta parte afisez absolut toate filmele userului cat si credentialele 
acestuia. La actiunile de purchase, rate, watch, like, afisez userul cu 
credentialele sale, dar si filmele tiannd cont de faptul ca este o ordine intre 
aceste comenzi : purchase trebuie sa fie prima, watch a doua, like a treia si rate 
a patra. Tinand cont de acest lucru, la purchase afisez primordial purchasedmovies 
si vreau sa includ si filmele noi cumparate, iar la celelalte tipuri de filme le 
afisez daca pentru userul curent exista. La watch asemanator ca la purchase, tin 
cont sa afisez atat filmele noi cat si vechi vizionate dar la purchase am o conditie 
ca un film sa nu fie achizionat de mai multe ori. Afisez filmele achizitionate(toate) 
ale userului, cat si cele vizionate ale userului(toate) si daca mai are alte tipuri de 
filme precum apreciate sau la care a dat rate, le afisez si pe ele, dar daca nu, nu le 
mai afisez. La rate ca la watch, afisez toate filmele achizitionate, vizionate, cat si 
cele la care a dat rate, pe langa caractersiticile user-ului. In cele din urma la like 
este acelasi rationament ca la rate, purchase, watch. Pentru actiunea see details, in 
general se afiseaza la sectunea CurrentMoviesList filmul dat de input. La etapa 1 
printre primele 6 teste, acest film era dat de la input, atat la rate, cat si la 
purchase si like, dar pentru cazul in care nu se dadea de la input, retineam nummele 
filmului intr-un String si lucram cu el la comenzile de see details. Pentru actiunea 
back, retin pagina precedenta si afisez ce afisam pe ea in mod normal previous page este 
actualizat dupa fiecare actiune, iar in caz ca nu se afla pe pagina care trebuie
am o variabila fail de tip int, o initializez cu 1 si verifica in caz ed este egal cu 1 
si daca da afisez o eroare. La database, adaug filmul oferit de input daca este film de 
adaugat si sterg filmul oferit de input daca este film de sters la input. La subscribe iau 
genul la care sa dea subscribe din input si il adaug la currentuser, la arraylist-ul cu 
genurile la care sa dea subscribe. La notifications, daca am un film in database ii pun
numele la recommendation si la message, pun ADD. Daca nu am nimic in database, pun 
No Recommendation. Notification este dupa for-ul de comenzi, deci la sfarsitul comenzilor
afisez aceste lucruri, dar cu conditia ca si contul ultimului utilizator sa fie de tipul
premium. 





