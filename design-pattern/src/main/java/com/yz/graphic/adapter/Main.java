package com.yz.graphic.adapter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author hjj
 * @create 2022/10/01/23:07
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FileIO fileIO = new FileProperties();
        fileIO.readFromFile("D:\\gitRepo\\Test\\gameConfig.txt");
        String name = fileIO.getValue("name");
        String age = fileIO.getValue("age");
        System.out.println(String.format("age: %s,name %s", age, name));
        fileIO.setValue("desc", "一个益智游戏");
        fileIO.writeToFile("D:\\gitRepo\\Test\\gameConfig2.txt");
    }
}
