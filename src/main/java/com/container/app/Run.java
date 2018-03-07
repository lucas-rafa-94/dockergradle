package com.container.app;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Run {

    public static String responsePayload = "";

    @RequestMapping("/")
    @ResponseBody()
    public ResponseEntity index() {
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            responsePayload = Unirest.get("https://gturnquist-quoters.cfapps.io/api/random")
                    .asJson().getBody().toString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        responseHeaders.add("Content-Type", "application/json");
        return new ResponseEntity(responsePayload,responseHeaders, HttpStatus.OK);
    }
}
