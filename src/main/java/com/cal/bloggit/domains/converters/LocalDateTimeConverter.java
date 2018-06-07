package com.cal.bloggit.domains.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Converter(autoApply=true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date>{

    @Override
    public Date convertToDatabaseColumn(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            return Date.from(localDateTime.toInstant(ZoneOffset.UTC));
        }
        return null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date date) {
        if (date != null) {
            return LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.UTC);
        }
        return null;
    }
}
