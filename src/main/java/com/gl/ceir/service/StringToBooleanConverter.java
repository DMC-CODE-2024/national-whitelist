package com.gl.ceir.service;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StringToBooleanConverter implements AttributeConverter<Boolean, String> {
    public String convertToDatabaseColumn(Boolean attribute) {
        if (attribute == null)
            return null;
        return attribute.booleanValue() ? "true" : "false";
    }

    public Boolean convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;
        return Boolean.valueOf("true".equalsIgnoreCase(dbData));
    }
}
