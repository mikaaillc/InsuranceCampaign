package com.example.insurancecampaign.Enums;


public enum EnumCategory {// Kategoriler için enum tanımlandı
    TSS("Tamamlayıcı Sağlık Sigortası", 0),
    OHS("Özel Sağlık Sigortası", 1),
    HS("Hayat Sigortası", 2),
    DIGER("Diğer", 3);

    public final String label;
    public final int value;
    EnumCategory(String label, int value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public int getValue() {
        return value;
    }
}
