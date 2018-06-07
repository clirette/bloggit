package com.cal.bloggit.converters.impl;

import com.cal.bloggit.converters.ILocalDateTimeConverter;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class LocalDateTimeConverterTest {

    ILocalDateTimeConverter localDateTimeConverter = new LocalDateTimeConverter();

    @Test
    public void convertLongToLocalDateTime() {
        Long epoch = 1483682400000L;    // 01/06/2017
        LocalDateTime localDateTime = localDateTimeConverter.convertLongToLocalDateTime(epoch);
        assertThat(localDateTime.getYear(), is(equalTo(2017)));
        assertThat(localDateTime.getMonthValue(), is(equalTo(1)));
        assertThat(localDateTime.getDayOfMonth(), is(equalTo(6)));
    }

    @Test
    public void convertLongToLocalDateTime_NullEpoch() {
        Long epoch = null;
        LocalDateTime localDateTime = localDateTimeConverter.convertLongToLocalDateTime(epoch);
        assertThat(localDateTime, is(nullValue()));
    }

    @Test
    public void convertLocalDateTimeToLong() {
        LocalDateTime localDateTime = LocalDateTime.of(2017, 1, 6, 0, 0);
        Long epoch = localDateTimeConverter.convertLocalDateTimeToLong(localDateTime);
        assertThat(epoch, is(equalTo(1483660800000L)));
    }

    @Test
    public void convertLocalDateTimeToLong_NullLocalDateTime() {
        LocalDateTime localDateTime = null;
        Long epoch = localDateTimeConverter.convertLocalDateTimeToLong(localDateTime);
        assertThat(epoch, is(nullValue()));
    }

}