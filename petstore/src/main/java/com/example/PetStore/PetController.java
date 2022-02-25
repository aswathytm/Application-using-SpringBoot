package com.example.PetStore;
import com.example.PetStore.Model.Pet;
import com.example.PetStore.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "petstore/pet")
public class PetController {
    private PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Response getPet(){

        return petService.getAllPet();
    }


    @PostMapping
    public Response petRegister(@RequestBody Pet pet) {

        return petService.addNewPet(pet);
    }


    @DeleteMapping(path="{id}")
    public Response deletePet(@PathVariable ("id") String id){
        return petService.deletePet(id);

    }

    @PutMapping
    public Response updatePet(@RequestBody Pet pet){
        return petService.updatePet(pet);
    }

    @GetMapping(path="{id}")
    public Response FindPet(@PathVariable ("id") String id){
        return petService.findPet(id);

    }

}