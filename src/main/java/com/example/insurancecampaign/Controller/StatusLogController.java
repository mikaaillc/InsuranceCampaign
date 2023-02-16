package com.example.insurancecampaign.Controller;


import com.example.insurancecampaign.Models.LogModel;
import com.example.insurancecampaign.Service.IlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ControllerUtils.LOG_COTROLLER_REQUEST_MAPPING)
public class StatusLogController {

    @Autowired
    private IlogService ilogService;

    @GetMapping(ControllerUtils.LOG_COTROLLER_STATISTICS_PATH)
    private List<LogModel> getStatusLog(@PathVariable Long campaingId){
        return  ilogService.getStatusLog(campaingId);
    }


}
