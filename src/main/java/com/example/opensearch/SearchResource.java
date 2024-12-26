package com.example.opensearch;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;

@Path("/search")
public class SearchResource {

    @Inject
    OpenSearchClientService openSearchService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String search() {
        try {
            return openSearchService.search("10.88.0.1").toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"error\": \"Failed to fetch data\"}";
        }
    }
}

