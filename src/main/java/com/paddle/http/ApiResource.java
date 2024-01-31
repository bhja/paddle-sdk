package com.paddle.http;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiResource {
   private ObjectMapper objectMapper;

   public ApiResource(){
       objectMapper = new ObjectMapper();
       objectMapper.findAndRegisterModules();
   }

   protected ObjectMapper getObjectMapper(){
       return objectMapper;
    }

}
