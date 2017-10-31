package com.singletonapps.service.impl;

import com.singletonapps.database.DataBaseStub;
import com.singletonapps.model.Message;
import com.singletonapps.service.MessageService;

import javax.inject.Singleton;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Singleton
public class MessageServiceImpl implements MessageService, Serializable {

    private Map<Long, Message> messages = DataBaseStub.getMessages();

    public MessageServiceImpl(){
        messages.put(1L, new Message(1L, "Winter is coming", "Eddard Stark", LocalDateTime.now()));
        messages.put(2L, new Message(2L, "Mother of Dragons", "Daenerys Targaryen", LocalDateTime.now()));
        messages.put(3L, new Message(3L, "Queen of the Seven Kingdoms", "Cercei Lannister", LocalDateTime.now()));
    }


    public List<Message> getAllMessages(){
        return new ArrayList<>(messages.values());
    }

    public Message getMessage(long messageId){
        return messages.get(messageId);
    }

    public Message addMessage(Message message){

        message.setId(messages.size() + 1);
        message.setLastModified(LocalDateTime.now());

        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {

        if (message.getId() <= 0){
            return null;
        }

        message.setLastModified(LocalDateTime.now());
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id){
        return messages.remove(id);
    }
}
