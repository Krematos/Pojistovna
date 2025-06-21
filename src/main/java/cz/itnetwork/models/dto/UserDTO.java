package cz.itnetwork.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



public class UserDTO {
    @Email(message = "Vyplňte validní email")
    @NotBlank(message = "Vyplňtě uživatelský email")
    @NotNull(message = "Vyplňtě")
    private String email;

    @NotBlank(message = "Vyplňte uživatelské heslo")
    @Size(min = 8, message = "Heslo musí mít aspoň 8 znaků")
    @NotNull(message = "Vyplňtě")
    private String password;

    @NotBlank(message = "Vyplňte uživatelské heslo")
    @Size(min = 8, message = "Heslo musí mít aspoň 8 znaků")
    @NotNull(message = "Vyplňtě")
    private String confirmPassword;

    //region: getters and setters
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = this.password;
    }

    public String getConfirmPassword(){
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    //endregion
}
