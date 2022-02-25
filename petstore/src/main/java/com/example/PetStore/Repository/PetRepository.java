package com.example.PetStore.Repository;

import com.example.PetStore.Model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet,Integer> {
}
