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
import android.widget.Toast;

import com.example.ammacias.juegomarcas.Clase.Marca;
import com.example.ammacias.juegomarcas.Clase.Result;
import com.example.ammacias.juegomarcas.Interfaz.IHostinger;
import com.example.ammacias.juegomarcas.Interfaz.IMarca;
import com.example.ammacias.juegomarcas.localdb.DatabaseConnection;
import com.example.ammacias.juegomarcas.localdb.MarcaDB;
import com.example.ammacias.juegomarcas.localdb.MarcaDBDao;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

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

    RecyclerView recyclerView;

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

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            getDatos();
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


    void getDatos(){

        //RETROFIT
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IHostinger.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IHostinger service = retrofit.create(IHostinger.class);

        Call<Result> autocompleteList = service.getDatos();

        autocompleteList.enqueue(new Callback<Result>() {

            @Override
            public void onResponse(Response<Result> response, Retrofit retrofit) {

                if (response.isSuccess()) {
                    Result r = response.body();

                    MarcaDBDao marcaDBDao = DatabaseConnection.getMarcaDBDao(getActivity());
                    for (Marca m: r.getMarca()) {
                        //Si NO existe
                        if (marcaDBDao.load(m.getId())==null){
                            System.out.println("YEPA: "+marcaDBDao.load(m.getId()));

                            MarcaDB nuevaMarca = new MarcaDB();
                            nuevaMarca.setId(m.getId());
                            nuevaMarca.setNombre(m.getNombre());
                            nuevaMarca.setNivel(m.getNivel());
                            nuevaMarca.setFoto(m.getFoto());
                            nuevaMarca.setAcertado(m.getAcertado());

                            marcaDBDao.insert(nuevaMarca);
                        }else{
                            //TODO: Si hay algo diferente en alguna marca del JSON, hago update en local
                            /*for (MarcaDB a: marcaDBDao.loadAll()) {

                            }*/
                        }


                    // SELECT * FROM marca WHERE
                    // MarcaDB marcaActual = marcadbDao.load(id);

                    }

                    recyclerView.setAdapter(new MyMarcaRecyclerViewAdapter(getActivity(),marcaDBDao.loadAll(), mListener));

                } else {
                    System.out.println("Error: " + response.code());
                    Toast.makeText(getActivity(), "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Throw: " + t.getMessage());
                Toast.makeText(getActivity(), "Throw: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
