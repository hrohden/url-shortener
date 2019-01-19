package com.henriquerohden.urlshortener;

import org.springframework.data.jpa.repository.JpaRepository;

interface URLRepository extends JpaRepository<URL, Long> {
    URL findByHash(String hash);
}
