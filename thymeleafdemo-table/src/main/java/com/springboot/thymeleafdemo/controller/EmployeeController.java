package com.springboot.thymeleafdemo.controller;

import com.springboot.thymeleafdemo.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employeeList;

    @PostConstruct
    private void loadData() {
         employeeList = new ArrayList<>();
         employeeList.add(new Employee(1, "Ana", "Labudeanu", "ana@mail.ru"));
         employeeList.add(new Employee(2, "Maria", "Labudeanu", "maria@mail.ru"));
         employeeList.add(new Employee(3, "Lungu", "Labudeanu", "lungu@mail.ru"));

    }
    @GetMapping("/list")
    public String listEmployees(Model model) {

        model.addAttribute("employees",employeeList);
        return "employees-list";
    }

}
