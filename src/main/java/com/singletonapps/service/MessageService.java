package com.singletonapps.service;

import com.singletonapps.database.DataBaseStub;
import com.singletonapps.model.Message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MessageService implements Serializable {

    private Map<Long, Message> messages = DataBaseStub.getMessages();

    public List<Message> getAllMessages(){

        return new ArrayList<>(messages.values());
    }

    public Message addMessage(Message message){

        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

}
