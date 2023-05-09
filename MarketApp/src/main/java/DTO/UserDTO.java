/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author 이영근
 */
public class UserDTO {

    private String ID;
    private String PW;
    private String Name;
    private String Phone;

    public UserDTO(String id, String pw, String name, String phone) {
        this.ID = id;
        this.PW = pw;
        this.Name = name;
        this.Phone = phone;
    }

    public String getID() {
        return ID;
    }

    public String getPW() {
        return PW;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }
    
    public void setID(String iD) {
        this.ID = iD;
    }

    public void setPW(String pW) {
        this.PW = pW;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "ID : " + ID + " PW : " + PW + " Name : " + Name;
    }
}
