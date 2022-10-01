package com.yz.graphic.iterator;

/**
 * @author hjj
 * @create 2022/09/21/23:55
 */
public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("圣经"));
        bookShelf.appendBook(new Book("黄金时代"));
        bookShelf.appendBook(new Book("微积分的力量"));
        bookShelf.appendBook(new Book("图解设计模式"));

        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next.toString());
        }
    }
}
