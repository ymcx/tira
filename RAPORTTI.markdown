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

## 06-TASK

## 07-TASK

## 08-TASK

## 09-TASK
