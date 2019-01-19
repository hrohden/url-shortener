package com.henriquerohden.urlshortener;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime creationDate;
}
