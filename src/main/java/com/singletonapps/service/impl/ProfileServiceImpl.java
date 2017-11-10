package com.singletonapps.service.impl;

import com.singletonapps.database.DataBaseStub;
import com.singletonapps.exception.DataNotFoundException;
import com.singletonapps.model.Profile;
import com.singletonapps.service.ProfileService;

import javax.inject.Singleton;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Singleton
public class ProfileServiceImpl implements ProfileService, Serializable {

    private Map<Long, Profile> profiles = DataBaseStub.getProfiles();

    public ProfileServiceImpl() {

        profiles.put(1L, new Profile(1, "admin", "John", "Doe", LocalDateTime.now()));
        profiles.put(2L, new Profile(2, "publisher", "Jane", "Doe", LocalDateTime.now()));
        profiles.put(3L, new Profile(3, "editor", "Edward", "Elric", LocalDateTime.of(2009, 6, 3, 5,30,30)));
    }

    @Override
    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profiles.values());
    }

    @Override
    public Profile getProfile(long profileId) {

        final Profile profile = profiles.get(profileId);

        if (profile == null) {
            throw new DataNotFoundException("Profile with Id " + profileId + " not found");
        }

        return profile;
    }

    @Override
    public Profile addProfile(Profile profile) {
        profile.setId(profiles.size() + 1);
        profile.setLastModified(LocalDateTime.now());
        profiles.put(profile.getId(), profile);
        return profile;
    }

    @Override
    public Profile updateProfile(Profile profile) {
        if (profile.getId() <= 0){
            return null;
        }
        profile.setLastModified(LocalDateTime.now());
        profiles.put(profile.getId(), profile);
        return profile;
    }

    @Override
    public Profile removeProfile(long id) {
        return profiles.remove(id);
    }

    @Override
    public List<Profile> getAllProfilesByYear(int year){

        return profiles.entrySet().stream()
                .filter(p -> p.getValue().getLastModified().getYear() == year)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public List<Profile> getProfilesPaginated(int offset, int size) {

        List<Profile> profileList = new ArrayList<>(profiles.values());

        return profileList.subList(offset,
                size > profileList.size() ?
                profileList.size()
                :
                offset + size);
    }
}
