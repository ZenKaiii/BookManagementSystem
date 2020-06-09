package com.yzk.springtest.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void findAll(){
//        System.out.println(bookMapper.findAll());
//        System.out.println(bookMapper.findById(1));
        System.out.println(3/2);
    }
}