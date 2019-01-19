package com.henriquerohden.urlshortener;

import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Data
@Table(name = "urls")
public class URL {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "original_url")
    private String originalURL;

    @Column(name = "hash")
    private String hash;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
}
