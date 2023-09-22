package com.developer.colorblast.comment.dto;

public class CommentProRequest {
    private Long idPro;

    private Long idClient;

    private String content;

    private int note;

    public CommentProRequest(Long idPro, Long idClient, String content, int note) {
        this.idPro = idPro;
        this.idClient = idClient;
        this.content = content;
        this.note = note;
    }

    public Long getIdPro() {
        return idPro;
    }

    public void setIdPro(Long idPro) {
        this.idPro = idPro;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
