package com.henriquerohden.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class ApplicationController {

    @Autowired
    private URLRepository repository;

    @GetMapping("/")
    public ModelAndView index() {
        List<URL> urls = repository.findAll();
        return new ModelAndView("index", "urls", urls);
    }

}
