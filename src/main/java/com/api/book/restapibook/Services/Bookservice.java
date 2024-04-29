package com.api.book.restapibook.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.restapibook.Entites.Book;

@Component
public class Bookservice {

   private static List<Book> list = new ArrayList<>();
     
  static
  {
    list.add(new Book(10111,  "English", "William"));
    list.add(new Book(105411, "Physics", "HC Verma"));
    list.add(new Book(102421, "Math", "RD SHARMA"));
    list.add(new Book(104541, "Hindi", "Premchand"));
  }
    
    // get all book
    public List<Book> getAllBook()
    {
      
       

        return list;
    }
    
    //get single book
    public Book getBookById(int id)
    {
       Book book =null;
       book = list.stream().filter(bok->bok.getId() ==id).findFirst().get();
        
        return book;
    }

    // Adding the book
    public  Book addBook(Book book)
    {
        list.add(book);
        return book;
    }

    public void deleBook(int id)
    { 
         list.stream().filter(b->b.getId()!=id).collect(Collectors.toList() );

    }

    public void updateBook(int id, Book book) {
         
        // by using ternanry operator..
        list = list.stream().map(b1-> b1.getId()==id ? book : b1).collect(Collectors.toList());

        // list = list.stream().map(b1-> {
                             
        //                if(b1.getId()==id )
        //                {
        //                  b1.setTitle(book.getTitle());
        //                  b1.setAuthor(book.getAuthor());
        //                }   
        //                return b1;            
        //                   }).collect(Collectors.toList());

         
    }
}