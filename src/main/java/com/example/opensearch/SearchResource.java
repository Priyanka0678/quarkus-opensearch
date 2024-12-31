package com.example.opensearch;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;
import java.io.IOException;
import org.opensearch.client.opensearch.core.SearchResponse;

@Path("/search")
public class SearchResource {

    @Inject
    OpenSearchClientService openSearchService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public SearchResponse<Object> search() throws IOException {
        return openSearchService.search("my-index02");
    }
}

