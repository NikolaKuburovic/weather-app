package com.metropolitan.vreme;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonPetDana extends AsyncTask <String, Void, String>{


    String jsonrezultat;
/*    static String mesto;
    static String pritisak;
    static String vlaznost;*/

    @Override
    protected String doInBackground(String... urls) {

        jsonrezultat = "";
        URL url;
        HttpURLConnection urlConnection = null;

        try {
            url = new URL(urls[0]);

            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            int data = inputStreamReader.read();

            while (data != -1){
                char karakter = (char) data;
                jsonrezultat += karakter;
                data = inputStreamReader.read();
            }
            return jsonrezultat;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String jsonrezultat){
        super.onPostExecute(jsonrezultat);

        try {

            JSONObject jsonObject2 = new JSONObject(jsonrezultat);

/*            JSONArray array1 = jsonObject2.getJSONArray("city");
            JSONObject objekat1 = array1.getJSONObject(1);*/
            JSONObject objekatCity = new JSONObject(jsonObject2.getString("city"));
            String mesto = objekatCity.getString("name");

            JSONArray array1 = jsonObject2.getJSONArray("list");

            JSONObject objekat1 = array1.getJSONObject(4);
            JSONObject objMain = new JSONObject((objekat1.getString("main")));
            double temperatura = Double.parseDouble(objMain.getString("temp"));
            int tempInt = (int) (temperatura - 273.15);
            String pritisak = objMain.getString("pressure");
            String vlaznost = objMain.getString("humidity");

            String datum = objekat1.getString("dt_txt");
            datum = datum.substring(0, Math.min(datum.length(), 10));


            JSONArray arrayDesc = new JSONArray((objekat1.getString("weather")));
            JSONObject objDesc = arrayDesc.getJSONObject(0);
            String opis = objDesc.getString("main");

            PetDana.mestoTextView2.setText(mesto);
            PetDana.datumTextView2.setText(datum);
            PetDana.opisTextView2.setText("Vreme: " + opis);
            PetDana.temperaturaTextView2.setText("Temperatura: " + String.valueOf(tempInt) + "\u2103");
            PetDana.pritisakTextView2.setText("Pritisak: " + pritisak + " milibara");
            PetDana.vlaznostTextView2.setText("Vlažnost: " + vlaznost + " %");

            JSONObject objekat2 = array1.getJSONObject(12);
            JSONObject objMain2 = new JSONObject((objekat2.getString("main")));
            double temperatura2 = Double.parseDouble(objMain2.getString("temp"));
            int tempInt2 = (int) (temperatura2 - 273.15);
            String pritisak2 = objMain2.getString("pressure");
            String vlaznost2 = objMain2.getString("humidity");

            String datum2 = objekat2.getString("dt_txt");
            datum2 = datum2.substring(0, Math.min(datum2.length(), 10));

            JSONArray arrayDesc2 = new JSONArray((objekat2.getString("weather")));
            JSONObject objDesc2 = arrayDesc2.getJSONObject(0);
            String opis2 = objDesc2.getString("main");


            PetDana.datumTextView3.setText(datum2);
            PetDana.opisTextView3.setText("Vreme: " + opis2);
            PetDana.temperaturaTextView3.setText("Temperatura: " + String.valueOf(tempInt2) + "\u2103");
            PetDana.pritisakTextView3.setText("Pritisak: " + pritisak2 + " milibara");
            PetDana.vlaznostTextView3.setText("Vlažnost: " + vlaznost2 + " %");

            JSONObject objekat3 = array1.getJSONObject(20);
            JSONObject objMain3 = new JSONObject((objekat3.getString("main")));
            double temperatura3 = Double.parseDouble(objMain3.getString("temp"));
            int tempInt3 = (int) (temperatura3 - 273.15);
            String pritisak3 = objMain3.getString("pressure");
            String vlaznost3 = objMain3.getString("humidity");

            String datum3 = objekat3.getString("dt_txt");
            datum3 = datum3.substring(0, Math.min(datum3.length(), 10));

            JSONArray arrayDesc3 = new JSONArray((objekat3.getString("weather")));
            JSONObject objDesc3 = arrayDesc3.getJSONObject(0);
            String opis3 = objDesc3.getString("main");


            PetDana.datumTextView4.setText(datum3);
            PetDana.opisTextView4.setText("Vreme: " + opis3);
            PetDana.temperaturaTextView4.setText("Temperatura: " + String.valueOf(tempInt3) + "\u2103");
            PetDana.pritisakTextView4.setText("Pritisak: " + pritisak3 + " milibara");
            PetDana.vlaznostTextView4.setText("Vlažnost: " + vlaznost3 + " %");


            JSONObject objekat4 = array1.getJSONObject(28);
            JSONObject objMain4 = new JSONObject((objekat4.getString("main")));
            double temperatura4 = Double.parseDouble(objMain4.getString("temp"));
            int tempInt4 = (int) (temperatura4 - 273.15);
            String pritisak4 = objMain4.getString("pressure");
            String vlaznost4 = objMain4.getString("humidity");

            String datum4 = objekat4.getString("dt_txt");
            datum4 = datum4.substring(0, Math.min(datum4.length(), 10));


            JSONArray arrayDesc4 = new JSONArray((objekat4.getString("weather")));
            JSONObject objDesc4 = arrayDesc4.getJSONObject(0);
            String opis4 = objDesc4.getString("main");


            PetDana.datumTextView5.setText(datum4);
            PetDana.opisTextView5.setText("Vreme: " + opis4);
            PetDana.temperaturaTextView5.setText("Temperatura: " + String.valueOf(tempInt4) + "\u2103");
            PetDana.pritisakTextView5.setText("Pritisak: " + pritisak4 + " milibara");
            PetDana.vlaznostTextView5.setText("Vlažnost: " + vlaznost4 + " %");

            JSONObject objekat5 = array1.getJSONObject(36);
            JSONObject objMain5 = new JSONObject((objekat5.getString("main")));
            double temperatura5 = Double.parseDouble(objMain5.getString("temp"));
            int tempInt5 = (int) (temperatura5 - 273.15);
            String pritisak5 = objMain5.getString("pressure");
            String vlaznost5 = objMain5.getString("humidity");

            String datum5 = objekat5.getString("dt_txt");
            datum5 = datum5.substring(0, Math.min(datum5.length(), 10));


            JSONArray arrayDesc5 = new JSONArray((objekat5.getString("weather")));
            JSONObject objDesc5 = arrayDesc5.getJSONObject(0);
            String opis5 = objDesc5.getString("main");


            PetDana.datumTextView6.setText(datum5);
            PetDana.opisTextView6.setText("Vreme: " + opis5);
            PetDana.temperaturaTextView6.setText("Temperatura: " + String.valueOf(tempInt5) + "\u2103");
            PetDana.pritisakTextView6.setText("Pritisak: " + pritisak5 + " milibara");
            PetDana.vlaznostTextView6.setText("Vlažnost: " + vlaznost5 + " %");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
