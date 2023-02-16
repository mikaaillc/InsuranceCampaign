package com.example.insurancecampaign.Models;

import com.example.insurancecampaign.Enums.EnumCategory;
import lombok.Data;

import java.sql.Date;
@Data
public class
CampaingQueryModel {

    String title;
    String detail;
    EnumCategory category;
}
