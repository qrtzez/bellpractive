package com.bell.bellpractive.dao.citizenship;

import com.bell.bellpractive.model.Citizenship;

import java.util.List;

public interface CitizenshipDao {
    List<Citizenship> allCitizenship();

    Citizenship getCode(String code);
}
