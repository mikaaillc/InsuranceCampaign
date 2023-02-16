package com.example.insurancecampaign.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "\"CampaingLog\""
)
public class LogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "campaingId")
    private Long campaingId;

    @Column(name = "beforeStatus")
    private String beforeStatus;

    @Column(name = "nextStatus")
    private String nextStatus;

    @Column(name = "Detail")
    private String Detail;

    @Column(name = "createdDate")
    private Date createdDate;

}
