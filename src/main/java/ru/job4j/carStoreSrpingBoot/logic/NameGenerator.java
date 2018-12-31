package ru.job4j.carStoreSrpingBoot.logic;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.job4j.carStoreSrpingBoot.model.CarPic;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class generate name for picture
 */
public class NameGenerator {

    public static String generateName() {
        Long random = Math.abs(new Random().nextLong());
        return random.toString();
    }


}