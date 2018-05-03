package com.example.jerseyapi;

import com.example.jerseyapi.entities.PersonEntity;
import com.example.jerseyapi.services.PersonDaoService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
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
    @Path("/updateperson")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject updatePerson(@QueryParam("personid") int personid, @QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname){
        personDaoService = new PersonDaoService();
        String username = firstname.toLowerCase() + "." + lastname.toLowerCase();
        String email = username + "@cybercom.com";
        PersonEntity p = new PersonEntity();
        p.setId(personid);
        p.setUsername(username);
        p.setEmail(email);
        p.setFirstname(firstname);
        p.setLastname(lastname);
        PersonEntity person = personDaoService.addPerson(p);

        try{
            if(person.getId() >= 1){
                JSONObject jSon = new JSONObject("{" +
                        "'Username':'"+person.getUsername()+"'," +
                        "'Firstname':'"+person.getFirstname()+"'," +
                        "'Lastname':'"+person.getLastname()+"'" +
                        "}");
                return jSon;
            }else{
                //Return empty
                JSONObject jsonObject = new JSONObject("{" +
                        "'Status':'User not found.','PersonID':'"+person.getId()+"'" +
                        "}"
                );
                return jsonObject;
            }
        }catch (JSONException e){
            System.err.println("JSON: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }

    }

    @GET
    @Path("/addperson")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject addPerson(@QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname){
        personDaoService = new PersonDaoService();

        String username = firstname.toLowerCase() + "." + lastname.toLowerCase();
        String email = username + "@cybercom.com";
        PersonEntity p = new PersonEntity();
        p.setUsername(username);
        p.setEmail(email);
        p.setFirstname(firstname);
        p.setLastname(lastname);
        PersonEntity personEntity = personDaoService.addPerson(p);

        try{
            if(personEntity.getId() >= 1){
                JSONObject json = new JSONObject("{" +
                        "'Username':'"+personEntity.getUsername()+"'," +
                        "'Firstname':'"+personEntity.getFirstname()+"'," +
                        "'Lastname':'"+personEntity.getLastname()+"'" +
                        "}");
                return json;
            }else{
                //Return empty
                JSONObject jsonObject = new JSONObject("{" +
                        "'Status':'User not found.'," +
                        "'PersonID':'"+personEntity.getId()+"'" +
                        "}"
                );
                return jsonObject;
            }
        }catch (JSONException e){
            System.err.println("JSON ERROR: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }

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

    @GET
    @Path("/{default: .*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response returnWrongPath(@Context HttpServletRequest request){
        String url = request.getRequestURL().toString();
        return Response.status(404).entity("URL " + url + "  not found").build();
    }
}
