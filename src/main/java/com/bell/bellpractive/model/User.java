package com.bell.bellpractive.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


/**
 * Класс, описывающий сотрудника
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * Идентификатор
     */
    private Long id;

    /**
     * Поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Поле идентификатора офиса
     */
    @Column(name = "office_id", nullable = false)
    private Integer officeId;

    /**
     * Имя
     */
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "second_name", length = 50)
    private String secondName;

    /**
     * Отчество
     */
    @Column(name = "middle_name", length = 50)
    private String middleName;

    /**
     * Должность
     */
    @Column(name = "position", length = 50, nullable = false)
    private String position;

    /**
     * Телефон
     */
    @Column(name = "phone", length = 15)
    private String phone;

    /**
     * Поле идентификации
     */
    @Column(name = "is_identified")
    private boolean isIdentified;

    /**
     * Поле, связывающее сотрудника с офисом
     */
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "office_id",insertable=false, updatable=false)
    @JsonIgnore
    private Office office;

    /**
     * Поле, связывающее сотрудника
     */
    @OneToOne(mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private DocumentUser documentUser;

    /**
     * Поле, связывающее сотрудника с гражданство
     */
    @ManyToOne
    @JoinColumn(name = "citizenship_id")
    private Citizenship citizenship;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public DocumentUser getDocumentUser() {
        return documentUser;
    }

    public void setDocumentUser(DocumentUser documentUser) {
        this.documentUser = documentUser;
    }

    public boolean getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(boolean identified) {
        isIdentified = identified;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
