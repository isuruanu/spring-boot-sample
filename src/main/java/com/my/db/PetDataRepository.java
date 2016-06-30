package com.my.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by isuru on 6/29/2016.
 */
public interface PetDataRepository extends CrudRepository<PetData, Long> {
    PetData save(PetData petData);

    PetData findOne(Long aLong);

    void delete(Long aLong);

    @Query("select p  from PetData p where p.status = :status")
    List<PetData> findByStatus(@Param("status") String status);
}
