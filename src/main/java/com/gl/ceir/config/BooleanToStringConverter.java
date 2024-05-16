package com.gl.ceir.config;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

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
