package com.example.insurancecampaign;

import com.example.insurancecampaign.Enums.EnumCategory;
import com.example.insurancecampaign.Enums.EnumStatus;
import com.example.insurancecampaign.Models.CampaingModel;
import com.example.insurancecampaign.Models.CampaingStatusModel;
import com.example.insurancecampaign.Models.StatisticsModel;
import com.example.insurancecampaign.Service.ICampaingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@SpringBootTest
class InsuranceCampaignApplicationTests {

    @Autowired
    private ICampaingService iCampaingService;
    private final CampaingModel model =new CampaingModel();
    @BeforeEach
    void contextLoads() {

        model.setTitle("Deneme  Başlık deneme Başlık deneme Başlık");
        model.setDetail("Deneme  Başlık deneme Başlık deneme Başlık deneme Başlık");
        model.setCategory(EnumCategory.TSS);
        model.setStatus(EnumStatus.ONAY_BEKLIYOR);
    }
    @Test
    public void testSaveCampaing() throws ParseException {
        CampaingModel model1= iCampaingService.saveCampaing(model);
        Assertions.assertNotNull(model1);
    }

    @Test
    public void testChangeStatus() throws ParseException {
        CampaingStatusModel campaingStatusModel = new CampaingStatusModel();
        CampaingModel model =new CampaingModel();
        model.setTitle("Deneme  Başlık deneme Başlık deneme");
        model.setDetail("Deneme  Başlık deneme Başlık deneme Başlık deneme");
        model.setCategory(EnumCategory.TSS);
        model.setStatus(EnumStatus.ONAY_BEKLIYOR);
        CampaingModel model1= iCampaingService.saveCampaing(model);
        campaingStatusModel.setCampaingId(model1.getId());
        campaingStatusModel.setStatus(EnumStatus.DEAKTIF);
        CampaingModel changeStatus= iCampaingService.changeStatus(campaingStatusModel);
        Assertions.assertEquals(changeStatus.getStatus(),EnumStatus.DEAKTIF);
    }

    @Test
    public void testStatistics() throws ParseException {
        iCampaingService.saveCampaing(model);
        StatisticsModel statisticsModel = iCampaingService.getStatistics();
        Assertions.assertNotNull(statisticsModel);
    }

}
