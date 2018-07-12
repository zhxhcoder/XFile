package com.zhxh.xfilelib;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {

    public static List<String> getFilesFromDir(String dirPath) {
        return getFilesFromDir(dirPath, null);
    }

    public static List<String> getFilesFromDir(String dirPath, String regRex) {
        List<String> resultList = new ArrayList<>();
        File fileDirectory = new File(dirPath);
        File[] fileList = fileDirectory.listFiles();
        if (fileList == null) {
            return resultList;
        }
        for (File file : fileList) {
            if (!file.isDirectory()) {
                String fileName = file.getName();
                if (null == regRex || regRex.length() == 0) {
                    resultList.add(fileName);
                } else {
                    Pattern pattern = Pattern.compile(regRex);
                    Matcher matcher = pattern.matcher(fileName);
                    if (matcher.find()) {
                        resultList.add(fileName);
                    }
                }
            }
        }
        return resultList;
    }
}
