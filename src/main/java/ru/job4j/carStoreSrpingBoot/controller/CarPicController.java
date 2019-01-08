package ru.job4j.carStoreSrpingBoot.controller;

import lombok.extern.slf4j.Slf4j;
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


/**
 * This controller will be useful in next version
 * It gets pictures and safe them both to Db and to the storage according car ID
 */
@CrossOrigin
@RestController
@RequestMapping("pic")
@Slf4j
public class CarPicController extends HttpServlet {
  private final PicRepo picRepo;
  private final FileWriter fileWriter;
  private final CarRepo carRepo;
  private final PicPathMaker pathMaker;



  @Autowired
  public CarPicController(PicRepo picRepo, CarRepo carRepo) {
    this.picRepo = picRepo;
    this.carRepo = carRepo;
    pathMaker = new PicPathMaker();
    fileWriter = new FileWriter();

  }

  @GetMapping
  public List<CarPic> list() {
    return picRepo.findAll();
  }

  @PostMapping()
  public List<String> create(@PathVariable("id") String carId, HttpServletRequest req) {

    List<CarPic> pics = fileWriter.writeCarPics(carId, req);
    for (CarPic pic : pics) {
      picRepo.save(pic); //todo can I do It from a single request to Db?
    }
    return pathMaker.getPath(req, carId, pics);
  }

  @DeleteMapping
  public void delete(@PathVariable("id") CarPic carPic) {
    picRepo.delete(carPic);
  }

}
