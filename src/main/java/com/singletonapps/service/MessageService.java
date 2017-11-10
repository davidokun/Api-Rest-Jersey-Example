package com.singletonapps.service;

import com.singletonapps.model.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    List<Message> getAllMessages();

    Message getMessage(long messageId);

    Message addMessage(Message message);

    Message updateMessage(Message message);

    Message removeMessage(long id);

    List<Message> getAllMessagesByYear(int year);

    List<Message> getAllMessagesPaginated(int offSet, int size);
}
