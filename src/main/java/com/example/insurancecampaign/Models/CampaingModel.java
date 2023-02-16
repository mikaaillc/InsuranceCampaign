package com.example.insurancecampaign.Models;

import com.example.insurancecampaign.Enums.EnumCategory;
import com.example.insurancecampaign.Enums.EnumStatus;
import lombok.Data;

@Data
public class CampaingModel {

    private Long id;
    private String title;
    private String detail;
    private EnumCategory category;
    private EnumStatus status;


}