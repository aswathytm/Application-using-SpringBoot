package com.example.PetStore.Repository;


import com.example.PetStore.Model.PhotoUrls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoUrlsRepository extends JpaRepository<PhotoUrls,Integer> {
}
