package lab.p04_Book_Comparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book first, Book second) {
        if (first.getTitle().compareTo(second.getTitle()) == 0){
            return Integer.compare(first.getYear(), second.getYear());
        } else {
            return first.getTitle().compareTo(second.getTitle());
        }
    }
}
