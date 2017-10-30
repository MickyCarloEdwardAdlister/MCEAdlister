package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import java.util.List;
public interface Ads {
    List<Ad> all();
    Long insert(Ad ad);
    List<Ad> search(String searchAd);
    void update(Ad ad);
}

