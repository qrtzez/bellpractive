package com.bell.bellpractive.model;

import javax.persistence.*;

/**
 * Класс, описывающий организацию
 */
@Entity
@Table(name = "organization")
public class Organization {
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
     * Название организации
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Полное название организации
     */
    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;

    /**
     * ИНН организации
     */
    @Column(name = "inn", length = 50, nullable = false)
    private String inn;

    /**
     * КПП организации
     */
    @Column(name = "kpp", length = 50, nullable = false)
    private String kpp;

    /**
     * Адрес организации
     */
    @Column(name = "address", length = 50, nullable = false)
    private String address;

    /**
     * Телефон организации
     */
    @Column(name = "phone", length = 50)
    private String phone;

    /**
     * Поле, показывающее рабочая ли организация
     */
    @Column(name = "is_active", length = 50, nullable = false)
    private boolean isActive;

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
