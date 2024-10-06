package com.gl.ceir.config;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if (attribute == null) {
            return null;
        } else {
            return attribute ? "true" : "false";
        }
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "true".equals(dbData);
    }
}
