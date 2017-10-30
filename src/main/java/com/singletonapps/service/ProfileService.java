package com.singletonapps.service;

import com.singletonapps.model.Profile;

import java.util.List;

public interface ProfileService {

    List<Profile> getAllProfiles();

    Profile getProfile(long messageId);

    Profile addProfile(Profile profile);

    Profile updateProfile(Profile profile);

    Profile removeProfile(long id);
}
