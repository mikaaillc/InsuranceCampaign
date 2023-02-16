package com.example.insurancecampaign.Repository;

import com.example.insurancecampaign.Entities.CampaingEntity;
import com.example.insurancecampaign.Enums.EnumCategory;
import com.example.insurancecampaign.Models.CampaingModel;
import com.example.insurancecampaign.Models.CampaingQueryModel;
import jdk.jfr.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaingRepo extends JpaRepository<CampaingEntity,Long> {

    @Query("SELECT count(s)  FROM CampaingEntity s " +
            "WHERE s.category = :category  " +
            "and s.title = :title  " +
            "and s.detail = :detail  " )
    Integer checkSameCampaing(String title, String detail, EnumCategory category);


    @Query("  SELECT (SELECT count(s)  FROM CampaingEntity s WHERE s.status= 0 ) as onaybekliyor , " +
            " (SELECT count(s)  FROM CampaingEntity s WHERE s.status= 1 ) as aktif, " +
            " (SELECT count(s)  FROM CampaingEntity s WHERE s.status= 2 ) as deaktif " +
            "from CampaingEntity  group by status " )
    List<Integer>  getStatistics();

}