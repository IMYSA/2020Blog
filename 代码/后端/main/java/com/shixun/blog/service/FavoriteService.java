package com.shixun.blog.service;

import com.shixun.blog.entity.Article;
import com.shixun.blog.entity.Favorite;

import java.util.List;

public interface FavoriteService {
    void addFavorite(Favorite f);
    Favorite searchFavorite(Favorite f);
    void deleteFavorite(Favorite f);
    List<Article> getFavorites(Favorite f);
}
