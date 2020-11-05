package com.bell.bellpractive.model;

import javax.persistence.*;

@Entity
@Table(name = "type_document")
public class TypeDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type", length = 50, nullable = false)
    private String type;

    @Column(name = "code", length = 20, nullable = false)
    private String code;

    @Version
    private Integer version;

}
