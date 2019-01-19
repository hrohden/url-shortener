package com.henriquerohden.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Component
public class ApplicationStartupRunner implements ApplicationRunner {

    @Autowired
    private URLRepository repository;

    @Override
    public void run(ApplicationArguments args) {
        List<URL> mocks = Arrays.asList(
                new URL("http://www.google.com", "2htjXRzP", Calendar.getInstance()),
                new URL("http://www.microsoft.com", "bl5dQhui", Calendar.getInstance()),
                new URL("http://www.apple.com", "IJMtl1ji", Calendar.getInstance()),
                new URL("http://www.amazon.com", "V2rSTB3W", Calendar.getInstance()),
                new URL("http://www.facebool.com", "eFkViScd", Calendar.getInstance())
        );
        repository.saveAll(mocks);
    }
}
