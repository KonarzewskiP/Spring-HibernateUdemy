package springdemo.mvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/*
* CourseCodeConstraintValidator - Helper class that contains business rules/ validation logic
* */
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
/*
* {ElementType.METHOD, ElementType.FIELD} - Can apply this annotation to a method or field
* */
@Target({ElementType.METHOD, ElementType.FIELD})
/*
* RetentionPolicy.RUNTIME - Retain this annotation in the Java class file.
* Process it at runtime
* */
@Retention(RetentionPolicy.RUNTIME)
//@CourseCode(value="LUV", message="must start with LUV")
public @interface CourseCode {

    // define default course code
    public String[] value() default {"LUV","HIPS"};

    // define default error message
    public String message() default "must start with LUV";

    // define default groups
    public Class<?>[] groups() default {};

    // define default payloads
    public Class<? extends Payload>[] payload() default {};
}
