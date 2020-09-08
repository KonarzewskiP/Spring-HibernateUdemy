package com.kon.springdemo.mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {

        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @RequestMapping("/processForm")
    public String processForm(
            //@Valid - validate the customer object
            //@ModelAttribute -
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult bindingResult) {

        System.out.println("Last name: |" + theCustomer.getLastName() + "|");

        System.out.println("Binding result: "+ bindingResult);

        System.out.println("\n\n\n\n");

        if (bindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }

    /*
     * @InitBinder annotation works as a pre-processor
     * It will pre-process each web request to our controller
     * Method annotated with @InitBinder is executed
     *
     * Pre-Process every String form data
     * Remove leading and trailing white space
     * if String only has white space ... trim it to null
     * */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        //StringTrimmerEditor - removes whitespace - leading and trailing
        // true - means trim to null
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        //For every String class apply stringTrimmerEditor
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
