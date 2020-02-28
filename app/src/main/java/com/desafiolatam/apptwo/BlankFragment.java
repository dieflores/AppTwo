package com.desafiolatam.apptwo;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.everseat.textviewlabel.TextViewLabel;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TextViewLabel pregunta, categoria, dificultad;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button button;
    // private Image image;


    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        // pregunta.setText(mParam1);
        // pregunta.setText(mParam2);

        // el botonb se agrego cuando hicimos el segundo fragmento second_fragment

        initializeView(view);
        button.setOnClickListener(new View.OnClickListener() {            // este metodo cuando creamos el boton
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Pasamos", Toast.LENGTH_SHORT).show();
                pasarBotonDos();

            }
        });


        return view;

    }


    private void initializeView(View view) {

        // image = view.findViewById(R.id.imagen12);
        pregunta = view.findViewById(R.id.mitextlabel);
        categoria = view.findViewById(R.id.mitextlabel2);
        dificultad = view.findViewById(R.id.mitextlabel3);
        button = view.findViewById(R.id.buttonInFragment);  // se agrego cuando hicimos el boton para pasar a segundo fragmento


    }

    private void pasarBotonDos() {
        SecondFragment secondFragment = SecondFragment.newInstance("", "");
        getActivity().getSupportFragmentManager()                                                 // aqui cambia respecto al anterior  antes de getSuportFragmentManager poner getActivity() para saber donde está
                .beginTransaction()
                .replace(R.id.frameLayout, secondFragment, "SECONDFRAGMENT")
                .addToBackStack("SECONDFRAGMENT")
                .commit();
    }

}

