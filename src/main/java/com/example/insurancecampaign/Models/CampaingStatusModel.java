package com.example.insurancecampaign.Models;

import com.example.insurancecampaign.Enums.EnumStatus;
import lombok.Data;

@Data
public class CampaingStatusModel {

    private Long campaingId;
    private EnumStatus status;
}
