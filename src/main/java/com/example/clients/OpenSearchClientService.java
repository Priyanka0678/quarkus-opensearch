package com.example.opensearch;

import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch._types.query_dsl.MatchAllQuery;
import org.opensearch.client.RestClient;
import org.opensearch.client.RestClientBuilder;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.rest_client.RestClientTransport;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class OpenSearchClientService {

    private final OpenSearchClient client;

    @Inject
    public OpenSearchClientService(OpenSearchClient client) {
        this.client = client;
    }

    // Perform a search query
    public SearchResponse<Object> search(String indexName) throws IOException {
        // Build the search request
        SearchRequest searchRequest = new SearchRequest.Builder()
                .index(indexName)
                .query(new MatchAllQuery.Builder().build()._toQuery())
                .build();

        // Execute the search query and return the response
        return client.search(searchRequest, Object.class);
    }
}

