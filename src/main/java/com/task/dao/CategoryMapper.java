package com.task.dao;


import com.task.model.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
//声明接口与其中的方法
//这些接口中的方法不是必须需要实现的，spring会自动通过标签来实现sql语句与其中方法的装配
//需要对mysql实现什么功能，只需要在这个表中添加相应的方法和sql语句就可以了
public interface CategoryMapper {
//在表student中添加相应的name和age
    @Insert("insert into student ( name,age) values (#{name},#{age})")
    public int add(Category category);
//查询整个student表
    @Select("select * from   student")
    public List<Category> list();
//通过id查询student表
    @Select("  select * from   student where id= #{id}")
    public List<Category> ListOfId(Category category);

}