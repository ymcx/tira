package oy.interact.tira.grade_4.task_8;

public class Person implements Comparable<Person> {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person is " + name;
    }

    @Override
    public boolean equals(Object another) {
        if (another instanceof Person) {
            return this.name.equals(((Person)another).name);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int hash = 31;
        for (int index = 0; index < name.length(); index++) {
            hash += name.charAt(index);
        }
        return hash;
    }

    @Override
    public int compareTo(Person another) {
        return this.name.compareTo(another.name);
    }
}
