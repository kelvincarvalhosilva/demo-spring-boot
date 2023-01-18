package com.example.flows.apis;

import com.example.flows.model.ResponseExampleDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public enum JsonApi {

  INSTANCE;

  public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

  private final HttpRequestFactory requestFactory;

  private static final Logger log = LoggerFactory.getLogger(JsonApi.class);

  JsonApi() {
    requestFactory = new NetHttpTransport().createRequestFactory();
  }


  public ResponseExampleDTO postExample() {
    ResponseExampleDTO response;

    try {
      GenericUrl url = new GenericUrl(BASE_URL + "/posts");
      var request = requestFactory.buildPostRequest(url,null);
      ObjectMapper objectMapper = new ObjectMapper();
      var requestResponse = request.execute().parseAsString();
      response = objectMapper.readValue(requestResponse, ResponseExampleDTO.class);

    } catch (Exception e) {
      log.error("Error POST jsonplaceholder:" + e.getMessage());
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error POST jsonplaceholder", e);
    }

    return response;
  }


  public ResponseExampleDTO putExample(Long id) {
    ResponseExampleDTO response;

    try {
      GenericUrl url = new GenericUrl(BASE_URL + "/posts/5");
      var request = requestFactory.buildPutRequest(url,null);
      ObjectMapper objectMapper = new ObjectMapper();
      var requestResponse = request.execute().parseAsString();
      response = objectMapper.readValue(requestResponse, ResponseExampleDTO.class);
    } catch (Exception e) {
      log.error("Error PUT jsonplaceholder:" + e.getMessage());
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "ERROR", e);
    }

    return response;
  }

}
