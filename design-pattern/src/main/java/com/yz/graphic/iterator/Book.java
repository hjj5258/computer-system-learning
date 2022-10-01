package com.yz.graphic.iterator;

/**
 * @author hjj
 * @create 2022/09/21/23:47
 */
public class Book {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
