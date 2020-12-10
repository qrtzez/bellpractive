package com.bell.bellpractive.view;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypeDocumentView {
    private Long id;

    @Size(max = 50)
    @NotNull
    private String type;

    @Size(max = 20)
    @NotNull
    private String code;

    public TypeDocumentView() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "TypeDocumentView{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
