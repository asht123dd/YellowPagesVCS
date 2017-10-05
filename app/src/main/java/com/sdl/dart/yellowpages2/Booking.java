package com.sdl.dart.yellowpages2;

/**
 * Created by ashutosh on 5/10/17.
 */

public class Booking {
    private String u_name;
    private String w_id;

    public Booking(String u_name, String w_id) {
        this.u_name = u_name;
        this.w_id = w_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getW_id() {
        return w_id;
    }

    public void setW_id(String w_id) {
        this.w_id = w_id;
    }
}
