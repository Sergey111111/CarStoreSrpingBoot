package ru.job4j.carStoreSrpingBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.job4j.carStoreSrpingBoot.logic.FileWriter;
import ru.job4j.carStoreSrpingBoot.logic.PicPathMaker;
import ru.job4j.carStoreSrpingBoot.model.CarPic;
import ru.job4j.carStoreSrpingBoot.repo.CarRepo;
import ru.job4j.carStoreSrpingBoot.repo.PicRepo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("pic/")
public class CarPicController extends HttpServlet {
     private final PicRepo picRepo;
     private final FileWriter fileWriter;
     private final CarRepo carRepo;
     private final PicPathMaker pathMaker;

    @Autowired //Is this annotation deprecated?
    public CarPicController(PicRepo picRepo, CarRepo carRepo) {
        this.picRepo = picRepo;
        this.carRepo = carRepo;
        pathMaker = new PicPathMaker();
        fileWriter = new FileWriter(); //Is it has to be a singleton?
    }
    @GetMapping
    public List<CarPic>  list(){
        return picRepo.findAll();
    }
    //Todo get list of pics by car Id
//    @GetMapping("{carId}")
//    public List<String> list(@PathVariable("carId") Long carId, HttpServletRequest req) {
//        List<CarPic> pics = picRepo.findByCarId(carId).get();
//
//        return pathMaker.getPath(req, String.valueOf(carId), pics);
//    }

    @PostMapping({"carId"})
    public List<String> create(@PathVariable("carId") String carId, HttpServletRequest req) {
        List<CarPic> pics = fileWriter.writeCarPics(carId, req);
        for (CarPic pic: pics) {
            picRepo.save(pic); //todo can I do It from a single request to Db?
        }
     return pathMaker.getPath(req, carId, pics);
    }
    @DeleteMapping
    public void delete(@PathVariable("id") CarPic carPic) {
        picRepo.delete(carPic);
    }

}
