package com.singletonapps.service;

import com.singletonapps.database.DataBaseStub;
import com.singletonapps.model.Message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MessageService implements Serializable {

    private Map<Long, Message> messages = DataBaseStub.getMessages();

    public MessageService(){
        messages.put(1L, new Message(1L, "Hello Fuck", "David"));
        messages.put(2L, new Message(2L, "Hello Ass", "Marin"));
    }


    public List<Message> getAllMessages(){

        return new ArrayList<>(messages.values());
    }

    public Message getMessage(long messageId){
        return messages.get(messageId);
    }

    public Message addMessage(Message message){

        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }



}
