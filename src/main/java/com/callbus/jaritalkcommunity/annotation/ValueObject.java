package com.callbus.jaritalkcommunity.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.persistence.Embeddable;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Embeddable
public @interface ValueObject {

}
