package com.zhxh.xfilelib;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {

    public static List<String> getFilesFromDir(String path) {

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

    public static List<String> getFilesFromDir(String path, String regRex) {

        List<String> resultList = new ArrayList<>();

        File fileDirectory = new File(path);

        File[] fileList = fileDirectory.listFiles();

        for (int i = 0; i < fileList.length; i++) {

            File file = fileList[i];

            if (!file.isDirectory()) {

                String fileName = file.getName();

                Pattern pattern = Pattern.compile(regRex);
                Matcher matcher = pattern.matcher(fileName);

                if (matcher.find()) {
                    resultList.add(fileName);
                }
            }
        }
        return resultList;
    }

}
