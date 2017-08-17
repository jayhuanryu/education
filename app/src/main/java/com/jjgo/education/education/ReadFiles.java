package com.jjgo.education.education;

import android.content.Context;

import java.io.InputStream;

/**
 * Created by jayhuanryu on 2017. 8. 17..
 */

public class ReadFiles {

    public static String readTextFile(Context context, String filename) {
        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte buffer[] = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


}
