package oy.interact.tira.grade_4.task_8;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import oy.interact.tira.NotYetImplementedException;
import oy.interact.tira.factories.HashTableFactory;
import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedContainer;

class PersonHashtableTests {
    
    private Pair<Person, String> [] array;
    
    @Test 
    // @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void testHashTableWithPerson() {
        TIRAKeyedContainer<Person, String> hashTable = HashTableFactory.createHashTable();
        Person tinan = new Person("tinan");
        hashTable.add(tinan, "Tinan is a dancer");
        Person antin = new Person("antin");
        hashTable.add(antin, "Antin is a teacher");
        Person nitan = new Person("nitan");
        hashTable.add(nitan, "Nitan is a dog breeder");

        assertDoesNotThrow(() -> array = hashTable.toArray());
        assertEquals(3, hashTable.size());
        assertEquals(3, array.length);

        // Try updating a collided key with new value
        String value = hashTable.get(nitan);
        assertEquals("Nitan is a dog breeder", value, "Correct value found");
        hashTable.add(new Person("nitan"), "Nitan is no longer a dog breeder");
        value = hashTable.get(nitan);
        assertEquals(3, hashTable.size(), "Nitan was updated so count must still be three.");
        assertEquals("Nitan is no longer a dog breeder", value, "Correct updated value for Nitan found");

        try {
            String removed = hashTable.remove(tinan);
            assertEquals("Tinan is a dancer", removed);
            assertEquals(2, hashTable.size());
            assertDoesNotThrow(() -> array = hashTable.toArray());
            assertEquals(2, array.length);

            removed = hashTable.remove(tinan);

            assertNull(removed);
            assertEquals(2, hashTable.size());
            assertDoesNotThrow(() -> array = hashTable.toArray());
            assertEquals(2, array.length);

            removed = hashTable.remove(antin);
            assertEquals("Antin is a teacher", removed);
            assertEquals(1, hashTable.size());
            assertDoesNotThrow(() -> array = hashTable.toArray());
            assertEquals(1, array.length);

            removed = hashTable.remove(nitan);
            assertEquals("Nitan is no longer a dog breeder", removed);
            assertEquals(0, hashTable.size());
            assertDoesNotThrow(() -> array = hashTable.toArray());
            assertEquals(0, array.length);            
        } catch (UnsupportedOperationException | NotYetImplementedException e) {
            fail("For this grade, hashtable.remove must be correctly implemented");
        } catch (Exception e) {
            fail("Threw unexpected exception");
        }
    }
}
