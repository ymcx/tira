# Tehtävä 1

Tässä ensimmäisessä tehtävässä käydään läpi joitakin yleisiä asioita joita ei myöhemmissä tehtävissä tarvitse enää käsitellä. Lue siis kärsivällisesti ohjeet ja tehtävän lisäohjekin läpi, niin asiat sujuvat jatkossa sitten kitkattomammin.

Kurssin ohjelmointitehtävien ohjeet ovat yleensä kattavia ja pitkähköjä, koska materiaali on tarkoitettu itsenäistäkin opiskelua tukevaksi. Muista kuitenkin aina se, että opettajat ovat tukemassa oppimistasi ja auttamassa ongelmien ratkaisussa. Kysy siis apua mieluummin heti kuin liian myöhään. Minkään ongelman kanssa ei pidä painiskella 1-2 päivää pidempään, ilman että kysyt opettajilta apua.

Toinen syy miksi ohjelmointitehtävien ohjeet saattavat olla pitkiä on se, että vuosi vuodelta samat ongelmat joko oletetun osaamisen (edeltävät kurssit) tai tämän kurssin asioissa toistuvat useissa palautuksissa. Nämä ohjeet on kirjoitettu siksi, että välttäisit nämä perusasioihin liittyvät ongelmat omassa koodissasi. Jos seuraat ohjeita, opit asiat, toteutat ne oikein, ongelmia joko ei ole tai on vähemmän.

## Oletettu osaaminen

Tehtävässä oletetaan että osaat seuraavat, edeltävillä kursseilla opetetut asiat:
- toistorakenteet: `for`, `while`  (Ohjelmointi 1, 2)
- ehtorakenteet: `if` (Ohjelmointi 1, 2)
- *perustietotyyppien* arvojen vertailu operaattoreilla `<, <=, >, =>, ==` ja `!=` (Ohjelmointi 1, 2)
  - Perustietotyyppejä Javassa ovat esim. `int, double, float, char, boolean`
- loogiset operaatiot boolean -arvoilla (`true`, `false`) (Ohjelmointi 1, 2, Laitteet ja tietoverkot)
- Javan `Object` -luokka, josta kaikki luokat periytyvät, ja sen tärkeät metodit (Ohjelmointi 2)
- Javan rajapinnat (interface) ja perintä sekä metodien ylikuormitus (override) (Ohjelmointi 2)
- *Luokkien olioiden (instanssien)* vertailu Javalla: equals ja compareTo (Ohjelmointi 2)
  - Huom: luokat eli oliot nimetään Javassa isolla alkukirjaimella, perustietotyypit pienellä
  - Oliota (`Integer`, `Double`, `Character`, `String`, ja muut luokat, myös itse tehdyt) ei Javassa verrata vertailuoperaattoreilla, paitsi kun halutaan tietää onko olio *sama* olio (sama *muuttuja*), eikä vaan *samanlainen* eli yhtäsuuri/erisuuri/pienempi/suurempi. 
  - Kun halutaan tietää onko olio samanlainen, yhtäsuuri kuin toinen, käytetään `Object`-luokasta perittyjä metodeja `equals()` ja/tai `compareTo` (vertailemaan pienempi kuin/suurempi kuin).
- taulukot; arrays (Ohjelmointi 1, 2)
- taulukoiden indeksit ja taulukon läpikäynti silmukoilla indeksien avulla (Ohjelmointi 1, 2)
- seuraukset (virheet, ongelmat) taulukon alueen ylittämisestä (Ohjelmointi 1, 2)
- ongelmanratkaisun perusteet: kynä ja paperi, debuggaus (Ohjelmointi 1, 2)

**Lue** [tehtävän lisäohje](01a-TASK-addendum.markdown) **miten vertailua Javassa tehdään**, jos yhtään tuntuu siltä että asiaa on syytä kerrata. Lisäohje kertaa Ohjelmointi 2:ssa opetettuja asioita, ja huolimatta tästä, niiden kanssa on ollut joitakin ongelmia tällä kurssilla.

## Yleistä tehtävistä

Ensimmäisen tehtävän yhteydessä tässä alla ohjeita joita kannattaa noudattaa läpi koko kurssin.

**Katso ensin** kurssin liveluento tai sen tallenne, joka esittelee TIRA Coders -sovelluksen rakenteen, tärkeät luokat ja mihin kohtaa koodia teet tehtävään liittyvät omat osuutesi tässä harjoituksessa.

**Tehtävillä on deadline** johon mennessä koodin tulee olla toimivana etärepositoryssäsi. Deadlinen tullessa testiskriptit hakevat koodisi etäraposta ja automaattitestit testaavat toteutuksesi. Lisätietoja arvostelusta löydät ohjeesta [README-ARVOSTELU.markdown](README-ARVOSTELU.markdown).

**Huomaa** myös että tässä, kuten kurssin muissakaan tehtävissä (graafitehtävää 09 lukuunottamatta), **ei saa käyttää** Javan `Arrays`, `System` tai `Collections` -luokkien algoritmeja, tai *mitään* Javan tietosäiliöluokkia (`ArrayList`, `Vector`, `List`, `Collection` tai näiden rajapintojen toteutukset, jne). Myös Javan funktionaalisen ohjelmoinnin algoritmeja ei saa käyttää. Tarkoitus on tässä opetella tekemään vastaavia asioita itse.

**Käytä** heti alusta asti komentoja `git commit`, tarvittaessa `git add` sekä `git push` *usein*. Näin työsi on jatkuvasti tallessa etärepositoryssä, voit palata takaisin vanhempaan versioon tarvittaessa, ja ennen kaikkea jos tarvitset apua opettajilta, etärepossasi on mahdollisimman tuore koodi jota katsomalla opettajat voivat auttaa sinua ongelmissasi. Muista myös aina apua pyytäessäsi (sähköpostilla tai Moodlessa) laittaa mukaan URL etärepoosi, tämä nopeuttaa huomattavasti avun tarjoamista.

Git:n komennoista on pikaopas ohjeessa [GIT-CHEAT-SHEET.markdown](GIT-CHEAT-SHEET.markdown).

**Geneerisen ohjelmoinnin** perusteet on käyty läpi Ohjelmointi 2 -kurssilla, jossa käytit valmiita Javan geneerisiä tietorakenteita (esim. `ArrayList`), ja toteutit kyseisen kurssin harjoituksissa lisäyslajittelun (*insertion sort*) geneerisenä. Jos geneerinen ohjelmointi on silti vielä vieras asia, **katso luentotallenne** geneerisestä ohjelmoinnista (löytyy Moodlesta).


## Esittely

TIRA Coders -sovelluksen koodarilistaus on järjestämätön.  Tämä tekee koodarilistan selaamisesta ja koodareiden etsimisestä hankalaa. Siksi **tässä tehtävässä**:

1. toteutat yksinkertaisen, Ohjelmointi 2:ssa opitun lajittelualgoritmin (lisäyslajittelu eli *insertion sort*),
2. toteutat luokkaan `Coder` koodareiden vertailussa tarvittavan `compareTo` -algoritmin,
3. toteutat taulukon järjestyksen kääntämisen päinvastaiseksi (reverse),
4. täydennät valmiina annettua koodia siten että se hyödyntää toteuttamiasi algoritmeja.

Muissa arvosanoissa ei ole tähän tehtävään liittyviä vaatimuksia tai tehtäviä.

> Tehtävässä kirjoitat yhteensä noin 25-45 riviä koodia, riippuen koodaustyylistä. Mihin tehtävän koodi kirjoitetaan, kerrotaan tarkemmin alla olevissa askeleittain etenevissä ohjeissa.

Huomaa että jos algoritmi tai ohjeet eivät muuta kerro, lajittelu toteutetaan aina ns. **luonnolliseen järjestykseen** (*natural order*). Tämä tarkoittaa nousevaa järjestystä. Numeerisilla tietotyypeillä numeroiden arvot siis *kasvavat* taulukossa edetessä, ja merkkijonotaulukoissa tämä tarkoittaa aakkosjärjestystä A...Ö.
 
> Jos sinun on hankala siirtyä edes takaisin kooditiedostojen ja tämän ohjeen välillä VS Codessa, avaa tämä ohje etäreposi ohjesivu nettiselaimella GitHubissa. Näin voit selaimessa lukea ohjeita ja tehdä koodaushommat VS Codessa.

## Lähteitä

* Yksinkertainen lisäyslajittelualgoritmi on käyty läpi Ohjelmointi 2 -kurssilla (pakollinen edeltäjäkurssi).
* Kurssikirja: Introduction to Algorithms, 4th ed (Comer et al) ss 18-24.
* Kurssin Luentokalvot.
* Liveluento (tallenne) ja sen vinkit ja esimerkit.
* [Lisäyslajittelu (wikipedia)](https://en.wikipedia.org/wiki/Insertion_sort).
* Javan [`Comparable` -rajapinta](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Comparable.html).
* Javan [`Object` -luokka](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html).


## Tehtävän tavoite

TIRA Coders appin koodarilista on *järjestämätön*.  Tämä tekee koodarilistan selaamisesta ja koodareiden etsimisestä hankalaa, varsinkin kun koodareita on paljon.

Toteutat alempana olevien ohjeiden mukaisesti yksinkertaisen geneerisen taulukon **lisäyslajittelualgoritmin** (*insertion sort*) jolla koodarit saadaan nimen (sukunimi, etunimi) mukaiseen nousevaan (*natural*) järjestykseen.

Toteuta myös taulukon **järjestyksen kääntäminen** (*reverse*) päinvastaiseen järjestykseen. Sekä lajittelu että järjestyksen kääntäminen tehdään **"in-place"**, eli käyttäen vain pieniä apumuuttujia. Jos käytät lajitteluun tai kääntämiseen aputaulukoita tai valmiita Javan (tai muiden) algoritmeja, **tehtävä on käsintarkistuksssa hylätty**!

Hyödynnä alussa mainittuja lähteitä. Toteuta tehtävä alla olevien ohjeiden ("Askel 1 - Ohjeet", alempana) mukaisesti:

1. Aluksi toteutat geneeriset algoritmit joita testataan yksinkertaisilla Javan tietotyypeillä.
2. Sitten toteutat ne osuudet joilla koodaritkin saadaan käyttöliittymässä lajiteltua.

Kirjoita lopuksi **raporttiin** (`RAPORTTI.markdown` löytyy valmiiksi projektin juurihakemistosta) analyysisi tehtävästä, annettujen ohjeiden mukaisesti. Huomaa että myös raportti on myös **arvosteltava tehtävä**.

Kun olet tehnyt tehtävät alla olevien ohjeiden mukaisesti, **testaa** toteutustasi testeillä `src/test/java/oy/interact/tira/grade_1/task_1` -hakemistossa.

Voit ajaa kaikki testit tai testin yksi kerrallaan joko VS Codesta käsin (painamalla "play" -nappia joka suorittaa testin; Run test)...:

![Testien ajaminen](task-01-vscode-tests.png)

...tai komentoriviltä (projektin juurihakemistossa, jossa tiedosto `pom.xml` sijaitsee) yksi kerrallaan. Testin nimi `InsertionSortArrayTests` tulee testiluokan nimestä:

```console
mvn -Dtest=grade_1/task_1/InsertionSortArrayTests test
```

Vasta sitten, kun testit menevät läpi, etene kokeilemaan miten lajittelu toimii TIRA Coders:ssa, alempana löytyvien ohjeiden mukaisesti.

Huomaa että jos testi ei mene läpi, etkä koodia lukemalla ja analysoimalla saa selville vikaa, voit myös suorittaa testin *debuggaamalla*. Laita pysäytyspisteitä (*breakpoint*) omaan koodiisi, suorita koodia testaava testi *debuggaamalla* (play -nappi jossa ötökän kuva), ja askella (*step*) koodia seuraten muuttujien arvoja, ja mitä oikein tapahtuu. Usein näin vaihe vaiheelta koodia debuggerilla suorittaen, ongelma näkyy selkeästi. Ole tarkka ja kärsivällinen; älä oleta mitä tapahtuu vaan *katso* mitä tapahtuu kun debuggaat suoritusta.

Lisää debuggauksesta ohjeessa [DEBUGGAUS.markdown](DEBUGGAUS.markdown).


## Askel 1 - Ohjeet

Tässä askeleessa:

* toteutat kaksi lajittelualgoritmia luokkaan `oy.interact.tira.student.Algorithms`.

> Huomaa että tässä vaiheessa sovelluksessa toimii vain taulukkopohjainen coder-puhelinluettelo (valikossa "Simple array phonebook"), joka on valmiiksi annettu toteutus. Toteutuksesta puuttuu pieniä palasia joita täydennät tehtävien aikana.

**Toteuta** taulukon geneerinen lisäyslajittelu `Algorithms` -luokan metodeihin:

* `public static <T extends Comparable<T>> void insertionSort(T [] array)` - lajittelee koko taulukon luonnolliseen järjestykseen. Voit olettaa ettei taulukossa ole `null`:eja.
* `public static <T extends Comparable<T>> void insertionSort(T [] array, int fromIndex, int toIndex)` - lajittelee taulukon luonnolliseen järjestykseen *annettujen indeksien välillä*. Voit olettaa ettei taulukossa ole annetulla indeksivälillä `null`:eja.

> **HUOM**: indeksit ovat `[fromIndex,toIndex)` -- lajittelu tehdään siis `fromIndex..<toIndex`, ei `fromIndex...toIndex`.
>
> Huomaa *uudelleenkäyttö*; voit toteuttaa metodin `insertionSort(T [] array)` kutsumalla metodia `insertionSort(T [] array, 0, array.length)`. Sama pätee myös järjestyksen kääntämisalgoritmeihin alla.

**Huomaa** miten algoritmin eli metodin rajapinnassa esiintyy Javan rajapinta `Comparable`. Näin algoritmi "vaatii" että tietotyyppi `T` joita taulukossa on, **toteuttaa** `Comparable` -rajapinnan. Algoritmia voidaan kutsua vain taulukoilla jotka sisältävät `Comparable` -rajapinnan toteuttavia olioita. Javan kääntäjä tietää tämän ja antaa käännösvirheen, jos luokka ei rajapintaa toteuta.

Voit jo tässä vaiheessa testata lajittelualgoritmiasi, koska sitä varten on omat erilliset testit (`InsertionSortArray...` -testit). Testit luovat `Integer` ja `String` -taulukoita. Molemmat luokat *toteuttavat* `Comparable` -rajapinnan joten algoritmin vaatimus toteutuu.

Toteuta myös taulukon **järjestyksen vaihtaminen** päinvastaiseksi `Algorithms` -luokan metodeihin:

* `void reverse(T [] array)` - kääntää koko taulukon alkioiden järjestyksen päinvastaiseksi.
* `void reverse(T [] array, int fromIndex, int toIndex)` - kääntää alkioiden järjestyksen päinvastaiseksi indeksien välillä.

> HUOM: indeksit ovat `[fromIndex,toIndex)` -- kääntäminen tehdään siis `fromIndex..<toIndex`, ei `fromIndex...toIndex`.

Koska järjestyksen vaihtaminen päinvastaiseksi ei vaadi olioiden vertailua, näissä algoritmien rajapinnoissa *ei esiinny* vaatimusta että `T`:n pitäisi toteuttaa `Comparable` -rajapinta.

**Testaa** toteutuksiasi (lajittelu ja kääntäminen) annetuilla yksikkötesteillä `grade_1/task_1` -hakemistossa (arvosanaan 2; `grade_2/task_1`). Miten tämä tehdään, kuvattiin yllä.

Älä etene Askel 2:een alla ennenkuin testit menevät läpi. Testien suorittamisesta on kurssilla ohjeistus muuallakin. Etsi tai kysy, jos et löydä.

Testit luovat satunnaisia taulukoita `Integer` ja `String` -olioita, ja lajittelevat niitä algoritmillasi. Testit vertailevat lajiteltuja taulukoita siihen mitä tuloksena pitäisi olla. Jos tulos ei ole odotettu, testi epäonnistuu. Reverse -testit eivät vaadi lajiteltua aineistoa, joten lajittelu- ja reverse -testit eivät ole riippuvaisia toisistaan.

Jos testi epäonnistuu, analysoi mikä meni pieleen ja miksi, lukien tarkkaan testien tulostuksia. Jos et ymmärrä mitä sieltä tulee ulos, kysy apua opettajilta.

**Vinkki:** Koska useissa algoritmeissa on tarve vaihtaa taulukossa olevien kahden elementin paikkaa, on hyödyllistä tehdä myös geneerinen `swap` -algoritmi...:

 ```Java
 public static <T> void swap(T[] array, int first, int second)
 ```

...joka vaihtaa indekseissä `first` ja `second` olevien olioiden paikkaa taulukossa. Voit kutsua tätä lajittelumetodeista ja muista taulukkoja käsittelevistä algoritmeista. Samaa asiaa ei kannata toteuttaa montaa kertaa (uudelleenkäyttö eli reusability on hyvä juttu)!


## Askel 2 - TIRA Codersin koodareiden lajittelu

### Testiaineiston lataaminen

Tarvitset tässä ja kaikissa muissakin kurssin tehtävissä **testiaineiston** jolla testata tietorakenteiden ja algoritmien toimintaa. Koska testiaineisto on todella laaja, se ei ole mukana tässä repositoryssä koska tiedostokoko on liian suuri GitHubiin ladattavaksi. **Älä** lisää tätä lataamaasi testiaineistoa omaan git:iin, sillä tiedostot ovat aivan liian suuria sinne. 

> **Älä käytä** GitHubin LFS:ää tähän tarkoitukseen. Raporttien kuvaliitteetkään eivät ole syy turvautua LFS:ään. Jos et tiedä mikä LFS on niin ei tarvitsekaan tietää.

**Hae testiaineisto** [TIRACoders.zip](https://drive.google.com/file/d/1-GU4HVON_txNmrq_7HCRe4tHweod5PSO/view?usp=share_link) tästä linkistä koneellesi. **Pura** haettu .zip -tiedosto tähän **samaan** hakemistoon missä repository on (hakemisto jossa nämä ohjetiedostot ja projektin `pom.xml` -tiedosto ovat). Sinun pitäisi nähdä nämä testiaineistotiedostot (`.json` -päätteiset tiedostot) myös VS Codessa, kuten tässä kuvassa näkyy:

![Testiaineisto näkyy VS Codessa](task-01-test-data-files.png)

> **Älä muokkaa testiaineistoa** millään tavoin. Jos aineisto menee sekaisin, koodi ei välttämättä enää toimi tai testit eivät mene läpi. Jos haluat, voit *kopioida* jonkun pienen aineiston *toiselle* tiedostonnimelle ja testailla sen kanssa omia juttujasi (vaikka lisätä sinne omat koodaritietosi). 

### Askeleen 2 ohjeet

**Kokeile** aluksi miten TIRA Coders toimii. Käynnistä sovellus ja huomaat että testikoodarit eivät ole aakkosjärjestyksessä. Lataa tiedostosta (valikko TIRA Coders > Import JSON phonebook) testikoodareita sisältäviä puhelinluetteloita (*pieniä*, isojen käsittely on vielä todella hidasta!) ja näet että nekin ovat missä sattuu järjestyksessä.

> Testiaineiston tulee siis löytyä projektin juurihakemistosta. Voit myös *kopioida* ne sellaiseen paikkaan josta vähemmillä klikkauksilla voit niitä avata TIRA Codersin käyttöliittymästä avata, tai vielä fiksummin, tehdä tiedostojärjestelmän *linkin* (Windows: shortcut, Mac/Linux: symbolic link). Oletushakemisto, jonka sovellus ensimmäisen kerran avaa, on käyttäjän kotihakemisto, joten kopioi tiedostot (tai tee linkit) vaikka sinne tai kotihakemiston uuteen alihakemistoon. Kun tiedosto on avattu kerran, sen jälkeen TIRA Coders käyttää samaa hakemistoa oletushakemistona, kunnes sovellus sammutetaan. **Älä** kuitenkaan *siirrä* tiedostoja pois tämän projektin päähakemistosta, sillä *testit* odottavat löytävänsä tiedostot sieltä.

**Tässä askeleessa**:

* **täydennät** luokan `oy.interact.tira.model.Coder` toteutusta,
* **täydennät** metodin `oy.interact.tira.util.SimpleContainer.sort()` toteutusta.

Testit edellä testasivat miten algoritmisi toimivat Javan tietotyyppien kanssa. Mutta tarkoituksenahan oli pystyä lajittelemaan *koodareita*, ei pelkästään kokonaislukuja tai merkkijonoja, kuten testit tekivät.

Toteutat koodareiden lajitteluun liittyvät asiat tässä osuudessa tehtävää. Kun olet valmis, geneeriset lajittelualgoritmisi osaavat lajitella myös `Coder` -olioita sisältäviä taulukoita luonnolliseen järjestykseen. Näet sitten käyttöliittymässä miten tämä tapahtuu!

Tutustu **ensin** luokkaan `oy.interact.tira.model.Coder` huolellisesti; sitä käytetään kaikissa muissakin kurssin harjoituksissa:

* Miltä luokka yleisesti näyttää; metodit, jäsenmuuttujat, jne.
* Huomaa miten `Coder` toteuttaa jo valmiiksi rajapinnan `Comparable`.
* Pane merkille kommenteissa esitetty huomautus siitä miten luokan toteutus (comparable, equals) poikkeaa yleisestä normista. Perustelut tälle on selitetty kurssin liveluennoilla (ja sen tallenteella).
* Rajapinnan `Comparable` ainoa metodi on `compareTo`, joka on **toteuttamatta**. 
* Luokassa on myös yhtäsuuruutta vertaileva metodi `equals`.
* Huomaa `@Override` näiden metodien yhteydessä. Ne kertovat kääntäjälle että tarkoitus on nimenomaan **ylikuormittaa** yläluokasta tai rajapinnasta peritty metodi. Tuo `@Override` on silloin hyvä sinne aina laittaa -- jos vahingossa muutat metodin rajapintaa erilaiseksi, kääntäjä ilmoittaa siitä virheellä. Jos nimittäin rajapinta onkin erilainen, **et enää ylikuormitakaan** perittyä metodia, eikä Java kutsu sitä silloin kuin pitäisi! Tämä tietysti johtaa kaikenlaisiin ongelmiin. Käytä siis **aina** tuota `@Override`:a kun tarkoitus on ylikuormittaa peritty metodi.

**Tutustu** `Comparable` -rajapinnan dokumentaatioon (Lähteitä -luku yllä). Pohdi mitä se vertailu tarkoittaa kun ei verratakaan kokonaislukuja, yksittäisiä merkkijonoja, vaan `Coder` -olioita?

Huomaa että `Comparable.compareTo()` -metodin tarkoitus on vertailla olioita siten että niiden järjestykseksi tulee ns. luonnollinen järjestys (*natural order*). Mitä se tarkoittaa `Coder` -olioiden suhteen, kun haluamme lajitella koodarit järjestykseen sukunimen ja etunimen mukaisesti?

**Toteuta** `Coder.compareTo()` siten että lajittelu *luonnolliseen* järjestykseen (järjestyksessä sukunimi - etunimi) tapahtuu *oikein*. Voit hyödyntää tässä Javan `String` -luokan `compareTo` -metodia.

Miten koodareiden lajittelu käyttöliittymän lajittelujärjestyslistan valinnasta lähtien oikein tapahtuu? Tätä ei ole pakko juurta jaksain ymmärtää, mutta voi olla avuksi. Käytännössä et koske tähän alla listattuun koodiin, ainoastaan `SimpleContainer` -luokkaan tulee pieniä muutoksia. Eli:

1. Käynnistä TIRA Coders sovellus (IDE:n debuggerilla tai komentoriviltä). Pane merkille että koodarit ovat sekalaisessa järjestyksessä. Voit kokeilla avata koodaritiedostoja valikosta ja nähdä että tiedot ovat tosiaan epäjärjestyksessä.
2. Valitse lajittelujärjestys käyttöliittymän listalta.
3. Tämä käyttöliittymän valinta käsitellään `DataControlPanel.actionPerformed()` -metodissa (luokka on packagessa `oy.interact.tira.view`).
4. Tällä saadaan aikaiseksi **lajittelujärjestysolio** `CoderSortOrder`.
5. Lajittelujärjestysolio annetaan lajittelua varten puhelinluettelo-oliolle: `TIRACodersApp.getModel().sort(order);`. Tässä vaiheessa kurssia puhelinluettelo-olio on valmiina annettu toteutus yksinkertaisesta taulukkopohjaisesta tietorakenteesta luokassa `oy.interact.tira.model.PhoneBookArray`.
6. `oy.interact.tira.model.PhoneBookArray.sort()` käynnistää lajittelun pistettyään lajittelujärjestyksen muistiin omaan jäsenmuuttujaansa. 
7. `PhoneBookArray.sort()` kutsuu metodia `currentSortOrder.getComparator();` joka **palauttaa tällä hetkellä aina `null`in**. 
8. Koska `currentSortOrder.getComparator()` palauttaa `null`, `PhoneBookArray.sort`kutsuu `phoneBook.sort()` -algoritmia joka lajittelee tietosäiliön **luonnolliseen järjestykseen** (katso kommentti koodissa alla):

```Java
public class PhoneBookArray extends PhoneBookBase {
...
	public void sort(CoderSortOrder order) {
...
		Comparator<Coder> comparator = currentSortOrder.getComparator();
		if (null != comparator) {
...
		} else {
			System.out.println("Comparators not yet implemented, sorting in natural order by full name");
			long start = System.currentTimeMillis();
			phoneBook.sort();        // <<<<<<<<<<<<<<< Lajitellaan luonnolliseen järjestykseen!
			addMeasurement("Sorting", System.currentTimeMillis() - start);
		}
```
Tuo olio `phoneBook` on luokka joka toteuttaa rajapinnan `TIRAContainer`. Tämä rajapinnan toteuttava luokka on tässä `SimpleContainer` (packagessa `oy.interact.tira.util`). Se on yksinkertainen taulukkoa hyödyntävä tietorakenne, jonka koodin siis olet saanut valmiina. Tai lähes valmiina.

**Tutustu** luokkaan `SimpleContainer` ja sen rajapintaluokkaan `TIRAContainer` ja erityisesti rajapintaluokan dokumentaatioon. Toteutusluokka pitää sisällään geneerisen taulukon `private E [] array`, jonne `Coder` -olioita laitetaan. Huomaa että tämä tietorakenne, kuten myös myöhemmin toteutettava tehokkaampi tietorakenne, ei anna lisätä duplikaatteja olioita. Eli jos samaa koodarioliota yritetään lisätä `SimpleContainer`iin uudestaan, jo taulukossa oleva *korvataan* uudella. Onko olio sama vai eri, testataan `.equals` -metodilla (valmiiksi toteutettuna `Coder.equals()`:ssa).

Tämä taulukko on aluksi tyhjä eli täynnä null -olioita. Kun koodariolioita lisätään taulukkoon, se tapahtuu aina edellisen perään, seuraavan `null`:n tilalle. Jäsenmuuttuja `count` kertoo montako koodaria taulukossa on ja mikä on siis se indeksi johon seuraava sitten lisätään. Kun taulukon tila loppuu kesken, sitä kasvatetaan, kopioimalla uuteen isompaan taulukkokon entisen pienemmän taulukon koodarit. 

Näin taulukossa on aina null -olioitakin, koska taulukkoa kannattaa kasvattaa aina reilusti isommaksi. Uudelleenallokointi on nimittäin **hidasta** koska se vaatii RAM -muistin allokointia ja tietojen siirto vanhan ja uuden taulukon välillä. Huomaat tämän jos yrität ladata suuria puhelinluettelotiedostoja tähän tietorakenteeseen sovelluksen valikosta. 

`SimpleContainer` on toteutettu siten että oikeat (ei-null) oliot ovat aina taulukon alussa, eli indeksien `0..<count` välissä. `null`it ovat sitten lopussa, *indeksistä count eteenpäin*. Tämä helpottaa ja nopeuttaa useita algoritmeja, koska taulukkoa voidaan siten käsitellä aina välillä `0..<count`.

Nyt **täydennät** luokan `SimpleContainer` **toteutusta** siten että se käyttää lajittelussa juuri toteuttamaasi lisäyslajittelualgoritmia! Näin koodarit saadaan käyttöliittymäänkin lajiteltuna!

**Lisää** `SimpleContainer.sort()` -metodiin (se jossa ei ole parametreja) **kutsu toteuttamaasi lisäyslajittelualgoritmiin**, antaen oikeat parametrit lajittelualgoritmille. Erityisesti huomioi tässä se, että koko taulukkoa `array` ei voi lajitella lajittelualgoritmilla joka olettaa että taulukossa on vain muuta kuin `null`:eja. Ja että kun on niin, että taulukon ei-null -arvot ovat kaikki välillä `0..<count`, ei ole edes järkeä lajitella myöhemmin olevia `null` -olioita. Eli kutsu oikeaa lajittelualgoritmiasi, oikeilla parametreilla. Jos et ymmärrä kumpaa kutsua, kysy apua.

**Käynnistä** TIRA Coders uudestaan (jos se oli jo käynnissä), ja **kokeile** että toteutuksesi toimii, valitsemalla lajittelujärjestys sovelluksen käyttöliittymästä. Huomaa, että se minkä lajittelutavan valitset valikosta, ei vaikuta millään tavalla lajittelujärjestykseen, joka on aina luonnollinen järjestys eli A...Ö. Toteutat vasta seuraavassa tehtävässä eri järjestyksiin lajittelun. 

**Varmista** siis vain että koodarit tulevat lajitelluksi aina nousevaan järjestykseen periaatteella sukunimi-etunimi. Valikkokomento "Clear phonebook" poistaa kaikki koodarit ja lisää alkuperäiset kolme testikoodaria jotka eivät ole aakkosjärjestyksessä. Voit siis tämän avulla aina kokeilla lajittelua uudestaan.

> Kun lataat nyt uusia koodari -JSON -tiedostoja valikon kautta, huomaat että ne ovat jo valmiiksi oikeassa järjestyksessä. Tämä johtuu siitä, että `PhoneBookArray.loadPhoneBook` joka lataa tiedostoissa olevat koodareiden tiedot tietorakenteeseen, kutsuu loppujen lopuksi `phoneBook.sort()` -metodia jonka olet nyt toteuttanut. Kätevää!

Jos ohjelma ja erityisesti lajittelu ei toimi oikein, korjaa virheet. Jos muutat lajittelu- tai kääntämisalgoritmejasi, muista myös ajaa yksikkötestit aina uudestaan! Älä muuta muuta koodia kuin sitä mitä yllä ohjeissa sanotaan, mahdolliset virheet eivät siellä ole.

> Huomaa että olet toteuttanut lajittelun hyödyntäen Javan `String` -luokan `compareTo` -metodia. Se *ei huomioi* kielikohtaisia lajittelusääntöjä, joten *järjestys ei ole välttämättä suomen kielen lajittelusääntöjen mukainen*. Miten kieli ja muut vastaavat alue- ja kulttuurikohtaiset asiat otetaan huomioon sovelluksissa, liittyy aiheisiin lokalisointi (*localization, l10n*) ja internationalisointi (*internationalization, i18n*), joita käsitellään **Ohjelmointi 4** -kurssilla.

**Lataa** TIRA Codersiin eri kokoisia *pieniä* koodaritiedostoja. Varmista että koko lista, ensimmäistä ja viimeistä koodaria myöten, ovat oikeassa nousevassa aakkosjärjestyksessä sukunimen ja sitten etunimen mukaan.

**Huomaa** myös että jos lataat suurempia koodaritiedostoja, ohjemasi toimii **todella hitaasti**. Esimerkiksi opettajan koneella tiedoston `100000-europe-coders.json` lataaminen muistiin ja lajittelu kesti tällä tietorakenteella ja tässä tehtävässä tehdyllä lajittelualgoritmilla 91,8 sekuntia.... hi-das-ta....

Tämä johtuu siitä että käytämme tässä vaiheessa kurssia vielä *hidasta* tietorakennetta ja *hidasta* lajittelualgoritmia. Nämä asiat korjataan myöhemmissä tehtävissä, kun opit tekemään nopeampia tietorakenteita ja algoritmeja -- se on tämän kurssin **oppimistavoite**. 

Nyt meillä on joku **vertailupohja** mihin yksinkertaisilla asioilla aikatehokkuuden suhteen pääsee -- ja mihin ei. Ja samalla olet päässyt enemmän sisään kurssin ohjelmointitehtävän aiheeseen, yksikkötestaukseen ja työkalujen käyttöön.

> Jos ohjelmasi ei vaan tunnu saavan hommaa päätökseen, voit lopettaa sen suorituksen kesken halutessasi. Kunhan varmistat testeillä että lajittelu kuitenkin toimii oikeellisesti.

Missä sitä `reverse()` -algoritmia nyt sitten tarvittiin? Jos katsot `PhoneBookArray.sort()`:n toteutusta, näet että tässä on tiettyä logiikkaa:

```Java
	if (oldOrder.isReversed(order)) {
		long start = System.currentTimeMillis();
		phoneBook.reverse(); // Not yet implemented, though!
```

Eli jos järjestys on edelliseen järjestykseen verrattuna käänteinen, ei kutsutakaan lajittelualgoritmia vaan sitä joka kääntää järjestyksen toisin päin. Miksi? Kun olet katsonut kurssin aikakompleksisuusluennot, **arvioi** mikä on sekä toteuttamasi lajittelualgoritmin aikakompleksisuusluokka, että kääntämisalgoritmin aikakompleksisuusluokka? Tätä koodia tosin *ei vielä tässä vaiheessa harjoitusta kutsuta*, koska nuo järjestysoliot ovat vielä luomatta. Seuraavassa tehtävässä, kun ne toteutetaan, voit sitten tarkastella näiden algoritmien nopeuseroja käytännössäkin.


## Raportti

**Kirjaa** raporttiisi (`RAPORTTI.markdown` joka löytyy projektin juurihakemistosta), **mitä opit** tehtävän tekemisestä, mikä oli vaikeaa, mikä helppoa, jne. Muista että raportti on myös kurssin **arvosteluun** vaikuttava asia!

Pohdi raportissasi myös seuraavia asioita:

* Mikä on toteuttamasi lajittelualgortmin *aikakompleksisuusluokka*?
* Mikä on toteuttamasi reverse -algoritmin *aikakompleksisuusluokka*?
* Jos taulukko on jo valmiiksi järjestyksessä nousevaan järjestykseen, ja se aiotaan lajitella laskevaan järjestykseen, kannattaako taulukko lajitella vai kääntää sen järjestys? Miksi, perustele?


## Lopuksi

Kun olet valmis, varmista että sekä raportti että kaikki koodi on paikallisessa git -repositoryssäsi ja myös etärepositoryssäsi (komennot `git commit`, tarvittaessa uusille tiedostoille `git add` sekä `git push`).

## Tietoja

* Kurssimateriaalia Tietorakenteet ja algoritmit -kurssille | Data structures and algorithms 2021-2024.
* Tietojenkäsittelytieteet, Tieto- ja sähkötekniikan tiedekunta, Oulun yliopisto.
* (c) Antti Juustila 2021-2024.