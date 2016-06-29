package com.my.db;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by isuru on 6/29/2016.
 */
public interface PetDataRepository extends CrudRepository<PetData, Long> {
    PetData save(PetData petData);

    PetData findOne(Long aLong);

    void delete(Long aLong);
}
