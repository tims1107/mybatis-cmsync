// EmailAttachDataRepository.java
package com.developerinc.mybatiscmsync.repo;

import com.developerinc.mybatiscmsync.model.EmailAttachData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailAttachDataRepository extends JpaRepository<EmailAttachData, Long> {

    @Query("SELECT e FROM EmailAttachData e")
    List<EmailAttachData> getAllEmailAttachData();
}