package lab.p03_Comparable_Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    private String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private List<String> getAuthors() {
        return authors;
    }

    private void setAuthors(String... authors) {
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }

    @Override
    public int compareTo(Book book) {
        if (this.getTitle().compareTo(book.getTitle()) == 0){
            return Integer.compare(this.getYear(), book.getYear());
        } else {
            return this.getTitle().compareTo(book.getTitle());
        }
    }

    @Override
    public String toString() {
        return this.getTitle();
    }
}
