package com.bell.bellpractive.model;

import javax.persistence.*;

/**
 * Класс, описывающий тип документа
 */
@Entity
@Table(name = "type_document")
public class TypeDocument {
    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Тип документа
     */
    @Column(name = "type", length = 50, nullable = false)
    private String type;

    /**
     * Код документа
     */
    @Column(name = "code", length = 20, nullable = false)
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
