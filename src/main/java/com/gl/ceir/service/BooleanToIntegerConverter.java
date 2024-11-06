package com.gl.ceir.service;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BooleanToIntegerConverter implements AttributeConverter<Boolean, Integer> {
    public Integer convertToDatabaseColumn(Boolean attribute) {
        if (attribute == null)
            return null;
        return Integer.valueOf(attribute.booleanValue() ? 1 : 0);
    }

    public Boolean convertToEntityAttribute(Integer dbData) {
        if (dbData == null)
            return null;
        return Boolean.valueOf(dbData.equals(Integer.valueOf(1)));
    }
}
