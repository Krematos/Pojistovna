package cz.itnetwork.controllers;

import cz.itnetwork.models.dto.PojistenciDTO;
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
@RequestMapping("/pojistenci")
public class PojistenciController {

    @Autowired
    private PojistenciService pojistenciService;

    @GetMapping
    public String listPojistenci(Model model) {
        List<PojistenciDTO> pojistenci = pojistenciService.getAll();
        model.addAttribute("pojistenci", pojistenci);
        return "pages/pojistenci/index";
    }

    @GetMapping("/{pojistenci_id}")
    public String showPojistenec(@PathVariable long pojistenci_id, Model model) {
        PojistenciDTO pojistenec = pojistenciService.getById(pojistenci_id);
        model.addAttribute("pojistenec", pojistenec);
        return "pages/pojistenci/detail";
    }

    @GetMapping("/new")
    public String renderNewPojistenecForm(@ModelAttribute("pojistenciDTO") PojistenciDTO pojistenciDTO) {
        return "pages/pojistenci/new";
    }

    @PostMapping("/new")
    public String createPojistenec(@Valid @ModelAttribute("pojistenciDTO") PojistenciDTO pojistenciDTO, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "pages/pojistenci/new";
        }
        pojistenciService.create(pojistenciDTO);
        redirectAttributes.addFlashAttribute("success", "Pojištěnec úspěšně přidán.");
        return "redirect:/pojistenci";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/edit/{pojistenci_id}")
    public String renderEditForm(@PathVariable long pojistenci_id, Model model) {
        PojistenciDTO pojistenec = pojistenciService.getById(pojistenci_id);
        model.addAttribute("pojistenec", pojistenec);
        return "pages/pojistenci/edit";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/edit/{pojistenci_id}")
    public String updatePojistenec(@PathVariable long pojistenci_id, @Valid @ModelAttribute("pojistenec") PojistenciDTO pojistenciDTO, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "pages/pojistenci/edit";
        }
        pojistenciDTO.setPojistenci_id(pojistenci_id);
        pojistenciService.edit(pojistenciDTO);
        redirectAttributes.addFlashAttribute("success", "Údaje o pojištěnci byly upraveny.");
        return "redirect:/pojistenci";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/delete/{pojistenci_id}")
    public String removePojistenec(@PathVariable Long pojistenci_id, RedirectAttributes redirectAttributes) {
        pojistenciService.remove(pojistenci_id);
        redirectAttributes.addFlashAttribute("success", "Pojištěnec byl smazán.");
        return "redirect:/pojistenci";
    }

    @ExceptionHandler({PojistenecNotFoundException.class})
    public String handlePojistenecNotFoundException(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "Pojištěnec nenalezen.");
        return "redirect:/pojistenci";
    }
}
