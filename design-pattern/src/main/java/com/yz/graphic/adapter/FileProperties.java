package com.yz.graphic.adapter;

import java.io.*;
import java.util.Properties;

/**
 * @author hjj
 * @create 2022/10/01/23:01
 */
public class FileProperties extends Properties implements FileIO {
    @Override
    public void readFromFile(String filename) throws IOException {
        super.load(new InputStreamReader(new FileInputStream(filename), "utf-8"));
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        super.store(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"), "");
    }

    @Override
    public void setValue(String key, String value) {
        super.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return super.getProperty(key);
    }
}
