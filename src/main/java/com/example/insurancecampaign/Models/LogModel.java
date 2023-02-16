package com.example.insurancecampaign.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogModel {

    private Long campaingId;
    private String beforeStatus;
    private String nextStatus;
    private Date createdDate;
    private String Detail;

}
