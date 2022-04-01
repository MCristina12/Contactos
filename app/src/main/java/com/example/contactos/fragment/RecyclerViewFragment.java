package com.example.contactos.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactos.R;
import com.example.contactos.adapter.ContactoAdaptador;
import com.example.contactos.pojo.Contacto;
import com.example.contactos.presentador.IRecyclerViewFragmentPresenter;
import com.example.contactos.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false); //como el onCreate de MainActivity


        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        presenter = new RecyclerViewFragmentPresenter(this, getContext());


        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        listaContactos.setAdapter(adaptador);
    }
}
