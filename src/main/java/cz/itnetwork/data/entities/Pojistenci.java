package cz.itnetwork.data.entities;

import jakarta.persistence.*;



@Entity
public class Pojistenci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pojistenci_id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 30)
    private String lastName;
    @Column(nullable = false, length = 30)
    private String town;
    @Column(nullable = false, length = 9)
    private String telefon;
    @Column(nullable = false, length = 8)
    private String PSC;
    @Column(nullable = false, length = 60)
    private String address;
    @Column(nullable = false, length = 20)
    private String birthday;

    @Column(nullable = false)
    private boolean isDeleted;


    //region: getters and setters
    public String getTelefon(){
        return telefon;
    }

    public void setTelefon(String telefon){
        this.telefon = telefon;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
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
