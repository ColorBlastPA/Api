package com.developer.colorblast.messagerie.dto.response;

import com.developer.colorblast.messagerie.entity.MessagerieEntity;
import com.developer.colorblast.pro.entity.ProfessionnelEntity;

public class MessagerieForClient {


    MessagerieEntity messagerie;

    ProfessionnelEntity pro;

    public MessagerieForClient(MessagerieEntity messagerie, ProfessionnelEntity pro) {
        this.messagerie = messagerie;
        this.pro = pro;
    }

    public MessagerieEntity getMessagerie() {
        return messagerie;
    }

    public void setMessagerie(MessagerieEntity messagerie) {
        this.messagerie = messagerie;
    }

    public ProfessionnelEntity getPro() {
        return pro;
    }

    public void setPro(ProfessionnelEntity pro) {
        this.pro = pro;
    }

}
