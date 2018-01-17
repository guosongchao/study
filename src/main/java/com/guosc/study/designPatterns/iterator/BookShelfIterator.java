package com.guosc.study.designPatterns.iterator;

/**
 * Created by DOOM on 2017/12/19.
 */
public class BookShelfIterator implements Iterator{
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf){
        this.bookShelf = bookShelf;
        index = 0;
    }


    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    public Book next() {
        return bookShelf.getBookAt(index++);
    }
}
