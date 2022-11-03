package com.hiringmenu.controllers.userProfile;

import com.hiringmenu.models.common.ResponseBody;
import com.hiringmenu.models.userProfile.UserProfileRequest;
import com.hiringmenu.models.userProfile.UserQualificationRequest;
import com.hiringmenu.service.userProfile.interfaces.IUserQualificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static com.hiringmenu.models.common.Constants.*;

@Slf4j
@Path("/v1/api/user-qualification")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class UserQualificationController {

    @Autowired
    private IUserQualificationService userQualificationService;

    @POST
    @Path("/create")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response createUserQualification(UserQualificationRequest requestDto) {
        log.debug("UserQualificationController.createUserQualification() - got create request: request={}", requestDto);
        ResponseBody response = null;
        try {
            boolean isSuccess = userQualificationService.createOrUpdateUserQualification(requestDto);
            if (isSuccess) {
                response = new ResponseBody(SUCCESS, QUALIFICATION_CREATE_SUCCESS);
            }
        } catch (Exception e) {
            log.error("UserQualificationController.createUserQualification() - failed to create userQualification: request={}, error={}", requestDto, e.getMessage());
            response = new ResponseBody(FAILURE, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @PUT
    @Path("/edit/{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editUserQualification(UserQualificationRequest requestDto) {
        log.debug("UserQualificationController.editUserQualification() - got create request: request={}", requestDto);
        ResponseBody response = null;
        try {
            boolean isSuccess = userQualificationService.createOrUpdateUserQualification(requestDto);
            if (isSuccess) {
                response = new ResponseBody(SUCCESS, QUALIFICATION_UPDATE_SUCCESS);
            }
        } catch (Exception e) {
            log.error("UserQualificationController.editUserQualification() - failed to update userQualification: request={}, error={}", requestDto, e.getMessage());
            response = new ResponseBody(FAILURE, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @GET
    @Path("/get/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getUserQualification(@PathParam("id") Long id) {
        log.debug("UserQualificationController.getUserQualification() - got get request: request={}", id);
        ResponseBody response;
        try {
            UserProfileRequest profileResponse = userQualificationService.getQualificationById(id);
            response = new ResponseBody(SUCCESS, profileResponse);
        } catch (Exception e) {
            log.error("UserQualificationController.getUserQualification() - failed to get userQualification: request={}, error={}", id, e.getMessage());
            response = new ResponseBody(FAILURE, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deleteUserQualificationById(@PathParam("id") Long id) {
        log.debug("UserQualificationController.deleteUserQualificationById() - got create request: request={}", id);
        ResponseBody response = null;
        try {
            boolean isSuccess = userQualificationService.deleteUserQualificationById(id);
            if (isSuccess) {
                response = new ResponseBody(SUCCESS, QUALIFICATION_DELETE_SUCCESS);
            }
        } catch (Exception e) {
            log.error("UserQualificationController.deleteUserQualificationById() - failed to delete userQualification: request={}, error={}", id, e.getMessage());
            response = new ResponseBody(FAILURE, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(response).build();
    }

}
