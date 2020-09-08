package springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String[] coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    /*
     * Spring MVC will call: isValid(...)
     * theCode - HTML Form Data entered by the user
     * theConstrainValidatorContext - Helper class for additional error messages
     * */
    @Override
    public boolean isValid(String theCode,
                           ConstraintValidatorContext theConstrainValidatorContext) {
        boolean result = false;

        if (theCode != null) {


            /*
            loop thru course prefixes
            check to see if code matches any of the course prefixes
             */

            for (String tempPrefix : coursePrefix) {
                result = theCode.startsWith(tempPrefix);
                // if we found a match then break out of the loop
                if (result) {
                    break;
                }
            }
        } else {
            result = true;
        }

/*        >> single String validation <<

        if (theCode != null) {
            //does it starts with LUV?
            result = theCode.startsWith(coursePrefix);
        } else {
            result = true;
        }*/

        return result;
    }
}
