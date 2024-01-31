package com.paddle.http;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiResource {
   private ObjectMapper objectMapper;
   protected static final String POST = "POST";
   protected static final String GET ="GET";
   protected static final String PUT = "PUT";

   public ApiResource(){
       objectMapper = new ObjectMapper();
       objectMapper.findAndRegisterModules();
   }

   protected ObjectMapper getObjectMapper(){
       return objectMapper;
    }

}
