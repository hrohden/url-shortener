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

    public URL(String originalURL, String hash, Calendar creationDate) {
        this.originalURL = originalURL;
        this.hash = hash;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return originalURL;
    }
}
