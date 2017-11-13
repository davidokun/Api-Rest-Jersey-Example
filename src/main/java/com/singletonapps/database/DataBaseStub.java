package com.singletonapps.database;

import com.singletonapps.model.Message;
import com.singletonapps.model.Profile;

import java.util.HashMap;
import java.util.Map;

public class DataBaseStub {

    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();

    public static Map<Long, Message> getMessages(){
        return messages;
    }

    public static Map<String, Profile> getProfiles(){
        return profiles;
    }
}
