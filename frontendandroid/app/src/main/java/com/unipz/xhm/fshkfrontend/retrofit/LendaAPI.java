package com.unipz.xhm.fshkfrontend.retrofit;

import com.unipz.xhm.fshkfrontend.model.Lenda;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LendaAPI {

    @GET("/lenda/getAllLendaSD")
    Call<List<Lenda>> getAllLendaSD();

    @GET("/lenda/getAllLendaTIT")
    Call<List<Lenda>> getAllLendaTIT();

    @POST("/lenda/save")
    Call<Lenda> saveLenda(@Body Lenda lenda);

    @PUT("/lenda/{lendaId}")
    Call<Lenda> updateLenda(
            @Path("lendaId") Integer lendaId,
            @Body Lenda lenda
    );
    @DELETE("/lenda/{lendaId}")
    Call<String> deleteLenda(@Path("lendaId") Integer lendaId);
}
