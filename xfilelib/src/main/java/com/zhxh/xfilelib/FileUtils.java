package com.zhxh.xfilelib;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static List<String> showFile(String path) {

        List<String> resultList = new ArrayList<>();

        File fileDirectory = new File(path);

        File[] fileList = fileDirectory.listFiles();

        for (int i = 0; i < fileList.length; i++) {

            File file = fileList[i];

            if (!file.isDirectory()) {
                String fileName = file.getName();
                resultList.add(fileName);
            }
        }

        return resultList;
    }

}
