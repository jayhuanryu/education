package com.jjgo.education.education;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by jayhuanryu on 2017. 8. 17..
 */

public class ReadFiles {

    public static String readText(Context context, String filename) {
        String text = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(filename)));
            String line="";
            while((line = reader.readLine())!=null) {
                Log.d("JAY", "code" +line);
                text += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d("JAY", "final text : " +text);
        return text;
    }


}
