package com.bell.bellpractive.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Класс, описывающий гражданство
 */
@Entity
@Table(name = "citizenship")
public class Citizenship {
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
     * Название страны
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Код страны
     */
    @Column(name = "code", length = 20, nullable = false)
    private String code;

    public Citizenship() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
