# Tehtävä 8

Älä tee tätä tehtävää ennenkuin olet tehnyt [tehtävän 7](07-TASK.markdown).

Tämän harjoituksen aiheena on tietorakenne nimeltään **hajautustaulu** (*hash table*). Hajautustaulu on edistynyt tietorakenne, joten huolehdi että olet ensin tutustunut tietorakenteeseen kurssin luentojen kautta sekä tarvittaessa perehtymällä tähän tietorakenteeseen liittyvään kirjallisuuteen.

> Tässä tehtävässä ei erikseen luetella mitkä ovat eri hajautustaulun algoritmien toteutuksiesi aikakompleksisuusvaatimukset kuten esim. pino ja jono -tehtävissä. Osin siksi, että toteutuksen vaihtoehdoista riippuen tietyn algoritmin O voi olla eri. Toisekseen, siksi että tämän tehtävän raportissa sinun tulee itsenäisesti arvioida oman toteutuksesi aikakompleksisuutta, ja onko se hyvä vai huono, ja miten se suhteutuu luennoilla esiteltyyn teoriaan.

Tehtävän arvostelussa on seuraavat arvosanavaatimukset:

* Arvosana 1 hajautusfunktion toteutus (`Coder.hashCode()`) ja hajautustaulun oikeellinen toteutus avoimella osoittamisella ja luotaamisella (ei poistamista) ja soveltava tehtävä (`CodeWordsCounter`).
  * Linkitettyjen listojen käyttäminen törmäysten käsittelyyn on sallittu, oletuksena kuitenkin avoin osoittaminen ja luotaaminen.
* Arvosana 4 hajautustaulusta poistaminen (`remove()`) oikeellisesti toteutettuna.
* Arvosana 5 joukko-tietorakenteen (Set, rajapintaluokka `SetInterface`) toteutus hajautustaulun tekniikoilla, mukaan lukien poistaminen.

Ohjeen lopussa sananen arvosanojen 4 ja 5 toteutuksista.

## Lähteitä

* Kurssin luentokalvot.
* Liveluento (tallenne) ja sen vinkit ja esimerkit.
* Kurssikirja: Introduction to Algorithms, 4th ed (Comer et al):
  * Hajautustaulut 275...
  * Hajautusfunktiot: ss 282...
  * Open addressing (avoin osoittaminen) ss. 293...
  * Linear probing (lineaarinen luotaaminen) ss 297...
  * Arvosana 4: poistaminen lineaarisessa luotaamisessa, yksi tapa kolmesta: s 302.
  * Arvosanaan 5: Set: ss 1153-1158
* Muu kirjallisuus ja verkkolähteet. Etsi kirjallisuudesta ja nettilähteistä erilaisia hajautusfunktioita ja kokeile mikä niistä on tehokkain tässä tilanteessa.
* `oy.interact.tira.util.TIRAKeyedContainer` -rajapinta.
* `oy.interact.tira.factories.HashTableFactory`, tehdasluokka joka instantioi toteutuksesi hajautustaulusta, kunhan se on valmis.
* `oy.interact.tira.student.CodeWordsCounter`, työkaluluokka, joka laskee käytettyjen sanojen määrää kooditiedostoista.
* [Javan Object.hashCode()](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html#hashCode()), dokumentaatio Javan `hashCode()` -metodista. Lue myös ko. metodin alta löytyvän `equals(Object)` -metodin dokumentaation kohta "API Note".


## Johdanto

Hajautustaulu sekä Binäärinen hakupuu pyrkivät molemmat välttämään tavallisten taulukoiden haittapuolet. Näin pyritään tietorakenteisiin joiden käyttäminen (elementtien lisääminen, haku, poistaminen jne) on nopeampaa kuin tavallisten taulukoiden kanssa. 

Hajautustaulu eroaa BST:stä siinä, että se *käyttää* taulukoita, mutta eri tavalla kuin "tavallinen" taulukko jossa yleensä pyritään täyttämään taulukkoa alusta eteenpäin, ja jossa taulukosta esimerkiksi etsitään tietoa silmukassa -- taas alusta alkaen kunnes etsittävä tieto löytyy tai taulukon data on käyty läpi.

BST:ssä avainarvo sai olla duplikaatti, koska koodareilla voi olla sama nimi. Lisäksi lajittelujärjestys oli BST:ssä tärkeää.

Tässä harjoituksessa teemme toteutuksen tästä hajatustaulusta siten, että avainarvot *eivät saa olla duplikaatteja*, eikä elementtien järjestyksellä tietosäiliössä ole merkitystä. Siksi hajautustaulu toteuttaakin rajapinnan `oy.interact.tira.util.TIRAKeyedContainer` (ei "ordered" -sanaa).

Tässä harjoituksessa hyödynnetään hajautustaulua tietorakenteena. Emme tosin korvaa BST:tä hajautustaululla, vaan käytämme sitä *uuteen käyttötarkoitukseen*. Koska olemme kiinnostuneita koodareista, meitä kiinnostaa myös *lähdekoodi*. Haluamme tietää:

1. Mitä eri ohjelmointikielten *avainsanoja* koodareidemme lähdekoodissa käytetään eniten, ja
2. Miten koodarimme nimevät *muuttujia* ja *funktioita* koodissa; minkälaista "sanastoa" koodarimme käyttävät.

Tähän tarkoitukseen hajautustaulu käy hyvin. Taulukko pitää kirjaa jokaisesta *uniikista* sanasta (K eli key) joka lähdekoodista löytyy, ja pitää kirjaa siitä, kuinka monta kertaa (V eli value) kyseistä sanaa koodissa käytetään.

Taulukko näyttää siis vaikkapa tältä (tämän projektin koodin malliratkaisun yleisimmät sanat tätä tehtävää kirjoitettaessa):

| Sana (K)  | Esiintymiset (V) |
|-----------|-----------------:|
| the       |       928        |
| import    |       744        |
| int       |       560        |
| if        |       519        |
| new       |       513        |
| array     |       509        |
| public    |       474        |

...ja niin edelleen. Tämä toiminta voidaan käynnistää TIRA Coder -sovelluksen valikosta "Count Code Words (hashtable)". Kun olet toteuttanut hajautustaulun, ja täydentänyt koodia muuallakin, näet 100 yleisimmän käytetyn sanan esiintymismäärät sekä graafisessa käyttöliittymässä että tulostettuna konsoliin:

![Esimerkki hajautustaulun käytöstä](task-08-codewords-count-sample.png)

Voit itse valita mistä hakemistosta sanoja lasketaan. Minkä ohjelmointikielten lähdekooditiedostoja laskuri käsittelee, näet metodista `CodeWordsCounter.countWordsinSourceCodeFiles()`.

Tosin harjoituksen **testit** laittavat hajautustauluun tuttuja `Coder` -olioita, mutta sehän toimii koska toteutat hajautustaulun geneerisenä tietorakenteena. Testit käyttävät avaimena koodarin id:tä, joten ne ovat uniikkeja ja kaikki toimii oikein. Tämä siksi että analyysissä ja raportissasi saat vertailukelpoista aineistoa BST -tehtävän suhteen ja voit verrata hajautustaulun ja BST:n aikatehokkuutta.


## Tavoite

Toteuta ja testaa hajautustaulu algoritmeineen siten että se toteuttaa `TIRAKeyedContainer` -rajapinnan. Testaa toteutusta tarvittaessa sitä korjaten siten, että toteutus läpäisee testit. Tarkemmin tämän vaiheet on kuvattu alla luvussa Toteutuksen askeleet. Rajapintaluokan metodien yhteydessä kommenteissa on hyödyllistä dokumentaatiota, joten lue ne!

Jotta voit sijoittaa `Coder` -olioita hajautustauluun, on sinun uudelleenmääriteltävä (`@Override`) `Coder` -luokassa sen `Object` -luokasta perimä metodi `int hashCode()` toteuttamalla siihen tiivisteen laskeminen.

Kun testit menevät läpi, voit kokeilla hajautustaulun toimintaa TIRA Coders -sovelluksessa koodin sanojen laskentaan, mutta tässä vaiheessa toteutat vielä hieman lisää toiminnallisutta `CodeWordsCounter` -luokkaan ennen kuin tämä toimii. Ohjeet tähän alempana. 

Vertaat myös hajautustaulun toiminnallisuutta ja aikatehokkuutta esimerkkinä valmiiksi annettuun taulukkopohjaiseen ratkaisuun, sekä aikaisemmin toteuttamaasi BST:hen.

Analysoi raportissasi toteutuksesi oikeellisuutta ja aikatehokkuutta.

Liveluennot (ja niiden tallenteet) sisältävät demoja siitä miten tämä tietorakenne koodataan, joten niistä on varmasti apua tehtävän tekemisessä. Tutustu niihin.

> Huomaa myös että tässä(kään) tehtävässä **ei saa käyttää** Javan tietosäiliöluokkia (`Collection` ja `Map` -rajapintojen toteutukset) tai algoritmeja luokissa `Arrays` ja `Collections`. Kaikki tietorakenteet ja algoritmit *toteutetaan itse* käyttäen Javan tavallisia taulukoita ja omia luokkia sekä Javan perustietotyyppejä int, Integer, String, ja niin edelleen. 
>
> Samoin **hajautusavain eli tiiviste (hash)** pitää laskea itse; **ei saa käyttää** (eli kutsua) Javan valmiita toteutuksia *minkään* luokan `hashCode()` -metodeista (ml. String, Integer, jne.). Tiiviste tulee laskea merkkitiedosta itse, **merkki merkiltä**, etsien  mahdollisimman aikatehokasta toteutusta joka sopii hyvin **nimenomaan** tälle aineistolle (koodareiden UUID:t).


## Toteutuksen askeleet

**Luo uusi luokka** packageen `oy.interact.tira.student`, nimeltään vaikkapa `HashTableContainer` tai vastaavaa:

```Java
public class HashTableContainer<K extends Comparable<K>,V> implements TIRAKeyedContainer<K,V> {
```

Kuten yltä näet, luokan on toteutettava `TIRAKeyedContainer` -rajapinta, ja se sisältää avain-arvo -pareja (K eli key ja V eli value). Näistä avaimeen on lisäksi liitetty vaatimus että se toteuttaa `Comparable` -rajapinnan.

Tämän toteutuksen tulee olla geneerinen ja toimia minkä tahansa tietotyyppien kanssa, kunhan K on tosiaan `Comparable`. Testeissä tietorakennetta testataan erilaisilla tietotyypeillä, ja TIRA Coder -sovelluksessa tuo Key tulee olemaan luokka `String` (ohjelmakoodin sanasto) ja Value tulee olemaan `Integer` (montako kertaa kukin sana esiintyi koodissa). 

Hajautustaulussa key:n on siis oltava uniikki. Tämä tarkoittaa sitä, että kun toteutat `add` -metodia, toteutuksen on varmistettava onko kyseinen avaimen arvo jo valmiiksi tietosäiliössä. Jos on, tietosäiliössä oleva arvo (value) *päivitetään*. Jos taas ei ole, avain-arvopari *lisätään* tietosäiliöön. Tähän käytetään avaimen `equals` -metodia.

**Huomaa** että voit hyödyntää avain-arvo -parien sijoittamiseen hajautustauluun valmiina annettua `Pair` -luokkaa. `Pair` yhdistää avaimen ja arvon yhteen luokkaan. Voit siis luoda sisäiseksi tietorakenteeksi hajautustauluun taulukon (array) `Pair` -olioita.

Mutta ennenkuin teet hajautustaulun toteutuksen loppuun, kannattaa myös keskittyä **hajautusfunktion** toteutukseen. Hajautustaulu ja hajautusfunktiot kulkevat aina käsi kädessä, ja molempia tarvitaan. Molemmat ovat myös olennaisia tehokkaan hajautustaulu -tietorakenteen toteutuksessa. Jos toteutat hyvän hajautustaulun, mutta huonon hajautusfunktion, se voi romuttaa kokonaisuuden aikatehokkuuden.


## Hajautusfunktion toteutus

Toteutuksen ollessa hajautustaulu, `HashTableContainer` laskee indeksin taulukkoon lisättäväville olioille *hajautusfunktion* avulla. Mistä hajautusfunktio löytyy Javassa? 

Jokainen hajautustaulun avain (`K` eli key) on Javan olio, perii luokan `Object` jossa on määritelty metodi `hashCode()`. Aliluokat uudelleenmäärittelevät (`@Override`) tämän metodin siten että ne laskevat itse oliolle *hajautusavaimen* **tämän** *hajautusfunktion* avulla.

Näin jokaisen avainluokan koodari voi *ihan itse* määritellä mistä *tämän* luokan jäsenmuuttujista tiiviste lasketaan ja miten. Ei ole mitään yleistä yhtä tapaa laskea tiivistettä, vaan se tehdään aina jokaiselle luokalle erikseen. 

Kun teet oman luokan, on aina syytä miettiä, laitetaanko luokan olioita sellaisiin tietosäilöihin jotka hyödyntävät tiivisteitä. Javassa näitä ovat mm. `Hashtable` ja `HashSet`. Ja tällä kurssilla oma hajautustaulusi toteutus sekä tehtävässä 9 graafi eli verkkotietorakenne myös hyödyntää tiivisteitä.

Yleensä `hashCode()`n ja `equals()` -metodien toteutukset käyttävät samoja jäsenmuuttujia yhtäsuuruuden ja tiivisteen määrittelyssä. Eli `equals()` tarkistaa tiettyjä jäsenmuuttujia vertaillen ovatko oliot sama olio, ja vastaavasti `hashCode()` laskee tiivisteen täsmälleen samoista jäsenmuuttujista kuin mitä `equals()` käyttää.

Hajautusfunktio palauttaa kokonaisluvun (`int`) joka voi olla arvoltaan positiivinen tai negatiivinen numero. Koska *hajautustaulussa* taulukon indeksin pitää olla aina `0 <= index < array.length`, hajautusfunktion palauttaman *kokonaisluvun arvo on sovitettava* taulukon indeksiksi, riippuen hajautustaulun taulukon tämänhetkisestä pituudesta. Miten tämä tehdään, on näytetty kurssin luennoilla.

Tiivistefunktio ei kuitenkaan tätä tiivisteen "supistamista" tuohon taulukon kokoon tee -- se tehdään vasta *hajautustaulun* toteutuksessa. Jokaisen luokan hajautusfunktio pyrkii *hajauttamaan* arvot mahdollisimman laajalle alueelle kokonaislukujen arvoaluetta, eli palauttavat (Javassa) arvoja väliltä `Integer.MIN_VALUE-Integer.MAX_VALUE` eli `-2147483648...2147483647`.

**Toteuta** `Coder` -luokalle **hajautusfunktio** ylikuormittaen se. Toteuta metodi **käyttämättä** (kutsumatta) mitään valmista Javan `hashCode()` metodia. Muista että `Coder` -luokan `hashCode()` -metodia voidaan käyttää muidenkin tietorakenteiden tai -algoritmien kuin hajautustaulun kanssa. Siksi `hashCode()`:n toteutus **ei saa** rajoittaa palautettavan kokonaisluvuna arvoa millään tavoin; sen pitää voida olla erittäin suuri tai pieni positiivinen *tai* negatiivinen kokonaisluku. Tämä luku rajataan taulukon kokoon **vasta** hajautustaulu -tietorakenteessa.

**Testaa** tiivistefunktion toteutusta testillä `grade_1/task_8/CoderHashTests`. Testi testaa lähinnä kahta asiaa:

1. palauttaako tiivistefunktio (`Coder.hashCode()`) aina nollan tai muun yhden ja saman arvon -- se on yleensä merkki siitä että ohjeita ei ole luettu eikä tiivistefunktiota ole toteutettu ollenkaan. Tai sitten tiivistefunktio on toteutettu väärään paikkaan (yleensä hajautustaulu-luokkaan) ja väärällä tavalla. 
2. Onko tiivistefunktio toteutettu kutsumalla `Coder.id`:n `hashCode()` -metodia, eli ei ole toteutettu *omaa* hajautusfunktiota vaan kutsutaan tuota `id` -jäsenmuuttujan `hashCode()` -metodia -- tässä ei saanut käyttää Javan valmiita hajautusfunktioita vaan toteuttaa sellainen itse.
3. Toinen asia mitä testi tuottaa on se tieto, että tuottaako tiivistefunktio mahdollisimman *uniikkeja tiivisteitä* eri `Coder` -olioille. 

Tarkoitushan on nimenomaan *hajauttaa* kokonaislukujen arvoja mahdollisimman laajalle arvoalueelle, siten että eri koodareille tulisi eri tiiviste. Ideaalitilanteessa joka ikisellä koodarioliolla joka ikinä luodaan, olisi uniikki tiivisteen arvo. Tiivistefunktiot eivät kuitenkaan tähän yleensä pysty, koska ne nimensä mukaisesti "tiivistävät" olion identiteetin yhteen 32-bittiseen kokonaislukuun, jolloin väistämättä sattuu törmäyksiä (*collision*) eli kahdelle eri oliolle tulee sama tiiviste. Tämän olisi kuitenkin syytä olla suhteellisen harvinaista.

Esimerkiksi opettajan eräällä tiivistefunktion toteutuksella `CoderHashTests` -testi tulostaa:

```
...
7/8 ==> Starting to analyse Coder.hashCode with 1000000-global-coders.json 2024/08/27 08:18:45
  JSON Parsing - from file 1000000-global-coders.json to JSONArray it took 16394 ms
  From JSONArray to Coders array it took 1990 ms
  Testing Coder.hashCode took 439 ms
  For 1000000 coders, there were 107 duplicate hashes

8/8 ==> Starting to analyse Coder.hashCode with 2000000-milky-way-orion-spur-coders.json 2024/08/27 08:19:04
  JSON Parsing - from file 2000000-milky-way-orion-spur-coders.json to JSONArray it took 33209 ms
  From JSONArray to Coders array it took 6658 ms
  Testing Coder.hashCode took 2999 ms
  For 2000000 coders, there were 460 duplicate hashes
```

Tästä nähdään että kun aineiston koko on 1 000 000 koodaria, 107 koodarille tuli sama tiiviste. Eli törmäyksiä tuli 0.01% tapauksista. Tämä on aika hyvä tiivistefunktio. Kun aineisto kasvoi kahteen miljoonaan, törmäyksiä tuli 460 kappaletta eli törmäyksiä tuli 0.02% tapauksista.

Testi ei epäonnistu jos törmäyksiä tulee paljon. Mutta sinun tulee itse varmistaa katsomalla testitulostuksia, että näin ei tapahdu. Jos noita duplikaatteja tiivisteitä tulee useampia prosentteja tai peräti kymmeniä, hajautusfunktiosi on selkeästi huono, se tekee myös hajautustaulusta hitaan ja funktiota pitäisi ehdottomasti parantaa.

Huono hajautusfunktio johtaa hajautustauluun lisätessä siihen että törmäyksiä tulee paljon, niiden hoitaminen koodissa kestää, jolloin sekä hajautustauluun olioiden lisääminen että niiden etsiminen hidastuu. Siksi on olennaista toteuttaa hyvä hajautusfunktio.

Huomaa myös että kun hajautustaulu vielä rajoittaa tiivisteen arvon alueelle `0...<array.length`, eli leikkaa tiivisteen arvosta pois negatiiviset arvot ja arvot jotka ovat suurempia kuin taulukon koko, törmäyksiä syntyy vielä enemmän kuin mitä tämä testi ilmaisee. Eli jos jo tässä testissä tulostuu paljon törmäyksiä kun arvoa ei vielä edes rajoiteta taulukon kokoon, niitä syntyy varmasti vielä paljon enemmän hajautustaulussa kun näin tehdään!


## Hajautustaulun toteutus loppuun

Kun olet toteuttanut sopivan hyvän tiivistefunktion `Coder.hashCode()` -metodiin, **toteuta loppuun** hajautustaulu metodeineen. 

Huomaa että poistaminen on vasta **arvosanan 4** tehtävä, eli `remove()` -metodin voi jättää toteuttamatta, jos et tähtää tähän arvosanaan.

Huomaa että hajautustaulun rajapintaluokassa `TIRAKeyedContainer` on jokaisen metodin yhteydessä dokumentaatiota joka selittää mitä metodissa pitäisi tapahtua.

Liittyen edellä mainittuun tiivisteen laskentaan ja duplikaattehin tiivisteisiin. Hajautustaulussa kun (luentojen ohjeiden mukaan) rajaat tiivisteen perusteella lasketun indeksin avaimelle, taulukon valideihin indekseihin, toteuta hajautustauluun:

1. `add` -metodiin metriikkakoodia jossa lisäät uuden jäsenmuuttujalaskurin arvoa aina kun tapahtui törmäys,
2. resetoi laskurin arvo `clear()` -metodissa ja ennen reallokointia,
3. tulosta (tässä tulostaminen tietorakenteessa on sallittua, kts. arvosteluperiaatteet) laskurin arvo `toArray()` -metodissa.

**Tarkkaile** laskurin arvoa aikatehokkuustesteissä. Jos huomaat että törmäyksiä on paljon ja hajautustaulu on hidas, voi olla että syynä on ehkä: 

1. hajautusfunktiosi joka tuottaa paljon törmäyksiä, tai on muusta syystä hidas (allokoi esim. muistia?) paranna sitä yllä olevien ohjeiden perusteella tai
2. reallokointi joka ei tapahdu ajoissa, eli kun hajautustaulun täyttöaste on jo liian suuri
  - tämä lisää törmäysten lukumääriä ja siksi hidastaa hajautustaulua.

Jos et löydä syytä hitaudelle, käy ohjaussessioissa kysymässä apua, tai laita viestiä opettajille, mukana reposi linkki. Opettaja voi hakea koodisi ja selvittää mikä on hitauden syy vai onko tietorakenne algoritmeineen hidas ollenkaan.

> Mikä on hidas hajautustaulu? Kauanko esim. miljoonan koodarin aineiston lisääminen hajautustauluun saa kestää? Tähän on mahdotonta antaa vastausta, koska hitaus riippuu niin monesta asiasta. Jos koneesi on hidas ja siinä on vähän muistia (RAM), se hidastaa toimintaa, vaikka toteutuksesi olisi kuinka nopea. Jos sinulla on käynnissä samaan aikaan useita ohjelmia jotka kuormittavat tietokoneen CPU:ta, sekin hidastaa testejä. Ja niin edelleen.

Kun olet saanut hajautustaulun toteutettua, ennen sen testaamista ja käyttöä **toteuta** vielä **tehdasmetodi** `oy.interact.tira.factories.HashTableFactory.createHashTable()`.

Kun olet valmis, voit **testata** toteutuksesi oikeellisuutta kuten alempana luvussa Hajautustaulun testaaminen on kuvattu.

**Kun testit menevät läpi**, voit viimeistellä koodin avainsanojen laskentaan liittyvän koodin alla olevien ohjeiden mukaisesti. Sen jälkeen voit käyttää TIRA Codersin valikkoa "Count Code Words (hashtable)", ja katsoa mitä sanoja *sinä* eniten käytät erinäisissä koodausprojekteissasi. Vaikka tässä projektissa. Ohjeet tähän alla.


### Koodin avainsanojen laskeminen

Kun olet testannut oikeellisuutta ja aikatehokkuutta, kokeile myös miten toteutuksesi toimii TIRA Codersin käyttöliittymän kautta.

Annetussa koodissa on valmiina toteutus jolla käydään läpi käyttäjän valitseman hakemiston ja sen alihakemistojen lähdekooditiedostot. Tehtäväsi on **täydentää** täät koodia siten että sanojen laskenta toimii. Tämä koodi löytyy luokasta `oy.interact.tira.student.CodeWordsCounter` ja sinä täydennät sen metodit `countWordsFrom(File)` sekä `topCodeWords(int)`. Katso metodien kommenteissa olevat ohjeet ja viimeistele toteutukset.

Kuten huomaat, luokka sisältää `TIRAKeyedContainer` -olion joka luodaan kutsumalla tehdasluokan metodia `HashTableFactory.createHashTable()` -- siellä luodaan olio sinun toteuttamastasi hajautustaulusta. Hajautustaulun avaimena (`K`, key) on `String`, eli kooditiedostosta löydetty sana. Arvona (`V` eli value) taas on `Integer` eli sanan esiintymismäärä kooditiedostoissa.

Idea on että metodissa `countWordsFrom(File)` luetaan merkki merkiltä lähdekooditiedoston merkkejä, pätkitään sieltä esille sanat, laitetaan sanan merkit taulukkoon josta saadaan sana merkkijonoksi. Sitten etsitään hajautustaulusta kyseinen sana. Jos se on siellä, lisätään sanan laskurin arvoa yhdellä. Jos sana ei ollut hajautustaulussa, lisätään se sinne laskurin arvolla 1.

Tämän jälkeen annettu koodi kutsuu metodia `topCodeWords(int)`. Tässä metodissa toteutat kommenttien avulla sen, että hajautustaulusta saadaan sana/laskuriparit taulukkoon. Sen jälkeen taulukko lajitellaan omalla nopealla lajittelualgoritmillasi sanan *esiintymislukumäärien* mukaiseen *laskevaan* järjestykseen. Sen jälkeen tästä taulukosta kopidaan toiseen taulukkoon pyydetty määrä näitä pareja, ja palautetaan se taulukko kutsujalle. 

Kun nämä on toteutettu:

1. Käynnistä sovellus.
2. Valitse valikosta "Count Code Words (hashtable)".
3. Selaa tietokoneella hakemistoon jossa joku koodausprojekti on.
4. Valitse hiirellä klikkaamalla hakemisto (single click) jonka *sisältämien* lähdekooditiedostojen sanoja haluat laskea.
5. Prosessoinnin jälkeen näet ikkunassa kooditiedostojen 100 yleisintä sanaa ja niiden esiintymislukumäärän.

Jos haluat testata tätä jonkun todella ison aineiston kanssa, kloonaa vaikka Linuxin kernelin lähdekoodi koneellesi Linus Torvaldsin repositorystä. Repositoryn koko alla kuvatulla tavalla kloonattuna on 1,78 Gt, joten tilaa se vähän vie -- **MUTTA -- älä vaan MISSÄÄN NIMESSÄ kloonaa tätä tämän TIRA -projektin hakemiston sisälle!!!! Vaan jonnekin ihan muualle, vaikka kotihakemistoosi temp -nimiseen hakemistoon jonka voit poistaa kun haluat!!!**. Et **todellakaan** halua että Linuxin kernelin lähdekoodi työnnetään **omaan etärepoosi** kun annat `git push` -komennon!

```console
git clone --depth 1 https://github.com/torvalds/linux
```

**Huomaa lisäksi** tuo parametri `--depth 1` -- ilman sitä *koko kernelin commit -historiakin* latautuu koneellesi ja se vie *aikaa* ja *levytilaa* paljon enemmän kuin tuo 1,78 Gt. 

Sen jälkeen valitse TIRA Codersilla valitse valikosta "Count Code Words (hashtable)", etsi koneeltasi ja valitse hiirellä tuo linux -niminen hakemisto, käynnistä koodin sanojen laskenta, ja odota että työ on tehty.

Varsinkin isojen aineistojen kanssa, katso miten sovelluksen loki-ikkunassa (ja konsolissa) tulostuu kauanko missäkin operaatiossa kesti. Raportoi myös näistä havainnoista.

Omalla koneellani *hajautustaulun täyttö* Linuxin kernelin koodia analysoitaessa kesti 15,668 sekuntia, johon ei ole laskettu mukaan tiedostojen käsittelyä. Käytännössä suoritusaika oli noin 20-30 sekuntia tiedostojen käsittely mukaan lukien. Näköjään avainsana `define` (C -kielen `#define` -makro lienee suurin osa tämän sanan esiintymismääristä) on selkeästi eniten käytetty sana Linuxin kernelin koodissa, 5 111 063 kertaa se sieltä löytyi (sillä versiolla jonka kloonasin).

> Huomaa että annettu koodi ja ohjeet laskevat kaikki merkit myös kommenteista. Jos haluat lisää mukavia koodaushetkiä, voit toteuttaa koodiin lisäominaisuuksia joilla ei lasketa koodin kommenteissa olevaa tekstiä mukaan. Huomioi se, että eri ohjelmointikielissä on mahdollisesti erilaisia kommenttimerkkejä, on olemassa rivikommentteja ja kommenttilohkoja, jne. joten tehtävä ei ole ihan yksinkertainen. Tästä *ei* saa lisäpisteitä kurssin toteutukseen, sillä tässä ei nyt ole kurssin aihealueen ytimessä olevasta asiasta kyse.

## Hajautustaulun testaaminen

### Hajautustaulun oikeellisuuden testaus pienellä aineistolla

Testaa ensin toteutustasi testillä `grade_1/task_8/GenericTests`. Se testaa hajautustaulun toimintaa kutsumalla sen useimpia metodeja ja varmistamalla oikeellisuuden.

Jos testi ei mene läpi, korjaa toteutustasi kunnes testi onnistuu.


### Hajautustaulun vertailuaineiston tuottaminen

Testi `SimpleKeyedTablePerformanceTests` testaa **taulukkopohjaista** toteutusta `SimpleKeyedContainer` **hajautustaulun sijaan**. Tämä `SimpleKeyedContainer` toteuttaa saman rajapinnan kuin hajautustaulu, mutta "tavalliseen tapaan" käyttää silmukoita elementtien etsimiseen yms. taulukosta. 

Tämä testi on olemassa aikatehokkuuden *vertailuja* varten. Se kutsuu samankaltaisia metodeja kuin hajautustaulu (ja BST:n testit), sekä tallentaa näiden suoritusaikoja samanlaiseen taulukkoon kuin hajautustaulua (sekä BST:tä) testaavat testit. Saat siis tällä testillä vertailtavaa aineistoa hajautustaulun ja BST:n välistä suorituskykyanalyysiä ja raporttiasi varten.

*Huomaa* kuitenkin että varsinkin suurilla aineistoilla tämä testi on **hidas**. Kannattaa siis jättää testi pyörimään itsekseen ja palata myöhemmin katsomaan joko testi loppui. Jos koneesi on hidas, voit keskeyttää testien suorittamisen testien kestettyä liian pitkään (kymmeniä minuutteja tai tunteja).

Kopioi tämän testin tulostamat aikamittaukset tiedostosta `compare-simple-keyed-container.csv` johonkin taulukkolaskinsovellukseen. Tiedostossa jokaisen aineiston mittaukset ovat yhdellä rivillä, ja pilkulla erotetut sarakkeet sisältävät mittausaikoja eri toiminnallisuuksista.


### Hajautustaulun aikatehokkuuden testaaminen

Varsinainen hajautustaulun toteutusta suurilla aineistoilla testaava testi on `grade_1/task_8/HashTablePerformanceTests`. Se tallentaa suoritusaikamittaukset tiedostoon `compare-hashtable.csv`. 

Tarkoituksena testeillä on paitsi varmistaa tietorakenteen toteutuksen *oikeellisuutta*, myös **aikatehokkuutta** analysoimalla ja vertailemalla suoritusaikojen kasvua aineiston koon kasvuun (n) sekä myös taulukkopohjaisiin toteutuksiin. 

**Tutki** onko oma hajautustaulusi toteutus tarpeeksi nopea suhteessa siihen miten sen pitäisi käyttäytyä. Se miten hajautustaulun pitäisi käyttäytyä ja mikä on sen eri metodien aikakompleksisuusluokka (ja siten nopeus) pitäisi selvitä kurssin luentomateriaalista ja kirjallisuudesta.

Vertaile siis raportissasi tässä vaiheessa kurssia:

1. BST:n hitaan taulukkototeutuksen,
2. BST:n (nopea toteutus),
3. Tämän harjoituksen hitaan taulukon toteutuksen, sekä
4. Tämän harjoituksen hajautustaulun aikatehokkuuksia toisiinsa.

Hyödynnä analyysissäsi testien tuottamia csv -tiedostoja.

Muista raportoida havaintosi sekä analyysisi ja liittää näitä suoritusaikamittaukset myös raporttiisi.


## Arvosanat 4 ja 5

Voit skipata tämän luvun ohjeesta jos et tähtää arvosanoihin 4 tai 5. 

### Arvosana 4

**Arvosanaa 4** varten, toteuta myös hajautustaulusta poistaminen, eli `remove()` -metodi. 

**Huomaa** että hajautustaulusta **ei voi** yksinkertaisesti poistaa elementtiä laittamalla taulukon indeksiin `null` ja vähentämällä elementtien lukumäärää. Jos nimittäin on tullut törmäyksiä lisätessä elementtejä taulukkoon, ja törmäykset hoidetaan luotaamalla (*probing*), poistamalla elementti näin, sen jälkeen luotaamalla lisättyjä *ei enää löydy get -metodia kutsuessa*, jos se on toteutettu oikein (etsintä lopetetaan kun tulee vastaan `null`). Tehtävän testit nimenomaan testaavat tätäkin, eli että kun törmäyksiä tulee, yhden elementin poistamisen jälkeen muut edelleen löytyvät hajautustaulusta.

Pohdi siis *tarkkaan* miten poistaminen olisi syytä tehdä, ja miten tämä pitää ottaa huomioon eri hajautustaulun metodeissa.

Poistamiseen on kolme mahdollista toteutusta. Nämä kuvataan myös kurssikirjassa:

1. Hajautustaulusta ei *oikeasti* poisteta elementtiä vaan se *merkitään* poistetuksi (kts. `Pair`-luokka...). Tämä periaate pitää huomioida useissakin hajautustaulun metodeissa. Poistetut elementit poistetaan "oikeasti" `add` metodissa (poistetun päälle voidaan laittaa uusi elementti), `clear()` -metodissa kun koko hajautustaulu tyhjennetään ja reallokoinnin yhteydessä (poistettuja ei tarvitse lisätä uuteen isompaan taulukkoon). Poistaminen on tällöin O(1) -operaatio.
2. Siirretään poistettavan jälkeen hajautustauluun törmäysten kautta luotaamalla lisätyt elementit aiempiin indekseihin taulukossa, poistetun tilalle. Poistaminen on tällöin silmukka ja sen aikatehokkuus riippuu siitä, paljonko törmäyksiä on sattunut lisätessä elementtejä ja mistä kohtaa törmäys"listaa" elementti poistetaan. Jos esimerkiksi elementin X jälkeen taulukossa on 42 elementtiä lisätty törmäysten kautta, kaikki 42 pitää siirtää uusille paikoille.
3. Ei hallita törmäyksiä luotaamalla (open addressing, probing) vaan linkitetyillä listoilla. Linkitetystä listasta poistaminen ei edellytä elementtien siirtelyä uusiin indekseihin eikä poistetuksi merkitsemistä. Reallokoinnin toteutus linkitetyillä listoilla on kuitenkin monimutkaisempaa, ja reallokointi on silti toteutettava. Muuten jos taulukon kokoa ei kasvateta aineiston koon kasvaessa, linkitettyjen listojen pituus taulukossa kasvaa aivan liian suureksi, joka hidastaa hajautustaulun sietämättömän hitaaksi kun n on suuri.

Näillä kaikilla tekniikoilla on omat etunsa ja haittansa. Jos toteutat poistamisen, valitse joku näistä tekniikaksi (riippuen siitä miten toteutit törmäysten käsittelyn), ja raportissasi *analysoi* näiden tekniikoiden etuja ja haittoja ja perustele miksi valitsit mitä valitsit.

**Testaa** poistamisen oikeellisuus testeillä `grade_4/task_8/PersonHashtableTests` ja `grade_4/task_8/RemoveFromHashTableTests`, korjaten mahdollisia virheitä, kunnes testit menevät läpi. Jos et ymmärrä miksi testi epäonnistuu, tutki testikoodia ja kysy tarvittaessa apua opettajilta.


### Arvosana 5

Tämä korkeimman arvosanan tehtävä on jo vähän haasteellisempi ja edellyttää hieman itseopiskelua. Toteutus edellyttää n. 300 riviä koodia. Toteutusta helpottaa se, että perusoperaatiot (lisäys, poisto, haku, jne.) ovat hyvin samankaltaisia kuin hajautustaulussa, joten voit hyödyntää hajautustaulun koodiasi tässä toteutuksessa.

**Arvosanaa 5** varten, tutustut uuteen **tietojoukko** -käsitteeseen (*Set*). Tietojoukko on järjestämätön joukko tietoelementtejä, joka takaa että joukossa ei ole identtisiä olioita. Se käyttäytyy siis samaan tyyliin kuin hajautustaulu, mutta tietojoukossa ei ole avain-arvopareja, vaan yksittäisiä tietoelementtejä.

Joukko oppi on olennainen osa tietojenkäsittelyä, englanninkielisestä [wikipedia-artikkelista](https://en.wikipedia.org/wiki/Set_theory), koska sekä boolen algebra että logiikka liittyvät joukko-oppiin:

> Set theory is used to introduce students to logical operators (NOT, AND, OR), and semantic or rule description (technically intensional definition[30]) of sets (e.g. "months starting with the letter A"), which may be useful when learning computer programming, since Boolean logic is used in various programming languages. Likewise, sets and other collection-like objects, such as multisets and lists, are common datatypes in computer science and programming.

**Tutustu tutoriaaliin** tietojoukoista. Löydät sen täältä [https://github.com/anttijuu/SetDemo](https://github.com/anttijuu/SetDemo). Demo käydään läpi kurssin liveluennoilla jos siihen jää aikaa, tai siitä voidaan tehdä oma demotallenteensa jossain vaiheessa.

* Elementtien lisäämisessä (`insert()`) hyödynnetään elementin tiivistettä eli `hashCode()` -metodia etsimään paikkaa sisäisessä taulukossa nopeutta ajatellen, ja tarkistetaan `equals()` -metodilla ettei samaa elementtiä lisätä joukkoon kahdesti. Toimii siis samaan tapaan kuin hajautustaulun `add()`.
* Myös elementin haussa (`get`) hyödynnetään tiivisteitä.
* Törmäykset lisätessä ja hakiessa toteutetaan samalla periaatteella kuin hajautustaulussa.
* Sisäistä taulukkoa joudutaan reallokoimaan jos tilaa ei löydy, kuten hajautustaulussakin.
* Taulukossa ei ole avain-arvo -pareja vaan vain yksittäisiä elementtejä, helpompi tehdä kuin hajautustaulu.
* Elementtien poistamisessa on sama periaate kuin yllä hajautustaulun `remove()` -metodin toteutuksessa. 

Tämän tehtävän toteutusta helpottaa se, että suurilta osin tietojoukon toteutus on samankaltainen kuin hajautustaulunkin, ja joukkojen perusoperaatiot (leikkaus, yhdistelmä ja erotus) ovat suhteellisen helppoja ymmärtää käsitteellisesti. Monimutkaisempaa joukkojen "matematiikkaa" tässä ei tarvitse ymmärtää tai toteuttaa.

Arvosanaa 5 varten, **toteuta** hajautustaulusta tutuin tekniikoin *tietojoukko* toteuttamalla rajapintaluokka `oy.interact.tira.util.SetInterface` konkreettisessa luokassa tiedostoon `SetImplementation.java`. Sijoita tämä konkreettinen luokka `student` -packageen kuten tähänkin asti uudet omat luokkasi olet sijoittanut. 

**Lue** rajapintaluokan metodien kommenteista kuvaukset mitä metodien tulisi tehdä. 

**Lue taustaksi** yllä linkitetty tutoriaali tietojoukkojen operaatioista, kuten esimerkiksi leikkaus (*intersection*), yhdistelmä eli unioni (*union*) ja symmetrinen erotus (*symmetric difference*) ja mitä ovat osajoukko (*subset*) ja . Kysy tarvittaessa apua opettajilta.

**Huomaa** myös että `SetInterface` toteuttaa Javan rajapinnan `Iterable` ([Oraclen ohje](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)), joten se on myös toteutettava omassa konkreettisessa luokassasi. Tästä on se etu, että voit käydä läpi elementtejä set-tietojoukosta yksinkertaisessa for-in-loopissa, kuten Javankin tietosäiliöluokkienkin kanssa, tässä erään joukon algoritmin `filter` pätkä:

```Java
...
		for (E element : this) {
			if (element != null && filter.test(element)) {
				newSet.insert(element);
			}
		}
  ...
// ja testeissä:
		SetInterface<Integer> setOfInts = SetFactory.createIntegerSet();
    ...
		SetInterface<Integer> setOfEvenNumbers = setOfInts.filter( value -> value % 2 == 0);
    // Tässä hyödynnetään Iterable -rajapintaa tietojoukon iterointiin
		for (Integer value : setOfEvenNumbers) {
			assertEquals(0, value % 2);
		}

```
Nuo for -silmukat ovat tuossa set:n olioita (`this`, `setOfEvenNumbers`) käsitellessä noin yksinkertaisia siksi, että luokka toteuttaa `Iterable` -rajapinnan. Mm. kaikki Javan tietosäiliöluokat toteuttavat `Iterable` -rajapinnan, joten iteraation toteuttaminen arvosanatasolla 5 on hyödyllistä oppimaa.

Ohjeita siitä, miten `Iterable` -rajapinta toteutetaan, löytyy netistä, esim. [Geeks for geeks](https://www.geeksforgeeks.org/java-implementing-iterator-and-iterable-interface/).

Instantioi toteutuksesi tietojoukko-luokasta tehdasluokan `src/main/java/oy/interact/tira/factories/SetFactory.java` metodeissa, sillä alla mainittu testi hyödyntää sitä testeissä.

**Testaa** toteutusta testeillä hakemistossa `grade_5/task_8/`. Jos kaikki testit menevät läpi, olet saanut toteutettua tietojoukko-tietorakenteen oikein. Huomaa testiluokissa olevat vinkit ja linkit tyhjien joukkojen käsittelystä joissakin joukkojen operaatioissa.


## Raportti

**Kirjaa** raporttiisi `RAPORTTI.markdown` mitä opit tehtävän tekemisestä, mikä oli vaikeaa, mikä helppoa, jne.

Analysoi toteutuksesi oikeellisuutta ja aikatehokkuutta huomioiden seuraavat asiat:

* Kurssin luennot ja kirjallisuus hajautustauluista.
* Yksikkötestit ja niiden mittaukset.
* Vertailut taulukkopohjaiseen tietorakenteeseen, sen aikatehokkuusmittaukset.
* Havaintosi TIRA Codersin käyttöliittymästä kun analysoit koodin avainsanojen määriä.

**Vertaile** siis raportissasi tässä vaiheessa kurssia yhdistellen tietoja eri tietorakenteiden aikatehokkuudesta:

1. BST:n hitaan taulukkototeutuksen,
2. BST:n (nopea toteutus),
3. Tämän harjoituksen hitaan taulukon toteutuksen, sekä
4. Tämän harjoituksen hajautustaulun aikatehokkuuksia toisiinsa.

Varmista että "hidas" taulukkototeutus jolla kurssi aloitettiin, käyttää silti nopeaa toteuttamaasi lajittelualgoritmia, sekä toteuttamaasi nopeaa puolitushakua (kun tehdään tarkka haku). Näin vertailu on reilumpaa.

Hyödynnä analyysissäsi testien tuottamia **csv -tiedostoja**. Kaikki nämä nopeustestit käyttävät samoja JSON -tiedostoja joissa koodareiden tietoja. Testit tuottavat siis vertailukelpoista aineistoa. Vie tiedostojen sisältö taulukkolaskimeen, tee niistä graafeja ja analysoi mitä ne kertovat.

> Graafeja tehdessäsi kannattaa ehdottomasti valita aina aineiston määrä (n) x-akselille, ja **yksi** aikamittauskategoria (sarake) kerrallaan graafiin, esimerkiksi viivadiagrammiin. Näin voit lukea n:n kasvun vaikutusta graafista visuaalisesti *vasemmalta oikealle* n:n kasvaessa x-akselilla. Jos laitat useampia aikamittauksia yhtäaikaa samaan graafiin, ja toinen sarake sisältää huomattavan paljon pienempiä mittoja, tämä käyrä jää käytännössä x-akselin pintaan tai päälle, eikä siitä saa mitään informaatiota esille. Tee useampia graafeja joissa kussakin yksi mittaus. Huomioi myös se, että n ei kasva testiaineistossa tasaisesti, vaan välillä kasvu on isompaa. Esimerkiksi koodareiden määrä on pienimmästä tiedostosta alkaen 100, 1000, 5000, 10000, ja niin edelleen. Ota tämä siis huomioon kun tulkitset graafeja!

**Analysoi** miten aineiston koon kasvu vaikutti eri hajautustaulun algoritmien aikatehokkuuteen. Hyödynnä tässä testien tuottamaa csv -tiedostoa. Miten tämä aineiston koon kasvun vaikutus mitattuihin suoritusaikoihin vertautuu siihen, mitä tiedät hajautustaulun *eri* algoritmien aikakompleksisuusluokista?

Vertaa hajautustaulun aikatehokkuutta BST:n aikatehokkuuteen:

1. missä BST on nopeampi kuin hajautustaulu, ja päinvastoin? Miksi?
2. onko toinen tietorakenne nopeampi pienemmillä aineistoilla ja hitaampi suuremmilla kuin toinen; kumpi? Milloin ja miksi?


## Lopuksi

Jos kloonasit **Linuxin kernelin** koodin, **varmista** ettei se ole sinun repositorysi hakemistoissa, muuten tulee aika isoja ongelmia repositorysi koon kanssa...

Kun olet valmis, varmista että sekä raportti että kaikki koodi on paikallisessa git -repositoryssäsi ja myös etärepositoryssäsi (komennot `git commit`, tarvittaessa uusille tiedostoille `git add` sekä `git push`).


## Tietoja

* Kurssimateriaalia Tietorakenteet ja algoritmit -kurssille | Data structures and algorithms 2021-2024.
* Tietojenkäsittelytieteet, Tieto- ja sähkötekniikan tiedekunta, Oulun yliopisto.
* (c) Antti Juustila 2021-2024, INTERACT Research Group.