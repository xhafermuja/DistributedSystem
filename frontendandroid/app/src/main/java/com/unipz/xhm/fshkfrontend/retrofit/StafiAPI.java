package com.unipz.xhm.fshkfrontend.retrofit;

import com.unipz.xhm.fshkfrontend.model.Professor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface StafiAPI {

    @GET("/professor/getAll")
    Call<List<Professor>> getAllProfessor();

    @POST("/professor/save")
    Call<Professor> saveProfessor(@Body Professor professor);

    @PUT("/professor/{professorId}")
    Call<Professor> updateProfessor(
            @Path("professorId") Integer professorID,
            @Body Professor professor
    );

    @DELETE("/professor/{professorId}")
    Call<String> deleteProfessor(@Path("professorId") Integer professorId);


}
