package com.example.examen1.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDHelper extends SQLiteOpenHelper {
    public BDHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE t_funcionario"+"(" +
                "usu_id INTEGER PRIMARY KEY," +
                "f_nombre text NOT NULL," +
                "f_cargo text NOT NULL," +
                "f_area text NOT NULL," +
                "f_estado text NOT NULL," +
                "f_hijos text NOT NULL," +
                "f_sueldo text NOT NULL," +
                "f_subsidio text NOT NULL," +
                "f_atrasos text NOT NULL," +
                "f_horas text NOT NULL," +
                "f_sueldoT text NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE t_funcionario");
        onCreate(db);
    }
}
