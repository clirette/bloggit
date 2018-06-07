package com.cal.bloggit.converters.impl;

import com.cal.bloggit.converters.ILocalDateTimeConverter;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Service
public class LocalDateTimeConverter implements ILocalDateTimeConverter{

    @Override
    public LocalDateTime convertLongToLocalDateTime(Long epoch) {
        if (epoch != null) {
            Instant epochDate = Instant.ofEpochMilli(epoch);
            return LocalDateTime.ofInstant(epochDate, ZoneOffset.UTC);
        }

        return null;
    }

    @Override
    public Long convertLocalDateTimeToLong(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            OffsetDateTime zdt = localDateTime.atOffset(ZoneOffset.UTC);
            return zdt.toInstant().toEpochMilli();
        }
        return null;
    }
}
