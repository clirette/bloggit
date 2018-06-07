package com.cal.bloggit.converters;

import java.time.LocalDateTime;

public interface ILocalDateTimeConverter {

    public LocalDateTime convertLongToLocalDateTime(Long epoch);

    public Long convertLocalDateTimeToLong(LocalDateTime localDateTime);
}
