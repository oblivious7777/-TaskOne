package com.task.service;

import com.task.controller.HelloController;
import com.task.model.Category;
import com.task.dao.CategoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
//单元测试，并调用applicationContext.xml的配置
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {
//对类成员变量，方法及构造函数进行标注,完成自动装配的工作
    @Autowired
    private CategoryMapper categoryMapper;
//声明是一个测试方法
    @Test
    public void testList() {//这个方法通过sql语句查询表中的所有数据
        try{//这个try写的挺简单的...
            List<Category> cs=categoryMapper.list();//把表中的数据装配为category对象
            for (Category c : cs) {
                System.out.println(c.getName());//打印其中的name值
            }
        }catch (Exception e) {
            System.out.print("出错了");
        }
    }
    @Test
    public void add(){//为表中添加多条数据
        Category category = new Category();//声明一个category对象
        //for(long i=1;i<(long)200000000;i++){
        for(int i=1;i<10;i++){//源自任务一的2亿条数据，我电脑太慢不太好插入
            int a= (int)(10*Math.random());//声明一个0-9的数字（age）
            category.setName("new Category");
            category.setAge(a);
            categoryMapper.add(category);//为表中的数据输入name和age的值，id的值是自增长的
        }
    }

    @Test
    public void ListOfId(){//查询表中特定id的数据并返回其姓名
        Category category = new Category();
        category.setId(HelloController.SId());//调用的是controller层的数据
        List<Category> cs=categoryMapper.ListOfId(category);//因为考虑到对age的查询也可以使用这个方法（返回复数数据），所以这里用的是泛型
        for (Category c : cs) {
            System.out.println(c.getName());
        }
    }
}