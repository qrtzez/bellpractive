package com.bell.bellpractive.model;

import javax.persistence.*;

@Entity
@Table(name = "document_user")
public class DocumentUser {

    @Id
    @Column(name = "id")
    private Long id;

    @Version
    private Integer version;

    @Column(name = "number", length = 15)
    private String number;

    @Column(name = "date", length = 20)
    private String date;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_doc_id")
    private User user;

    @ManyToOne
    @Column(name = "type_id")
    private TypeDocument typeDocument;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TypeDocument getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(TypeDocument typeDocument) {
        this.typeDocument = typeDocument;
    }
}
