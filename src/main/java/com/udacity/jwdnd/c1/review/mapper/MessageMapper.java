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

    // Not used but could for all messsages by a single user.
    @Select("SELECT * FROM messages WHERE username = #{username}")
    ChatMessage getMessage(String username);

    @Insert("INSERT into messages(username, messageText) VALUES(#{username}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insertMessage(ChatMessage messageText);
}
