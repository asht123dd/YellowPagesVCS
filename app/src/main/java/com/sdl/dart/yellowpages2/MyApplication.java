package com.sdl.dart.yellowpages2;

import android.app.Application;

/**
 * Created by ashutosh on 5/10/17.
 */

public class MyApplication extends Application {
    private static String someVariable;

    public static String getSomeVariable() {
        return someVariable;
    }

    public static void setSomeVariable(String someVariable2) {
        someVariable = someVariable2;
    }
}
