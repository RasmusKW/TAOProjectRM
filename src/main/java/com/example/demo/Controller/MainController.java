package com.example.demo.Controller;

import com.example.demo.Model.Item;
import com.example.demo.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    ItemService itemService;

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("items", itemService.fetchAllItems());
        return "shop";
    }

    @GetMapping("/create")
    public String showCreatePage(){

        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Item item){
        itemService.addItem(item);
        return "redirect:/shop";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        itemService.deleteItem(id);
        return "redirect:/shop";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("item", itemService.findItemById(id));
        return "update";
    }

    @PostMapping("/update")
    public String updateNow(@ModelAttribute Item item){
        itemService.updateItem(item);
        return "redirect:/shop";
    }

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
