package com.codeup.adlister.dao;
import com.codeup.adlister.models.Ad;
import java.sql.SQLException;
import java.util.List;

public interface Ads {
    List<Ad> all();
    Long insert(Ad ad);
    List<Ad> search(String searchAd);
    boolean adsDelete(Long id);
    List<Ad> findByUsername(long user_id);
    void update(Ad ad);
    Ad findById(long id);
}

