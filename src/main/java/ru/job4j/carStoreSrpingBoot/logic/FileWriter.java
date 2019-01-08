package ru.job4j.carStoreSrpingBoot.logic;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.job4j.carStoreSrpingBoot.model.CarPic;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
@Slf4j
public class FileWriter {

    public List<CarPic> writeCarPics( String carId, HttpServletRequest req) {
        List<CarPic> carPics = new ArrayList<>();
        try {
            List<FileItem> pics = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
            for (FileItem item : pics) {
                if (!item.isFormField()) {
                    String name = NameGenerator.generateName();
                    File file = new File(PicPathMaker.getPath(req,carId,name));
                    item.write(file);
                }
            }
        } catch (Exception e) {
            log.error("unable to write picture(s)...");
        }
        return carPics;
    }

}
