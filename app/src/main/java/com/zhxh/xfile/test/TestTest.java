package com.zhxh.xfile.test;

import com.zhxh.xfilelib.FileUtils;

/**
 * Created by zhxh on 2018/7/12
 */
public class TestTest {

    private static final String dirPath = "D:\\________________testDir";

    public static void main(String[] args) {

        System.out.println("***************************************************************");

        for (String name : FileUtils.getFilesFromDir(dirPath)) {
            System.out.println(name);
        }

        System.out.println("***************************************************************");

        for (String name : FileUtils.getFilesFromDir(dirPath, "")) {
            System.out.println(name);
        }
    }

}
