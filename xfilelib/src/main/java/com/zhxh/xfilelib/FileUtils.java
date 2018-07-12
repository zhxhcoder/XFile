package com.zhxh.xfilelib;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {

    public static List<String> getMatchFiles(String dirPath) {
        return getMatchFiles(dirPath, null);
    }

    public static List<String> getMatchFiles(String dirPath, String regRex) {
        return getMatchFiles(null, false, dirPath, regRex);
    }

    /**
     * 输出顺序是从树最深层遍历 深度优先 逆序
     *
     * @param resultList 输出位置
     * @param isNest     是否嵌套
     * @param dirPath    目录位置
     * @param regRex     匹配的正则
     * @return 能匹配的文件名
     */
    public static List<String> getMatchFiles(List<String> resultList, boolean isNest, String dirPath, String regRex) {
        if (resultList == null) {
            resultList = new ArrayList<>();
        }
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
            } else {
                if (isNest) {
                    getMatchFiles(resultList, true, file.getAbsolutePath(), regRex);
                }
            }
        }
        return resultList;
    }


}
