package cz.itnetwork.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventsController {
    @GetMapping
    public String showEvents(){
        return "pages/events/index.html";
    }
}
