package exercise.p10_11_12_13_Inferno_Infinity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ClassInfo {

    String author();

    int revision();

    String description();

    String[] reviewers();
}
