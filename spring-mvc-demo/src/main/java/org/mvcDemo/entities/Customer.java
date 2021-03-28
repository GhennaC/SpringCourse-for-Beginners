package org.mvcDemo.entities;

import org.mvcDemo.validation.CourseCode;
import org.springframework.format.annotation.NumberFormat;
import org.thymeleaf.messageresolver.IMessageResolver;

import javax.validation.constraints.*;

public class Customer {

    private String firstName;
    @NotNull(message = "can not be null")
    @Size(min=1, message="is required")
    private String lastName;

    @NotNull(message = "can not be null")
    @Min(value = 0, message = "must be less thar or equal to zero")
    @Max(value = 10, message = "must be greater thar or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 char+digits")
    private String postalCode;

    @CourseCode(value = {"TOPS", "LUV"}, message = "MUST START WITH TOPS")
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}