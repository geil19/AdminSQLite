package com.aplica.andres.adminsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by andres on 25/11/2017.
 */

public class CargarBase extends SQLiteAssetHelper {
    private static final  String DATABASE_NAME = "centrotic";
    private static final int DATABASE_VERSION = 1;

    public CargarBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


}

