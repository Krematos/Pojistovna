package cz.itnetwork.controllers;



import cz.itnetwork.models.dto.PojistenciDTO;
import cz.itnetwork.models.dto.mapper.PojistenciMapper;
import cz.itnetwork.models.exceptions.PojistenecNotFoundException;
import cz.itnetwork.models.services.PojistenciService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;



@Controller
@RequestMapping
public class PojistenciController {

    private final PojistenciMapper pojistenciMapper;
    @Autowired
    private PojistenciService pojistenciService;




    public PojistenciController(PojistenciService pojistenciService, PojistenciMapper pojistenciMapper){
        this.pojistenciService = pojistenciService;
        this.pojistenciMapper = pojistenciMapper;
    }

    @GetMapping("/pojistenci/detail")
    public String showPojistenciDetail(Model model){
        List<PojistenciDTO> pojistenci = pojistenciService.getAll();
        model.addAttribute("pojistenci", pojistenci);
        return "pages/pojistenci/detail.html";
    }


    @GetMapping({"/pojistenci/new"})
    public String createPojistenec(@Valid @ModelAttribute PojistenciDTO pojistenciDTO, BindingResult result, RedirectAttributes redirectAttributes){
        pojistenciService.create(pojistenciDTO);
        redirectAttributes.addFlashAttribute("success", "Pojištěnec přidán.");
        return "pages/pojistenci/new.html";
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("edit/{pojistenci_id}")
    public String editDetail(@PathVariable long pojistenci_id, @Valid PojistenciDTO pojistenciDTO, BindingResult result, RedirectAttributes redirectAttributes){
        pojistenciDTO.setPojistenci_id(pojistenci_id);
        pojistenciService.edit(pojistenciDTO);
        redirectAttributes.addFlashAttribute("success", "Údaje o pojištěnci byly upraveny.");
        return "redirect:/pojistenci";
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/delete/{pojistenci_id}")
    public  String removePojistenci(@PathVariable Long pojistenci_id, RedirectAttributes redirectAttributes){
        pojistenciService.remove(pojistenci_id);
        redirectAttributes.addFlashAttribute("success", "Vozidlo smazáno");
        return  "redirect:/pojistenci";
    }

    @ExceptionHandler({PojistenecNotFoundException.class})
    public String handlePojistenecNotFoundException(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("error", "Pojištěnec nenalezen");
        return "redirect:/pojistenci";
    }

}
