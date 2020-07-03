package com.shixun.blog.mapper;

import com.shixun.blog.entity.Follow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FollowMapper {
    @Insert("INSERT INTO `follow` (user_id, friend_id) VALUES (#{user_id}, #{friend_id})")
    void addFollow(Follow f);

    @Select("Select * from `follow` where user_id = #{user_id} AND friend_id = #{friend_id}")
    Follow searchFollow(Follow f);

    @Delete("delete from `follow` where user_id = #{user_id} AND friend_id = #{friend_id}")
    void deleteFollow(Follow f);

    @Select("Select * from `follow` where user_id = #{user_id} ")
    List<Follow> getFollows(Follow f);
}
