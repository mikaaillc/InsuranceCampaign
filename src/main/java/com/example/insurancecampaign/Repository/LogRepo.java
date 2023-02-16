package com.example.insurancecampaign.Repository;

import com.example.insurancecampaign.Entities.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepo extends JpaRepository<LogEntity,Long> {

    List<LogEntity> getLogEntitiesByCampaingId(Long campaingId);
}
