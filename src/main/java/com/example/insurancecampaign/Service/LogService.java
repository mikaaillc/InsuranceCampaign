package com.example.insurancecampaign.Service;

import com.example.insurancecampaign.Entities.LogEntity;
import com.example.insurancecampaign.Mapper.LogMapper;
import com.example.insurancecampaign.Models.LogModel;
import com.example.insurancecampaign.Repository.LogRepo;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class LogService implements IlogService{

    private final LogRepo logRepo;

    public LogService(LogRepo logRepo) {
        this.logRepo = logRepo;
    }

    @Override
    public void saveCampaing(LogModel logModel) throws ParseException {
        LogEntity entity =LogMapper.mapTo(logModel);
        logRepo.save(entity);
    }

    @Override
    public List<LogModel> getStatusLog(Long campaingId) {
        return LogMapper.mapToList(logRepo.getLogEntitiesByCampaingId(campaingId));
    }
}
