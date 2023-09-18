package com.developer.colorblast.email;

public class Help {
    String mail;
    String content;

    public Help(String mail, String content) {
        this.mail = mail;
        this.content = content;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
