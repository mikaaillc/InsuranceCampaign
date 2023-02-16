package com.example.insurancecampaign.Controller;


import com.example.insurancecampaign.Models.CampaingStatusModel;
import com.example.insurancecampaign.Models.CampaingModel;
import com.example.insurancecampaign.Models.StatisticsModel;
import com.example.insurancecampaign.Service.ICampaingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


@RestController
@RequestMapping(ControllerUtils.CAMPAING_COTROLLER_REQUEST_MAPPING)
public class CampaingController {

    @Autowired
    private ICampaingService iCampaingService;

    public CampaingController(ICampaingService iCampaingService) {
        this.iCampaingService = iCampaingService;
    }


    @PostMapping(ControllerUtils.CAMPAING_COTROLLER_SAVE_PATH)
    private CampaingModel saveCampaing(@RequestBody CampaingModel campaingModel) throws ParseException {
        return  iCampaingService.saveCampaing(campaingModel);
    }

    @PostMapping(ControllerUtils.CAMPAING_COTROLLER_STATUS_PATH)
    private CampaingModel changeStatus(@RequestBody CampaingStatusModel status) throws ParseException {
        return  iCampaingService.changeStatus(status);
    }

    @GetMapping(ControllerUtils.CAMPAING_COTROLLER_STATISTICS_PATH)
    private StatisticsModel getStatistics(){
        return  iCampaingService.getStatistics();
    }


}
