package com.api.book.restapibook.Controllers;


import org.springframework.web.bind.annotation.RestController;

import com.api.book.restapibook.Entites.Book;
import com.api.book.restapibook.Services.Bookservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class Bookcontroller {
    
    @Autowired
    private Bookservice bookService;

     // Get all book handler or Method
    @GetMapping("/books")
    public List<Book> getbooks()
    {
        //  Book book = new Book();
        //  book.setId("6543546");
        //  book.setAuthor("JK Rowling");
        //  book.setTitle("Harry Potter and the Sorcerer's Stone");
        //  return book;
        return bookService.getAllBook();

    }
    
    // get single book handler or method
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id)
  
    {
        return bookService.getBookById(id);

    }

    // created a book in  database using post request
    @PostMapping("/books")
    public  Book addBook(@RequestBody Book book)
    {
              Book b = bookService.addBook(book);
              System.out.println(b);
              return b;
                 
    }

    // delete books
    
    @DeleteMapping("/books/{id}")
    //@PathVariable used to bind wth  url sgment with java variable
    public void deleteBook(@PathVariable("id") int id){

               bookService.deleBook(id);
    }
     
    // update books
    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable("id") int id, @RequestBody Book book)
    {    
        
        bookService.updateBook(id ,book);
        return book;

    }

}
