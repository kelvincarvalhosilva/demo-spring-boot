package com.example.flows.service;

import com.example.flows.apis.JsonApi;
import com.example.flows.model.ResponseExampleDTO;
import org.springframework.stereotype.Service;


@Service
public class ServiceExample {

  public ResponseExampleDTO postExample() {
    return JsonApi.INSTANCE.postExample();
  }


  public ResponseExampleDTO putExample(Long id) {
    return JsonApi.INSTANCE.putExample(id);
  }

}
