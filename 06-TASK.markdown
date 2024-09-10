# Tehtävä 6

Älä tee tätä tehtävää ennenkuin olet tehnyt [tehtävän 5](05-TASK.markdown).

Tämän harjoituksen aiheena ovat nopeat lajittelualgoritmit. Tehtävän testit hyödyntävät myös aiemmin toteuttamaasi yksinkertaista lajittelualgoritmia (tehtävä 1) sekä puolitushakua (tehtävä 3), joten näiden tulee myös toimia oikein.

Toteutit aikaisemmassa tehtävässä 1 yksinkertaisen lajittelualgoritmin. Toteutettu algoritmi toimii ihan riittävän hyvin pienillä aineistoilla, mutta jos kokeilet ladata TIRACodersiin isompia koodaritiedostoja, lajittelu kestääkin aika kauan. Kokeile tätä sovelluksessa.

> Mitä tarkoittaa kauan? Peukalosääntönä esimerkiksi käyttöliittymäsuunnittelussa, liian hidas tarkoittaa yleensä yli 200 ms odottelua. Tämän jälkeen käyttäjä alkaa jo ihmettelemään miksi ohjelma ei reagoi tai että onko se jumissa. Lajittelu (tai mikään muukaan operaatio) ei siis saisi kestää tätä pidempään. Toki sitten on olemassa tapoja ilmaista käyttäjälle että joku homma kestää, käyttämällä erilaisia käyttöliittymäelementtejä jotka ilmaisevat ohjelman puuhastelevan jotain. Mutta jos toteutetut algoritmit ovat nopeita, käyttäjän *ei tarvitse* odotella eikä ohjelman *tarvitse* näyttää tiimalaseja, pyöriviä ympyröitä, eteneviä palkkeja tai pyöriviä rantapalloja. Parempi siis alun perinkin toteuttaa nopea algoritmi. Jotkut käyttöjärjestelmät (erityisesti mobiilit) myös tappavat (kill) sovelluksen joka näyttää jumiutuneen (varsinkin sovelluksen pääsäie), joten todella pistkäkestoinen lajittelu voi saada sovelluksen kaatumaan.

Siksi tässä tehtävässä opetellaan toteuttamaan nopea lajittelualgoritmi. 

Voit toteuttaa nopeita lajittelualgoritmeja 1-3 kappaletta, riippuen arvosanatavoitteestasi, seuraavasti:

* Arvosanaan 1 toteuta pikalajittelu eli Quicksort, ja testaa sen toteutus testeillä `grade_1/task_6` -hakemistossa.
* Arvosanaan 2 toteuta edellisen lisäksi lomituslajittelu eli Mergesort, ja testaa sen toteutus testeillä `grade_2/task_6` -hakemistossa.
* Arvosanaan 3 toteuta edellisen lisäksi kekolajittelu eli Heapsort, ja testaa sen totuetus testeillä `grade_3/task_6` -hakemistossa.
* Arvosanaan 4 toteuta kaikki kolme lajittelualgoritmia siten että ne oikeellisesti lajittelevat myös taulukon alueen (range) siten että lajiteltava alue ei välttämättä ole taulukon alussa, vaan vaikkapa jossain keskellä (esim. indekseissä 42-84). Alempien arvosanojen testit eivät testaa toimivatko algoritmit oikein myös aluetta lajitellessa. Algoritmista riippuen tämä on joko helppo tai vaikeampi asia toteuttaa oikein.

Huomaa että arvosanoihin 2 ja 3 on myös muita lisätehtäviä joita on tehtävä, eli pelkkä uuden lajitteluagloritmin toteutus ei riitä kyseisiin arvosanoihin.

Huoma valmiina annettu koodi `Algorithms.java`ssa:

```Java
   public enum FastSortAlgorithm {
      QUICKSORT,
      HEAPSORT,
      MERGESORT
   }

   public static <E> void fastSort(E[] array, Comparator<E> comparator) {
      fastSort(array, 0, array.length, comparator, FastSortAlgorithm.QUICKSORT);
   }

   public static <E extends Comparable<E>> void fastSort(E[] array) {
      fastSort(array, 0, array.length, Comparator.naturalOrder(), FastSortAlgorithm.QUICKSORT);
   }

   public static <E> void fastSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      fastSort(array, fromIndex, toIndex, comparator, FastSortAlgorithm.QUICKSORT);
   }

   public static <E> void fastSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator, FastSortAlgorithm algorithm) {
      switch (algorithm) {
         case QUICKSORT:
            // Tässä kutsu toteuttamaasi quicksortia antamalla sille parametrina taulukko, indeksit ja comparaattori.
            break;
         case HEAPSORT:
            // Valinnanen tehtävä: tässä kutsu toteuttamaasi heapsortia antamalla sille parametrina taulukko, indeksit ja comparaattori.
            break;
         case MERGESORT:
            // Valinnanen tehtävä: tässä kutsu toteuttamaasi mergesortia antamalla sille parametrina taulukko, indeksit ja comparaattori.
            break;
         default:
            break;
      }
   }
```

Huomaa että kaikki `fastSort` -algoritmit joissa parametrina ei ole lajittelualgoritmin valintaa (`FastSortAlgorithm`), kutsuvat sitten sellaista `fastSort`ia jossa parametri on ja se on aina arvoltaan `FastSortAlgorithm.QUICKSORT`.

**Oletuksena** on siis että toteutat **pikalajittelun** (quicksort) tässä tehtävässä. Arvosanan 1 testit kutsuvat noita yllä olevia metodeja, joten oletusarvoisesti käytetään sitten quicksortia. Korkeamman arvosanan testit taas kutsuvat erikseen heapsort ja mergesort -parametreilla noita lajittelualgoritmeja ja testaavat erikseen niitä. Nämä ovat valinnaisia tehtäviä joilla siis saa mahdollisesti korkeamman arvosanan.

> Tässä tehtävässä kirjoitettavien rivien lukumäärä riippuu valitusta lajittelualgoritmista. Pikalajittelussa myös partitiointi- eli ositusalgoritmin valinta vaikuttaa myös koodirivien lukumäärään. Lyhimmillään selviää 15-20 rivillä koodia. Jos toteutat useamman lajittelualgoritmin, silloin koodirivien määrä tietysti nousee.

**Huomaa** että jos lajittelualgoritmisi hyödyntää **rekursiota** (kuten esimerkiksi quicksort tekee), on mahdollista että suurien tietoaineistojen lajittelussa algoritmi kuluttaa pinomuistia (stack) niin paljon rekursiivisia metodeja kutsuttaessa, että pinomuisti loppuu kesken. Tällöin tapahtuu ns. pinon ylivuoto eli **stack overflow**. Lue tästä lisää ohjeessa [WHAT-STACKOVERFLOW.markdown](WHAT-STACKOVERFLOW.markdown). Siellä ohjeet miten asiaan voi varautua ilman että ohjelman suoritus epäonnistuu.

Myös kekomuisti (heap) voi loppua kesken suurten aineistojen käsittelyssä. Katso siinä tilanteessa lisätietoa ja ohjeita dokumentista [NOT-ENOUGH-MEMORY.markdown](NOT-ENOUGH-MEMORY.markdown).

## Lähteitä

* Kurssin luentokalvot.
* Liveluento (tallenne) ja sen vinkit ja esimerkit.
* Demosovellus [SortSpectacle](https://github.com/anttijuu/sortspectacle) jossa useampikin lajittelualgoritmin toteutus Swift -kielellä.
* Kirjallisuus lajittelualgoritmeista, kurssikirja: Introduction to Algorithms, 4th ed (Comer et al):
   * Arvosana 1: Quicksort eli pikalajittelu ss 182-204.
   * Arvosana 2: Mergesort eli lomituslajittelu ss 34-44, 57.
   * Arvosana 3: Heapsort eli kekolajittelu ss 161-181.

* Englanninkielisessä Wikipediassa on myös mainituista lajittelualgoritmeista hyvät kuvaukset pseudokoodeineen.

## Tavoite

**Toteuta** vähintään (arvosana 1) pikalajittelu (Quicksort) geneerisenä lajittelualgoritmina `Algorithms.java` -tiedostoon. 

**Testaa** algoritmin oikeellisuus. Analysoi toteutuksen nopeutta suhteessa aiemmin toteuttamaasi hitaampaan algoritmiin. Kirjaa analyysisi tulokset raporttiin. Jos toteutit useamman algoritmin, vertaa niiden aikatehokkuutta toisiinsa tämän tehtävän testien avulla. Tarkemmat ohjeet tähän alempana.

Arvosanaan 1 riittää siis quicksortin toteutus, siten että se osaa lajitella taulukon indeksiväliltä 0...n, nousevaan ja laskevaan järjestykseen. 

**Arvosanaan 2** toteuta vastaavalla tavalla myös Mergesort, ja **arvosanaan 3** lisäksi Heapsort. **Arvonsanaan 4** näiden lajittelualgoritmien pitää toimia myös jos aloitusindeksi josta lajittelu aloitetaan on suurempi kuin nolla, eli taulukosta lajitellaan vain annettu väli. Toteutusvinkkejä arvosanaan 4 voi kysellä opettajilta.


## Askel 1 - Ohjeet

Toteuta `Algorithms.java` -tiedostoon pikalajittelualgoritmi ja kutsu sitä sitten erilaisista fastSort -algoritmeista antaen tarvittavat parametrit quickSort -toteutuksellesi. 

> **HUOM**: indeksit ovat `[fromIndex,toIndex)` (fromIndex inclusive, toIndex exclusive) -- lajittelu tehdään siis välillä `fromIndex..<toIndex`, ei `fromIndex...toIndex`.

Tarvitset myös omia apumetodeja, esimerkiksi quicksort tarvitsee ositus- eli partitiointialgoritmin. Heapsort tarvitsee omat apualgoritminsa, jotka näet luentomateriaalista. Toteuta nämä privaatteina staattisina metodeina samaiseen `Algorithms` -luokkaan, tarpeellisine parametreineen.

Voit koodailun aikana tehdä myös oman, vaikkapa `oy.interact.tira.SortTestMain.java` -tiedoston, sinne `main` -metodin ja testailla lajittelualgoritmejasi sillä. Testeistä enemmän alla.

## Testaaminen nopealla yksikkötestillä

Hakemisto `grade_1/task_06` sisältää tehtävän perustestit pikalajittelulle.

**Aloita** testiluokasta `CodersFastSortBasicTests`. Se käsittelee pientä testiaineistoa (100 koodarin JSON -tiedosto) joten voit nopeasti varmistua nopean lajittelualgoritmisi toteutuksen *oikeellisuudesta*.

Voit suorittaa testin joko VS Codesta käsin tai komentoriviltä, projektin juurihakemistossa (jossa `pom.xml` -tiedosto on):

```console
 mvn -Dtest=CodersFastSortBasicTests test
 ```

Voit tietysti suorittaa yhtä testimetodia kerrallaan.

Testi sisältää testimetodeja joista ensimmäinen käyttää lajittelussa algoritmia `fastSort(E [] array)`, osa testaa algoritmia `fastSort(E [] array, Comparator<E> comparator)` erilaisilla `Comparator` -olioilla. 

Jos testit menevät läpi, näet vain tulostuksia. Muussa tapauksessa näet virheilmoituksia testien epäonnistumisesta punaisella värillä.


## Testaaminen isoilla aineistolla

Tässä vaiheessa suoritat testejä, jotka käsittelevät koodaritiedostoja (JSON), alkaen pienistä ja jatkaen isoihin tiedostoihin.

Testit tulostavat aikamittauksia joita käytät lopuksi algoritmien aikatehokkuuden analysointiin ja vertailuun.

Ensin suorita testit jotka käyttävät hidasta lajittelualgoritmiasi (ohjeet alla). Tästä saat vertailuaineistoa nopean lajittelualgoritmin analysointiin.

Sen jälkeen suoritat testit jotka testaavat nopeaa lajittelualgoritmiasi isoilla aineistoilla, alkaen pienistä.


### Yksinkertaisen lajittelualgoritmin testi

Tämä testi testaa saman aineiston käsittelyä hyödyntämällä aikaisemmin toteuttamaasi yksinkertaista (ja hidasta) lajittelualgoritmia `Algorithms.insertionSort`. Tämän avulla saat **vertailuaineistoa** raporttiisi -- kuinka paljon nopea lajittelualgoritmisi on nopeampi kuin hidas insertion sort?

Testi löytyy testiluokasta `CodersSlowComparatorTests`. Suorita testi, ja varmista että tulos on oikeellinen (testi ei epäonnistu) ja kopioi talteen raporttiisi testin tulostama suoritusaika per aineiston koko.

> Huomaa, että koneesi tehoista riippuen tämä testi voi kestää suhteellisen kauan, useita minuutteja. Käynnistä testi vaikka kun lähdet lounaalle, pidät kahvitauon tai teet muita hommia. Opettajan koneella tämän testin suorittaminen kesti tätä kirjoittaessa viidenteen testiin mennessä 123977 ms eli 123 s eli noin kaksi minuuttia. Viimeinen 100 000 aineiston lajittelu veikin jo 732 sekuntia. Tähän testiin meni siis kaiken kaikkaan koneellani 856 sekuntia eli noin 14 minuuttia.
>
> Jos tutkit tehtävän testiluokan koodia, huomaat ettei testi testaa lajittelun aikatehokkuutta kaikista suurimmilla tiedostoilla. Hidas insertion sort -testi testaa vain kuutta ensimmäistä koodaritiedostoa, sillä tässäkin menee jo aika kauan aikaa.

### Nopean lajittelualgoritmin testi

Tämä testi testaa saman aineiston käsittelyä hyödyntämällä nyt toteuttamaasi nopeaa lajittelualgoritmia.

Testi löytyy testiluokasta `CodersFastComparatorTests`. Suorita testi, ja varmista että tulos on oikeellinen (testi ei epäonnistu) ja kopioi talteen raporttiisi testin tulostama suoritusaika.

Tämä testi käyttää kaikista suurintakin testiaineistoa (2 000 000 koodaria). Jos kekomuisti (heap) loppuu kesken, lue tehtävän alussa mainittu dokumentti siitä miten voit kasvattaa kekomuistia joka testille annetaan käyttöön. Jos tämäkään ei auta, tule hakemaan apua harjoituksiin niin katsotaan opettajien avustuksella miten testit saadaan toimimaan.

Vastaaasti, jos toteutit lajittelun rekursiivisella algoritmilla, pinomuisti voi loppua ja testi päättyy pinon ylivuotovirheeseen (*stack overflow*). Tästäkin löytyy ohjeet miten pinomuistia voi kasvattaa jotta saisit testit läpi myös isoilla aineistoilla.

Jos toteutit useamman kuin yhden nopean lajittelualgoritmin, suorita kaikkien näiden algoritmien testit erikseen testihakemistoissa (riippuen mihin arvosanaan tähtäät) `grade_1`, `grade_2/task_6`, `grade_3/task_6` ja/tai `grade_4/task_6`. Raportoi lajittelualgoritmien eroista kuten alla ohjeistettu.


## Muutokset TIRA Codersiin

Kun nopea lajittelualgoritmisi testatusti toimii, voit ottaa sen käyttöön TIRA Coders -sovelluksessa. Voit ensin kerrata kuinka hitaasti lajittelu tapahtuu: käynnistä TIRA Coders, lataa suuriakin testiaineistotiedostoja, ja kokeile lajittelua.

Luokassa `SimpleContainer` on kaksi lajittelumetodia (`sort`), jotka kutsuvat omia `Algorithms` -luokan toteutuksiasi hitaasta lajittelualgoritmista, aikaisemmista tehtävistä. Voit nyt **muuttaa koodia** täällä siten että kutsutkin nopeita lajittelualgoritmejasi.

> **HUOMAA** että `SimpleContainer`n taulukossa on lopussa `null`:eja, joten kutsu aina sitä fastSortia jolle annetaan indeksiväli joka lajitellaan. Tai muuten huolehdi että toteutus ei kaadu siihen että lajittelualgoritmisi yrittää vertailla null -oloita (`NullPointerException`), tai ei lajittele `null`jea oikein (taulukon loppuun).

Sen jälkeen käynnistä TIRA Coders, lataa suuriakin testiaineistotiedostoja, ja kokeile uudestaan lajittelua. Onko nopeampaa?

## Raportti

**Kirjaa** raporttiisi `RAPORTTI.markdown` mitä opit tehtävän tekemisestä, mikä oli vaikeaa, mikä helppoa, jne.

**Analysoi** testien `CodersSlowComparatorTests` ja `CodersFastComparatorTests` avulla hitaan lisäyslajittelun ja toteuttamasi nopean (tai nopeiden) algoritmien nopeuseroja. Arvioi algoritmien aikakompleksisuusluokkaa testin tulostamien aikamittausten, koodin ja kurssin teorian perusteella. Raportoi näistä havaintosi ja näkemyksesi perustellen analyysisi tulokset.

**Sisällytä** raporttiin testien tulostamat aikamittaukset algoritmien suoritusnopeudesta omalla koneellasi. Arvioi algoritmien nopeuseroja toisiinsa, ja perustele miksi kukin on toistensa suhteen hitaampi tai nopeampi algoritmi.

Huomaa että hitaan ja nopean lajittelualgoritmin tulostukset tulostavan aineistoittain sekä lajittelun kokonaisajan, että lajittelun keston per taulukon koko (eli n). Hyödynnä tätä tietoa analyysissäsi.

Hyödynnä analyysissäsi taulukkolaskimia (Excel, Numbers, Google Sheet,...) ja laadi niiden avulla graafeja jotka havainnollistavat algoritmien välisiä eroja. Ota kuvaruutukaappauksia graafeista ja sisällytä ne raporttitiedostoosi. Esimerkki siitä miten tämä tehdään, löytyy [RAPORTTI.markdown](RAPORTTI.markdown) -tiedostosta. Älä toimita repositoryssäsi Word, Excel yms documentteja, ainoastaan kuvaruutukaappauksia ja tekstiä.

Analysoi myös sitä, mitä eroja löysit eri algoritmien aikatehokkuudesta pienien ja isojen aineiston välillä? Jos toteutit useamman nopean lajittelualgoritmin, suorita testiä nopean lajittelualgoritmin ison aineiston testiä jokaisen toteuttamasi algoritmin kanssa, ja raportoi myös algoritmien aikatehokkuuseroista, perustellen miksi joku algoritmi on mielestäsi nopeampi kuin toinen, tämän aineiston kanssa.

Huomaa että analyysi on myös arvosteltava tehtävä, ja puuttuvat tai heikot perustelut ja väärät analyysit vaikuttavat arvosanaan.

## Lopuksi

Kun olet valmis, varmista että sekä raportti että kaikki koodi on paikallisessa git -repositoryssäsi ja myös etärepositoryssäsi (komennot `git commit`, tarvittaessa uusille tiedostoille `git add` sekä `git push`).

## Tietoja

* Kurssimateriaalia Tietorakenteet ja algoritmit -kurssille | Data structures and algorithms 2021-2024.
* Tietojenkäsittelytieteet, Tieto- ja sähkötekniikan tiedekunta, Oulun yliopisto.
* (c) Antti Juustila 2021-2024, INTERACT Research Group.