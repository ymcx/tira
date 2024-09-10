# TIRA-2024

Tämä repository (koodiarkisto tai tietovarasto), lyhyesti "repo", sisältää tehtävämateriaalin kurssille Tietorakenteet ja algoritmit (lyhyesti TIRA).

Sinä opiskelijana luot tästä repositorystä oman kopiosi eli forkin GitHubissa oman tunnuksesi alle. Sen jälkeen kloonaat (clone) tämän forkin omalle tietokoneellesi ja teet kurssin tehtävät omalla tietokoneellasi. Sitä mukaa kun saat tehtäviä tehtyä, toimitat tekemisesi forkin kautta opettajien arvioitavaksi.

> Etärepository on pidettävä aina ajan tasalla. Jokaisena koodaus- tai raportinkirjoituspäivänä, teet commitin paikalliseen repositoryyn ja viet lopuksi muutokset etärepoosi. Näin jos sinulla on ongelmia, opettajat pääsevät välittömästi hakemaan koodisi etärepostasi, ja voivat ohjata sinua eteenpäin.
>
> Miten tämä kaikki tapahtuu, kerrotaan tässä ja muissa repon ohjetiedostoissa. Lisäksi kurssimateriaali sisältää useita demovideoita joiden kautta näet miten tämä tehdään. 

Kaikki kurssin tehtävät ovat yksilösuorituksia, joten ryhmätyötä tässä kurssilla ei tehdä.

**TÄRKEÄ huomautus**: tehtävissä **ei saa käyttää** Javan Collection (tietosäiliö) luokkia eikä niihin liittyviä algoritmeja (esimerkiksi `Collections`, `Arrays`, `System`, `Set`, `ArrayList`, `LinkedList`, `Stack`, `Vector`, `Queue`, mikään `Map` -rajapinnan toteutus (esim. `HashMap`, `Hashtable`), `Arrays.sort`, `Collections.sort`. jne.) ellei *erityisesti* sanota että se on sallittua jossain *tietyssä* tehtävässä. 

On **sallittua** käyttää `String` -luokkaa ja kaikkia primitiivisiä (alkeis-)tietotyyppejä kuten int, long, short, double, float, char, näiden luokkaversiot (`Integer`, `Double`, jne.) ja "tavalliset" taulukot (esim. `String [] arrayOfStrings`). Niissä tehtävissä joissa pitää toteuttaa **hajautusfunktio** (tiivistefunktio, hash), **ei saa käyttää** Javan luokkien valmista `hashCode()` -metodia (esim. `String.hashCode()`), ellei taas erikseen toisin mainita, vaan tiivistefunktiot toteutetaan *itse*. Omia apuluokkia ja -algoritmeja on luonnollisesti hyväkin tehdä, tehtävästä riippuen.


## Työkalut

Kurssilla tarvittavien työkalut ja niiden asennusohjeet on kerrottu [TOOLS.markdown](TOOLS.markdown) ohjeessa. 

**Asenna työkalut** ja jatka sitten ohjeiden lukemista eteenpäin. Katso myös Moodlesta löytyvät demovideot aiheesta.


## Miten pystytän työtilani

Ohjeessa [SETUP.markdown](SETUP.markdown) kerrotaan miten voit forkata ja kloonata kurssin alkuperäisen repon omaa työskentelyäasi varten. Tämän tehtyäsi työskentelet omalla koneellasi *paikallisen* (local) reposi kanssa, ja kun olet saanut tehtävää eteenpäin, työntää työsi omaan etärepositoryysi.

Käytät git:iä kurssilla siihen että:

1. lisäät uusia kooditiedostoja ja muutoksia olemassa olevaan koodiin omalla koneella olevaan paikalliseen git-repositoryysi,
1. työnnät (push) paikallisessa repossa olevaa koodia omaan etärepositooryysi,
1. josta opettajat voivat tarkastella edistymisetäsi, auttaa sinua ongelmien kanssa ja lopuksi hakea koodisi testattavaksi ja arvioitavaksi arvosanan antamista varten.

Seuraa siis ohjeita [SETUP.markdown](SETUP.markdown) -tiedostossa. Tämä pitää tehdä *vain kerran* kurssin alkaessa.


## Ajoitus ja määräajat

Taulukko alempana kuvaa kurssin toteutuksen aikataulun syksyllä 2024 perideissa 1-2. 

Jokainen kurssin tehtävä on omassa ohjetiedostossa (`01-TASK.markdown`, jne. numeroituna) jossa on ohjeita kyseisen tehtävän toteuttamiseksi. Kun etenet tehtävän kanssa, lue nämä ohjeet *huolellisesti* ennen kuin aloitat työskentelyn. Etene tehtävät *järjestyksessä*.

Kurssin deadline:n tullessa kohdalle, kurssin opettajat kloonaavat skripteillään repositorynne automaattista testausta varten. Jokaisessa tehtävässä on **pakollisia** osuuksia, ja useissa tehtävissä myös **valinnaisia** eli vapaaehtoisesti tehtäviä osuuksia. Pakollisten tehtävien tekeminen mahdollistaa kurssin läpäisyn arvosanalla 1.

**Noudata kurssin määräaikoja; mikäli deadlineen kuuluvien pakollisten tehtävien testit eivät mene läpi deadlinen kohdalla, kurssin suoritus keskeytyy siihen.**

> Huomaa että jos se sinulle on mahdollista, voit edetä **nopeammin** kuin kurssin aikataulu esittää. Deadlinesta ei kuitenkaan voi myöhästyä. Kaikki pakolliset tehtävät on tehtävä sen deadlineen mennessä. Valinnaisia tehtäviä voi tehdä, mutta ne on myös tehtävä tehtävän deadlineen mennessä. Jos sairastut, sinulla on opintopsykologin todistus tai joku muu dokumentti joka voi mahdollistaa deadlinesta joustamisen, ota yhteyttä **etukäteen** tai välittömästi kuin mahdollista, kurssin vastuuhenkilöön. Deadlinesta ei jousteta muista kuin dokumentoiduista syistä (en ehtinyt, en jaksanut, en osannut, tms.).

### Luennot

Kurssin **liveluennot** ovat lähinnä opiskelun tueksi ja demojen läpikäyntejä varten. Näiden aikataulutus löytyy Moodlen kalenterista. Varsinaiset luennot ovat katsottavissa videotallenteina.

Voit katsoa luennot videotallenteina omaan tahtiisi. Huomaa kuitenkin että kuhunkin harjoitukseen liittyvät luennot on syytä katsoa *ennen* kuin aloitat kyseisen harjoituksen tekemisen. Luennot antavat taustaa, esimerkkejä ja käsitteitä joita tarvitset tehtävien tekemisessä. Tavallisin syy tehdä turhaa työtä ja/tai epäonnistua tehtävissä on se, ettei ole oikealla tavalla sovellettu luennoilla ja muissa kurssimateriaaleissa esitettyjä asioita.


### Harjoitukset 

**Harjoitusten** aikataulutus on suunniteltu niin että *aloitat* harjoituksen alla mainitulla viikolla. Huomaa tehtävien ajoitus ja deadlinet, palauta työsi ajoissa. Älä jätä hommia viime tippaan, se on yleinen resepti lisästressille ja suorituksen keskeytymiselle. Aloita töiden tekeminen ja viimeistele työsi mieluummin etupainoitteisesti. Hae apua ennemmin kuin myöhemmin, jos et saa tehtävää tehtyä tai bugia korjattua.

**Deadlinet**: Kun kurssin aikainen välideadline tulee, automaattiset testiskriptit hakevat reposi koodin ja suorittavat tehtävien yksikkötestit. Mikäli pakollisten tehtävien yksikkötestit eivät mene läpi, kurssin suoritus keskeytyy siihen. Lopullisessa arvostelussa, kurssin viimeisen deadlinen jälkeen, tehtävän toteutus käydään läpi, ja suoritetaan lopullinen arvostelu. Tehtävän arvostelu voi olla tällöin myös hylätty (tehtävä pitää tehdä hyväksyttävästi arvosanan saamiseksi), nolla tai tehtävän maksimipistemäärä tai jotain siltä väliltä.

Hyödynnä ohjausessioita ja muita tukimuotoja **ajoissa** jotta voit varmistua siitä että deadlinen tullessa kaikki on kunnossa. Deadlinen yhteydessä et saa palautetta tehtävistä.

**Aikataulu ja deadlinet** selviävät alla olevasta taulukosta. Valinnaiset ja pakolliset ohjelmointitehtävien osat listataan erikseen ohjeessa [README-ARVOSTELU.markdown](README-ARVOSTELU.markdown) jossa selitetään arvosteluun liittyvät yksityiskohdat.


| Viikko |  Luento                | Ohjelmointitehtävä                  | Huomioitavaa             |
|-------:|------------------------|-------------------------------------|--------------------------|
| 37     | A  Kurssin esittely    | [01-TASK](01-TASK.markdown)         | Ohjelmointi 2 kertausta: | 
|        | B  Aiheen esittely     |                                     | - lisäyslajittelu        |
| 38     | C  Aikakompleksisuus   | [01-TASK](01-TASK.markdown) jatkuu  | Lajittelu asc/desc,      |
|        | D  Analyysi            | [02-TASK](02-TASK.markdown)         |  lineaarinen haku        |
| 39     | E  Intro: lajittelu    | [03-TASK](03-TASK.markdown)         | Puolitushaku             |
| 40     | F  Pino                | [04-TASK](04-TASK.markdown)         | Pinotietorakenne         |
| 41     | G  Jono, Linkitetty lista | [05-TASK](05-TASK.markdown)      | Jono, linkitetty lista   |
| 42     | H  Lajittelualgoritmit | [06-TASK](06-TASK.markdown)         | Quicksort, heapsort+,    |
|        |                        |                                     | merge sort+,...          |
| 43     | I  Binäärinen hakupuu  | [07-TASK](07-TASK.markdown)         |                          |
| 44     |    Binäärinen hakupuu  |                                     | **Tentti 1**             |
| 45     | J  Hajautustaulu       | [08-TASK](08-TASK.markdown)         |                          |
| 46     |                        |                                     |                          |
| 47     | K  Verkot (graphs)     | [09-TASK](09-TASK.markdown)         |                          |
| 48     |    Verkot (graphs)     |                                     |                          |
| 49     |    Verkot (graphs)     | [09-TASK](09-TASK.markdown)         |                          |
| 50     |    Verkot (graphs)     | [09-TASK](09-TASK.markdown)         |                          |
| 50     | L Suunnittelu, dynamic |                                     |                          |
| w2/2025| **Deadline**           | **Kaikki tehtynä ja etärepossa**    | **Tentti 2**             |


Tenttiin 1 sisältyy luentojen aiheet A...H, ja tenttiin 2 sisältyy aiheet I...L. Tenttikysymykset saattavat hyödyntää myös ohjelmointimateriaalien (tehtävät) aineistoa. Molemmat tentit ovat max á 10 pistettä. Tarkemmin tenteistä ja niiden ajankohdasta tiedotetaan kurssin Moodle -sivuilla.

Ohjelmointitehtävien deadline on kyseisen viikon **maanantaina klo 16:00 EET**. Opettajien skriptit hakevat reposi sisällön koneelle tuona ajankohtana, ja sen hetkinen versio testataan ja arvioidaan.


## Tietoja

* Kurssimateriaalia Tietorakenteet ja algoritmit -kurssille | Data structures and algorithms 2021-2024.
* Tietojenkäsittelytieteet, Tieto- ja sähkötekniikan tiedekunta, Oulun yliopisto.
* (c) Antti Juustila 2021-2024.
