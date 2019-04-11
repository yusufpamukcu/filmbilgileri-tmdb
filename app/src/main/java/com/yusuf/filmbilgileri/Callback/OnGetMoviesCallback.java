package com.yusuf.filmbilgileri.Callback;


import com.yusuf.filmbilgileri.View.Movie;

import java.util.List;

public interface OnGetMoviesCallback {

    void onSuccess(int page, List<Movie> movies);

    void onError();
}
