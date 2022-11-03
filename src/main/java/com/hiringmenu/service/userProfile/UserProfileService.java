package com.hiringmenu.service.userProfile;

import com.hiringmenu.models.userProfile.UserProfileRequest;
import com.hiringmenu.persistance.UserProfileRepository;
import com.hiringmenu.service.userProfile.interfaces.IUserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
public class UserProfileService implements IUserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public boolean createOrUpdateUserProfile(UserProfileRequest requestDto) {

        try{
            userProfileRepository.save(requestDto);
        }catch (Exception e){
            log.info("UserProfileService :: createUserProfile exception occurred while saving data in DB. RequestDto :{} and exception :{}", requestDto, e.getMessage());
            throw new RuntimeException("exception occurred while saving data in DB");
        }
        return true;
    }

    @Override
    public UserProfileRequest getUserById(Long id) {
        Optional<UserProfileRequest> response = null;
        try {
            response = userProfileRepository.findById(id);
            if (response.isPresent()) {
                return response.get();
            }
        } catch (Exception e) {
            log.info("UserProfileService :: getUserById exception occurred while getting data in DB. RequestId :{} and exception :{}", id, e.getMessage());
            throw new RuntimeException("exception occurred while getting data in DB");
        }
        return null;
    }

    @Override
    public boolean deleteUserProfile(Long id) {
        try {
            userProfileRepository.deleteById(id);
        } catch (Exception e) {
            log.info("UserProfileService :: deleteUserProfile exception occurred while saving data in DB. Request :{} and exception :{}", id, e.getMessage());
            throw new RuntimeException("exception occurred while deleting data in DB");
        }
        return true;
    }
}
