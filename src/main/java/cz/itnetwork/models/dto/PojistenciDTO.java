package cz.itnetwork.models.dto;

import jakarta.validation.constraints.NotBlank;



public class PojistenciDTO {
    private long pojistenci_id;
    @NotBlank(message = "Zadejte telefon")
    private String telefon;
    @NotBlank(message = "Zadejte jméno")
    private String Name;
    @NotBlank(message = "Zadejte příjmení")
    private String lastName;
    @NotBlank(message = "Zadejte datum narození")
    private String birthday;
    @NotBlank(message = "Zadejte město")
    private String town;
    @NotBlank(message = "Zadejte PSC")
    private String PSC;
    @NotBlank(message = "Zadejte adresu")
    private String address;

    private boolean isDeleted = false;

    //region: getters and setters

    public long getPojistenci_id(){
        return pojistenci_id;
    }

    public void setPojistenci_id(long pojistenci_id){
        this.pojistenci_id = pojistenci_id;
    }
    public String getTelefon(){
        return telefon;
    }

    public void setTelefon(String telefon){
        this.telefon = telefon;
    }

    public String getName(){
        return Name;
    }

    public void setName(String name){
        this.Name = name;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getTown(){
        return town;
    }

    public void setTown(String town){
        this.town = town;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public String getPsc(){
        return PSC;
    }

    public void setPsc(String psc){
        this.PSC = psc;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public boolean isDeleted(){
        return isDeleted;
    }

    public void setDeleted(boolean deleted){
        isDeleted = deleted;
    }
    // endregion
}
