package com.zhxh.xfilelib;

import java.io.File;

public class FileUtils {

    private static void searchFile(String path,String filename) {

        File fileDirectory = new File(path);

        File[] fileList = fileDirectory.listFiles();

        for (int j = 0; j < fileList.length; j++) {

            File file = fileList[j];

            String fileName = file.getName();

            if (fileName.contains(".apk")) {

                String tempFileName = fileName.substring(0, fileName.indexOf(".apk"));

                if (tempFileName.contains("-release")) {

                    String newFileName = filename + tempFileName.substring(tempFileName.indexOf("-") + 1, tempFileName.indexOf("-release"));

                    System.out.println(newFileName);

                    file.renameTo(new File(fileDirectory + "/" + newFileName + ".apk"));
                } else {
                    System.out.println("已经改名");
                }

            }
        }
    }

}
