/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restapitest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author itsnasa
 */
@Path("RestTest")
@RequestScoped
public class RestTestResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestTestResource
     */
    public RestTestResource() {
    }

    /**
     * Retrieves representation of an instance of com.restapitest.RestTestResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        return "<html><body><h2>Hash of \"Sahil Naphade\" is 617ab19a45401c7b00335ba14ae3920aa64089ab9e180c19fae9e30f1451e769 !!</h2><body></html>";
    }

    /**
     * PUT method for updating or creating an instance of RestTestResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
