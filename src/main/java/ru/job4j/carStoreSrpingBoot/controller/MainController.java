package ru.job4j.carStoreSrpingBoot.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.carStoreSrpingBoot.model.User;
import ru.job4j.carStoreSrpingBoot.repo.AdvRepo;

import java.util.HashMap;
@CrossOrigin
@Controller
@RequestMapping("/")
public class MainController {

    private final AdvRepo advRepo;

    public MainController(AdvRepo advRepo) {
        this.advRepo = advRepo;
    }

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user) {
        HashMap<Object, Object> data = new HashMap<>();
        data.put("profile",user);
        data.put("advs", advRepo.findAll());
        model.addAttribute("frontendData", data);
        return "index";
    }
}
