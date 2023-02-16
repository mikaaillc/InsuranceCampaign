package com.example.insurancecampaign.Mapper;


import com.example.insurancecampaign.Entities.CampaingEntity;
import com.example.insurancecampaign.Models.CampaingModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CampaingMapper {
    public static CampaingModel mapTo(CampaingEntity campaingEntity){
        CampaingModel campaingModel = new CampaingModel();
        Long id =campaingEntity.getId();
        if(id!=null){
            campaingModel.setId(id);
        }
        campaingModel.setStatus(campaingEntity.getStatus());
        campaingModel.setCategory(campaingEntity.getCategory());
        campaingModel.setDetail(campaingEntity.getDetail());
        campaingModel.setTitle(campaingEntity.getTitle());
        return campaingModel;
    }

    public static CampaingEntity mapTo(CampaingModel campaingModel){
        CampaingEntity campaingEntity = new CampaingEntity();
        Long id =campaingModel.getId();
        if(id!=null){
            campaingEntity.setId(id);
        }
        campaingEntity.setStatus(campaingModel.getStatus());
        campaingEntity.setCategory(campaingModel.getCategory());
        campaingEntity.setDetail(campaingModel.getDetail());
        campaingEntity.setTitle(campaingModel.getTitle());
        return campaingEntity;
    }


    public static List<CampaingModel> mapToList(List<CampaingEntity> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream().map(CampaingMapper::mapTo).collect(Collectors.toList());
    }


}
