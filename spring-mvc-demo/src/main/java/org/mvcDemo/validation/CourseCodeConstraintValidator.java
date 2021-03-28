package org.mvcDemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
        implements ConstraintValidator<CourseCode, String> {

    private String[] coursePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s,
                           ConstraintValidatorContext constraintValidatorContext) {
        if(s != null)
            for (String tempPrefix : coursePrefix) {
                if (s.startsWith(tempPrefix))
                    return true;
            }
        return false;
    }
}
