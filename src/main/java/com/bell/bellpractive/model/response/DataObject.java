package com.bell.bellpractive.model.response;

/**
 * Класс-обертка
 */
public class DataObject {
    private Object data;

    public DataObject(Object data) {
        this.data = data;
    }

    public DataObject() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
