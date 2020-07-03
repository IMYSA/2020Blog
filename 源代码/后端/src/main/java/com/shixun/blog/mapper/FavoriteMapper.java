package com.shixun.blog.mapper;

import com.shixun.blog.entity.Favorite;
import com.shixun.blog.entity.Follow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FavoriteMapper {
    @Insert("INSERT INTO `favorite` (user_id, article_id) VALUES (#{user_id}, #{article_id})")
    void addFavorite(Favorite f);

    @Select("Select * from `favorite` where user_id = #{user_id} AND article_id = #{article_id}")
    Favorite searchFavorite(Favorite f);

    @Delete("delete from `favorite` where user_id = #{user_id} AND article_id = #{article_id}")
    void deleteFavorite(Favorite f);

    @Select("Select * from `favorite` where user_id = #{user_id} ")
    List<Favorite> getFavorites(Favorite f);
}
