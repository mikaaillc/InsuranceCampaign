package com.example.insurancecampaign.Controller;


import com.example.insurancecampaign.Annotations.LogTime;
import com.example.insurancecampaign.Models.CampaingStatusModel;
import com.example.insurancecampaign.Models.CampaingModel;
import com.example.insurancecampaign.Models.CampaingQueryModel;
import com.example.insurancecampaign.Models.StatisticsModel;
import com.example.insurancecampaign.Service.ICampaingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


@RestController
@RequestMapping("/Campaing")
public class CampaingController {

    @Autowired
    private ICampaingService iCampaingService;

    public CampaingController(ICampaingService iCampaingService) {
        this.iCampaingService = iCampaingService;
    }


    @PostMapping("/saveCampaing/")
    @LogTime
    private CampaingModel saveCampaing(@RequestBody CampaingModel campaingModel) throws ParseException {
        return  iCampaingService.saveCampaing(campaingModel);
    }

    @PostMapping("/changeStatus/")
    @LogTime
    private CampaingModel changeStatus(@RequestBody CampaingStatusModel status) throws ParseException {
        return  iCampaingService.changeStatus(status);
    }

    @GetMapping("/getStatistics/")
    @LogTime
    private StatisticsModel getStatistics(){
        return  iCampaingService.getStatistics();
    }


}
