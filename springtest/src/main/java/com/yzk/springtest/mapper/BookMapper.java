package com.yzk.springtest.mapper;

import com.yzk.springtest.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("select * from book")
    public List<Book> findAll();

    @Select("select * from book limit #{start},#{end}")
    public List<Book> findByPage(Integer start, Integer end);

    @Select("select * from book where id = #{id}")
    public Book findById(Integer id);

    @Select("select count(*) from book")
    public Integer getTotalAmount();

    @Select("select max(id)+1 from book")
    public Integer getAvailableID();

    @Insert("insert into book values(#{id},#{name},#{author})")
    public Integer saveBook(Integer id, String name, String author);

    @Update("update book set name=#{name},author=#{author} where id = #{id}")
    public Integer updateBook(Integer id, String name, String author);

    @Delete("delete from book where id = #{id}")
    public Integer deleteBook(Integer id);

}
