package com.developer.colorblast.line.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "line")
public class LineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_messagerie")
    private Long idMessagerie;

    @Column(name = "id_sender")
    private Long idSender;

    @Column(name = "id_receiver")
    private Long idReceiver;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "content")
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    public LineEntity() {
    }

    public LineEntity(Long id, Long idMessagerie, Long idSender, Long idReceiver, String lastname, String firstname, String content, Date date) {
        this.id = id;
        this.idMessagerie = idMessagerie;
        this.idSender = idSender;
        this.idReceiver = idReceiver;
        this.lastname = lastname;
        this.firstname = firstname;
        this.content = content;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMessagerie() {
        return idMessagerie;
    }

    public void setIdMessagerie(Long idMessagerie) {
        this.idMessagerie = idMessagerie;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getIdSender() {
        return idSender;
    }

    public void setIdSender(Long idSender) {
        this.idSender = idSender;
    }

    public Long getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(Long idReceiver) {
        this.idReceiver = idReceiver;
    }
}
