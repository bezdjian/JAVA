package com.example.jerseyapi;

import com.example.jerseyapi.entities.PersonEntity;
import com.example.jerseyapi.services.PersonDaoService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import junit.framework.TestCase;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

/**
 * Created by bezdj on 22/04/2018.
 */
public class JerseyClientTest extends TestCase {

    private PersonDaoService personDaoService;

    public void testApp(){
        System.out.println("\n\n---------------- testApp ----------------");



        System.out.println("\n\n---------------- EO: testApp ----------------");
    }

    /*public void testGet(){
        System.out.println("\n\n---------------- TESTGET ----------------");
        try{
            ClientConfig cc = new DefaultClientConfig();
            Client client = Client.create(cc);

            WebResource webResource = client.resource("http://localhost:8080/jerseyAPI/get");
            ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);

            //NOT OK
            if(clientResponse.getStatus() != 200){
                throw new RuntimeException("---- Failed in JerseyClient: HTTP error code: " + clientResponse.getStatus());
            }

            String output = clientResponse.getEntity(String.class);

            System.out.println("Output from server  ..... Status " + clientResponse.getStatus() + "\n");
            System.out.println(output);

        }catch (ClientHandlerException e){
            System.out.println("ClientHandlerException : " + e.getMessage());
        }
        System.out.println("\n---------------- EO: TESTGET ---------------- \n\n");
    }

    /*public void testGetPerson(){
        System.out.println("---------------- testGetPerson, Client test ----------------");
        try{
            ClientConfig cc = new DefaultClientConfig();
            Client client = Client.create(cc);

            WebResource webResource = client.resource("http://localhost:8080/jerseyAPI/person/?personid=98");
            ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);

            //NOT OK
            if(clientResponse.getStatus() != 200){
                throw new RuntimeException("---- Failed in JerseyClient: HTTP error code: " + clientResponse.getStatus());
            }

            String output = clientResponse.getEntity(String.class);

            System.out.println("Output from server ..... Status " + clientResponse.getStatus());
            System.out.println("----- " + output);

        }catch (ClientHandlerException e){
            System.out.println("ClientHandlerException: " + e.getMessage());
        }
        System.out.println("\n---------------- EO: testGetPerson ----------------\n\n");
    }*/
}