package com.singletonapps.service.impl;

import com.singletonapps.database.DataBaseStub;
import com.singletonapps.service.MessageServiceable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageService implements MessageServiceable, Serializable {

    private Map<Long, com.singletonapps.model.Message> messages = DataBaseStub.getMessages();

    public MessageService(){
        messages.put(1L, new com.singletonapps.model.Message(1L, "Winter is coming", "Eddard Stark"));
        messages.put(2L, new com.singletonapps.model.Message(2L, "Mother of Dragons", "Daenerys Targaryen"));
        messages.put(3L, new com.singletonapps.model.Message(3L, "Queen of the Seven Kingdoms", "Cercei Lannister"));
    }


    public List<com.singletonapps.model.Message> getAllMessages(){
        return new ArrayList<>(messages.values());
    }

    public com.singletonapps.model.Message getMessage(long messageId){
        return messages.get(messageId);
    }

    public com.singletonapps.model.Message addMessage(com.singletonapps.model.Message message){

        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public com.singletonapps.model.Message updateMessage(com.singletonapps.model.Message message) {
        if (message.getId() <= 0){
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public com.singletonapps.model.Message removeMessage(long id){
        return messages.remove(id);
    }
}
