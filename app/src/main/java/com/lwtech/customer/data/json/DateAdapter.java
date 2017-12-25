package com.lwtech.customer.data.json;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import java.util.Date;

public final class DateAdapter {


    @ToJson
    public Long toJson(Date date) {
        if (date == null) {
            return null;
        }
        return date.getTime();
    }

    @FromJson
    public Date fromJson(Long value) {
        if (value == null) {
            return null;
        }
        return new Date(value);
    }
}
