# Raportit tehtävistä

Kirjaa tähän tiedostoon **jokaiseen** tehtävään liittyvät omat raporttisi ja analyysisi. Muista että raportti on myös kurssilla **arvosteltava tehtävä**.

Voit sisällyttää raporttiin tekstimuotoisia taulukoita (tasaukset välilyönnein):

```
n     Fill     Search   Total
500   7        700      707
1000  9        288      297
```

Ja näihin liittyviä kuvatiedostoja:

![Esimerkkikuva](report-sample-image.png)

Nämä näkyvät sitten VS Coden Preview -näkymässä (tai oman repositorysi webbisivulla) oikein muotoiltuna. Käytä tässä dokumentissa olevia muotoiluja esimerkkinä kun kirjoitat raporttiasi. 

Huomaa että jos laitat kuvatiedostot vaikka omaan alihakemistoonsa, Markdown -muotoilussa on oltava suhteellinen polku tiedostoon, esimerkiksi `images/report-sample-image.png`. **Älä** käytä absoluuttisia polkuja `C:\Users\tippaleipa\kurssit\TIRA\kuva.png`, koska nämä eivät tietenkään toimi opettajan koneella. Ei kannata laittaa linkkiä etärepoosikaan, vaan nimenomaan paikalliseen tiedostoon.

Voit myös sisällyttää *lyhyitä* koodinpätkiä vaikkapa Java -formaatilla:

```Java
	@Override
	public int hashCode() {
		// Oma nerokas hajautufunktioni!
	}
```
Tarvittaessa käytä myös paremmin muotoiltuja taulukoita:

| n	| Fill	| Search	| Total |
|-----|--------|--------|-------|
| 500	 | 7	| 700	| 707 |
| 1000 |	9	| 288	| 297 | 

Alaluvut jokaisen tehtävän raportille löydät alta.


## 01-TASK

Opin toteuttamaan simppelin algoritmin koodilla käytännön hahmotuksen lisäksi. Toisaalta mieleen palasi Javan syntaksi ja sen raikkaus verrattuna mm. C++ ja Rustiin, joidenka parissa olen käytännössä koko Ohjelmointi 2 -kurssin jälkeisen ajan viettänyt. Haasteita tuli tuon maagisen 'TIRA Coders' -applikaation löytämiseen, sillä tykkään kirjoittaa koodini suoraan terminaalissa ja myös ajaa sen siellä. Kurssin tuleville toteutuksille lienee parasta selventää tuota hieman ja sitä, mistä/miten kyseisen applikaation voi avata.

Toteutetun lajittelualgortmin aikakompleksisuusluokka on O(n^2) ja vastaavasti kääntöalgoritmin O(n).

Taulukko kannattaa kääntää uudelleenlajittelun sijaan, sillä lajittelu joutuu tekemään tarpeettomia vertailuja eri muuttujien välillä. Ylimääräisille muuttujille muistin allokoiminen on myös hidasta sekä kallista muistin suhteen.


## 02-TASK

## 03-TASK

## 04-TASK

## 05-TASK

## 06-TASK

## 07-TASK

## 08-TASK

## 09-TASK