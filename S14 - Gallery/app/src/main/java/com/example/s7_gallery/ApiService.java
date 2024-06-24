package com.example.s7_gallery;

import com.example.app.com.example.s7_gallery.Image;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("path/to/your/api/endpoint")
    Call<List<Image>> getImages();
}
