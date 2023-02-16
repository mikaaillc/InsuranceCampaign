package com.example.insurancecampaign.Enums;

public enum EnumStatus {
    ONAY_BEKLIYOR("Onay Bekliyor", 0),
    AKTIF("Aktif", 1),
    DEAKTIF("Deaktif", 2);

    public final String label;
    public final int value;

    EnumStatus(String label,int value) {
        this.value = value;
        this.label = label;
    }

    public int getValue(){
        return value;
    }
    public String getlabel(){
        return label;
    }
}
