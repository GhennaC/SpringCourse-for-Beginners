package org.mvcDemo.controllers;

import org.mvcDemo.entities.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("customer",new Customer());

        return "customer-form";
    }

    @RequestMapping("/processForm")
    public String showForm() {


        return "customer-confirmation";
    }

}
