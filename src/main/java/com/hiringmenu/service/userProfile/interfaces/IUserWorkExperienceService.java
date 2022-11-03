package com.hiringmenu.service.userProfile.interfaces;

import com.hiringmenu.models.userProfile.UserProfileRequest;
import com.hiringmenu.models.userProfile.UserWorkExperienceRequest;

public interface IUserWorkExperienceService {
    boolean createOrUpdateUserWorkExperience(UserWorkExperienceRequest requestDto);

    UserProfileRequest getUserWorkExperienceById(Long id);

    boolean deleteUserWorkExperienceById(Long id);
}
