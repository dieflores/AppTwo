package com.desafiolatam.apptwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.desafiolatam.apptwo.pojos.RespuestaApi;
import com.everseat.textviewlabel.TextViewLabel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private TextViewLabel pregunta, categoria, dificultad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();

        Api api = RetroFitClient.getRetrofit().create(Api.class);
        Call<RespuestaApi> call = api.getQuestion();

        call.enqueue(new Callback<RespuestaApi>() {
            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {
                pregunta.setText(response.body().getResults().get(0).getQuestion());

            }

            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Existe un error", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void initializeView() {
        pregunta = findViewById(R.id.mitextlabel);
        categoria = findViewById(R.id.mitextlabel2);
        dificultad = findViewById(R.id.mitextlabel3);


    }


}
