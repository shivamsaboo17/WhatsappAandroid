package com.example.shivam.whatsappui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by Kumar Himanshu on 2/5/2017.
 */

public class Contents {
    private String Title ;
    private String Message;
    private String Time ;
    private Bitmap d ;

    public Bitmap getD() {
        return d;
    }

    public void setD(Bitmap d) {
        this.d = d;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }


}
