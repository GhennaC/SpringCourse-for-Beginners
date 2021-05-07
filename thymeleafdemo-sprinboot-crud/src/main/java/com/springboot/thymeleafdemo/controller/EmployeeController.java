package com.springboot.thymeleafdemo.controller;

import com.springboot.thymeleafdemo.entity.Employee;
import com.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/list")
    public String listEmployees(Model model) {

        List<Employee> list = employeeService.findAll();

        model.addAttribute("employees",list);
        return "employees/employees-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        model.addAttribute("employee",new Employee());

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id,
                                    Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee",employee);

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delteEmployee(@RequestParam("employeeId") int id) {

        employeeService.delete(id);

        return "redirect:/employees/list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

}
