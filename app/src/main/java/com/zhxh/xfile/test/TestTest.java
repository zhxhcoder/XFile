package com.zhxh.xfile.test;

import com.zhxh.xfilelib.FileUtils;

/**
 * Created by zhxh on 2018/7/12
 */
public class TestTest {

    private static final String dirPath = "D:\\________________testDir";
    private static final String dirPath1 = "D:\\________________testDir1";

    public static void main(String[] args) {

        System.out.println("***************************************************************");

        for (String name : FileUtils.getMatchFiles(dirPath,"\\.\\.")) {
            System.out.println(name);
        }

        System.out.println("***************************************************************");

        for (String name : FileUtils.getMatchFiles(dirPath, "")) {
            System.out.println(name);
        }
        System.out.println("***************************************************************");

        for (String name : FileUtils.getMatchFiles(null,true,dirPath, "txt")) {
            System.out.println(name);
        }
    }

}
