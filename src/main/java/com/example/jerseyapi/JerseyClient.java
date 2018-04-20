package com.example.jerseyapi;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;

public class JerseyClient {

    public static void main(String args[]){

        ClientConfig cc = new DefaultClientConfig();
        Client client = Client.create(cc);

        WebResource webResource = client.resource("http://localhost:8080/jerseyAPI/get");
        webResource.setProperty("header", MediaType.APPLICATION_JSON_TYPE);
        ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);

        //NOT OK
        if(clientResponse.getStatus() != 200){
            throw new RuntimeException("---- Failed in JerseyClient: HTTP error code: " + clientResponse.getStatus());
        }

        String output = clientResponse.getEntity(String.class);

        System.out.println("Output from server ..... \n");
        System.out.println(output);

    }
}
