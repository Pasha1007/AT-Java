package task4;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface CustomAnnotation {
    String value() default "Default Value";
}

@CustomAnnotation("Class Level Annotation")
public class AnnotatedClass {

    @CustomAnnotation("Method Level Annotation")
    public void annotatedMethod() {
        System.out.println("Inside the annotated method");
    }

    public static void main(String[] args) {
        try {
            AnnotatedClass obj = new AnnotatedClass();

            Class<?> annot = obj.getClass();
            System.out.println("Class Annotations:");
            for (var annotation : annot.getAnnotations()) {
                System.out.println(annotation);
            }

            Method method = annot.getMethod("annotatedMethod");
            System.out.println("\nMethod Annotations:");
            for (var annotation : method.getAnnotations()) {
                System.out.println(annotation);
            }

            obj.annotatedMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
