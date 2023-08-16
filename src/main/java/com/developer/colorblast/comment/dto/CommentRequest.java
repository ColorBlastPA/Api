package com.developer.colorblast.comment.dto;

public class CommentRequest {

    private Long idProduct;

    private Long idClient;

    private String content;

    private int note;

    public CommentRequest(Long idProduct, Long idClient, String content, int note) {
        this.idProduct = idProduct;
        this.idClient = idClient;
        this.content = content;
        this.note = note;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
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
