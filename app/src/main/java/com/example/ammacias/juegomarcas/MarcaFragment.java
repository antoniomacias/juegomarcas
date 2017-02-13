package com.example.ammacias.juegomarcas;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ammacias.juegomarcas.Clase.Marca;
import com.example.ammacias.juegomarcas.Clase.Result;
import com.example.ammacias.juegomarcas.Interfaz.IMarca;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link IMarca}
 * interface.
 */
public class MarcaFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 4;

    private IMarca mListener;

    Result result;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MarcaFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_marca_list, container, false);

        MainActivity ma = (MainActivity) getActivity();
        result=ma.getResult();


        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

           /*for (Marca p: result.getMarca()) {
                System.out.println("Todo: "+p.getNombre());
            }*/

            List<Marca> a = new ArrayList<>();
            a.add(new Marca("audi.jpg"));
            a.add(new Marca("volvo.jpg"));
            a.add(new Marca("nissan.jpg"));
            a.add(new Marca("maserati.jpg"));
            a.add(new Marca("honda.jpg"));
            recyclerView.setAdapter(new MyMarcaRecyclerViewAdapter(getActivity(),a, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IMarca) {
            mListener = (IMarca) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement IMarca");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
