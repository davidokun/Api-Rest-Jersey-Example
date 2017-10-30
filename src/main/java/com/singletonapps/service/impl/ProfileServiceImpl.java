package com.singletonapps.service.impl;

import com.singletonapps.database.DataBaseStub;
import com.singletonapps.model.Profile;
import com.singletonapps.service.ProfileService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileServiceImpl implements ProfileService, Serializable {

    private Map<Long, Profile> profiles = DataBaseStub.getProfiles();

    public ProfileServiceImpl() {

        profiles.put(1L, new Profile(1, "admin", "John", "Doe"));
        profiles.put(2L, new Profile(2, "publisher", "Jane", "Doe"));
    }

    @Override
    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profiles.values());
    }

    @Override
    public Profile getProfile(long profileId) {
        return profiles.get(profileId);
    }

    @Override
    public Profile addProfile(Profile profile) {
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getId(), profile);
        return profile;
    }

    @Override
    public Profile updateProfile(Profile profile) {
        if (profile.getId() <= 0){
            return null;
        }
        profiles.put(profile.getId(), profile);
        return profile;
    }

    @Override
    public Profile removeProfile(long id) {
        return profiles.remove(id);
    }
}
