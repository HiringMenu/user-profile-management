package com.hiringmenu.service.userProfile.interfaces;

import com.hiringmenu.models.userProfile.UserProfileRequest;
import com.hiringmenu.models.userProfile.UserQualificationRequest;

public interface IUserQualificationService {
    boolean createOrUpdateUserQualification(UserQualificationRequest requestDto);

    UserProfileRequest getQualificationById(Long id);

    boolean deleteUserQualificationById(Long id);
}
