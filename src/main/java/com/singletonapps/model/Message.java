package com.singletonapps.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement
public class Message {

    private long id;
    private String message;
    private LocalDateTime lastModified;
    private String author;

    public Message() {
    }

    public Message(long id, String message, String author, LocalDateTime localDateTime) {
        this.id = id;
        this.message = message;
        this.lastModified = localDateTime;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
