package cz.itnetwork.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PojisteniController {

    @GetMapping("/pojisteni/new")
    public String showPojistenciPage(){
        return "/pages/pojisteni/new.html";
    }


}
