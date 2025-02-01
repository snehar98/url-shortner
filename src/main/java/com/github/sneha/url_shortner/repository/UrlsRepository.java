package com.github.sneha.url_shortner.repository;

import com.github.sneha.url_shortner.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlsRepository extends JpaRepository<Url,String > {

    @Query("SELECT u FROM Url u WHERE u.longUrl = ?1")
    Url findByLongUrl(String longUrl);
}
