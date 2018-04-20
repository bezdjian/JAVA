package com.example.jerseyapi;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class HelloWorld {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        return "Hello Jersey!\n Try to add /get at the end of the URL.";
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Track getTrackInJSON(){
        Track t = new Track("Spit out the bone!", "Metallica");

        return t;
    }

    @POST
    @Path("/post/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(@QueryParam("singer") String singer, @QueryParam("title") String title){
        Track t = new Track(title, singer);
        String result = "Track saved: " + t;
        return Response.status(201).entity(result).build();
    }
}
