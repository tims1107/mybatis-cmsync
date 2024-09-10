// EmailAttachDataService.java
package com.developerinc.mybatiscmsync.service;

import com.developerinc.mybatiscmsync.model.EmailAttachData;
import com.developerinc.mybatiscmsync.repo.EmailAttachDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmailAttachDataService {

    @Autowired
    private EmailAttachDataRepository emailAttachDataRepository;

    public List<EmailAttachData> getAllEmailAttachData() {
        List<EmailAttachData> emailAttachData = emailAttachDataRepository.getAllEmailAttachData();
        System.out.println("Returned email attach data: {}" + emailAttachData);
        return emailAttachData;
    }
}