package com.example.dns.dnsapp.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FileEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void notifyComplete(FileEvent fileEvent) {
        applicationEventPublisher.publishEvent(fileEvent);
    }

    public void notifyError(FileEvent fileEvent) {
        applicationEventPublisher.publishEvent(fileEvent);
    }
}
