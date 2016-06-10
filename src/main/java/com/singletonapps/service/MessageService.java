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
        messages.put(1L, new Message(1L, "Winter is coming", "Eddard Stark"));
        messages.put(2L, new Message(2L, "Mother of Dragons", "Daenerys Targaryen"));
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

    public Message updateMessage(Message message) {
        if (message.getId() <= 0){
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id){
        return messages.remove(id);
    }
}
