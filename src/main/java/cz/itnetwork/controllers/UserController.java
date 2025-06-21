package cz.itnetwork.controllers;

import jakarta.validation.Valid;
import cz.itnetwork.models.dto.UserDTO;
import cz.itnetwork.models.exceptions.DuplicateEmailException;
import cz.itnetwork.models.exceptions.PasswordDoNotEqualException;
import cz.itnetwork.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String renderLogin(){
        return "/pages/user/login.html";
    }

    @GetMapping("/register")
    public String renderRegister(@ModelAttribute UserDTO userDTO){
        return "/pages/user/register.html";
    }

    @GetMapping("/logout")
    public String renderLogout(){
        return "/pages/user/login.html";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute UserDTO userDTO, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors())
            return renderRegister(userDTO);
        try{
            userService.create(userDTO, false);
        } catch (DuplicateEmailException e){
            result.rejectValue("email", "error", "Email již je používán.");
            return "/pages/user/register";
        } catch (PasswordDoNotEqualException e){
            result.rejectValue("password", "error", "Hesla se nerovnají.");
            result.rejectValue("confirmPassword", "error", "Heslo se nerovnají.");
            return "/pages/user/register";
        }
        redirectAttributes.addFlashAttribute("success", "Uživatel zaregistrován.");
        return "redirect:/user/login";
    }


}
