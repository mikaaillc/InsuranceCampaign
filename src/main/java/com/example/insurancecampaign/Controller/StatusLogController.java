package com.example.insurancecampaign.Controller;


import com.example.insurancecampaign.Models.LogModel;
import com.example.insurancecampaign.Models.StatisticsModel;
import com.example.insurancecampaign.Service.IlogService;
import com.example.insurancecampaign.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statusLog")
public class StatusLogController {

    @Autowired
    private IlogService ilogService;

    @GetMapping("/getStatistics/{campaingId}")
    private List<LogModel> getStatusLog(@PathVariable Long campaingId){
        return  ilogService.getStatusLog(campaingId);
    }


}
