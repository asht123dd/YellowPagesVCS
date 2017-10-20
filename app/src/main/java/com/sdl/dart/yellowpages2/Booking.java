package com.sdl.dart.yellowpages2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ashutosh on 5/10/17.
 */

public class Booking implements Parcelable {
    private String u_name;
    private String w_id;
    private String date_st;
    private String time_st;

    public Booking(String u_name, String w_id) {
        this.u_name = u_name;
        this.w_id = w_id;
    }

    public Booking(String u_name, String w_id, String date_st, String time_st) {
        this.u_name = u_name;
        this.w_id = w_id;
        this.date_st = date_st;
        this.time_st = time_st;
    }

    public int describeContents() {
        return 0;
    }

    public Booking(Parcel in) {
        u_name = in.readString();
        w_id = in.readString();
        date_st = in.readString();
        time_st = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(u_name);
        dest.writeString(w_id);
        dest.writeString(date_st);
        dest.writeString(time_st);
    }

    public static final Parcelable.Creator<Booking> CREATOR = new Parcelable.Creator<Booking>() {
        public Booking createFromParcel(Parcel in) {
            return new Booking(in);
        }

        public Booking[] newArray(int size) {
            return new Booking[size];
        }
    };


    public Booking() {
    }

    public String getDate_st() {
        return date_st;
    }

    public void setDate_st(String date_st) {
        this.date_st = date_st;
    }

    public String getTime_st() {
        return time_st;
    }

    public void setTime_st(String time_st) {
        this.time_st = time_st;
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
