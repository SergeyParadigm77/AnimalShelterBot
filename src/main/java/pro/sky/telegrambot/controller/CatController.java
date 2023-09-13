package pro.sky.telegrambot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.telegrambot.model.Cat;
import pro.sky.telegrambot.service.CatService;

@RestController
@RequestMapping("/animal-shelter/cat")
public class CatController {
    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Cat> getCat(@PathVariable long id) {
        Cat cat = catService.getCat(id);
        if (cat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cat);
    }
    @PostMapping
    public Cat createCat(@RequestBody Cat cat) {
        return catService.createCat(cat);
    }
}
