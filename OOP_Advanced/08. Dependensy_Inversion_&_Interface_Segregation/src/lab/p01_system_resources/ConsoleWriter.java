package lab.p01_system_resources;

public class ConsoleWriter implements Writer {

    @Override
    public void println(String string) {
        System.out.println(string);
    }
}
