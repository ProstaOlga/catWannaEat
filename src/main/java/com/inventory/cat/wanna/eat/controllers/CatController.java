package com.inventory.cat.wanna.eat.controllers;

import com.inventory.cat.wanna.eat.service.api.CatService;
import com.inventory.cat.wanna.eat.dto.CatDTO;
import com.inventory.cat.wanna.eat.models.Cat;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cat")
public class CatController {
    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping()
    public HttpEntity<List<CatDTO>> view(){
        return new HttpEntity<>(catService.getCats());
    }


    @GetMapping("/{id}")
    public HttpEntity<CatDTO> view(@PathVariable long id){
        return new HttpEntity<>(catService.getCatById(id));
    }

    @PutMapping()
    public void create(@RequestBody CatDTO cat){
        catService.createCat(cat);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        catService.removeCat(id);
    }
}
