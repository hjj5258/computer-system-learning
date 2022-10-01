package com.yz.graphic.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hjj
 * @create 2022/09/21/23:47
 */
public class BookShelf implements Aggregate {
    /**
     * 容器，存放书籍
     */
    private List<Book> books;

    public BookShelf() {
        this.books = new ArrayList<>();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public int getLength() {
        return books.size();
    }

    /**
     * 添加书籍
     *
     * @param book
     */
    public void appendBook(Book book) {
        books.add(book);
    }
}
