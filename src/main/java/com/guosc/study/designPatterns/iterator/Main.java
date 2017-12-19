package com.guosc.study.designPatterns.iterator;

/**
 * Created by DOOM on 2017/12/19.
 */
public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(3);
        Book book1 = new Book("book1");
        Book book2 = new Book("book2");
        bookShelf.appendBook(book1);
        bookShelf.appendBook(book2);
        Iterator it = bookShelf.iterator();
        Book book;
        while(it.hasNext()){
            book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}
