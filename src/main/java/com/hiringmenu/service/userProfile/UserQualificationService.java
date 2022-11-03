package com.hiringmenu.service.userProfile;

import com.hiringmenu.models.userProfile.UserProfileRequest;
import com.hiringmenu.models.userProfile.UserQualificationRequest;
import com.hiringmenu.service.userProfile.interfaces.IUserQualificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserQualificationService implements IUserQualificationService {
    @Override
    public boolean createOrUpdateUserQualification(UserQualificationRequest requestDto) {
        return false;
    }

    @Override
    public UserProfileRequest getQualificationById(Long id) {
        return null;
    }

    @Override
    public boolean deleteUserQualificationById(Long id) {
        return false;
    }
}
