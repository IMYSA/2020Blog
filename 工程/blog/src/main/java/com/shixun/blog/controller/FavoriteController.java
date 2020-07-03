package com.shixun.blog.controller;

import com.shixun.blog.entity.Article;
import com.shixun.blog.entity.Favorite;
import com.shixun.blog.service.FavoriteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@ResponseBody
@RestController
@CrossOrigin()
public class FavoriteController {
    @Resource
    private FavoriteService favoriteService;
    @RequestMapping(value = "/add_favorite", method = RequestMethod.POST)
    public void addFollow(@RequestBody Favorite f)    {
        favoriteService.addFavorite(f);
    }

    @RequestMapping(value = "/delete_favorite", method = RequestMethod.POST)
    public void deleteFollow(@RequestBody Favorite f)    {
        favoriteService.deleteFavorite(f);
    }

    @RequestMapping(value = "/search_favorite", method = RequestMethod.POST)
    public Favorite searchFollow(@RequestBody Favorite f)    {
        return favoriteService.searchFavorite(f);
    }
    @RequestMapping(value = "/get_favorites", method = RequestMethod.POST)
    public List<Article> searchFavorite(@RequestBody Favorite f)    {
        return favoriteService.getFavorites(f);
    }
}
