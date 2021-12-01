package com.metropolitan.vreme;

import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;




public class Vreme extends Fragment {

    View v;

    static TextView mestoTextView;
    static TextView temperaturaTextView;
    static TextView datumTextView;
    static TextView pritisakTextView;
    static TextView vlaznostTextView;
    static TextView opisTextView;
    static TextView celzijusTextView;
    static ImageView imageView;
    Button arhivaButton;
    JsonVreme jsonVreme;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_vreme, container, false);

        mestoTextView = (TextView) v.findViewById(R.id.mestoTextView);
        temperaturaTextView = (TextView) v.findViewById(R.id.temperaturaTextView);
        datumTextView = (TextView) v.findViewById(R.id.datumTextView);
        pritisakTextView = (TextView) v.findViewById(R.id.pritisakTextView);
        vlaznostTextView = (TextView) v.findViewById(R.id.vlaznostTextView);
        opisTextView = (TextView) v.findViewById(R.id.opisTextView);
        celzijusTextView = (TextView) v.findViewById(R.id.celzijusTextView);
        imageView = (ImageView) v.findViewById(R.id.imageView);
        arhivaButton = (Button) v.findViewById(R.id.arhivaButton);

        jsonVreme = new JsonVreme();

        arhivaButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                jsonVreme.dodajArhiva();
            }
        });

        return v;
    }

}
