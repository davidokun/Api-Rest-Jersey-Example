package com.singletonapps.service;

import com.singletonapps.model.Message;

import java.util.List;

public interface MessageService {

    List<com.singletonapps.model.Message> getAllMessages();

    Message getMessage(long messageId);

    Message addMessage(com.singletonapps.model.Message message);

    Message updateMessage(com.singletonapps.model.Message message);

    Message removeMessage(long id);
}
