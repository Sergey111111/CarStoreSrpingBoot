package ru.job4j.carStoreSrpingBoot.logic;

import ru.job4j.carStoreSrpingBoot.model.CarPic;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class PicPathMaker {
    //todo Test this with mockito
    public List<String> getPath(HttpServletRequest req, String carId, List<CarPic> pics) {
        List<String> result = new ArrayList<>();
        for(CarPic pic: pics) {
            result.add(this.getPath(req, carId, pic));
        }
        return result;
    }

    private String getPath(HttpServletRequest req, String carId, CarPic pic) {
        return String.format("%s/pics/%s/%s.jpg", req.getSession().getServletContext().getRealPath("resources"), carId, pic.getFilename());
    }
    public static String getPath(HttpServletRequest req, String carId, String filename) {
        return String.format("%s/pics/%s/%s.jpg", req.getSession().getServletContext().getRealPath("resources"), carId, filename);
    }

}
