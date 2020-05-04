package com.example.demo.Controller;

//import com.example.demo.Model.Item;
import com.example.demo.Model.Student;
import com.example.demo.Repository.ExRepo;
//import com.example.demo.Repository.StudentRepo;
//import com.example.demo.Service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    /*
    @Autowired
    StudentService studentService;

     */

    private ExRepo studentRepo;

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("students", studentRepo.readAll());
        return "shop";
    }

    @GetMapping("/create")
    public String showCreatePage(){

        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Student student){
        studentRepo.create(student);
        return "redirect:/shop";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        studentRepo.delete(id);
        return "redirect:/shop";
    }
    /*
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Model model){
        studentRepo.update();
                return "update";
    }
    */

    /*
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("student", studentRepo.update());
        return "update";
    }

    @PostMapping("/update")
    public String updateNow(@ModelAttribute Student student){
        studentService.updateStudent(student);
        return "redirect:/shop";
    }
    */
    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/converter")
    public String converter(){

        return "converter";
    }

    @GetMapping("/blog")
    public String blog(){

        return "blog";
    }

}
