package com.bell.bellpractive.model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Set;

/**
 * Класс, описывающий офис
 */
@Entity
@Table(name = "office")
public class Office {
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
     * Идентификатор организации
     */
    @Column(name = "org_id", nullable = false)
    private Integer orgId;

    /**
     * Название офиса
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Адрес офиса
     */
    @Column(name = "address", length = 50, nullable = false)
    private String address;

    /**
     * Телефон офиса
     */
    @Column(name = "phone", length = 50)
    private String phone;

    /**
     * Поле, показывающее рабочий ли офис
     */
    @Column(name = "is_active", length = 50, nullable = false)
    private Boolean isActive;

    /**
     * Список сотрудников офиса
     */
    @OneToMany(mappedBy="office")
    private Set<User> users;

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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
