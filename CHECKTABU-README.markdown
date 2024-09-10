# checktabu

Checktabu on Java Swing -ohjelma jolla voit tarkistaa onko koodissasi käytetty ohjelmointitöissä kiellettyjä Javan luokkia ja algoritmeja.

Työkalu käy läpi kaikki student -packagessa olevat lähdekooditiedostot ja tarkistaa, ettei niissä käytetä kiellettyjä ratkaisuja.

Tarkistus tehdään katsomalla onko koodissa importattu Javan luokkia joita ei saa käyttää.

Esimerkiksi, jos koodisi käyttää Javan listaa (`List` -rajapinnan toteutuksia), se importtaa esimerkiksi seuraavaa:

```Java
import java.util.ArrayList;
```

Suurimmassa osassa tehtäviä ei tarvitse importata mitään muuta kuin TIRA:n omia rajapintaluokkia ja luokkien toteutuksia. Eli importit `import oy.interact.tira.*` ovat aina sallittuja.


Vain seuraavia Javan importteja tarvitaan useimmissa (muttei kaikissa) tehtävissä:

```Java
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.Iterator; // vain arvosanan 5 Set -tehtävässä
```

Joten näistä työkalu ei tietenkään mitään valita.

Koska graph eli verkkotietorakenteessa saa käyttää kaikkia Javan luokkia, työkalu ei tarkista sen koodia.

Huomaa että työkalu ei huomaa jos et ole itse toteuttanut hajautusfunktiota (tehtävä 8) vaan käytät Javan valmista hajautusfunktiota. Mutta tälle on erikseen testit kyseisen tehtävän yhteydessä.


## Miten käytät työkalua?

Käynnistä se tuplaklikkaamalla checktabu.jar:ia tai käynnistämällä se komentoriviltä:

```console
java -jar checktabu.jar ..
```

Ja valitse painikkeella se hakemisto joka on projektisi juurihakemisto. Älä mene kyseiseen hakemistoon tuplaklikkaamalla sitä, vaan valitse hakemisto sitä kerran klikkaamalla, ja sitten valitse avaa -painike dialogissa.

Työkalu käy läpi koodisi `student` -packagessa ja katsoo ettei siellä ole importattu sellaista mitä ei pitäisi eikä tarvitse importata. Jos kiellettyjä asioita importataan, ne listataan käyttöliittymään näkyville.

Esimerkkilistaus:

```
19 files checked:

  1. HashTableContainer.java
  2. CoderFullNameComparator.java
  3. BSTToArrayVisitor.java
  4. SetImplementation.java
  5. StackImplementation.java
  6. TreeNode.java
  7. ArrayQueue.java
  8. Algorithms.java
  9. LinkedListQueue.java
 10. BSTPredicateSearcherVisitor.java
 11. CoderNameComparator.java
 12. BinarySearchTreeContainer.java
 13. ParenthesesException.java
 14. BSTGetIndexVisitor.java
 15. ParenthesisChecker.java
 16. CodeWordsCounter.java
 17. BSTAnalyzerVisitor.java
 18. CodeWordsComparator.java
 19. BSTToDotFileTreeVisitor.java

Found 1 files using unnecessary or forbidden imports:

1/1. File: /Users/juustila/workspace/tira-2024/coders/src/main/java/oy/interact/tira/student/BSTAnalyzerVisitor.java
   import java.util.ArrayList; is forbidden or unnecessary import.
   import java.util.List; is forbidden or unnecessary import.
```

Tässä tapauksessa (opettajan) koodista löytyi yksi (valinnainen tehtävä) visitor -toteutus joka käyttää ArrayList -luokkaa. Hyi ope!

Kysy lisää opettajilta tarvittaessa.

