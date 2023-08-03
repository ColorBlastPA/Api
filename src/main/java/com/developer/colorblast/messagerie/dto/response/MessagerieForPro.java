package com.developer.colorblast.messagerie.dto.response;

import com.developer.colorblast.client.entity.ClientEntity;
import com.developer.colorblast.messagerie.entity.MessagerieEntity;

public class MessagerieForPro {
    MessagerieEntity messagerie;
    ClientEntity client;

    public MessagerieForPro(MessagerieEntity messagerie, ClientEntity client) {
        this.messagerie = messagerie;
        this.client = client;
    }

    public MessagerieEntity getMessagerie() {
        return messagerie;
    }

    public void setMessagerie(MessagerieEntity messagerie) {
        this.messagerie = messagerie;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }
}
