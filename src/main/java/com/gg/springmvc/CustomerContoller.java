package com.gg.springmvc;


import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.processing.SupportedSourceVersion;

@Controller
public class CustomerContoller {


    // Add initbinder... to convert trim input strings
    // Remove leading and trailing whitespace
    // Resolve issue for our validation

    @InitBinder
    public void iniBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }



    @GetMapping("/")
    public String showForm(Model theModel) {

        theModel.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processFrom(
            @Valid @ModelAttribute ("customer") Customer theCustomer,
            BindingResult theBindingResult) {

        System.out.println("Last name: |" + theCustomer.getLastName() + "|");

        System.out.println("Binding results: " + theBindingResult.toString());

        if(theBindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}
