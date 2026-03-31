package in.hrms.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Employee {

    @GetMapping("/employee")
    public String getEmployee(){
        return "OK";
    }
    
}
