package com.bell.bellpractive.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "second_name", length = 50)
    private String secondName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @Column(name = "position", length = 50, nullable = false)
    private String position;

    @Column(name = "phone", length = 15)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "citizenship_id")
    private Citizenship citizenship;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private Set<Office> office;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private DocumentUser documentUser;

    @Column(name = "is_identified")
    private boolean isIdentified;

    @Version
    private Integer version;

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

    public Set<Office> getOffice() {
        return office;
    }

    public void setOffice(Set<Office> office) {
        this.office = office;
    }

    public DocumentUser getDocumentUser() {
        return documentUser;
    }

    public void setDocumentUser(DocumentUser documentUser) {
        this.documentUser = documentUser;
    }

    public boolean isIdentified() {
        return isIdentified;
    }

    public void setIdentified(boolean identified) {
        isIdentified = identified;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
