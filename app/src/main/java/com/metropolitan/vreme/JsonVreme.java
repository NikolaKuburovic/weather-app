package com.metropolitan.vreme;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JsonVreme extends AsyncTask <String, Void, String>{


    static String jsonrezultat = "";
    static String mesto = "";
    static String pritisak = "";
    static String vlaznost = "";
    static String date = "";
    static String temperatura = "";
    static String vremeDatum = "";


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
            JSONObject jsonObject = new JSONObject(jsonrezultat);

            JSONArray array = jsonObject.getJSONArray("weather");
            JSONObject objekat = array.getJSONObject(0);
            JSONObject weatherDatas = new JSONObject(jsonObject.getString("main"));

            double tempInt = Double.parseDouble(weatherDatas.getString("temp"));
            int tempIn = (int) (tempInt - 273.15);
            temperatura = String.valueOf(tempIn);

            mesto = jsonObject.getString("name");
            pritisak = weatherDatas.getString("pressure");
            vlaznost = weatherDatas.getString("humidity");

            String uopsteniOpis = objekat.getString("main");
            uopsteniOpis = uopsteniOpis.replaceAll("\\s+","");

            Vreme.mestoTextView.setText(mesto);
            Vreme.temperaturaTextView.setText(temperatura);

            Vreme.pritisakTextView.setText("Pritisak: " + pritisak + " milibara");
            Vreme.vlaznostTextView.setText("Vlažnost: " + vlaznost + " %");
            Vreme.celzijusTextView.setText("\u2103");

            Date today = Calendar.getInstance().getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            date = formatter.format(today);
            Vreme.datumTextView.setText(date);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            vremeDatum  = dateFormat.format(new Date());


            if(uopsteniOpis.equals("Clear")){
                Vreme.imageView.setImageResource(R.drawable.vedro);
                Vreme.opisTextView.setText("Vedro");
            }
            else if(uopsteniOpis.equals("Thunderstorm")){
                Vreme.imageView.setImageResource(R.drawable.oluja);
                Vreme.opisTextView.setText("Oluja");
            }
            else if(uopsteniOpis.equals("Drizzle")){
                Vreme.imageView.setImageResource(R.drawable.magla);
                Vreme.opisTextView.setText("Izmaglica");
            }
            else if(uopsteniOpis.equals("Rain")){
                Vreme.imageView.setImageResource(R.drawable.kisa);
                Vreme.opisTextView.setText("Kiša");
            }
            else if(uopsteniOpis.equals("Snow")){
                Vreme.imageView.setImageResource(R.drawable.sneg);
                Vreme.opisTextView.setText("Sneg");
            }
            else if(uopsteniOpis.equals("Clouds")){
                Vreme.imageView.setImageResource(R.drawable.oblacno);
                Vreme.opisTextView.setText("Oblačno");
            }
            else{
                Vreme.imageView.setImageResource(R.drawable.malo_oblacno);
                Vreme.opisTextView.setText("Malo oblačno");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dodajArhiva(){
        MainActivity.baza.Unesi(mesto, temperatura, vremeDatum);
    }
}
