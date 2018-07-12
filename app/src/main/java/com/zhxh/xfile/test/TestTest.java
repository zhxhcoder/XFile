package com.zhxh.xfile.test;

import com.zhxh.xfilelib.FileUtils;

/**
 * Created by zhxh on 2018/7/12
 */
public class TestTest {

    private static final String dirPath = "D:\\________________testDir";

    public static void main(String[] args) {

        System.out.println("***************************************************************");

        for (String name : FileUtils.getMatchFiles(dirPath, "\\.\\.")) {
            System.out.println(name);
        }

        System.out.println("***************************************************************");

        for (String name : FileUtils.getMatchFiles(dirPath, "")) {
            System.out.println(name);
        }
        System.out.println("***************************************************************");

        for (String name : FileUtils.getMatchFiles(null, true, dirPath, "")) {
            System.out.println(name);
        }

        System.out.println("*******************************改变名字********************************");
        for (String name : FileUtils.getMatchFiles(null, true, dirPath, "\\.txt$")) {
            System.out.println("before " + name);
        }
        //FileUtils.renameMatchFiles(true,dirPath, "\\.\\.txt$","._.txt");
        for (String name : FileUtils.getMatchFiles(null, true, dirPath, "\\.txt$")) {
            System.out.println("after " + name);
        }
        System.out.println("*******************************删除文件********************************");
        for (String name : FileUtils.getMatchFiles(null, true, dirPath, "text21")) {
            System.out.println("before " + name);
        }
        FileUtils.deleteMatchFiles(true,dirPath, "text21");
        for (String name : FileUtils.getMatchFiles(null, true, dirPath, "text21")) {
            System.out.println("after " + name);
        }
    }

}
