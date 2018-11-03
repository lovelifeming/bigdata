package com.zsm.demo.utils;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.*;


/**
 * @Author: zengsm.
 * @Description: TODO()
 * @Date:Created in 2018/8/27.
 * @Modified By:
 */
//@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@JacksonAnnotationsInside
@JsonSerialize(using = SensitiveSerialize.class)
public @interface SensitiveInfo
{
    SensitiveType value() default SensitiveType.NO_MASK;
}
