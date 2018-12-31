package ru.job4j.carStoreSrpingBoot.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.job4j.carStoreSrpingBoot.model.Adv;
import ru.job4j.carStoreSrpingBoot.repo.AdvRepo;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("adv")
public class AdvController {

    private final AdvRepo advRepo;

    @Autowired
    public AdvController(AdvRepo advRepo) {
        this.advRepo = advRepo;
    }
    @GetMapping
    public List<Adv> list() {
        return advRepo.findAll();
    }

    @GetMapping("{id}")
    public Adv getOne(@PathVariable("id") Adv adv) {
        return adv;
    }

    @PostMapping
    public Adv create(@RequestBody Adv adv) {
        adv.setCreationDate(LocalDateTime.now());
        return advRepo.save(adv);
    }
    @PutMapping
    public Adv update(@PathVariable("id") Adv advFromDb, @RequestBody Adv adv) {
        BeanUtils.copyProperties(adv, advFromDb, "id");
        return advRepo.save(advFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Adv adv) {
        advRepo.delete(adv);
    }


}
