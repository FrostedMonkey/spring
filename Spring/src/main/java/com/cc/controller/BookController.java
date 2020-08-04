package com.cc.controller;

import com.cc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @ClassName BookController
 * @Author chenchen
 * @Date 2019/9/8 22:37
 * @Version 1.0
 **/
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
}
