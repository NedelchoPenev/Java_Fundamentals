package exercise.P04_Тelephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> sites;

    public Smartphone(List<String> numbers, List<String> sites) {
        this.numbers = numbers;
        this.sites = sites;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("\\D");
        for (String number : this.numbers) {
            Matcher matcher = pattern.matcher(number);
            if (matcher.find()) {
                sb.append("Invalid number!").append(System.lineSeparator());
            } else {
                sb.append("Calling... ").append(number).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("\\d");
        for (String site : this.sites) {
            Matcher matcher = pattern.matcher(site);
            if (matcher.find()) {
                sb.append("Invalid URL!").append(System.lineSeparator());
            } else {
                sb.append("Browsing... ").append(site).append("!").append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.call()).append(this.browse());
        return sb.toString();
    }
}
