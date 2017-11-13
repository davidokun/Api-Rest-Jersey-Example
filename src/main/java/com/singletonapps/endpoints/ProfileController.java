package com.singletonapps.endpoints;

import com.singletonapps.filter.BeanFilter;
import com.singletonapps.model.Profile;
import com.singletonapps.service.ProfileService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/profiles")
public class ProfileController {

    @Inject
    private ProfileService profileService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProfiles(@BeanParam BeanFilter filter){


        if (filter.getYear() > 0){

            return Response.ok( createGenericEntity(profileService.getAllProfilesByYear(filter.getYear())) )
                    .build();
        }
        if (filter.getOffset() >= 0 && filter.getSize() > 0) {

            return Response.ok( createGenericEntity(profileService.getProfilesPaginated(filter.getOffset(), filter.getSize())) )
                    .build();
        }


        return Response.ok( createGenericEntity(profileService.getAllProfiles()) )
                .build();
    }

    @GET
    @Path("/{profileName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProfile(@PathParam("profileName") String profileName){

        return Response.ok(profileService.getProfile(profileName))
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProfile(@Context UriInfo uriInfo, Profile profile){

        Profile profileCreated = profileService.addProfile(profile);
        String newProfileId = String.valueOf(profileCreated.getId());

        final URI locationUri = uriInfo.getAbsolutePathBuilder()
                .path(newProfileId)
                .build();

        return Response.created(locationUri)
                .entity(profileCreated)
                .build();
    }

    @PUT
    @Path("/{profileId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProfile(@PathParam("profileId") long id, Profile profile){

        profile.setId(id);

        return Response.ok(profileService.updateProfile(profile))
                .build();
    }

    @DELETE
    @Path("/{profileName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeProfile(@PathParam("profileName") String profileName){

        profileService.removeProfile(profileName);

        return Response.noContent()
                .build();
    }

    private GenericEntity<List<Profile>> createGenericEntity(List<Profile> profiles){

        return new GenericEntity<List<Profile>>(profiles){};
    }
}
