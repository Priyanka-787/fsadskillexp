package com.klu.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.klu.model.Book;
@RestController
@RequestMapping("/library")
public class LibraryController 
{

    private List<Book> bookList = new ArrayList<>();

    // task1
    @GetMapping("/welcome")
    public String welcome() 
    {
        return "Welcome to the Library Application";
    }

    // task2
    @GetMapping("/count")
    public int totalBooks() 
    {
        return 100;
    }

    // task3
    @GetMapping("/price")
    public double samplePrice() 
    {
        return 499.99;
    }

    // task4
    @GetMapping("/books")
    public List<String> getBookTitles() 
    {
        return Arrays.asList("Java Basics", "Spring Boot Guide", "Microservices");
    }

    // task5
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) 
    {
        return new Book(id, "Sample Book", "venky", 299.99);
    }

    // task6
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) 
    {
        return "Searching for book with title: " + title;
    }

    // task7
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) 
    {
        return "Books written by author: " + name;
    }

    // task8
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) 
    {
        bookList.add(book);
        return "Book added successfully";
    }

    // task9
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() 
    {
        return bookList;
    }
}