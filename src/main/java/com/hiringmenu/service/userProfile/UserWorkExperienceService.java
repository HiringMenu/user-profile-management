package com.hiringmenu.service.userProfile;

import com.hiringmenu.models.userProfile.UserProfileRequest;
import com.hiringmenu.models.userProfile.UserWorkExperienceRequest;
import com.hiringmenu.service.userProfile.interfaces.IUserWorkExperienceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserWorkExperienceService implements IUserWorkExperienceService {
    @Override
    public boolean createOrUpdateUserWorkExperience(UserWorkExperienceRequest requestDto) {
        return false;
    }

    @Override
    public UserProfileRequest getUserWorkExperienceById(Long id) {
        return null;
    }

    @Override
    public boolean deleteUserWorkExperienceById(Long id) {
        return false;
    }
}
