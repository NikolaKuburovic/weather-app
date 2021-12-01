package com.metropolitan.vreme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    public static final String IME_BAZE = "vremenskeprilike";
    public static final String TABELA = "arhiva";
    public static final String GRAD = "grad";
    public static final String TEMPERATURA = "temperatura";
    public static final String DATUM = "datum";
    public static final int VERZIJA_BAZE = 1;
    public static final String KREIRAJ_BAZU = "create TABLE " + TABELA + " ( " + GRAD + " text, " + TEMPERATURA + "" +
            " text, " + DATUM + " text);";

    public DatabaseHelper(Context context) {
        super(context, IME_BAZE, null, VERZIJA_BAZE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(KREIRAJ_BAZU);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }

    public boolean Unesi(String grad,String temperatura,String datum) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(GRAD,grad);
        contentValues.put(TEMPERATURA,temperatura);
        contentValues.put(DATUM,datum);
        long izvrseno = db.insert(TABELA,null ,contentValues);
        if(izvrseno == -1) {
            return false;
        }
        else{
             return true;
        }
    }

    public Cursor PrikaziSve() {
        db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABELA,null);
        return res;
    }

    public boolean Izmeni(String grad,String temperatura, String datum) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(GRAD,grad);
        contentValues.put(TEMPERATURA,temperatura);
        contentValues.put(DATUM,datum);
        db.update(TABELA, contentValues, "grad = ?",new String[] { grad.toString() });
        return true;
    }

    public Integer Obrisi (String grad) {
        db = this.getWritableDatabase();
        return db.delete(TABELA, "grad = ?",new String[] {grad.toString()});
    }
}
