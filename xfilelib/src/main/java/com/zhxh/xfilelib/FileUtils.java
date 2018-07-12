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
                    getMatchFiles(resultList, isNest, file.getAbsolutePath(), regRex);
                }
            }
        }
        return resultList;
    }

    /**
     * 重命名匹配的文件
     *
     * @param isNest  是否嵌套
     * @param dirPath 目录位置
     * @param regRex  匹配的正则
     * @param replace 替换的字符串
     * @return 能匹配的文件名
     */
    public static void renameMatchFiles(boolean isNest, String dirPath, String regRex, String replace) {

        File fileDirectory = new File(dirPath);
        File[] fileList = fileDirectory.listFiles();
        if (fileList == null) {
            return;
        }
        for (File file : fileList) {
            if (!file.isDirectory()) {
                String fileName = file.getName();
                if (null == regRex || regRex.length() == 0) {
                    return;
                } else {
                    Pattern pattern = Pattern.compile(regRex);
                    Matcher matcher = pattern.matcher(fileName);
                    if (matcher.find()) {
                        if (file.renameTo(new File(file.getParent() + "\\" + fileName.replaceAll(regRex, replace)))) {
                            //重命名成功
                        }
                    }
                }
            } else {
                if (isNest) {
                    renameMatchFiles(true, file.getAbsolutePath(), regRex, replace);
                }
            }
        }
    }

    public static void renameMatchFiles(String dirPath, String regRex, String replace) {
        renameMatchFiles(false, dirPath, regRex, replace);
    }

    /**
     * 删除匹配的文件
     *
     * @param isNest  是否嵌套
     * @param dirPath 目录位置
     * @param regRex  匹配的正则
     * @return 能匹配的文件名
     */
    public static void deleteMatchFiles(boolean isNest, String dirPath, String regRex) {

        File fileDirectory = new File(dirPath);
        File[] fileList = fileDirectory.listFiles();
        if (fileList == null) {
            return;
        }
        for (File file : fileList) {
            if (!file.isDirectory()) {
                String fileName = file.getName();
                if (null == regRex || regRex.length() == 0) {
                    return;
                } else {
                    Pattern pattern = Pattern.compile(regRex);
                    Matcher matcher = pattern.matcher(fileName);
                    if (matcher.find()) {
                        if (file.delete()) {
                            //删除成功
                        }
                    }
                }
            } else {
                if (isNest) {
                    deleteMatchFiles(true, file.getAbsolutePath(), regRex);
                }
            }
        }
    }

    public static void deleteMatchFiles(String dirPath, String regRex) {
        deleteMatchFiles(false, dirPath, regRex);
    }
}
