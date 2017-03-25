package exercise.p06_Strategy_Pattern;

import java.util.Comparator;

public class NameLengthComparator implements Comparator<Person> {

    public NameLengthComparator() {
    }

    @Override
    public int compare(Person person1, Person person2) {
        if (person1.getName().length() == person2.getName().length()){
            return person1.getName().toLowerCase().charAt(0) - person2.getName().toLowerCase().charAt(0);
        }
        return person1.getName().length() - person2.getName().length();
    }
}
