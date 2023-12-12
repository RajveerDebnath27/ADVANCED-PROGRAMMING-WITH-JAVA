package dev.controller;

import dev.domain.Student;
//import dev.domain.Gender;
import dev.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;



    @GetMapping
    public ModelAndView showAllStudents() {
        List<Student> students = studentService.getAllStudents();
        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showStudentDetails(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        ModelAndView modelAndView = new ModelAndView("studentDetails");
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("genders", Gender.values());
        return "editStudent";
    }

    @PostMapping("/{id}/edit")
    public String editStudent(@PathVariable int id,
                              @Valid @ModelAttribute("student") Student student,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editStudent";
        }

        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
