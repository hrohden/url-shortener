package com.henriquerohden.urlshortener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;

import lombok.Data;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "urls")
class URL {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "original_url")
    private String originalURL;

    @Column(name = "hash_code")
    private String hash;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar creationDate;

    private Integer hits;

    public URL() {
        this.hits = 0;
    }

    public URL(String originalURL, String hash, Calendar creationDate) {
        this.originalURL = originalURL;
        this.hash = hash;
        this.creationDate = creationDate;
        this.hits = 0;
    }

    public URL(String originalURL, String hash, Calendar creationDate, Integer hits) {
        this.originalURL = originalURL;
        this.hash = hash;
        this.creationDate = creationDate;
        this.hits = hits;
    }

    @Override
    public String toString() {
        return originalURL;
    }

    public static String randomAlphaNumeric(int count) {
        String seed = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*seed.length());
            builder.append(seed.charAt(character));
        }
        return builder.toString();
    }

    public void addHits() {
        hits++;
    }
}
