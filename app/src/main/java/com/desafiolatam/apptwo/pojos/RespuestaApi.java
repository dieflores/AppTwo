package com.desafiolatam.apptwo.pojos;

import com.desafiolatam.apptwo.pojos.Result;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RespuestaApi {


    // private List<String>results;  no sirve string hay que hacer pojo (muchos resultados) crear clase pojo
    // creamos a responseCode (desde clase pojo y lo declaramos aqui ) (ene ste caso pojo viene con errores de convencion de nombres (answers_incorrect)
    // vamos a implementar librerias (retrofit y retrofit gson)
    // para los errores de convencion o escritura utilizamos SerializedName

    @SerializedName("response_code")
    private int responseCode;
    private List<Result> results;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
