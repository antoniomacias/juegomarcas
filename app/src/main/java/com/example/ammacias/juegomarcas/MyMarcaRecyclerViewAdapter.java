package com.example.ammacias.juegomarcas;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ammacias.juegomarcas.Clase.Marca;
import com.example.ammacias.juegomarcas.Interfaz.IMarca;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Marca} and makes a call to the
 * specified {@link IMarca}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyMarcaRecyclerViewAdapter extends RecyclerView.Adapter<MyMarcaRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private final List<Marca> mValues;
    private final IMarca mListener;

    public MyMarcaRecyclerViewAdapter(Context context, List<Marca> items, IMarca listener) {
        ctx = context;
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.nombre.setText(mValues.get(position).getNombre());
        Picasso.with(ctx)
                .load(("http://juegomarcas.esy.es/images/ncage.jpg"/*+mValues.get(position).getFoto()*/))
                .resize(250, 250)
                .centerCrop()
                .into(holder.foto);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onClickMarca(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView nombre;
        public final ImageView foto;
        public Marca mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            nombre = (TextView) view.findViewById(R.id.nombre);
            foto = (ImageView) view.findViewById(R.id.foto);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
