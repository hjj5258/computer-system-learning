package com.yz.graphic.adapter;

import java.io.IOException;

/**
 * @author hjj
 * @create 2022/10/01/22:59
 */
public interface FileIO {
    void readFromFile(String filename) throws IOException;

    void writeToFile(String filename) throws IOException;

    void setValue(String key, String value);

    String getValue(String key);
}
