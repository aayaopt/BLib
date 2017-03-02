package com.futurenavi.pf.erecyclerview.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Child implements Parcelable {

    public String name;
    public String type;
    public String time;
    public boolean isTopHit;

    public Child(String name, boolean isTopHit, String type, String time) {
        this.name = name;
        this.type = type;
        this.time = time;

        this.isTopHit = isTopHit;
    }

    protected Child(Parcel in) {
        name = in.readString();
        name = in.readString();
        time = in.readString();
        isTopHit = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(time);
        dest.writeByte((byte) (isTopHit ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Child> CREATOR = new Creator<Child>() {
        @Override
        public Child createFromParcel(Parcel in) {
            return new Child(in);
        }

        @Override
        public Child[] newArray(int size) {
            return new Child[size];
        }
    };
}
