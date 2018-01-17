package com.guosc.study.designPatterns.iterator;

/**
 * Created by DOOM on 2017/12/19.
 */
public class BookShelf implements Aggregate {
    private Book[] books;
    private int last;

    public BookShelf(int maxSize){
        books = new Book[maxSize];
        last = 0;
    }

    public Book getBookAt(int index){
        return books[index];
    }

    public void appendBook(Book book){
        books[last++] = book;
    }

    public int getLength(){
        return last;
    }

    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
