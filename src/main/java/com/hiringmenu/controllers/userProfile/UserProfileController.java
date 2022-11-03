package com.hiringmenu.controllers.userProfile;

import com.hiringmenu.models.common.ResponseBody;
import com.hiringmenu.models.userProfile.UserProfileRequest;
import com.hiringmenu.service.userProfile.interfaces.IUserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static com.hiringmenu.models.common.Constants.*;

@Slf4j
@Path("/v1/api/user-profile")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class UserProfileController {

    @Autowired
    private IUserProfileService userProfileService;

    @POST
    @Path("/create")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response createUserProfile(UserProfileRequest requestDto) {
        log.debug("UserProfileController.createUserProfile() - got create request: request={}", requestDto);
        ResponseBody response = null;
        try {
            boolean isSuccess = userProfileService.createOrUpdateUserProfile(requestDto);
            if (isSuccess) {
                response = new ResponseBody(SUCCESS, ACCOUNT_CREATE_SUCCESS);
            }
        } catch (Exception e) {
            log.error("UserProfileController.createUserProfile() - failed to create userProfile: request={}, error={}", requestDto, e.getMessage());
            response = new ResponseBody(FAILURE, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @PUT
    @Path("/edit/{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editUserProfile(UserProfileRequest requestDto) {
        log.debug("UserProfileController.createUserProfile() - got create request: request={}", requestDto);
        ResponseBody response = null;
        try {
            boolean isSuccess = userProfileService.createOrUpdateUserProfile(requestDto);
            if (isSuccess) {
                response = new ResponseBody(SUCCESS, ACCOUNT_CREATE_SUCCESS);
            }
        } catch (Exception e) {
            log.error("UserProfileController.editUserProfile() - failed to update userProfile: request={}, error={}", requestDto, e.getMessage());
            response = new ResponseBody(FAILURE, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @GET
    @Path("/get/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getUserProfile(@PathParam("id") Long id) {
        log.debug("UserProfileController.getUserProfile() - got get request: request={}", id);
        ResponseBody response;
        try {
            UserProfileRequest profileResponse = userProfileService.getUserById(id);
            response = new ResponseBody(SUCCESS, profileResponse);
        } catch (Exception e) {
            log.error("UserProfileController.getUserProfile() - failed to get userProfile: request={}, error={}", id, e.getMessage());
            response = new ResponseBody(FAILURE, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deleteUserProfileById(@PathParam("id") Long id) {
        log.debug("UserProfileController.deleteUserProfile() - got create request: request={}", id);
        ResponseBody response = null;
        try {
            boolean isSuccess = userProfileService.deleteUserProfile(id);
            if (isSuccess) {
                response = new ResponseBody(SUCCESS, ACCOUNT_DELETE_SUCCESS);
            }
        } catch (Exception e) {
            log.error("UserProfileController.deleteUserProfileById() - failed to delete userProfile: request={}, error={}", id, e.getMessage());
            response = new ResponseBody(FAILURE, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(response).build();
    }
}
