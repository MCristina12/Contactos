package com.example.contactos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.contactos.R;
import com.example.contactos.pojo.Contacto;

import java.util.ArrayList;

public class ConstructorContactos {
    private static final int LIKE = 1;
    //intermediario

    private Context context;
    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarTresContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_CONTACTS_NOMBRE, "Mel Huarcaya");
        contentValues.put(ConstantesBD.TABLE_CONTACTS_TELEFONO, "925803692");
        contentValues.put(ConstantesBD.TABLE_CONTACTS_EMAIL, "mel@gmail");
        contentValues.put(ConstantesBD.TABLE_CONTACTS_FOTO, R.drawable.cont1);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_CONTACTS_NOMBRE, "Pedro Sanchez");
        contentValues.put(ConstantesBD.TABLE_CONTACTS_TELEFONO, "257153");
        contentValues.put(ConstantesBD.TABLE_CONTACTS_EMAIL, "pedro@gmail");
        contentValues.put(ConstantesBD.TABLE_CONTACTS_FOTO, R.drawable.cont2);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_CONTACTS_NOMBRE, "Lala Lopez");
        contentValues.put(ConstantesBD.TABLE_CONTACTS_TELEFONO, "253603692");
        contentValues.put(ConstantesBD.TABLE_CONTACTS_EMAIL, "lala@gmail");
        contentValues.put(ConstantesBD.TABLE_CONTACTS_FOTO, R.drawable.cont3);

        db.insertarContacto(contentValues);
    }



}
