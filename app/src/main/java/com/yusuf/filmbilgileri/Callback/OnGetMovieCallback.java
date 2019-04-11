package com.yusuf.filmbilgileri.Callback;


import com.yusuf.filmbilgileri.View.Movie;

public interface OnGetMovieCallback {

    void onSuccess(Movie movie);

    void onError();
}
