## 01-TASK

Opin toteuttamaan simppelin algoritmin koodilla käytännön hahmotuksen lisäksi. Toisaalta mieleen palasi Javan syntaksi ja sen raikkaus verrattuna mm. C++ ja Rustiin, joidenka parissa olen käytännössä koko Ohjelmointi 2 -kurssin jälkeisen ajan viettänyt. Haasteita tuli tuon maagisen 'TIRA Coders' -applikaation löytämiseen, sillä tykkään kirjoittaa koodini suoraan terminaalissa ja myös ajaa sen siellä. Kurssin tuleville toteutuksille lienee parasta selventää tuota hieman ja sitä, mistä/miten kyseisen applikaation voi avata.

Toteutetun lajittelualgortmin aikakompleksisuusluokka on O(n^2) ja vastaavasti kääntöalgoritmin O(n).

Taulukko kannattaa kääntää uudelleenlajittelun sijaan, sillä lajittelu joutuu tekemään tarpeettomia vertailuja eri muuttujien välillä. Ylimääräisille muuttujille muistin allokoiminen on myös hidasta sekä kallista muistin suhteen.


## 02-TASK

![Add- ja hakualgoritmi suhteessa listan kokoon](kuvat/t2.png)

Sekä add- ja koodattujen hakualgoritmien tulisi käytännössä olla lineaarisia ja vastata aikakompleksisuusluokkaa O(n). Kuitenkin jostain syystä omalla masiinallani benchmarkien käyrät muistuttavat enemmän eksponentiaalista kasvua. Ellen ole pahoin erehtynyt asian suhteen, saattaa syy johtua jostain muusta kuten esimerkiksi prosessorin thermal throttlaamisesta tai tarkastelujoukon koon pienuudesta.

Etsintäalgoritmini ei aluksi toiminut oikein, sillä tuota omalla koneellani noin kolme minuuttia kestävää testiä toistaessa se ei koskaan löytänyt listalla olevaa arvoa. Tajusin vasta varsin myöhään tehneeni kaikki for-loopit tarkistamaan arvot [0, count-1[, eikä [0, count-1]. Kysessä on siis klassinen off-by-one -virhe.

Nopean ja hitaan sorttauksen syynä lienee se, että monilla eri koodareilla on samoja koodarinimiä, jolloin uniikkien entryjen lukumäärä on moninkerroin pienempi. Molemmat algoritmit ovat vertailijaa lukuunottamatta identtisiä ja perustuvat samaan lisäyslajitteluun ensimmäisen tehtävän tapaan, joten myös näiden aikakompleksisuusluokan tulisi vastata luokkaa O(n^2).

Kuten ensimmäisessä tehtävässä on todettu, on listan kääntäminen nopeampaa uudelleenlajitteluun verrattuna. TIRA Coders -applikaatiossakin voi todeta tämän huomattavan eron näiden kahden välillä: sorttauksen suuntaa vaihtaessa kutsutaan vain reverse() -funktiota, joka tapahtuu alle sekuntissa. Sen sijaan pakollisen sorttauksen ollessa edessä esim. vaihtaessa sortattavaksi kohteeksi koodarinimen oikean nimen sijaan, kestää se useita sekunteja.

Toteutettuja hakualgoritmeja kutsutaan lineaarisiksi, sillä ne looppaavat jokaisen arvon läpi kertaalleen, toisesta päädystä toiseen. Siksi sen aikakompleksisuusluokka (O(n)) kuvastaa myös tätä lineaarisuutta.


## 03-TASK

![Binäärihaun osien kesto suhteessa listan kokoon](kuvat/t3.png)
![Excel-taulukko kyseisille tuloksille](kuvat/t3_2.png)

*Otathan huomioon, että 'binSearch'-sarakkeen ensimmäinen alkio on muutettu alkuperäisestä nollaan. Tämä virheellinen tulos teki käyrästä lähes hyödyttömän.*

Koska sovellus jäätyi jatkuvasti kokeillessani ladata 50k-kokoista tiedostoa, suoritin kokeilut tuolla suurimmalla toimivalla, 10k-kokoisella tietokannalla. Tällä tuo oletettavasti lineaarinen haku kesti ~20ms. Binäärihaun aika on login mukaan 0ms, joka tekee luonnollisesti näiden tulosten suhteellisesta vertaamisesta varsin haastavaa. Olennaista kuitenkin on se, että uusi algoritmi on ehtojen täyttyessä (haun pitää täsmälleen vastata tulosta) huomattavasti nopeampi.

Harmikseni en saanut kertaakaan tuota binäärihakua kestämään nollaa millisekuntia kauempaa, jolloin pienempiin tiedostokokoihin hakualgoritmin vertaaminen ei tuottanut vertailukelpoisia tuloksia. Tämä siis vaikka valitsin etsittäväksi alkioksi aina listan viimeisen, jonka haun pitäisi olla yksi kauimmin kestävistä tällä algoritmillä. Aikaisemman lineaarisen haun kesto skaalautui odotetusti tiedoston koon ja koodarin sijainnin mukaan. Sen sijaan binäärihaun tulisi olla tiedostokoosta riippumatta lähes välitön, mikäli haettava on täsmälleen listan keskellä. Tällöin funktio ei joudu rekursoimaan kertaakaan.

Kokonaisuudessaan tämän tehtävän haku on hieman hitaampi viime tehtävän vastaavaan nähden. Tämä johtuneen siitä, ettei lineaarinen haku edellytä listan hidasta sorttaamista. Jos sorttaamisen jättää laskuista pois, on se omalla järjestelmälläni noin 20 kertaa nopeampi. Kuten aikaisemmin todettu, tulee binäärihaun edellytysten täyttyäkseen haun vastata hakutulosta täsmällisesti. Sen käyttäminen lineaarihaun sijaan on kannattavaa testien perusteella pääosin vain silloin, kun lista on jo tai pitää sortata.

Tehtävän hakualgoritmin kompleksisuusluokka on O(log(N)), sillä jokaisen iteraation jälkeen tarkisteltava lista käytännössä jakaantuu kahdella. Oikean tuloksen löydettyä voidaan tarkastelu pysäyttää siihen paikkaan, eikä loppuja arvoja tarvitse tarkastella.


## 04-TASK

Kenties tärkein tämän tehtävän aikana opittu asia on se, että ehkä kuitenkin kannattaa rapidfire-toistokokeiden suorittamisen sijaan mennä Moodleen ja katsoa, että onko muilla ollut samankaltaisia ongelmia, kuin mikä on itsellä edessä. Nimittäin en millään saanut monenkaan tunnin ja hyvien yöunien jälkeen tehtävän sulkutestejä suoriutumaan ennen kuin erehdyin tuonne.

Suhteessa aikaisempiin tehtäviin, tämä tuotti huomattavasti enemmän hankaluuksia. Testamenttina tästä toimii mainiosti tuo toteutettu spagettikoodi (sic), jonka näistä kommiteista voi vapaasti lukea. Kaikki tehtävän lainausmerkkilogiikasta merkkijonon rivin ja kolumnin hakemiseen oli vähintäänkin aivoja silentävää.

Mitä tulee pinorakenteen aikakompleksisuusluokkaehtoihin, on niistä valtaosa helposti lajiteltavissa luokkaan O(1). Tälläisiä ovat mm.

1. clear(), joka luo uuden listaolion vanhan tilalle ja asettaa viimeksi asetetun elementin indeksin takaisin oletusarvoon -1.

2. isEmpty(), joka ei vertailun lisäksi kutsu muita muuttujia.

3. size(), joka suorittaa ainoastaan palautuksen lisäksi yhden laskutoimituksen.

4. peek(), joka palauttaa listan päällimmäisen arvon ilman for-looppia.

5. pop(), joka pienentää indeksiä yhdellä, poistaa päällimmäisen arvon ja palauttaa siitä tehdyn kopion.

6. push(), joka lisää annetun arvon listaan ja nostaa indeksiä. Poikkeuksena tiestysti listan täyttyminen, jolloin kutsutaan resize() -funktiota.

7. capacity(), joka palauttaa listan koon.

8. Kontsruktorit, jotka kummatkin luovat uuden listaolion, joko peruskoolla tai annetulla numerolla.

Sen sijaan toString() ja äskettäin mainittu resize() ovat poikkeuksia tästä. toString() käy uuvuttavan hitaasti jokaisen listan arvon läpi, ja lisää sen StringBuilder-olioon. For-loopin lisäksi siinä ei ole muita fuktiokutsuja, jotka joutuisivat käymään läpi jotain listaa. resize() puolestaan luo uuden listan, tällä kertaa kaksinkertaisella koolla aikaisempaan nähden. Jokainen vanhan listan arvo lisätään uuteen loopin sisällä ja lopuksi vanha lista korvataan uudella, antaen sen arvot Javan roskienkerääjälle kerättäväksi.


## 05-TASK

Tehtävä oli aikaisempaan verrattuna huomattavasti nopeampi tehdä ainakin omalta osaltani, vaikka ehkä vaatikin koodiriveissä mitattuna enemmän panostusta. Hankaluuksista ei sinänsä ollut mitään merkillepantavaa, ehkä joitain pieniä satunnaisia logiikkavirheitä tuli siellä sun täällä. 

Linkitetty lista käyttää taulukkopohjaiseen vastaavaan verrattuna enemmän ram-muistia, sillä jokainen elementti joutuu pitää sisällään osoittimen edelliseen ja tulevaan elementtiin. Hyvänä puolena tämä kuitenkin mahdollistaa tehtävänannossa alleviivatun käytännössä tarpeeksi suuren listan muodostamiseen ilman että uudelleenallokointia vaativa raja tulisi vastaan. Elementtejä voidaan mielivaltaisesti lisätä jokaiseen listan indeksiin ilman, että listan jokainen olio sitä ennen tai sen jälkeen jouduttaisiin manuaalisesti siirtää yhdellä eteenpäin.

Vaikka molempien listatoteutusten lisäysmetodien aikakompleksisuusluokka on tavanomaisesti O(1), on taulukkopohjaisen listan lisäysmetodin listan täyttyessä luoda uusi lista, rekursoiden jokaisen arvon läpi. Käytännössä siis aikakompleksisuusluokasta tulee tällöin O(n).

Toisaalta listalta on helpompaa poimia arvo mielivaltaisesti valitun indeksin kohdalta, sillä jokaisen arvon sijainti on tiedossa. Linkitetyn listan kanssa tämä vaatii pakollista looppaamista jommasta kummasta päädystä toiseen siihen asti, että haluttu arvo löydetään.

Listaimplementiossani ainoat silmukoita sisältävät funktiot ovat toString() ja resize(). Linkitetyssä listassa tällainen on vain toString(), sillä listan kokoa ei tarvitse erikseen muuttaa. Kuten aikaisemmin mainittu, vaatisi elementtien haku indeksien ja tietysti myös arvon perusteella jokaisen arvon läpi silmukoimista halutun tuloksen saavuttamiseen saakka.


## 06-TASK

![Sorttausalgoritmien vertailu toisiinsa](kuvat/t6.png)

Opin tässä tehtävässä toteuttaamaan hieman käytännönläheisempiä sorttausalgoritmeja. Tehtävässä ei onneksi tarvinnut kirjoittaa kovinkaan paljon koodirivejä, mutta määrän sijaan niiden tuli tällä kertaa olla verrattain laadukkaita. Vaikeuksia tuotti erityisesti tuo heapsortin implementointi tilanteessa, jossa alku- ja loppupään indeksit on erikseen annettu. Tästä toki tehtävässä etukäteen jo varoitettiinkin.

Kuten ylle kiinnitetystä kuvankaappauksesta voi todeta, on tehtävän nopeat algoritmit aikakompleksisuusluokaltaa toisissa sfääreissä suhteessa hitaaseen insertionsorttiin. Tämän vuoksi jouduinkin tekemään listasta logaritmisen, jotta kaikista pienimmät arvot pystyttiin edes havaita insertionsortin elinkautiselta tuntuvien aikayksiköiden vieressä. Uudet algoritmit ovat toisiinsa nähden selvästi eri mittaisia, muttei missään nimessä hitaita suhteessa hitaaseen algoritmiin.

Huomiona muuten, tajusin tätä tehtävää tehdessäni kirjoittaneeni insertionsortista O(n)-luokkaisena algoritmina, vaikka kahden silmukan vuoksi sehän on O(n^2). Palatakseni tähän tehtävään, testien ohella selvää on, että algoritmien aikakompleksisuusluokille O(f(n)) pätee O(f(n)) < O(n^2). Kuitenkaan O(n) ne eivät voi olla, sillä testitulokset eivät viittaa lineaarisuuteen. Tarkemmin en osaisi näitä varmaankaan itse luokitella, mutta materiaalia hyväksikäyttämällä voin todeta kaikkien uusien algoritmien seuraavan samaa O(n*log(n)) -aikakompleksisuusluokkaa.

Testien lomissa mergesort näyttää olevan selvä voittaja. Itsellä pisti silmään se, että siinä tosiaan pidetään yllä aina kahta listaa, joka luonnollisesti tulee lisääntyneen muistinkulutuksen kustannuksella. Toisaalta siinä missä muut algoritmit menivät jokseenkin pääni yli, oli tämä paljon ymmärrettävämpi ja siten myös helpompi implementoida.

Heapsort on muistinkäytöltään ehkäpä parhain näistä, joskaan tätä en itse päässyt testaamaan. Nopeudeltaan se on myös kaikista ennustettavin, quicksort mahdollisesti vähiten. Quicksortin kulmakivenä toimii hyvin valittu pivot-piste, jota ilman sorttauksen teho kärsii ja pahimmillaan aikakompleksisuudeltaan alkaa jäljentää O(n^2).

Omilla testeilläni algoritmien sijoitus nopeustestissä oli lähes aina kaikilla yli sataa koodiria sisältävän tiedoston sorttauksessa sama: mergesort tuli ensimmäisenä, quicksort toisena ja heapsort viimeisenä. Tätä pienemmistä aineistoista en osaa kommentoida muuta kuin sen, että aina pienempään tiedostoon tultaessa metodien tehokkuus lähenee toisiaan.


## 07-TASK

![Taulukko, BST:n hidas ja nopea implementaatio verrattuna keskenään](kuvat/t7.png)

*Huom. kuvassa on jälleen kerran hyödynnetty logaritmista skaalaa.*

Tämän tehtävän tekemiseen meni ainakin toistaiseksi eniten aikaa suhteessa aikaisempiin tehtäviin. Syynä lienee todennäköisesti ensinnäkin kyseisen tietorakenteen tuntemattomuus omalta osaltani sekä myös se, että koodin toiminnan hahmottaminen oli haastavampaa ja vaadittava koodimäärä suurempaa. Huomasin myös TIRA Codersia katsoessa, että olin tehnyt virheen tehtävässä numero kaksi, jossa vertasin olioiden yhtäpitävyyttä "=="-merkillä sen sijaan, että olisin käyttänyt equals()-metodia. Luulin näiden toteuttavan tismalleen saman asian, mutta kuinka ollakkaan, TIRA Codersista puuttuvat koodariystävät pamahtivat ruudulle välittömästi tämän korjaamisen jälkeen.

Oikeellisuudesta voin todeta sen, että yksikkötestit suoriutuivat onnistuneesti, enkä itse pystynyt paljaalla silmällä löytämään mitään hälyyttävää ongelmaa koodista. Toki ei olisi ennennäkemätöntä, että koodissa lymyilisi virhe, joita testejä ei olla kirjoitettu huomioimaan, kuten tuosta mainitsemastani mokasta voi huomata. 

Olen liittänyt tehtävän alkuosaan kuvan, jossa on vertailtu 50000 koodarin käsittelyä taulukolla, hitaalla sekä nopealla BST-implementaatiolla. Taulukko on puhtaasti nopein hakiessamme elementtiä annetusta indeksistä, joka toki vaatii sen, että taulukko ollaan etukäteen sortattu. Jos taulukkoa ei oltaisi sortattu, kestäisi tämä operaatio jopa kauemmin, kuin BST:n hitaampi implementaatio. Eli siis vaikka taulukko on tässä asiassa testien perusteella tuplasti nopeaa BST:tä nopeampi, on se käytännössä yhtä hidas hitaamman version kanssa. Muissa testeissä molemmat BST:t ovat lähestulkoon yhtä nopeita. Tämän testin suuri eroavuus johtunee siitä, että hitaampi BST joutuu käymään jokaisen elementin aina haluttuun indeksiin saakka läpi, kun taas nopeampi pystyy käyttämään jokaisen noden lapsilukumäärää hyödykseen laskiessaan suunnan, jonne tulisi seuraavaksi edetä löytääkseen halutun arvon.

Haku on kaikissa lähes yhtä nopea, joskin taulukon nopeus jää hieman vajaaksi muista kilpailijoista. Exporttauksessa yllättäen hidas BST näyttänee tulevan ensimmäiseksi, joskin voimme kommittien perusteella todeta, ettei kyseisen testin käyttämä funktio muuttunut ollenkaan hitaasta nopeaan versioon päivitettäessä. Testien hitain osuus nähdään kuitenkin vasta importtauksessa, jossa taulukolla kestää päälle minuutti viidenkymmenen tuhannen koodarin lisäämiseen samalla kun BST:llä kestää vain muutamia kymmeniä millisekunteja.

Nopeamman BST:n funktioiden aikakompleksisuusluokat ovat seuraavat:

1. Funktioiden indexOf(), getIndex(), add(), get() ja remove() aikakompleksisuusluokka on O(log(N)), sillä jokainen niistä joutuu käymään useita arvoja läpi. Minkään näistä ei kuitenkaan tule tarkistaa listan jokaista arvoa toisin kuin seuraavissa funktioissa, sillä ne saavat jatkuvaa syöttöä siitä, tullaanko lähemmäs vai kauemmas halutusta arvosta.

2. findIndex(), find() ja toArray() jäljentävät hitaampaa aikakompleksisuusluokkaa O(n), sillä ne joutuvat hiitaasti käymään lähes jokaisen arvon läpi, ilman minkäänlaista ohjennuoraa siitä, missä suunnasta etsityn arvon tulisi löytyä.

3. Simppelimmät funktiot accept(), size(), capacity(), ensureCapacity() ja clear() joutuvat tekemään vain staattisia operaatioita, eikä niissä ole käytetty minkäänlaista silmukkaa. Näin ollen niiden aikakompleksisuusluokka on  O(1).

Täydellisen BST:n kerroksien lukumäärää on mahdollista simuloida seuraavalla kaavalla:

(2^k)-1 = n, missä n on mikä tahansa koodarien määrää esittävä kokonaisluku ja k on kerrosten lukumäärä. Koska k kuvaa kerrosten lukumäärää, ja kerrokset voivat olla vajaita, mutta eivät kapasiteettiansa suurempia, pyöristetään k ylöspäin lähimpään kokonaislukuun.

Tästä saadaan seuraavat:

- k=4, kun n=10.

- k=7, kun n=100. Omalla toteutuksellani vastaava k:n arvo oli 13.

- k=10 ja omalla k=22, kun n=1000.

- k=13 ja omalla k=29, kun n=5000.

- k=14 ja omalla k=30, kun n=10000.

- k=16 ja omalla k=40, kun n=50000.

- k=17 ja omalla k=38, kun n=100000.

- k=20 ja omalla k=51, kun n=1000000.

- k=21, kun n=2000000. Muistini loppui tässä vaiheessa ja oli kiire viettämään viikonloppua, joten en jaksanut lähteä allokoimaan JVM:lle lisää muistia saatika lisäämään swappia.

Käytin toteutustapaa D funktioissa indexOf() ja getIndex(), A funktioissa toArray(), find() ja findIndex() sekä viimeisenä iteratiivista B:tä fuktioissa add(), get() ja remove(). Kaikki O(n) funktiot olisi ollut suotavaa toteuttaa D:nä, joskaan en sille löytänyt ratkaisua predikaatin käytön takia. Tästä lopullisesta toteutuksesta en oikeastaan muuttaisi mitään, mutta tulevaisuudessa aloittaisin kyllä suoraan tuosta D:stä sen sijaan, että lähden implementoimaan hitaampaa ratkaisua vain kumittaakseni sen pois nopeamman edeltä.

Testien mukaan hitaassa BST:ssä noden hakeminen indeksin perusteella ja exporttaaminen veivät tiedostokokoon nähtynä eksponentiaalisesti enemmän aikaa, kun taas lineaarisesti suhteessa koodaritiedoston kokoon käytetty aika kasvoi noden haussa annetun arvon pohjalta. 

Nopealla implementaatiolla tulosten seulominen oli hieman vaikeampaa sen nopeuden vuoksi. Näyttää kuitenkin siltä, että tässä elementin hakemiseen indeksin perusteella käytetty aika näyttää kulkevan käsi kädessä koodaritiedoston koon kanssa, eli lineaarisesti.

Pieni lisäys tulevaisuudesta tähän tehtävään. Siitä on kulunut jo päälle kaksi kuukautta, kun viimeksi koskin tähän tehtävään. Kaikki muutkin tehtävät olin jo tehnyt päälle kuukausi sitten, mutta yllätyksekseni saamani sähköposti automaattitestien suorituksiksta herjasi yhdestä epäonnistuneesta testistä.

No kuinka ollakaan, erratan mukaan testejä oltiin päivitetty kesken kurssin. En saanut Moodlelta tästä ilmoitusta. Koodissani oli virhe, siitä ei käy kiistäminen. Pidän sitä kuitenkin kertakaikkisen hyväksyttämättömänä, että keskellä kurssia testiohjelmia muutetaan noin vain ja erityisesti niin, että ne eivät ole yhteensopivia vanhojen kanssa. Kyseessähän ei ollut mikään kokeista tuttu yhden tehtävän pikku moka, vaan arvosanaan yksi vaadittu virhe. En siis olisi päässyt kurssista läpi, mikäli en olisi tuota yhtä sähköpostia sattunut vahingossa aukaisemaan.


## 08-TASK

![Hidas taulukko, binary search tree ja hashtable verrattuna keskenään](kuvat/t8.png)

Tehtävän tekeminen vei enemmän aikaa suhteessa kaikkiin aikaisempiin tehtäviin, vaikka tämän toteutus olikin mielestäni helpompi oivaltaa. Syy lienee suurelta osin siinä, että kyseisellä ajanhetkellä alkoi muiden kurssien tehtävät painaa enemmän päälle, jolloin tietorakenteet jäivät taka-alalle. Tämän viiveen takia osa tehtävän nippelitiedosta on valitettavasti ehtinyt jo unohtumaan, mutta yritän kuitenkin parhaani.

Hashtablen funktioista monet toimivat ideaalissa tilanteessa aikatehokkuudella O(1), mutta pahimmillaan O(n), kun lasketun hashin kohdalta taulukosta seuraavaan nulliin on pitkä matka. Tälläisia ovat add(), get() ja remove(), vaikkakin lisäysfunktion kohdalla taulukkoa joudutaan suurentamaan vanhan ollessa 75% täynnä. Tällöin lasketaan jokaiselle vanhan taulukon elementille uusi indeksi uuteen taulukkoon, jossa siinäkin voi syntyä uusia törmäyksiä. Eli siis haarukka lisäyksessä käytetylle resize-metodille on O(n)-O(n^2).

Find() on näihin verrattuna poikkeus, sillä se aloittaa tarkistamisen aina taulukon pohjalta ja etenee siitä eteenpäin haluttua arvoa etsiessä ja on näin ollen O(n). Tähän verrattuna vieläkin ennustettavampaa lineaarisuutta kuvastaa toArray(), joka käy jokaisen elementin läpi, eikä pysähdy ennen listan toista päätä.

Luokkaan O(1) kuuluvat size(), capacity(), ensureCapacity() ja clear(), jotka ovat kaikki verrattain yksinkertaisia funktioita ilman silmukoita.

Päätin hashtablen osalta toteuttaa poistamisen yksinkertaisimmalla ja myös suurelta osin tehokkaimmalla tavalla annetuista esimerkeistä. Kyseessä on tietysti siis tämä elementtien määrittäminen tyhjäksi binäärisellä lisämuuttujalla, jonka ansiosta elementtejä ei tarvitse lähteä siirtämään varsin vaivalloisesti indekseistä toisiin. Setissä sen sijaan vastaava ei toiminut, vaikka alkuunkin yritin tehdä jotain luokkaa, joka sisältäisi geneerisen arvon T ja tiedon arvon poistamisaikeesta. Koska tämä ei tuntunut toimivan ideaalisti, niin päätin siirtyä juuri tuohon elementtien liikuttamiseen poistometodissa, jottei muita metodeita tarvitse vaivautua muuttamaan. Lopputulos on hieman sotkuinen, sillä naiivin siirron sijaan jokaisen listan arvon hashi tuli uudelleentarkistaa ja siirtää mahdollisesti toisaalle aina seuraavaan nulliin asti.

Hajautustauluun sadantuhannen koodarin lisääminen vei 206ms, kun taas hitaalla taulukolla vain 15ms. Syy tähän löytynee varmaankin siitä, että pelkästään lisätessä taulukko voi aina laittaa uuden elementin heti seuraavan perään, tarvitsematta laskea jokaiselle arvolle omaa hashia.

Ero vaikka onkin puhtaan lisäyksen kanssa suhteessa toisiinsa iso, on absoluuttinen ero tiedon etsimisessä valtava. Nimittäin hitaalla taulukolla tähän meni samaisessa testissä noin 220 sekuntia, joka on huomattavasti hajautustaulun 107 millisekuntia pidempi aika. Puhumattakaan siitä, että ensimmäisellä tuo aika moninkertaistuu aineiston koon kanssa. Tämä lieneekin koko hajautustaulun tarkoitus, löytää tietty arvo annetun avaimen kohdalta taulukosta ilman uuvuttavaa koko listan läpikäyntiä. Exporttaaminen kummastakin toteutuksesta kesti vajaat kymmenen millisekuntia, sillä molempien toArray()-metodit tehtiin lineaarisina, alusta loppuun looppaavina.

Nopea BST ja hajautustaulu olivat verrattavissa asteikoissa aikatehokkuudessa, joskin suurilla aineistoilla etsiminen näyttänee ymmärrettävästi kallistuvan hajautustauluun puolelle. Muistaakseni BST:n hidasta versiota ei ole tallessa muualla kuin aikaisemmissa commiteissa ja sikäli päätin tässä vedota teoriaan. Teorian mukaan hitaiden ja nopeiden BST:den erot tulisivat näkyä vain indeksiperusteisessa hakemisessa, joita on vaikea erojensa takia verrata tämän tehtävän tauluihin. Toisin sanoen havainnot nopean BST:n, hitaan taulukon ja hajautustaulun välillä ovat kutakuinkin yhtäpitävät hitaan BST:n kanssa, enkä siksi lähde sitä erikseen vertaamaan.


## 09-TASK

Tehtävässä toteutettava algoritmi oli tähän mennessä itselle tuntemattomin. Teoriaan tutustuminen syvällisemmin oli siis tarpeen. Oli taas vaihteeksi virkistävää päästä käyttämään Javan valmiiksi annettuja luokkia omien implementaatioiden sijaan, sillä niihin pystyi turvautumaan sellaisenaan. Varsin mukavaa oli jälleen kerran aikakompleksisuudeltaan yksinkertaisten funktioiden laatiminen, erityisesti suhteessa noihin hakualgoritmeihin ja niiden näennäiseen monimutkaisuuteen.

Toteutukseni oikeellisuudesta en menisi takuuseen, sillä ainakin itse huomasin testien olevan puutteellisia omaan makuuni. Esimerkiksi Queue:n käyttäminen tehtävässä vaaditun PriorityQueuen sijaan saa testit läpäisemään ainakin omassa tapauksessani. Toisaalta on myös mahdollista, että olen hieman väärinymmärtänyt osia kirjoitetusta koodista.

Funktioiden aikakompleksisuusluokat:

- O(V+E): toString(), breadFirstSearch(), depthFirstSearch(), hasCycles(). Molemmat hakufunktiot joutuvat pahimmillaan käymään jokaisen graafin pisteen (V) ja näiden yhdistävän nuolen (E) läpi kertaalleen. hasCycles kutsuu itseään niin kauan, että ensimmäinen sykli on löydetty. Ennen tätä se joutuu käymään pisteen jokaisen naapurin ja näiden naapurit läpi, siis käytännössä samalla tyylillä BFS:n tapaan.

- O(1): getVertices(), createVertexFor(), addEdge(), addDirectedEdge(), getEdges(). Jokainen näistä käy kommentoja läpi ilman sen kummempaa iteroimista. Joskaan getVertices:n kohdalla en ole täysin varma siitä, miten tämä luo uuden hajautustaulun annetusta listasta. En löytänyt tähän nopealla internethaulla mitään relevanttia vastausta, joten se jää nyt näiden muiden kanssa samaan luokkaan.

- O(V): getVertexFor(), route(). getVertexFor joutuu sekä hitaalla, että nopealla implementaatiolla käymään listan pisteitä läpi. Erona tosin se, että uudella tavalla se tekee sen huomattavasti nopeammin läpi käyttäen hyödyksi elementin hashia. Vanha funktio (joka on jätetty tuohon koodiin kommentoituna) käy jokaisen alkion läpi varsin naiivisti. Uuden funktion nopeuteen tietysti vaikuttaa hash-funktion toteutuksen laatu sekä elementtien tyyppi. Route käy listan visit-alkioita läpi, kulkien näiden avulla ensimmäiseen visit-olioon asti.

- O(V^2): disconnectedVertices(), isDisconnected(), shortestPathDijkstra(), shortestPathsFrom(). isDisconnected hyödyntää disconnectedVertices:iä, joka puolestaan joutuu ensitöikseen kutsumaan BFS:ää. Tämän tehtyään funktio käy läpi jokaisen listaan tallennetun pisteen kertaalleen tutkiakseen, onko olion listassa yhtään alkiota, jota ei löydetty BFS:llä. Jos on, niin funktio poistaa nämä hakufunktiolla löydetyt näistä ja lisää uuteen listaan kaikki jäljelle jääneet alkiot. Ehkä toteutukselle olisi huomattavasti parempi toteutusvaihtoehto esimerkiksi suoraan palauttamalla pistelista sen sijaan, että jokainen olio tulisi ensin lisätä uuteen, halutunlaiseen listaan.

Käytin alkuu hashmappia, joten koitin sitten testata implementaation nopeutta hashtablella. Selkeää eroa en näiden väliltä löytänyt, mutta teorian mukaan hashmapin tulisi olla nopeampi. Näin ollen vaihdoin takaisin hashmappiin.

Olin hätähousu ja ryhdyin heti vaihtamaan koodiani tehtävänannon mukaan. Tehtävän ratkaiseminen vastauksen näkemisen jälkeen on hieman vaikeaa. Oli miten oli, paranneltua tyyliä mainostettiin tehtävässä aika voimakkaasti, joka toki oli ansaittua testien mukaan. Nimittäin kymmenentuhannen koodarin lisääminen listaan vanhalla tavalla vei hieman yli kaksikymmentä sekuntia ja uudella tämä vei alle sata millisekuntia.

Jos netistä löytämääni kaavaan on mitään luottamista, niin testattujen verkkojen tulisi olla harvoja. Seuraavan kaavan mukaan graafi on tiheä f(E,V) = (2E)/(V(V-1)), jos f(E,V) > 0.5. Nopealla matematiikalla noin jokaista pistettä kohtaan tulee olla viiva hieman alle joka neljänteen pisteeseen. Koodareiden tapauksessa siis tämä tarkoittaisi sitä, että tuhannella koodarilla tulisi olla jokaisella vähintään noin 250 kaveria tuosta joukosta. Tämähän ei siis pidä paikkaansa.

Mappi on verrattain skaalautuva tietosäiliö ainakin tuohon matriisiin verrattuna. En näe mitään syytä tyytyä matriisiin, kun vaihtoehtona on avain-arvo-parien hyödyntäminen mapilla.

Kuten yllä todettu, oli aikaisemmin tietorakenne huomattavan hidas ennen korjausta. Jokaisen listan pisteen läpikäyminen on hidasta, puhumattakaan saman toimenpiteen toteuttaminen lukuisia kertoja jokaiselle funktiokutsulle aina kasvavilla aineistoilla. Uudesta listasta arvon kalasteleminen hashilla on huomattavasti nopeampaa, sillä halutun arvon löytämiseksi ei tarvitse aina käydä samoja arvoja läpi.
