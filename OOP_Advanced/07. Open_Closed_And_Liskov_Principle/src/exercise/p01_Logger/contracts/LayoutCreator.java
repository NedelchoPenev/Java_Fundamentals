package exercise.p01_Logger.contracts;

public interface LayoutCreator {

    Layout getLayout(String type)  throws ReflectiveOperationException;
}
