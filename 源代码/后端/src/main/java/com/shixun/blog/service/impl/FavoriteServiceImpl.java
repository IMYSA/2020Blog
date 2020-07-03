package com.shixun.blog.service.impl;

import com.shixun.blog.entity.Article;
import com.shixun.blog.entity.Favorite;
import com.shixun.blog.mapper.ArticleMapper;
import com.shixun.blog.mapper.FavoriteMapper;
import com.shixun.blog.mapper.FollowMapper;
import com.shixun.blog.mapper.userInfoMapper;
import com.shixun.blog.service.FavoriteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Resource
    private FavoriteMapper favoriteMapper;
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private userInfoMapper userInfoMapper;

    @Override
    public void addFavorite(Favorite f) {
        favoriteMapper.addFavorite(f);
    }

    @Override
    public Favorite searchFavorite(Favorite f) {
        return favoriteMapper.searchFavorite(f);
    }

    @Override
    public void deleteFavorite(Favorite f) {
        favoriteMapper.deleteFavorite(f);
    }

    @Override
    public List<Article> getFavorites(Favorite f) {
        List<Favorite> list = favoriteMapper.getFavorites(f);
        List<Article> aList = new ArrayList<Article>();
        for(Favorite item : list){
            aList.add(articleMapper.getArticlesById(item.getArticle_id()));
        }

        for(Article item:aList){
            item.setAuthor_name(userInfoMapper.getUserInfo(item.getAuthor()).getName());
        }
        return aList;
    }
}
