package com.example.insurancecampaign.Service;



import com.example.insurancecampaign.Entities.CampaingEntity;
import com.example.insurancecampaign.Enums.EnumCategory;
import com.example.insurancecampaign.Enums.EnumStatus;
import com.example.insurancecampaign.Mapper.CampaingMapper;
import com.example.insurancecampaign.Models.CampaingStatusModel;
import com.example.insurancecampaign.Models.CampaingModel;
import com.example.insurancecampaign.Models.LogModel;
import com.example.insurancecampaign.Models.StatisticsModel;
import com.example.insurancecampaign.Repository.CampaingRepo;
import com.example.insurancecampaign.Utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.text.ParseException;
import java.util.Optional;

@Service
public class CampaingService implements ICampaingService {


    private final CampaingRepo campaingRepo;
    @Autowired
    private EntityManager entityManager;
    private final LogService logService;

    @Autowired
    public CampaingService(CampaingRepo campaingRepo, LogService logService) {
        this.campaingRepo = campaingRepo;
        this.logService = logService;
    }


    @Override
    public CampaingModel saveCampaing(CampaingModel campaingModel) throws ParseException {
        if(campaingModel.getCategory().equals(EnumCategory.HS)){
            campaingModel.setStatus(EnumStatus.AKTIF);
        }else{
            campaingModel.setStatus(EnumStatus.ONAY_BEKLIYOR);
        }
        CampaingEntity campaing = CampaingMapper.mapTo(campaingModel);
        campaing.setSameCampaing(checkSameCampaing(campaingModel));//mükerrer kontrol
        campaing.setCreatedDate(DateUtils.getCurrentDate());

        return CampaingMapper.mapTo(campaingRepo.save(campaing));
    }


    private Boolean checkSameCampaing(CampaingModel campaingQueryModel){
        Integer check = campaingRepo.checkSameCampaing(
                campaingQueryModel.getTitle(),
                campaingQueryModel.getDetail(),campaingQueryModel.getCategory());
        return check>0;
    }

    @Override
    public CampaingModel changeStatus(CampaingStatusModel campainStatusModel) throws ParseException {
        CampaingEntity campaing = new CampaingEntity();
        Optional<CampaingEntity> campaingEntity = campaingRepo.findById(campainStatusModel.getCampaingId());
        if(campaingEntity.isPresent()){
            campaing =  campaingEntity.get();
        }// boş olması durumunda uygun hata dönülecek
        if(campaing.getSameCampaing()==Boolean.FALSE && campainStatusModel.getStatus()!=campaing.getStatus()){
                //status değişkliğşinde loglama yapılıyor
                LogModel logModel= new LogModel(campaing.getId(),campaing.getStatus().getlabel(),campainStatusModel.getStatus().getlabel(),DateUtils.getCurrentDate(),campaing.getTitle());
                logService.saveCampaing(logModel);
            // sadece mükerrer olmayanaların durumu güncellenebilir ve güncellenecek durum önceki durumdan farklı olmalıdır aynı durum için kayıt oluşturulmaz
            campaing.setStatus(campainStatusModel.getStatus());
            campaingRepo.save(campaing);
        }// uygun hata dönülecek
        return CampaingMapper.mapTo(campaing);
    }


    @Override
    public StatisticsModel getStatistics() {
        Object[] query = createQuery().getSingleResult();
        StatisticsModel statisticsModel = new StatisticsModel();
        if(query.length>0){
            statisticsModel.setOnayBekliyorSayi((long) query[0]);
            statisticsModel.setAktifSayi((long) query[1]);
            statisticsModel.setDeaktifSayi((long) query[2]);
            statisticsModel.setTamamlayiciSaglik((long) query[3]);
            statisticsModel.setOzelSaglik((long) query[4]);
            statisticsModel.setHayatSigortasi((long) query[5]);
            statisticsModel.setDiger((long) query[6]);
            statisticsModel.setToplamKampanyaSayi((long) query[7]);
        }
        return statisticsModel;
    }

    private TypedQuery<Object[]> createQuery(){
        return entityManager.createQuery(
                "SELECT (SELECT count(s)  FROM CampaingEntity s WHERE s.status= 0 ) as onayBekliyorSayi , " +
                        "       (SELECT count(s)  FROM CampaingEntity s WHERE s.status= 1 ) as aktifSayi," +
                        "       (SELECT count(s)  FROM CampaingEntity s WHERE s.status= 2 ) as deaktifSayi," +
                        " (SELECT count(s)  FROM CampaingEntity s WHERE s.category= 0 ) as tamamlayiciSaglik, " +
                        " (SELECT count(s)  FROM CampaingEntity s WHERE s.category= 1 ) as ozelSaglik," +
                        " (SELECT count(s)  FROM CampaingEntity s WHERE s.category= 2 ) as hayatSigortasi," +
                        " (SELECT count(s)  FROM CampaingEntity s WHERE s.category= 3 ) as diger , " +
                        " (SELECT count(s)  FROM CampaingEntity s ) as toplam " +
                        "     from CampaingEntity  group by status ", Object[].class);
    };
}
