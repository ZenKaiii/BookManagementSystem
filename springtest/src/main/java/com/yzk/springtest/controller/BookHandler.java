package com.yzk.springtest.controller;

import com.yzk.springtest.entity.Book;
import com.yzk.springtest.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/findAll/{page}/{size}")
    public List<Book> findAll(@PathVariable Integer page, @PathVariable Integer size){
        return bookMapper.findByPage((page-1)*size,size);
    }
    @GetMapping("/getPage/{size}")
    public Integer getPage(@PathVariable Integer size){
        return (int)Math.ceil((double)bookMapper.getTotalAmount()/size);
    }
    @PostMapping("/save")
    public String save(@RequestBody Book book){
        Integer result = bookMapper.saveBook(bookMapper.getAvailableID(),book.getName(),book.getAuthor());
        if (result != 0){
            return "success";
        } else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Book findByid(@PathVariable("id") Integer id){
        return bookMapper.findById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Integer result = bookMapper.updateBook(book.getId(),book.getName(),book.getAuthor());
        if (result != 0){
            return "success";
        } else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable Integer id) {
        bookMapper.deleteBook(id);
    }
}
