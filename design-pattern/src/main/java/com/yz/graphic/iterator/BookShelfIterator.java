package com.yz.graphic.iterator;

/**
 * @author hjj
 * @create 2022/09/21/23:47
 */
public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;

    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = bookShelf.getLength() - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public Object next() {
        Book curBook = bookShelf.getBookAt(index);
        index--;
        return curBook;
    }
}
