package ru.job4j.carStoreSrpingBoot.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.carStoreSrpingBoot.model.User;
import ru.job4j.carStoreSrpingBoot.repo.CarRepo;
import java.util.HashMap;


/**
 * This main and blank controller  gets user and send to the front-end side initial data
 */
@CrossOrigin
@Controller
@RequestMapping("/")
public class MainController {

    private final CarRepo carRepo;

    public MainController(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user) {
        HashMap<Object, Object> data = new HashMap<>();
        data.put("profile",user);
        data.put("cars", carRepo.findAll());
        model.addAttribute("frontendData", data);
        return "index";
    }
}
