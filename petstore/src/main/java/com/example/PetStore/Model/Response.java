package com.example.PetStore.Model;

import com.example.PetStore.User.Model.UserModel;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private int code;

    public Pet getPet() {
        return pet;
    }

    private Pet pet;
    private UserModel user;

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Response(UserModel user) {
        this.user = user;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    private String type;
    private String message;

    public Response(int code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public List<Pet> getPets() {
        return pets;
    }

    private List<Pet> pets;

}
