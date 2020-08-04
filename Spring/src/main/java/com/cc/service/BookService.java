package com.cc.service;

import com.cc.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @ClassName BookService
 * @Author chenchen
 * @Date 2019/9/8 22:37
 * @Version 1.0
 **/
@Service
public class BookService {
    /*@Autowired(required = false)//required = false当容器中没有时则不装配，默认是必须装配（true）。
    @Qualifier("bookDao2")*/
    /*@Resource*/
    @Inject
    private BookDao bookDao;
    public void print(){
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
