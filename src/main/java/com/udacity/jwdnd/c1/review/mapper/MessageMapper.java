package com.udacity.jwdnd.c1.review.mapper;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {

    @Select("SELECT * FROM messages")
    List<ChatMessage> getMessages();

    @Select("SELECT * FROM messages WHERE username = #{username}")
    ChatMessage getMessage(String username);

    @Insert("INSERT into messages(username, messageText) VALUES(#{username}, #{messageText})")
    @Options(useGeneratedKeys = true)
    void insertMessage(String username, String messageText);
}
