package com.example.jerseyapi;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;

public class JerseyClient {

    public static void main(String args[]){

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

            System.out.println("Output from server ..... Status " + clientResponse.getStatus() + "\n");
            System.out.println(output);

        }catch (ClientHandlerException e){
            System.out.println("ClientHandlerException: " + e.getMessage());
        }
    }
}
