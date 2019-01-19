package com.henriquerohden.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/")
public class ApplicationController {

    @Autowired
    private URLRepository repository;

    @GetMapping("/")
    public ModelAndView index() {
        List<URL> mocks = Arrays.asList(
                new URL("http://www.google.com", "2htjXRzP", Calendar.getInstance()),
                new URL("http://www.microsoft.com", "bl5dQhui", Calendar.getInstance()),
                new URL("http://www.apple.com", "IJMtl1ji", Calendar.getInstance()),
                new URL("http://www.amazon.com", "V2rSTB3W", Calendar.getInstance()),
                new URL("http://www.facebool.com", "eFkViScd", Calendar.getInstance())
        );
        repository.saveAll(mocks);
        return new ModelAndView("index", "urls", repository.findAll());
    }

}
