package com.gg.springmvc;


import jakarta.validation.constraints.*;
import org.springframework.web.bind.annotation.ModelAttribute;

public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater or equal to zero")
    @Max(value = 10, message = "must be less than or equal than 10")
    private Integer freePasses;

    @NotNull(message="is required")
    @Size(min=1,message="is required")
    private String lastName;


    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
}
