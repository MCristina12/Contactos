package com.example.contactos.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.contactos.pojo.Contacto;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //estrucutra de la bd (create table, nombre y esas cuestiones)
        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBD.TABLE_CONTACTS + "(" +
                ConstantesBD.TABLE_CONTACTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLE_CONTACTS_NOMBRE + " TEXT, " +
                ConstantesBD.TABLE_CONTACTS_TELEFONO + " TEXT, " +
                ConstantesBD.TABLE_CONTACTS_EMAIL + " TEXT, " +
                ConstantesBD.TABLE_CONTACTS_FOTO + " INTEGER" +
                ")";

        db.execSQL(queryCrearTablaContacto);

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {
        database.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLE_CONTACTS);

        onCreate(database);
    }

    public ArrayList<Contacto> obtenerTodosLosContactos(){
        ArrayList<Contacto> contactos = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBD.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            //aca llenamos contactos
            Contacto contactoActual = new Contacto();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setTelefono(registros.getString(2));
            contactoActual.setEmail(registros.getString(3));
            contactoActual.setFoto(registros.getInt(4));

            contactos.add(contactoActual);
        }

        db.close();

        return contactos;
    }

    public void insertarContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_CONTACTS, null, contentValues);
        db.close();
    }

}
