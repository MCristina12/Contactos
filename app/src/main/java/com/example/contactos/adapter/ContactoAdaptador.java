package com.example.contactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactos.db.ConstructorContactos;
import com.example.contactos.pojo.Contacto;
import com.example.contactos.DetalleContacto;
import com.example.contactos.R;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflar el layout y lo pasa al viewholder para que obtenga views
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {
        //Pasa la lista de contactos a cada elemento - empiezas a setear
        //asocia cada elemento de la lista con cada view
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());
        //contactoViewHolder.tvLike.setText(String.valueOf(contacto.getLikes())+" Likes");


        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("Nombre", contacto.getNombre());
                intent.putExtra("Telefono", contacto.getTelefono());
                intent.putExtra("Email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });

        /*contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste Like a " + contacto.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
                constructorContactos.darLikeContacto(contacto);

                contactoViewHolder.tvLike.setText(constructorContactos.obtenerLikesContacto(contacto));
            }
        });*/
    }

    @Override
    public int getItemCount() { //cantidad de elementos que contiene la lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        //private ImageButton btnLike;
        //private TextView tvLike;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto      = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV   = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            //btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            //tvLike = (TextView) itemView.findViewById(R.id.tvLikes);
        }
    }
}
