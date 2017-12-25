package com.lwtech.customer.di.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Jarly
 * Time :2017/11/9
 * Description:
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {
}
