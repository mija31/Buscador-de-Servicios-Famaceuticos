package wil.rutascbba.adapter;

import android.graphics.drawable.Drawable;

/**
 * Created by william on 15/04/2017.
 */

public class ItemRecyclerView {
    String titulo;
    String sindi;
    Drawable img;

    public ItemRecyclerView(String titulo, String sindi, Drawable img){
        this.titulo = titulo;
        this.sindi = sindi;
        this.img = img;


    }

    public String getTitulo() {
        return titulo;
    }

    public Drawable getImg() {
        return img;
    }

    public String getSindi() {
        return sindi;
    }
}
