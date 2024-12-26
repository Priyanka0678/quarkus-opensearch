package com.example.opensearch;

import org.opensearch.client.RestClient;
import org.opensearch.client.RestClientBuilder;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.rest_client.RestClientTransport;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;

import jakarta.enterprise.context.ApplicationScoped; // Updated import
import jakarta.enterprise.inject.Produces;           // Updated import

@ApplicationScoped // Annotation with jakarta namespace
public class OpenSearchClientProducer {

    @Produces
    public OpenSearchClient createClient() {
        // Create the RestClientBuilder to connect to OpenSearch
        RestClientBuilder builder = RestClient.builder(
            new org.apache.http.HttpHost("10.88.0.1", 9200, "https")
        );

        // Build the RestClient
        RestClient restClient = builder.build();

        // Wrap RestClient in RestClientTransport
        OpenSearchTransport transport = new RestClientTransport(
            restClient, new JacksonJsonpMapper()
        );

        // Create and return OpenSearchClient using OpenSearchTransport
        return new OpenSearchClient(transport);
    }
}

