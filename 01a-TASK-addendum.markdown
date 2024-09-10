# Tehtävän 1 lisäohje

Tämä on kertausta edeltäviltä kursseilta. Näiden asioiden kanssa on usein ongelmia, joten lue tämä jos koet että on syytä kerrata miten muuttujia vertaillaan Javassa, riippuen siitä onko kyse perustietotyypistä vai luokan oliosta.

Tehtävässä 1 toteutetaan lajittelualgoritmi. Lajittelussa lajiteltavia asioita aina **vertaillaan** jotta ne voidaan laittaa oikeaan järjestykseen. Vertailua toki tehdään myös muuallakin kuin lajitteluissa; se on erittäin yleinen operaatio, myös tämän kurssin muissa koodaustehtävissä.

Olet ehkä oppinut vertailemaan muuttujien arvoja operaattoreilla `<, <=, >, >=` sekä `==` ja `!=`. Esimerkiksi:

```C
	int a = 10;
	int b = 20;

	if (a < b) {
		printf("Muuttuja a on pienempi kuin b");
	}
	if (a == b) {
		printf("Muuttujat a ja b ovat yhtä suuret");
	}
	if (a != b) {
		printf("Muuttujat a ja b ovat eri suuret");
	}
```

Javan *luokkien* kanssa näitä **vertailuoperaattoreita ei voi eikä saa käyttää**. Ne toimivat *vain perustietotyyppien* kuten kokonaisluvut (`int`), reaaliluvut (`double`, `float`) sekä merkkitieto (`char`), kanssa. Aina kun Javan tietotyypin nimi alkaa Isolla Alkukirjaimella, kyseessä on luokka eikä vertailuoperaattoreita voi silloin käyttää yhtä- ja erisuuruuden arviointiin.

> Poikkeuksena vain tilanne, jossa halutaan katsoa ovatko kaksi oliota täsmälleen sama olio eli *sama muuttuja*. Silloin käytetään vertailuoperaattoreita `==` ja `!=`.

Koska Javan *geneeriset* luokat ja metodit toimivat *vain luokkien*, eivät perustietotyyppien (`int, double, char`...) kanssa, se tarkoittaa sitä että geneeristen algoritmien ja luokkien toteutuksessa vertailuja ei noilla operaattoreilla tehdä. Koska toteutat algoritmit tässä tehtävässä geneerisinä, tämä on tärkeä asia.

**Miten vertailut sitten Javassa pitää toteuttaa?**

Olioiden yhtä- tai erisuuruutta vertailtaessa käytetään `equals` -metodia (jonka *oletustoteutus* periytyy kaikille luokille `Object` -luokasta). 

Tämä `equals` -metodi pitää itse omille luokille toteuttaa (ylikuormittaa, *override*) *täsmälleen* samalla rajapinnalla kuin se on `Object` -luokassa esitelty. Kuhunkin luokkaan tehdään sitten luokalle *omanlaisensa* yhtäsuuruuden vertailu, kun halutaan tietää ovatko luokan oliot `equal` eli "samanarvoisia". Esimerkiksi henkilö -olioita vertailtaessa tämä voisi tarkoittaa vaikka henkilötunnuksen vertailua. Nimi ei ole kovin hyvä vaihtoehto tähän, sillä kahdella *eri* henkilöllä voi olla *sama* nimi.

Kun taas halutaan verrata järjestystä, vertailtavan luokan täytyy Javassa toteuttaa `Comparable` -rajapinta, ja järjestysvertailu (`<, <=, >, >=`) tehdään kutsumalla rajapinnan määrittelemää `compareTo` -metodia:

```Java
   Integer a = 10; // Integer on luokka, ei perustietotyyppi int.
   Integer b = 20;

   if (a.compareTo(b) < 0) {
      print("Muuttuja a on pienempi kuin b");
   }
   if (a.equals(b)) {
      printf("Muuttujat a ja b ovat yhtä suuret");
   }
   // Tai (mutta ei aina):
   if (a.compareTo(b) == 0) {
      printf("Muuttujat a ja b ovat yhtä suuret");
   }
   if (!a.equals(b)) { // Huomaa huutomerkki - NOT equals
      printf("Muuttujat a ja b ovat eri suuret");
   }
   // Tai (mutta ei aina):
   if (a.compareTo(b) != 0) {
      printf("Muuttujat a ja b ovat yhtä suuret");
   }
```

Aivan liian yleinen virhe kurssin tehtävissä on se, että olioiden vertailu tehdään väärin käyttämällä vertailuoperaattoreita. Se menee läpi kääntäjästä, ohjelma toimii, mutta toimii **väärin**. Koska silloin ei vertailla sitä mitä pitäisi. Vertailuoperaattoreilla verrataan onko *olio* sama tai eri *olio*, esimerkiksi:

```Java
	Coder one = new Coder("Tiina");
	Coder another = new Coder("Pertti");
	Coder third = one;
	if (one == another) { // false, different objects
		// ...
	}
	if (one == third) { // true, one and third refer to the _same_ object, coder Tiina!
		// ...
	}
```

*Joskus* tietysti olion viittauksien vertaaminen on ihan paikallaan, mutta *vain* silloin kun nimenomaan halutaan katsoa viittaako joku muuttuja `x` samaan olioon kuin toinen muuttuja `y`.

Oikea tapa verrata ovatko koodarit (semanttisesti) yhtäsuuret (eivätkä sama olio) on tämä:

```Java
	Coder one = new Coder("Tiina");
	Coder another = new Coder("Pertti");

	if (one.equals(another)) { // false, different names
		// ...
	}
```

Toinen yleinen virhe on se, että vertailumetodi `equals` joko unohdetaan toteuttaa tai se toteutetaan väärin (vertailu ei toimi kuten olisi syytä toimia), jolloin koodi ei toimi oikein. Tai `compareTo` -metodi toteutetaan väärin, jolloin tiedot esimerkiksi lajitellaan väärään järjestykseen. Ole siis näiden kanssa tarkkana!
