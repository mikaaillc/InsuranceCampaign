package com.example.insurancecampaign.Service;

import com.example.insurancecampaign.Models.LogModel;

import java.text.ParseException;
import java.util.List;

public interface IlogService {

    void saveCampaing(LogModel logModel) throws ParseException;

    List<LogModel> getStatusLog(Long campaingId);

}
