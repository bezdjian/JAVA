package com.example.jerseyapi;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class HelloWorld {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        return "Hello world!zzzz";
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Track getTrackInJSON(){
        Track t = new Track("Spit out the bone!", "Metallica");

        return t;
    }

    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Track track){
        String result = "Track saved: " + track;
        return Response.status(201).entity(result).build();
    }
}
