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

    private Map<String, Profile> profiles = DataBaseStub.getProfiles();

    public ProfileServiceImpl() {

        profiles.put("eddard", new Profile(1, "eddard", "Eddard", "Stark", LocalDateTime.now()));
        profiles.put("daenerys", new Profile(2, "daenerys", "Daenerys", "Targaryen", LocalDateTime.now()));
        profiles.put("cercei", new Profile(3, "cercei", "Cercei", "Lannister", LocalDateTime.of(2009, 6, 3, 5,30,30)));
    }

    @Override
    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profiles.values());
    }

    @Override
    public Profile getProfile(String profileName) {

        final Profile profile = profiles.get(profileName);

        if (profile == null) {
            throw new DataNotFoundException("Profile with name " + profileName + " not found");
        }

        return profile;
    }

    @Override
    public Profile addProfile(Profile profile) {
        profile.setId(profiles.size() + 1);
        profile.setLastModified(LocalDateTime.now());
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    @Override
    public Profile updateProfile(Profile profile) {
        if (profile.getId() <= 0){
            return null;
        }
        profile.setLastModified(LocalDateTime.now());
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    @Override
    public Profile removeProfile(String profileName) {
        return profiles.remove(profileName);
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
