package com.alicetin.vkicalculetion.data.repository;


import com.alicetin.vkicalculetion.data.entity.ReferenceVkiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// CrudRepository
// Creat Read Update Delete sorgular  bulunuyor.
 @Repository
//Database ile sorguların olduğu yerdir. yani Dao
//Save - findById - findAll - delete - deleteAllById - deleteAll gibi sorgular bulunuyor

public interface IReferanceVkiRepository extends CrudRepository<ReferenceVkiEntity,Long> {
     //Burada da özel durumlar yazılabilir.
} //End Interface
