package com.my.db;

import org.springframework.data.repository.Repository;

/**
 * Created by isuru on 6/29/2016.
 */
public interface PetDataRepository extends Repository<PetData, Long> {
    PetData save(PetData petData);
}
