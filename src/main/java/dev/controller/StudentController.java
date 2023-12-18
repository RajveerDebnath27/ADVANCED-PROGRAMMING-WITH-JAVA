package dev.controller;

import dev.domain.Gender;
import dev.domain.Student;
import dev.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("genders", Gender.values());
        return "register";
    }

    @PostMapping("/register")
    public String registerStudent(@Valid @ModelAttribute("student") Student student,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("error");
            return "register";
        }

        studentService.registerStudent(student);
        return "redirect:/students";
    }

    @PostMapping("/submitForm")
    public String submitForm(@RequestParam(value = "quota", required = false) String quota) {
        // Check if the checkbox is checked
        String quotaValue = (quota != null) ? "yes" : "no";

        // Now you can save the quotaValue in your database using your service/DAO

        return "redirect:/success";  // Redirect to a success page
    }
}
