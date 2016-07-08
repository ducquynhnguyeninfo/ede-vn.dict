package qducnguy.ede_vndict.database;

import android.app.Activity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by ndQ on 04/07/2016.
 */
public class DatabaseCreator {


    Activity mainActivity;
    public DatabaseCreator(Activity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public ArrayList<String> readRawFile() {
        ArrayList<String> listData = new ArrayList<>();


        try {
            InputStream is = mainActivity.getAssets().open("raw/ede-vn.txt");
            String str;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                if (is != null) {
                    while ((str = reader.readLine()) != null) {
                        listData.add(str);
//                        Log.e("ev", "readRawFile: " + str, new Exception("what erver"));
                    }
                }
            } finally {
                try { is.close(); } catch (Throwable ignore) {}
            }




        } catch (IOException e) {
            e.printStackTrace();
        }

        return listData;
    }

}
