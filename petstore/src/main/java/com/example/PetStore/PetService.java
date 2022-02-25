package com.example.PetStore;

import com.example.PetStore.Model.Pet;
import com.example.PetStore.Model.Response;
import com.example.PetStore.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private static PetRepository petRepository;

    @Autowired
    public  PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Response addNewPet(Pet pet) {
        Response response;
        if(pet.getName() == null && pet.getPhotoUrls() ==null){
            response = new Response(400,"GET","Invalid Input");
            return response;
        }
        petRepository.save(pet);
        response = new Response(201,"GET","Sucessfully Created");
        return response;

    }

    public Response deletePet(String id) {
        Response response ;
        int petId = 0;
        try{
            petId = Integer.parseInt(id) ;

        }
        catch(Exception e){
            response = new Response(400,"DELETE","Invalid ID supplied");
            return response;
        }
        Optional<Pet> pet = petRepository.findById(petId);
        if(petId<=0){
            response = new Response(400,"DELETE","Invalid ID supplied");
            return response;
        }
        if(petRepository.existsById(petId)){
            response = new Response(200,"DELETE","Sucessfully Deleted");
            petRepository.deleteById(petId);
            return response;
        }
        else{
            response = new Response(404,"DELETE","Pet not Found");
            return response;

        }

    }

    public Response findPet(String id) {
        Response response ;
        int petId = 0;
        try{
            petId = Integer.parseInt(id) ;

      }
      catch(Exception e){
          response = new Response(400,"GET","Invalid ID supplied");
          return response;
      }
      Optional<Pet> pet = petRepository.findById(petId);

        if(pet.isPresent()){
            response = new Response(200,"GET","Sucessfully Collected");
            response.setPet(pet.get());
            return response;
        }
        else{
            response = new Response(404,"GET","Pet not Found");
            return response;

        }

    }



    public Response getAllPet() {
        List<Pet> pets = new ArrayList<Pet>();
        Response response;
       try{
           pets =petRepository.findAll();
       }
       catch(Exception e){
           response = new Response(400,"GET","Invalid Syntax");
           return response;
       }
       response = new Response(200,"GET","Sucessfully Collected");
       response.setPets(pets);
       return response;

    }
@Transactional
    public Response updatePet(Pet pet) {
        Response response;
        if(pet.getId()<=0){
            response= new Response(400, "PUT", "Invalid ID supplied");
            return response;
        }
        if(pet.getName()==null || pet.getPhotoUrls()== null){
            response= new Response(405, "PUT", "Validation exception");
            return response;
        }
        Optional<Pet> petDemo = petRepository.findById(pet.getId());

        if(petDemo.isPresent()){
            response = new Response(200,"PUT","Sucessfully Updated ");
            petRepository.save(pet);
            return response;
        }
        else{
            response = new Response(404,"PUT","Pet not Found");
            return response;

        }


    }
}
