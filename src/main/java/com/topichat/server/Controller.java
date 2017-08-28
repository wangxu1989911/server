package com.topichat.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private static Logger logger = LoggerFactory.getLogger(Controller.class);

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    public ResponseEntity onConnect(@RequestBody MultiValueMap<String, String> map) {
        for (String key: map.keySet()) {
            logger.warn("Request param {} : {}", key, map.get(key));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public ResponseEntity onPublish(@RequestBody MultiValueMap<String, String> map) {
        for (String key: map.keySet()) {
            logger.warn("Request param {} : {}", key, map.get(key));
        }

        return ResponseEntity.ok().build();
    }
}
