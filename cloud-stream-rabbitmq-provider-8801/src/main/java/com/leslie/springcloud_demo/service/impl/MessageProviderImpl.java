package com.leslie.springcloud_demo.service.impl;

import com.leslie.springcloud_demo.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

@EnableBinding(Source.class)
public class MessageProviderImpl implements MessageProvider {

    @Autowired
    private MessageChannel output;

    @Override
    public String send() {

        String serial = UUID.randomUUID().toString();

        output.send(MessageBuilder.withPayload(serial).build());

        return serial;
    }
}
