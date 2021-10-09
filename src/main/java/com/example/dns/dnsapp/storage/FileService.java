package com.example.dns.dnsapp.storage;

import com.example.dns.dnsapp.domain.FileEvent;
import com.example.dns.dnsapp.domain.FileEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileService {
    
    private final FileEventPublisher fileEventPublisher;
    
    public void fileUpload(Map<String, Object> data) {
        try {
            log.info("파일 복사 완료");
            log.info("DB 파일 메타 정보 저장 완료");
            FileEvent fileEvent = FileEvent.toCompleteEvent(data);
            fileEventPublisher.notifyComplete(fileEvent);
        } catch (Exception e) {
            log.error("file upload fail", e);
            FileEvent fileEvent = FileEvent.toErrorEvent(data);
            fileEventPublisher.notifyError(fileEvent);
        }
    }
}
