package com.zhevakin.rabbitTest.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SampleController {

    Random random = new Random();
    @Autowired
    AmqpTemplate template;

    @RequestMapping("/emit/{id}")
    String queue1(@PathVariable("id") String id) {
        int value = Integer.parseInt(id);
        for (int i = 0; i < value; i++ )
            template.convertAndSend("info", "1:" + i);
        return "Emit to queue";
    }

}
