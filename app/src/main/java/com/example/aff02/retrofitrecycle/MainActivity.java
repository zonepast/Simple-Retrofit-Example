package com.example.aff02.retrofitrecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public Button btngetdata;
    private static final String BASE_URL = "http://27.109.20.118/SilverPixelz/api/categories/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btngetdata = (Button)findViewById(R.id.btngetdata);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APInterface apInterface = retrofit.create(APInterface.class);
        Call<RetrofitModel> call = apInterface.getData();

        call.enqueue(new Callback<RetrofitModel>() {
            @Override
            public void onResponse(Call<RetrofitModel> call, Response<RetrofitModel> response) {

                Log.d(TAG,"onResponse: Server Response:" +response.toString());
                Log.d(TAG,"onResponse : Received Information: "+response.body().toString());

//                ArrayList<RetrofitModel> retrofitModels = response.body().toString();
//
//                for (int i=0; i<retrofitModels.size();i++)
//                {
//                    Log.d(TAG,"onResponse: \n"+
//                    "proname :"+retrofitModels.get(i).getProdname()+"\n"+
//                    "proimg :"+retrofitModels.get(i).getProdImage());
//                }
            }

            @Override
            public void onFailure(Call<RetrofitModel> call, Throwable t) {

                Log.e(TAG,"onFailure Something went wrong"+t.getMessage());
                Toast.makeText(MainActivity.this,"ERROR :-(",Toast.LENGTH_LONG).show();

            }
        });

    }
}
