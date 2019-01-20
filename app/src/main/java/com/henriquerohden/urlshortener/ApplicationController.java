package com.henriquerohden.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        return new ModelAndView("index", "urls", repository.findAll());
    }

    @PostMapping("/save")
    public String save(URL url) {
        url.setHash(URL.randomAlphaNumeric(8));
        repository.save(url);
        return "redirect:/";
    }

    @GetMapping("/{hash}")
    public String redirect(@PathVariable("hash") String hash) {
        URL url = repository.findByHash(hash);
        url.addHits();
        repository.save(url);
        return "redirect:" + url.getOriginalURL();
    }

}
