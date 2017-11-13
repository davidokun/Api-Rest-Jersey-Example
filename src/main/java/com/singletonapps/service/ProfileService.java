package com.singletonapps.service;

import com.singletonapps.model.Profile;

import java.util.List;

public interface ProfileService {

    List<Profile> getAllProfiles();

    Profile getProfile(String profileName);

    Profile addProfile(Profile profile);

    Profile updateProfile(Profile profile);

    Profile removeProfile(String profileName);

    List<Profile> getAllProfilesByYear(int year);

    List<Profile> getProfilesPaginated(int offset, int size);
}
