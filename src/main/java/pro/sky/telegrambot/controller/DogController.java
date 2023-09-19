package pro.sky.telegrambot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.telegrambot.model.Cat;
import pro.sky.telegrambot.model.Dog;
import pro.sky.telegrambot.service.CatService;
import pro.sky.telegrambot.service.DogService;

@RestController
@RequestMapping("/animal-shelter/dog")
public class DogController {
    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Dog> getDog(@PathVariable long id) {
        Dog dog = dogService.getDog(id);
        if (dog == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dog);
    }
    @PostMapping
    public Dog createDog(@RequestBody Dog dog) {
        return dogService.createDog(dog);
    }
}
