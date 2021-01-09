package com.rabbitmq.receiver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ReceiverRestController {

    @GetMapping()
    public String connect() {
        return "Success";
    }
}
