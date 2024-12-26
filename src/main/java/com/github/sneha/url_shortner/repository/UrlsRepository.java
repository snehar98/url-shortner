package com.github.sneha.url_shortner.repository;

import com.github.sneha.url_shortner.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlsRepository extends JpaRepository<Url,String > {
}
