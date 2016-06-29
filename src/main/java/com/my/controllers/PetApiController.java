package com.my.controllers;

import com.my.api.Pet;
import com.my.db.PetData;
import com.my.db.PetDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Created by isuru on 6/29/2016.
 */
@Controller
@Component
@RequestMapping(path = "/pets")
public class PetApiController {

    private final PetDataRepository petDataRepository;

    @Autowired
    public PetApiController(PetDataRepository petDataRepository) {
        this.petDataRepository = petDataRepository;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST, path = "/")
    @ResponseBody
    public Pet savePet(@RequestBody Pet pet) {
        PetData petData = new PetData();
        petData.setName(pet.getName());
        petData.setType(pet.getType());
        petData.setBreed(pet.getBreed());
        petData.setStatus(pet.getStatus());

        petDataRepository.save(petData);

        return pet;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.PUT, path = "/")
    @ResponseBody
    public Pet updatePet(@RequestBody Pet pet) {
        PetData petData = new PetData();
        petData.setId(pet.getId());
        petData.setName(pet.getName());
        petData.setType(pet.getType());
        petData.setBreed(pet.getBreed());
        petData.setStatus(pet.getStatus());

        petDataRepository.save(petData);

        return pet;
    }

    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
    public Pet getById(@PathVariable("id") String id) {
        PetData petData = petDataRepository.getById(Long.valueOf(id));

        Pet pet = new Pet();
        pet.setStatus(petData.getStatus());
        pet.setBreed(petData.getBreed());
        pet.setType(petData.getType());
        pet.setId(petData.getId());
        pet.setName(petData.getName());

        return pet;
    }
}
