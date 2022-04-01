package com.example.contactos.fragment;

import com.example.contactos.adapter.ContactoAdaptador;
import com.example.contactos.pojo.Contacto;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);
}
