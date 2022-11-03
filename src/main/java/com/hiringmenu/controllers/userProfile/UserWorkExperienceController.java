package com.hiringmenu.controllers.userProfile;

import com.hiringmenu.models.common.ResponseBody;
import com.hiringmenu.models.userProfile.UserProfileRequest;
import com.hiringmenu.models.userProfile.UserWorkExperienceRequest;
import com.hiringmenu.service.userProfile.interfaces.IUserWorkExperienceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static com.hiringmenu.models.common.Constants.*;

@Slf4j
@Path("/v1/api/user-work-experience")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class UserWorkExperienceController {

    @Autowired
    private IUserWorkExperienceService userWorkExperienceService;

    @POST
    @Path("/create")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response createUserWorkExperience(UserWorkExperienceRequest requestDto) {
        log.debug("UserWorkExperienceController.createUserWorkExperience() - got create request: request={}", requestDto);
        ResponseBody response = null;
        try {
            boolean isSuccess = userWorkExperienceService.createOrUpdateUserWorkExperience(requestDto);
            if (isSuccess) {
                response = new ResponseBody(SUCCESS, WORK_EXPERIENCE_CREATE_SUCCESS);
            }
        } catch (Exception e) {
            log.error("UserWorkExperienceController.createUserWorkExperience() - failed to create userWorkExperience: request={}, error={}", requestDto, e.getMessage());
            response = new ResponseBody(FAILURE, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @PUT
    @Path("/edit/{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editUserWorkExperience(UserWorkExperienceRequest requestDto) {
        log.debug("UserWorkExperienceController.editUserWorkExperience() - got create request: request={}", requestDto);
        ResponseBody response = null;
        try {
            boolean isSuccess = userWorkExperienceService.createOrUpdateUserWorkExperience(requestDto);
            if (isSuccess) {
                response = new ResponseBody(SUCCESS, WORK_EXPERIENCE_UPDATE_SUCCESS);
            }
        } catch (Exception e) {
            log.error("UserWorkExperienceController.editUserWorkExperience() - failed to update userWorkExperience: request={}, error={}", requestDto, e.getMessage());
            response = new ResponseBody(FAILURE, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @GET
    @Path("/get/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getUserWorkExperience(@PathParam("id") Long id) {
        log.debug("UserWorkExperienceController.getUserWorkExperience() - got get request: request={}", id);
        ResponseBody response;
        try {
            UserProfileRequest profileResponse = userWorkExperienceService.getUserWorkExperienceById(id);
            response = new ResponseBody(SUCCESS, profileResponse);
        } catch (Exception e) {
            log.error("UserWorkExperienceController.getUserWorkExperience() - failed to get userWorkExperience: request={}, error={}", id, e.getMessage());
            response = new ResponseBody(FAILURE, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deleteUserWorkExperienceById(@PathParam("id") Long id) {
        log.debug("UserWorkExperienceController.getUserWorkExperience() - got create request: request={}", id);
        ResponseBody response = null;
        try {
            boolean isSuccess = userWorkExperienceService.deleteUserWorkExperienceById(id);
            if (isSuccess) {
                response = new ResponseBody(SUCCESS, WORK_EXPERIENCE_DELETE_SUCCESS);
            }
        } catch (Exception e) {
            log.error("UserWorkExperienceController.getUserWorkExperience() - failed to delete userWorkExperience: request={}, error={}", id, e.getMessage());
            response = new ResponseBody(FAILURE, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(response).build();
    }

}
