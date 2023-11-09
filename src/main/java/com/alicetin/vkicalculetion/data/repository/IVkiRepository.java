package com.alicetin.vkicalculetion.data.repository;


import com.alicetin.vkicalculetion.data.entity.UserVkiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// CrudRepository
// Creat Read Update Delete sorgular  bulunuyor.
 @Repository
//Database ile sorguların olduğu yerdir. yani Dao
//Save - findById - findAll - delete - deleteAllById - deleteAll gibi sorgular bulunuyor

public interface IVkiRepository extends CrudRepository<UserVkiEntity,Long> {
     //Burada da özel durumlar yazılabilir.
     Iterable<UserVkiEntity> findByuName(String u_name);

} //End Interface
