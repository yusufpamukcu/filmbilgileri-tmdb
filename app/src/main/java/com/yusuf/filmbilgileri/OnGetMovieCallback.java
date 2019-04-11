package com.yusuf.filmbilgileri;


public interface OnGetMovieCallback {

    void onSuccess(Movie movie);

    void onError();
}
