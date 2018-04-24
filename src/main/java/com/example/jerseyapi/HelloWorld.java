package com.example.jerseyapi;

import com.example.jerseyapi.entities.PersonEntity;
import com.example.jerseyapi.services.PersonDaoService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class HelloWorld {

    private PersonDaoService personDaoService;

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

    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getPersonById(@QueryParam("personid") int personid){
        personDaoService = new PersonDaoService();
        PersonEntity persons = personDaoService.getPersonById(personid);
        try{
            if(persons.getId() > 1){
                // Create JsonObject
                    JSONObject jsonObject = new JSONObject("{" +
                            "'Username':'"+persons.getUsername()+"'," +
                            "'Firstname':'"+persons.getFirstname()+"'," +
                            "'Lastname':'"+persons.getLastname()+"'" +
                            "}"
                    );
                    return jsonObject;
            }else{
                //Return empty
                JSONObject jsonObject = new JSONObject("{" +
                        "'Status':'User not found.'," +
                        "'PersonID':'"+personid+"'" +
                        "}"
                );
                return jsonObject;
            }
        }catch (JSONException e){
            System.err.println("JSON ERROR: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
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
