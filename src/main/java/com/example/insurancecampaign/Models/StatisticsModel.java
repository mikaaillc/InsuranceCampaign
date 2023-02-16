package com.example.insurancecampaign.Models;

import lombok.Data;

@Data

public class StatisticsModel {
    private long onayBekliyorSayi;
    private long aktifSayi;
    private long deaktifSayi;
    private long tamamlayiciSaglik;
    private long ozelSaglik;
    private long hayatSigortasi;
    private long diger;
    private long toplamKampanyaSayi;


}
