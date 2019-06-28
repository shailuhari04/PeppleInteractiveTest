package com.peopleinteractivetest.remote;

import com.peopleinteractivetest.pojo.response.UserResultResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("api/")
    Observable<UserResultResponse> getUsers(@Query("results") int limit);
}
