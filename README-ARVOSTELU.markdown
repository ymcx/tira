# TIRA-2024 Arvostelu

Alla tärkeää asiaa arvostelusta, aikatauluista, ja muista asioista. Lue tämä tarkkaan heti kurssin alussa ja kertaa tarvittaessa. Kysy jos et ymmärrä tai joku asia jää epäselväksi.

Asiat selitetään tässä juurta jaksain, syystä että aiemmin asioita ei ole aina esimerkiksi tiedetty, tai asiat on ymmärretty väärin, tai on tehty paikaansa pitämättömiä oletuksia siitä mitä saa ja mitä ei saa tehdä. Tarkoitus on siis välttää nämä väärinkäsitykset ja tiedon puutteesta johtuvat mahdolliset hankalat tilanteet, siinä vaiheessa kun kurssia arvostellaan.


### Ohjelmointitehtävien deadlinet ja arviointi

**Ohjelmointitehtävien** aikataulutus on suunniteltu niin että *aloitat* tehtävän aikataulussa mainitulla viikolla. Huomaa tehtävien ajoitus ja deadline; palauta työsi ajoissa etärepoon! Älä jätä hommia viime tippaan, se on yleinen resepti lisästressille ja alemmalle arvosanalle tai jopa hylätylle suoritukselle. Aloita töiden tekeminen ja viimeistele työsi mieluummin etupainoitteisesti.

**Deadline**: Kun kurssin deadline tulee, opettajien automaattiset testiskriptit ottavat etäreposi sen hetkisen version ja suorittavat tehtävien automaattiset yksikkötestit. 

Lisäaikaa ei anneta, eli arvosana määräytyy sen mukaan, minkä arvosanatason testit menevät läpi deadlinen tullessa.

Jokaiselle tehtävälle on testejä jotka on saatava läpi. Näiden pakollisten tehtävien läpäistyään kurssilta voi saada arvosanaksi 1, jos tentit ovat menneet läpi. Kuvasta alta näet esimerkiksi testihakemistossa `grade_1` olevat alihakemistot -- kaikki näissä olevat testit on läpäistävä arvosanan 1 saamiseksi:

![Testit arvostelua varten](readme-arvostelu-grades-tests.png)

Kurssin läpäisee siis **arvosanalla 1**, jos kaikki testit testihakemistossa `grade_1` eli sen alihakemistoissa `task_1...task_8` olevat testit menevät läpi.

> Alempana tässä ohjeessa ja kunkin tehtävän omassa ohjeessa, on tarkemmin kerrottu mitä koodia tehtävässä pitää toteuttaa, jotta testit saa läpi.

Mikäli tavoittelet arvosanaa 2, kaikkien arvosanan 1 testien on mentävä läpi ja sen *lisäksi*, testihakemiston `grade_2` kaikkien testien on mentävä läpi. Sama pätee arvosanaan 3, 4 ja 5.

Ajankäytöllisesti on suositeltavaa, että teet ensin **jokaisen** tehtävän arvosanatasolle 1, ja vasta **sen jälkeen** kun arvosana 1 on turvattu, lähdet tekemään tehtävistä seuraavan arvosanan osuuksia.

Huolehdi siis siitä, että ennen kuin etenet korkeampien arvosanojen tehtäviin, **kaikki** edellisen arvosanan testit menevät läpi. Vaikka olisit tehnyt esimerkiksi arvosanan 3 edellyttämiä tehtäviä, jos kaikki niiden testit eivät mene läpi, voimaan jää se arvoasana jonka **kaikki** testit menevät läpi.

> Huolehdi myös ettet käytä tehtävien ratkaisuissa **kiellettyjä** tekniikoita. Näitä on listattu pääohjeessa [README.markdown](README.markdown), luentomateriaaleissa sekä kunkin tehtävän omassa ohjeessaan. Kiellettyjen ratkaisujen käyttäminen tarkoittaa arvostelussa samaa asiaa kuin että testit eivät mene läpi.

Tässä paketissa on myös mukana työkalu `checktabu.jar` jolla voit testata käyttääkö koodisi kiellettyjä ratkaisuja tai muuten vaan turhaan importtaa sellaisia asioita joita tehtävän ratkaisussa ei tarvita. Tämän linkin takana työkalun ohjeet [CHECKTABU-README.markdown](CHECKTABU-README.markdown).

**Jos tavoittelet arvosanaa 4 tai 5**, huomioi että testien läpäisyn lisäksi palautus tapahtuu tekemällä Moodlessa **ajanvaraus**, ja kyseisenä aikana käydään Zoom -sessiossa läpi palautustasi opettajan kanssa keskustellen. Kuvailet ja perustelet tekemiäsi ratkaisuja, niiden hyviä ja huonoja puolia, ja opettaja voi myös esittää kysymyksiä palautuksestasi. Mikäli palautuskeskustelussa et pysty perustelemaan ja selittämään tekemiäsi ratkaisuja ja niiden etuja ja haittoja, tämä vaikuttaa arvosanaan alentavasti.

**Arvosanatavoitteestasi huolimatta**, jos sinulla on vain harvoja isoja committeja, varsinkin lähellä deadlinea, valmistaudu siihen että sinua pyydetään selittämään toteutuksesi yksityiskohtia opettajille Zoom -sessiossa. Mikäli et osaa selittää miten ja miksi koodisi toimii kuten se toimii, tämä vaikuttaa arvosanaan alentavasti tai suoritus hylätään. Pistokoemaisesti tällaista voidaan tehdä muutenkin, ilman sen kummempia epäilyksiä.


### Arvosanatasot ja tehtävät

Kurssilla on yhdeksän (9) ohjelmointitehtävää. Osassa tehtäviä on vaatimuksia joita ei edellytetä toteutettavaksi arvosanalle 1, jne.

Alla on listattu mitä mihinkin arvosanaan tehtävissä vaaditaan (tenttien läpäisyn lisäksi).

**Arvosanaan 1** vaaditaan:

* Tehtävä 1 kokonaisuudessaan (lisäyslajittelu, reverse).
* Tehtävä 2 kokonaisuudessaan (lisäyslajittelu nousevaan ja laskevaan järjestykseen Comparator -oliolla).
* Tehtävä 3 puolitushaun rekursiivinen toteutus.
* Tehtävä 4 pinotietorakenne, soveltavan tehtävän perusasiat (sulkujen tarkistus `ParenthesisChecker`llä, lainausmerkkien välissä olevia ei tarvitse huomioida).
* Tehtävä 5 jonotietorakenne, taulukkoon perustuva jonon toteutus ja soveltava osuus.
* Tehtävä 6 pikalajittelualgoritmin (quicksort) toteutus ja soveltava osuus.
* Tehtävä 7 binäärinen hakupuu, lisäys ja haku nopeita, muut algoritmit hitaampia, puu toimii kohtuullisesti tietorakenteena sovelluksessa pienemmillä aineistoilla.
* tehtävä 8 hajautusfunktion ja hajautustaulun oikeellinen toteutus ja soveltava tehtävä (CodeWordsCounter).

**Arvosanaan 2** vaaditaan edelliset ja lisäksi:

* Tehtävä 3 puolitushaun iteratiivinen toteutus.
* Tehtävä 4 soveltavassa osuudessa sulkujen tarkistus, lisäksi huomioiden myös lainausmerkit yhdellä rivillä.
* Tehtävä 5 jonon toteutus linkitettynä listana.
* Tehtävä 6 lomituslajittelu (merge sort).

**Arvosanaan 3** vaaditaan edelliset ja lisäksi:

* Tehtävä 4 soveltavassa osuudessa sulkujen tarkistus lisäksi huomioiden useamman rivin lainausmerkit.
* Tehtävä 6 kekolajittelu (heap sort).
* Tehtävä 8 Useamman (väh. 3) kirjallisuuten perustuvan hajautusfunktion toteutus ja tehokkuusvertailu raportissa.
* Tehtävä 9 verkon (graph) muodostaminen sekä leveys- että syvyyshakualgoritmit (BFS, DFS).

**Arvosanaan 4** vaaditaan edelliset ja lisäksi:

* Tehtävä 6 kaikissa kolmessa lajittelussa (quicsort, heapsort, mergesort) myös alueen (range) lajittelu,
  siten että aloitusindeksi voi olla > 0.
* Tehtävä 7 puusta poistaminen oikeellisesti.
* Tehtävä 8 hajautustaulusta poistaminen oikeellisesti, useampien hajautusfunktioiden toteutus ja vertailu raportissa.
* Tehtävä 9 verkkojen syklien tunnistaminen ja erillisten alueiden tunnistaminen.

**Arvosanaan 5** vaaditaan edelliset ja lisäksi:

* Tehtävä 7 (BST) elementin haku indeksin avulla ja indeksin haku elementille, aikatehokkuudella erittäin nopeita. Puu toimii esimerkkisovelluksessa tällöin tehokkaasti suurillakin testiaineistoilla.
* Tehtävä 8 joukko-tietorakenteen (Set) toteutus hajautustaulun periaatteilla, mukaan lukien poistaminen.
* Tehtävä 9 Dijkstran lyhimmän polun hakualgoritm, aikatehokkuuden huomioiminen verkon algoritmien toteutuksessa.

Tämän tiedoston lopusta löydät ohjeet miten voit yksinkertaisesti testata arvosanotasoittain menevätkö testit läpi vaiko eivät.


### Koodin arviointi ja vaikutus arvosanaan

Huomaa, että vaikka testit menisivät läpi, se ei tarkoita sitä että tehtävä johtaa välttämättä hyvään arvosanaan. Lopullisessa, ihmisen tekemässä arvostelussa, tehtävän toteutus käydään läpi, ja suoritetaan lopullinen arvostelu. Tehtävän arvostelu voi olla tällöin hylätty, tai voi johtaa myös alempaan arvosanaan.

**Esimerkkejä** tilanteista, jonka kaikki testit ovat menneet läpi, mutta tehtävä on arvosteltu hylätyksi tai arvosanaa alentavaksi: 

* Hajautustaulu on toteutettu käyttäen Javan `Hashtable` -luokkaa, kun hajautustaulu piti toteuttaa itse tavallista taulukkoa ja omaa hajautusfunktiota hyödyntäen (hylätty suoritus). 
* Pinon reallokointi on toteutettu hyödyntäen Javan `Stack` -luokkaa. Toteutuksessa ei saa käyttää Javan tai muitakaan valmiita tietorakenteita tai algoritmeja (hylätty suoritus).
* Taulukon lajittelu on tehty käyttäen Javan `Arrays.sort()` -algoritmia (tai vastaavaa), kun lajittelualgoritmit pitää toteuttaa itse ja käyttää niitä omia (hylätty suoritus). 
* Taulukon sisältö on kopioitu toiseen taulukkoon käyttäen `System.arraycopy()` -algoritmia. Tee yksinkertainen silmukka sen sijaan. Arvosanaa alennettu.
* Binäärinen hakupuu on toteutettu taulukolla ja hyödyntäen puolitushaku -algoritmia. Tämä ei ole binäärinen hakupuu ollenkaan (hylätty suoritus)
* Hajautusfunktio on toteutettu kutsumalla jotain Javan luokan hajautusfunktiota (esim. `String.hashCode()`) tai muita valmiita Javan tai standardikirjaston ulkopuolisen kirjaston hajautusfunktioita (arvosanan alennus tai hylätty suoritus, riippuen muista ongelmista). Oikea ratkaisu on tehdä oma hajautusfunktio joka laskee tiivisteen merkkijonosta (tai muista ohjeistetuista tiedoista) merkki merkiltä.
* Koodi pääasiassa on suoraan tai lähes sellaisenaan kopioitu toiselta opiskelijalta, edellisten vuosien ratkaisuista tai netistä (hylätty suoritus). Katso alempaa ohje plagoinnista. Lievemmissä tapauksissa arvosanan alennus.

> Osan näitä ongelmista saa kiinni kun käyttää yllä mainittua `checktabu.jar ` -työkalua tarkistamaan ettet käytä kiellettyjä ratkaisuja.

Jos haluat saada varmuuden **ennen deadlinea** että kaikki on kunnossa, käy **Zoomin ohjaussessiossa** varmistamassa asia opettajan kanssa, koodiasi analysoiden. Vaihtoehtoisesti voit kysyä asiaa opettajilta Tikettisysteemin kautta tai sähköpostilla. Koodisi on tällöin oltava etärepossa, jotta opettaja voi tutkia sitä. Jos jätät tällaiset kyselyt viime tippaan, voi olla ettet saa vastausta ajoissa.

Hyödynnä ohjaussessioita ja muita tukimuotoja **ajoissa**. Deadlinen yhteydessä et saa välttämättä palautetta tehtävistä. Jos haluat palautetta ja/tai varmistaa että toteutus on oikeellinen ja riittävä, tule kurssin tukisessiohin hakemaan palautetta ja kommentteja toteutuksestasi.

Huomaa **kurssin ydinteema**: tehtävien toteutuksessa *ei riitä* että toteutuksesi toimii (on toiminnallisesti oikeellinen). Toteutuksesi täytyy toteuttaa *aikakompleksisuuden* suhteen *tehokas* tapa käsitellä *suuria* tietomääriä. Totetutus joka toimii, voi siis olla jopa hylätty, jos se ei toimi tarpeeksi nopeasti suurilla tietomäärillä. Tästä lisää kurssin luennoilla ja tehtävien ohjeissa.

Huomaa myös että kurssilla harjoitellaan *yleiskäyttöisten* tietorakenteiden ja algoritmien toteuttamista, muidenkin ohjelmoijien käyttöön. Koodin ei siis pidä tehdä mitään muuta kuin se mitä tietorakenteen tai algoritmin kuuluu tehdä. Esimerkkejä siitä mitä lopullisen palautuksen koodissa **ei saa** olla, on listattu alempana.

Koodin rakenne on tärkeä asia sen luettavuuden kannalta. Jos koodi on rakenteeltaan sekavaa, sitä on vaikea lukea ja siten vaikeampi ymmärtää. Kirjasta *Clean Code* (Robert C. Martin): 

> ”Back in my days working in the Bell Labs Software Production Research organization (Production, indeed!) we had some back-of-the-envelope findings that suggested that consistent indentation style was one of the most statistically significant indicators of low bug density.”


## Tentit

Kurssilla on kaksi tenttiä. Kummastakin tentistä *pitää* erikseen saada minimipistemäärä (puolet täysistä pisteistä).

Tenttiin 1 sisältyy luentojen aiheet A...H, ja tenttiin 2 sisältyy aiheet I...L. 

Tenttikysymykset saattavat hyödyntää myös ohjelmointimateriaalien (tehtävät) aineistoa. Molemmat tentit ovat á 10 pistettä, läpipääsyyn vaaditaan *molemmista* tenteistä erikseen 5 pistettä. Tarkemmin tenteistä ja niiden ajankohdasta tiedotetaan kurssin Moodle -sivuilla. 

## Arvostelu

Kurssi arvostellaan seuraavin periaattein:

1. Opettajat tarkistavat automaattisin testein ja käsin tarkastamalla deadlinen yhteydessä, onko tehtävät tehty riittävälle tasolle (arvosana 1). Jos näin ei ole, kurssin suoritus on hylätty.
2. Paremman arvosanan saamiseksi, voi tehdä tehtäviä tehtävistä joilla saa paremman arvosanan, jos testit menevät läpi eikä käsin tarkastuksessa löydy ongelmia.
3. Koodin laatu vaikuttaa arvosteluun. Katso lista yllä.
4. Tehtävien raporttien laatu vaikuttaa myös arvosteluun.
5. Se että tehtävä läpäisee testit, ei vielä tarkoita hyväksyttyä, hyvää tai erinomaista suoritusta (testit eivät voi huomata kaikkea).
6. Tehtävissä ei saa käyttää Javan tietosäiliöluokkia tai algoritmeja (lukuunottamatta 09 -tehtävää (verkkotietorakenne)). Omia tietosäiliöitä ja algoritmeja jotka on tehty kurssin ohjelmointitehtävissä *saa* ja niitä *oletetaan* käytettävän hyödyksi muissa ohjelmointitehtävissä. 

Arvosteluasteikko:

| Arvosana | Kuvaus                                                                                       |
|---------:|----------------------------------------------------------------------------------------------|
|   1      | Tentit ja kaikki arvosanan 1 tehtävien testit menevät läpi, tarkastus ei aiheuta hylkäämistä.|
|   2      | Yllä mainittu, ja on tehty arvosanan 2 testit läpäisevät tehtävät.                           |
|   3      | Ym + on tehty arvosanan 3 testit läpäisevät tehtävät, raportit ja koodi laadukasta.          |
|   4      | Ym + on tehty arvosanan 4 testit läpäisevät tehtävät, raportit ja koodi laadukasta.          |
|   5      | Ym + on tehty arvosanan 5 testit läpäisevät tehtävät, raportit ja koodi laadukasta.          |

**Arvosanojen 4 ja 5** kohdalla opiskelija lisäksi varaa ajan Zoom-sessioon jossa hän käy läpi toteutustaan opettajan kanssa. Sessiossa opiskelija kertoo toteutuksestaan, sen etenemisestä, analysoi toteutustaan sekä raporttejaan kurssin oppimistavoitteisiin nähden. Sessio vaikuttaa arvosteluun. 


## "AI":n käyttö, toisten työn kopiointi ja plagiointi

Tällä kurssilla "tekoälyn" (large language models, LLM) käyttö koodin tuottamiseen on kielletty. 

Viittaan [Communications of the ACM:n uutiseen](https://cacm.acm.org/news/the-impact-of-ai-on-computer-science-education/), jossa huomattiin, että:

> One group was allowed to use ChatGPT to solve the problem, the second group was told to use Meta’s Code Llama large language model (LLM), and the third group could only use Google. The group that used ChatGPT, predictably, solved the problem quickest, while it took the second group longer to solve it. It took the group using Google even longer, because they had to break the task down into components.
>
> Then, the students were tested on how they solved the problem from memory, and the tables turned. **The ChatGPT group “remembered nothing, and they all failed,”** recalled Klopfer, a professor and director of the MIT Scheller Teacher Education Program and The Education Arcade.
>
> Meanwhile, half of the Code Llama group passed the test. The group that used Google? Every student passed.

Eli -- niistä jotka käyttivät ChatGPT:tä ohjelmointitehtävän ratkaisemiseen, **yksikään ei osannut ratkaista tehtävää** kun se piti tehdä ilman apua. Googlettavat opiskelijat taas osasivat **kaikki** ratkaista tehtävän uudestaan. He siis **oppivat** kun taas tekoälyä käyttäneet eivät oppineet **mitään**. Tilanne oli hieman parempi -- mutta silti huono -- Code Llamaa käyttäneiden kesken.

Jos et opi ja sisäistä näitä ohjelmoinnin perusasioita *ensin itse*, et voi arvioida "tekoälyn" antamaa koodia ja sen oikeellisuutta. Jäät riippuvaiseksi "tekoäly"työkaluista, etkä tule toimeen ilman niiden "apua" joka ei ole aina oikeellistakaan. Rakenna vahva perusosaaminen ja ammattitaito ja *sitten* jos koet sen välttämättömäksi, hyödynnä "tekoälyä" jos koet sen tarpeelliseksi ja hyödylliseksi. Muista, että on olemassa tuoreitakin tutkimuksia joiden mukaan n. 50% tapauksista tekoälyn antama koodi ei ole oikeellista tai on muuten huonompi kuin ammattitaidolla rakennettu ratkaisu.

Tekoälyn käyttö kokemattomissa käsissä on johtanut myös vinoutuneeseen toimintakulttuuriin, jossa esim. projektien pääkoodarit joutuvat korjailemaan kokenemattomien koodareiden tekoälyllä generoimaa koodia joka joko ei toimi oikein tai on tehotonta, tai tarpeettoman monimutkaista. Tai että mainetta ja kunniaa janoavat tunkevat avoimen lähdekoodin projekteihin AI-generoituja korjauksia tai lisäyksiä joiden arviointi ja hylkääminen (huonolaatuisina) vie aikaa vapaaehtoistyönä projekteja hallinnoivilta koodareilta. 

Älä opettele tällaiseen toimintakulttuuriin.

Kaikki koodi ja muut suoritukset tällä kurssilla on oltava sinun itsesi kirjoittamaa koodia ja tekstiä. Koodin kopiointi toisilta ja internetistä on **kiellettyä**. Voitte työskennellä yhdessä opiskelijakaverin kanssa ja keskustella toistenne kanssa toteutuksista, mutta jokainen kirjoittaa **joka ikisen rivin koodistaan** ihan itse. Jokainen vastaa itse omasta koodistaan ja sen toiminnasta tai toimimattomuudesta. 

Muista että se kaverilta saatu tai kaverin vinkkaama ratkaisu voi olla väärä tai huono, jolloin sen käyttäminen huonontaa myös omaa arvosanaasi. Näin on tällä kurssilla käynyt liian usein.

> Mikäli kahden opiskelijan tekemä koodi on identtistä tai lähes identtistä, tämä voi johtaa joko plagiointiprosessin käynnistämiseen (asiasta ei ole opiskelijan raporteissa mitään mainintaa, menee dekaanin käsiteltäväksi) tai arvosanan puolittamiseen. Eli jos arvosanan olisi molemmille testien läpäisyn ja koodin arvosanan perusteella 4, arvosanaksi tulee 2. Mikäli kolmella opiskelijalla on sama tilanne, arvosana jaetaan kolmella, jne.

Myös juuri ennen deadlinea tehty muutama harva commit jossa koko kurssin töiden toteutus, herättää epäilyksiä siitä että ratkaisu on kopioitu muualta. Tee siis jatkuvia committeja repoosi joka päivä kun työskentelet tehtävien parissa, ja pidä etäreposi jatkuvasti ajan tasalla. Se on muutenkin erittäin hyvä käytäntö, jolla voit välttää työsi hukkumisen konerikon tai muiden teknisten ongelmien takia. Jos teet koodia erillisissä haaroissa (branch) jotka yhdistät (merge) päähaaraan, älä poista näitä brancheja yhdistämisen jälkeen, koska se säilyttää jäljen siitä mitä itse teit. Näin vältät plagiointiepäilyt.

Voit käyttää kurssin kaikkea materiaalia (luentomateriaali, pseudokoodit, demot, esimerkit) inspiraationa omalle toteutuksellesi. Voit tietysti myös etsiä internetistä tietoa ja esimerkkejä, mutta muista että itse koodaat kaiken mitä tehtävien toteutukseesi laitat. Huomaa myös että kun otat mallia muualta, voit myös ottaa huonoa mallia huonoista esimerkeistä. Varmista siis että toteutuksesi vastaa sitä mitä kurssilla on opetettu.

Jos hyödynnät jotain muualta saatua esimerkkiä koodissasi jonka itse kirjoitit, on koodissasi oltava viittaus: lisää koodiin kommentti jossa linkki käyttämääsi lähteeseen, tai mainitse asiasta tehtävän raportissa linkin kanssa. Näin, jos opettaja huomaa toteutuksessasi puutteita tai ongelmia, voimme tarkistaa lähteesi ja katsoa onko toteutuksesi lähteesi mukainen, oletko tulkinnut lähdettä väärin vai onko kenties käyttämäsi lähde väärässä tai huono, tai että se ei sovellu tilanteeseen jossa sitä käytit.

Jos on syytä epäillä kopiointia tai plagiointia, opettajat noudattavat [Oulun yliopiston käytäntöjä (pdf)](https://www.oulu.fi/external/Ohje-vilppitapausten-ehkaisemiseen-ja-kasittelemiseen-Oulun-yliopistossa-2018.pdf) vilppien käsittelyssä. Minimirankaisu vilppitapausten käsittelyssä on kurssin suorituksen välitön keskeyttäminen hylätyllä arvosanalla. Jos tapaus on vakavampi, sen käsittely viedään tiedekunnan dekaanin päätettäväksi.


## Koodin laadun arviointilista

Näitä asioita koodissa ei saa olla:

* Koodi ei ole hyvää oliopohjaista koodia, noudattaen Ohjelmointi 2 ja oliosuunnittelukurssien oppeja. Jäsenmuuttujat ovat tarpeettomasti ei-private -suojattuja, luokan omat pikku apumetodit ovat public kun niiden pitäisi olla private, jne. Vakiot eivät ole static final.
* Koodi on epäsiistiä, sisennykset pielessä, nimeämistyyli ei noudata Javan nimeämistyyliä tai muuttujien ja metodien nimet ovat käsittämättömiä tai haittaavat koodin ymmärtämistä. Käytä IDEn koodin formatointityökalua (VS Code: hiiren oikea näppäin koodieditorin alueella > Format Document). Javassa luokkien nimet alkavat aina isoilla kirjaimilla (`FastHashTable`), metodien, muuttujien ja parametrien pienillä noudattaen `smallCamelCase` -nimeämistyyliä, vakiot (`final`) nimetään `ISOILLA_KIRJAIMILLA_SNAKE_CASE`.
* Tietorakenneluokassa on `main()` -metodi omia kokeiluja varten. Poista tämä ja tee oma luokka (`.java` -tiedosto) omia testejä varten sinne missä tietorakenneluokkasikin on (*ei* testikoodihakemistoon).
* Koodissa on varoituksia aiheuttavia kohtia, kun sitä käännetään. Korjaa koodi varoitukset poistaen. Paikoin on mahdollista myös hiljentää varoitus.
* Poista opettajan koodiin laittamat TODO -kommentit kun pyydetty koodi on toteutettu. Näin pysyt itsekin kärryillä paremmin mitä vielä on toteuttamatta.
* Koodissa on kommentoitua koodia. Poista nämä kun niitä ei kerran tarvita. Poikkeuksena koodi joka on osa selittäviä kommentteja, tai se että haluat jättää koodiin vaihtoehtoisen toteutuksen tai yritelmän jonka haluat jättää selityksen kera koodiin.
* Koodin joukossa on käyttämättömiä luokkia, metodeja, muuttujia, parametreja tai vakioita. Poista nämä.
* Koodi sisältää testikoodia ("kokeilempa miten tämä toimisi"), joka ei ole osa lopullisen tietorakenteen tai algoritmin toteutusta. Poista nämä.
* Koodi käyttää poikkeustenhallintaa (throw/try/catch) algoritmin logiikan ohjaamiseen. Try/catch -lohkoja ja poikkeuksia tulee käyttää *vain* virhetilanteiden käsittelyyn. Logiikan ohjaamiseen käytetään ehto-, toisto- ja valintarakenteita jotka on opetettu aiemmilla ohjelmointikursseilla.
* Tietorakenne tai algoritmi tulostaa konsoliin (System.out.println tms., jos ei *erikseen* sanota että näin tulee tehdä). *I/O on hidasta*, ja hidastaa koodisi suoritusta. Tällä on merkitystä varsinkin silloin kun testit mittaavat algoritmisi suoritusaikaa suurilla tietoaineistoilla! Poista tulostukset jos erikseen tehtävässä niitä ei pyydetä tekemään.
* Tietorakenne tai algoritmi käyttää muistia enemmän kuin mitä on välttämättä tarpeen sen toteuttamiseksi. Pääsääntö on toteuttaa algoritmit "in place", esimerkiksi lajittelu (Quicksort, Heap sort). Tosin osa algoritmeista käyttää lisämuistia *suunnitellusti*, kuten Merge sort - tällöin lisämuistin käyttö on tietysti sallittua.
* Mikäli koodissa on käytetty virheitä piilottavia ratkaisuja (esimerkiksi try/catch piilottaa poikkeuksen joka johtuu koodissa olevasta bugista), tämä johtaa joko **hylkäämiseen** tai minimissään siihen että tehtävästä saa **nolla** pistettä.

Yllämainitut asiat eivät välttämättä tarkoita hylättyä tehtävää, mutta ne voivat laskea arvosanaa. Yllä mainittujen huonojen piirteiden puuttuminen koodista taas kertoo laadukkaasta koodista, joka vaikuttaa arvosteluun positiivisesti.


## Arvosanatasojen testaus

Voit testata jokaisen arvosanan testit koodieditorisi kautta hiiren klikkauksilla, esim. VS Codessa, sen testinäkymässä.

Vaihtoehtoisesti, voit testata komentoriviltä menevätkö tietyn arvosanan kaikkien tehtävien testit läpi, alla olevalla komennolla.

**Ennen tätä**, muistat varmaan että jotkut tehtävät sisältävät *hitaan vertailutestin*, jonka odottelussa kesti kauan. Voit estää näiden testien suorittamisen, kun olet ensin kerännyt hitaiden testien datan raporttiisi ja analysoinut sen. Näin voit nopeasti testata omat (toivottavasti) nopeat koodisi yhdellä komennolla jokaisella arvosanatasolla.

Projektissa on mukana tiedosto nimeltään `enable-slow-tests`. Tiedosto on täysin tyhjä. Jos tiedosto *on olemassa*, hitaat vertailualgoritmien testit *suoritetaan*. Jos tiedostoa *ei ole* olemassa, hitaiden vertailualgoritmien testejä *ei suoriteta*.

Voit siis poistaa tiedoston kun olet analysoinut ja vertaillut raporteissasi hitaita ja nopeita toteutuksia. 

Näin testiä ei enää jatkossa suoriteta ja voit suorittaa kaikki tehtävän testit yhtäaikaa ilman esim. lineaarisen haun hitautta. **Muista** vaan aina **ensin** kerätä data analyysiä ja raporttia varten hitaistakin testeistä, ja vasta **sitten** hiljennä testi.

**Sitten** voit suorittaa kaikki arvosanan 1 testit komentoriviltä yhdellä komennolla (huomaa lainausmerkit ja tähdet, jotka pitää olla mukana komennossa):

```console
mvn "-Dtest=*/grade_1/**" test
```

**Muista** katsoa että testit eivät tulosta mitään punaista, sillä se on epäonnistuneen testin merkki! Alla esimerkki edellisen testin suorittamisesta, mitä lopuksi tulostuu kun kaikki testit menevät läpi:

```
...
[INFO] Results:
[INFO] 
[INFO] Tests run: 84, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:48 min
[INFO] Finished at: 2024-08-27T11:51:26+03:00
[INFO] ------------------------------------------------------------------------
```

> Jos haluat hitaat testit uudelleen suoritettavaksi, luo vain uusi tyhjä tiedosto nimellä `enable-slow-tests`. Huomaa että tiedoston nimessä ei ole tiedoston tyyppiä, eli esim *älä* luo tiedostoa `enable-slow-tests.txt` tai vastaavaa.

Huomaa myös että tällä tavalla testejä suorittaessa:

* testien suorittamisjärjestys ei ole sama kuin tehtävien järjestys, eli testit voidaan suorittaa missä vaan järjestyksessä, ja
* testit voivat kestää kauan, huolimatta vertailutestien disabloinnista, suurien aineistojen käsittelyn kohdalla, jos koneesi on hidas ja varsinkin jos esimerkiksi hajautusfunktiosi on huono (tehtävät 8 ja 9).

Tee vastaavasti myös arvosanan 2 kohdalla, muuta vain komennon sana `grade_1` sanaksi `grade_2`, jos siihen tähtäät. Ja sama `grade_3`:n kanssa. Muista aina testata jokaisen edeltävän arvosanan testit myös! Jos siis tähtäät arvosanaan 5, suoritat noita testejä viisi kertaa, jokaiselle arvosanatasolle.

Kun olet testannut että kaikki arvosanatavoitteesi testit menevät läpi, et ole käyttänyt kiellettyjä ratkaisuja (`checktabu.jar` -työkalu auttaa tässä) ja koodi on siistiä (katso arvosteluperusteet), olet valmis palautukseen!


## Tietoja

* Kurssimateriaalia Tietorakenteet ja algoritmit -kurssille | Data structures and algorithms 2021-2024.
* Tietojenkäsittelytieteet, Tieto- ja sähkötekniikan tiedekunta, Oulun yliopisto.
* (c) Antti Juustila 2021-2024.
