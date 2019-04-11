package com.yusuf.filmbilgileri;


import java.util.List;

public interface OnGetMoviesCallback {

    void onSuccess(int page, List<Movie> movies);

    void onError();
}
