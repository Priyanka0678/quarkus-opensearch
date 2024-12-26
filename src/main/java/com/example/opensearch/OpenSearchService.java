package com.example;

import org.opensearch.client.RestClient;
import org.opensearch.client.RestHighLevelClient;
import org.opensearch.client.Request;
import org.opensearch.client.Response;

import jakarta.enterprise.context.ApplicationScoped;  // Updated import
import jakarta.inject.Inject;  // Updated import
import java.io.IOException;

@ApplicationScoped
public class OpenSearchService {

    @Inject
    RestHighLevelClient client;  // Inject the OpenSearch client

    public String getDataFromOpenSearch() throws IOException {
        Request request = new Request("GET", "/my_index02/_search");
        Response response = client.getLowLevelClient().performRequest(request);
        return response.getEntity().toString();
    }
}

