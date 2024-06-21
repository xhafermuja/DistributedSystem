package com.unipz.xhm.fshkfrontend.retrofit;

import com.unipz.xhm.fshkfrontend.model.Department;
import com.unipz.xhm.fshkfrontend.model.Lenda;
import com.unipz.xhm.fshkfrontend.model.Professor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DepartmentAPI {

    @GET("/department/getAll")
    Call<List<Department>> getAllDepartments();

    @PUT("/lenda/{lendaId}/professor/{professorId}")
    Call<Lenda> assignProfessor(
            @Path("lendaId") Integer lendaId,
            @Path("professorId") Integer professorId
    );

    @PUT("/professor/{professorId}/department/{departmentId}")
    Call<Professor> assignDepartment(
            @Path("professorId") Integer professorId,
            @Path("departmentId") Integer departmentId
    );



}
