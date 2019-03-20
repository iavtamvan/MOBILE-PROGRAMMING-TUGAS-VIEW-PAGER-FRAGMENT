package com.iav.biodatapager.rest

import com.iav.biodatapager.model.ResponseModel
import retrofit.http.GET
import retrofit.http.Query
import rx.Observable

interface ApiService {

    @GET("eventsnextleague.php")
    fun getNextMatch(@Query("id") id: String): Observable<ResponseModel>

    @GET("lookup_all_teams.php")
    fun getTeamByLigaId(@Query("id") id: String): Observable<ResponseModel>
}