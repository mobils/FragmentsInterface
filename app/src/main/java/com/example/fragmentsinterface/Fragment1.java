package com.example.fragmentsinterface;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    OnFragment1Listener listener;  //variable per utilitzar el listener i avisar l'activity

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }

    // onAttach s'executa quan el fragment està en pantalla.
    //l'activitat que ha inflat el fragment és el que ens arriba per paràmetre com a "context"
    //Com que l'activitat implementa OnFragment1Listener puc fer el cast
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //Context és l'activitat que ha inflat el fragment i que està escoltant el fragment1Listener
        if (context instanceof OnFragment1Listener)
            listener=(OnFragment1Listener) context;
        else
            throw new RuntimeException ("Has de fer que l'activitat escolti OnFragmen1Listener");
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
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
        View v= inflater.inflate(R.layout.fragment_1, container, false);

        Button bFragment = v.findViewById(R.id.botoFragment1);

        bFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Avisar al activity que s'ha clicat el botó
                listener.onFragment1Click();  //d'aqui va al onFragment1Click del activity
            }
        });

        return v;
    }




    public interface OnFragment1Listener {
        public void onFragment1Click();
    }
}