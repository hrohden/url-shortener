package com.henriquerohden.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping(value = "/api", produces = "application/json")
    @ResponseBody
    public List<URL> statistics() {
        return repository.findAll();
    }

    @GetMapping(value = "/api/{hash}", produces = "application/json")
    @ResponseBody
    public URL statisticsByHash(@PathVariable("hash") String hash) {
        return repository.findByHash(hash);
    }

}
