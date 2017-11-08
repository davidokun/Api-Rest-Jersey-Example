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
import java.util.stream.Collectors;


@Singleton
public class MessageServiceImpl implements MessageService, Serializable {

    private Map<Long, Message> messages = DataBaseStub.getMessages();

    public MessageServiceImpl(){
        messages.put(1L,
                new Message(1L, "Winter is coming", "Eddard Stark", LocalDateTime.now()));
        messages.put(2L,
                new Message(2L, "Mother of Dragons", "Daenerys Targaryen", LocalDateTime.of(2010,5,15, 10,51,30)));
        messages.put(3L,
                new Message(3L, "Queen of the Seven Kingdoms", "Cercei Lannister", LocalDateTime.now()));
    }

    @Override
    public List<Message> getAllMessages(){
        return new ArrayList<>(messages.values());
    }

    @Override
    public Message getMessage(long messageId){
        // TODO: Add Optional<T> as a return type
        return messages.get(messageId);
    }

    @Override
    public Message addMessage(Message message){

        message.setId(messages.size() + 1);
        message.setLastModified(LocalDateTime.now());

        messages.put(message.getId(), message);
        return message;
    }

    @Override
    public Message updateMessage(Message message) {
        // TODO: Add Optional<T> as a return type
        if (message.getId() <= 0){
            return null;
        }

        message.setLastModified(LocalDateTime.now());
        messages.put(message.getId(), message);
        return message;
    }

    @Override
    public Message removeMessage(long id){
        return messages.remove(id);
    }

    @Override
    public List<Message> getAllMessagesByYear(int year){

        return messages.entrySet().stream()
                .filter(m -> m.getValue().getLastModified().getYear() == year)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public List<Message> getAllMessagesPaginated(int offSet, int size) {

        List<Message> messageList = new ArrayList<>(messages.values());

        return messageList.subList(offSet,
                size > messageList.size() ?
                        messageList.size()
                        :
                        offSet + size);
    }
}
