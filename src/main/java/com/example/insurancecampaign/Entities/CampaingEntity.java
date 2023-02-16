package com.example.insurancecampaign.Entities;

import com.example.insurancecampaign.Enums.EnumCategory;
import com.example.insurancecampaign.Enums.EnumStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "\"Campaing\""
)
public class CampaingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"CampaingId\"", nullable = false)
    private Long id;


    @Column(name = "\"Title\"")
    @Size(min=10,max = 50)
    private String title;

    @Column(name = "\"Detail\"")
    @Size(min=20,max = 200)
    private String detail;

    @Column(name = "\"Category\"")
    private EnumCategory category;


    @Column(name = "\"Status\"")
    private EnumStatus status;


    @Column(name = "\"SameCampaing\"")
    private Boolean sameCampaing;

    @Column(name = "\"createdDate\"", nullable = false)
    private Date createdDate;

}