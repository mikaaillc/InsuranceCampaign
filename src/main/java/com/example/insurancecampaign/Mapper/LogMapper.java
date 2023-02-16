package com.example.insurancecampaign.Mapper;


import com.example.insurancecampaign.Entities.LogEntity;
import com.example.insurancecampaign.Models.LogModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class LogMapper {
    public static LogModel mapTo(LogEntity logEntity){
        LogModel logModel = new LogModel();
        logModel.setBeforeStatus(logEntity.getBeforeStatus());
        logModel.setNextStatus(logEntity.getNextStatus());
        logModel.setDetail(logEntity.getDetail());
        logModel.setCampaingId(logEntity.getCampaingId());
        return logModel;
    }

    public static LogEntity mapTo(LogModel logModel){
        LogEntity logEntity  = new LogEntity();
        logEntity.setBeforeStatus(logModel.getBeforeStatus());
        logEntity.setNextStatus(logModel.getNextStatus());
        logEntity.setDetail(logModel.getDetail());
        logEntity.setCampaingId(logModel.getCampaingId());
        logEntity.setCreatedDate(logModel.getCreatedDate());
        return logEntity;
    }


    public static List<LogModel> mapToList(List<LogEntity> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream().map(LogMapper::mapTo).collect(Collectors.toList());
    }


}
