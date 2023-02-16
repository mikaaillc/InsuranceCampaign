package com.example.insurancecampaign.Service;



import com.example.insurancecampaign.Models.CampaingStatusModel;
import com.example.insurancecampaign.Models.CampaingModel;
import com.example.insurancecampaign.Models.StatisticsModel;

import javax.persistence.Tuple;
import java.text.ParseException;


public interface ICampaingService {


    CampaingModel saveCampaing(CampaingModel campaingModel) throws ParseException;
    CampaingModel changeStatus(CampaingStatusModel campaingStatusModel) throws ParseException;

    StatisticsModel getStatistics();


}
