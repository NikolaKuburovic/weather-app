package com.metropolitan.vreme;


import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PetDana extends Fragment {

    View v;

    static TextView mestoTextView2, temperaturaTextView2, datumTextView2, pritisakTextView2, vlaznostTextView2, opisTextView2;
    static TextView temperaturaTextView3, datumTextView3, pritisakTextView3, vlaznostTextView3, opisTextView3;
    static TextView temperaturaTextView4, datumTextView4, pritisakTextView4, vlaznostTextView4, opisTextView4;
    static TextView temperaturaTextView5, datumTextView5, pritisakTextView5, vlaznostTextView5, opisTextView5;
    static TextView temperaturaTextView6, datumTextView6, pritisakTextView6, vlaznostTextView6, opisTextView6;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_pet_dana, container, false);

        mestoTextView2 = (TextView) v.findViewById(R.id.mestoTextView2);
        temperaturaTextView2 = (TextView) v.findViewById(R.id.temperaturaTextView2);
        datumTextView2 = (TextView) v.findViewById(R.id.datumTextView2);
        pritisakTextView2 = (TextView) v.findViewById(R.id.pritisakTextView2);
        vlaznostTextView2 = (TextView) v.findViewById(R.id.vlaznostTextView2);
        opisTextView2 = (TextView) v.findViewById(R.id.opisTextView2);

        temperaturaTextView3 = (TextView) v.findViewById(R.id.temperaturaTextView3);
        datumTextView3 = (TextView) v.findViewById(R.id.datumTextView3);
        pritisakTextView3 = (TextView) v.findViewById(R.id.pritisakTextView3);
        vlaznostTextView3 = (TextView) v.findViewById(R.id.vlaznostTextView3);
        opisTextView3 = (TextView) v.findViewById(R.id.opisTextView3);


        temperaturaTextView4 = (TextView) v.findViewById(R.id.temperaturaTextView4);
        datumTextView4 = (TextView) v.findViewById(R.id.datumTextView4);
        pritisakTextView4 = (TextView) v.findViewById(R.id.pritisakTextView4);
        vlaznostTextView4 = (TextView) v.findViewById(R.id.vlaznostTextView4);
        opisTextView4 = (TextView) v.findViewById(R.id.opisTextView4);


        temperaturaTextView5 = (TextView) v.findViewById(R.id.temperaturaTextView5);
        datumTextView5 = (TextView) v.findViewById(R.id.datumTextView5);
        pritisakTextView5 = (TextView) v.findViewById(R.id.pritisakTextView5);
        vlaznostTextView5 = (TextView) v.findViewById(R.id.vlaznostTextView5);
        opisTextView5 = (TextView) v.findViewById(R.id.opisTextView5);


        temperaturaTextView6 = (TextView) v.findViewById(R.id.temperaturaTextView6);
        datumTextView6 = (TextView) v.findViewById(R.id.datumTextView6);
        pritisakTextView6 = (TextView) v.findViewById(R.id.pritisakTextView6);
        vlaznostTextView6 = (TextView) v.findViewById(R.id.vlaznostTextView6);
        opisTextView6 = (TextView) v.findViewById(R.id.opisTextView6);

        return v;
    }

}
