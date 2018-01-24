package com.github.flickr.scope;

import android.support.annotation.NonNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@NonNull
public @interface LateInit {
}