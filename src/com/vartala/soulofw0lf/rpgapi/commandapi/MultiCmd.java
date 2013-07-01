package com.vartala.soulofw0lf.rpgapi.commandapi;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MultiCmd {
    //
    String name() default "";

    String description() default "";

    String usage() default "";

    String permission() default "";

    int minArgs() default 0;

    boolean allowConsole() default true;

}
