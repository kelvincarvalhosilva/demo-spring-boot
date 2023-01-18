package com.example.flows.controller;

import com.example.flows.model.ResponseExampleDTO;
import com.example.flows.model.PostExampleDTO;
import com.example.flows.service.ServiceExample;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  private ServiceExample serviceExample;

  public HelloController(ServiceExample serviceExample) {
    this.serviceExample = serviceExample;
  }

  @PostMapping(value = "/test")
  public ResponseExampleDTO postExample(@RequestBody PostExampleDTO body) {
    return this.serviceExample.postExample();
  }


  @PutMapping(value = "/test/{id}")
  public ResponseExampleDTO putExample(@RequestBody PostExampleDTO body, @PathVariable Long id) {
    return this.serviceExample.putExample(id);
  }



}
