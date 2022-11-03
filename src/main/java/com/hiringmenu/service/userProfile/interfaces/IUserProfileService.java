package com.hiringmenu.service.userProfile.interfaces;

import com.hiringmenu.models.userProfile.UserProfileRequest;

public interface IUserProfileService {
    boolean createOrUpdateUserProfile(UserProfileRequest requestDto);

    UserProfileRequest getUserById(Long id);

    boolean deleteUserProfile(Long id);
}
