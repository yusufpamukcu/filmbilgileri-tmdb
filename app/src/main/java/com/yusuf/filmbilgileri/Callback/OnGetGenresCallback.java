package com.yusuf.filmbilgileri.Callback;


import com.yusuf.filmbilgileri.View.Genre;

import java.util.List;

public interface OnGetGenresCallback {

    void onSuccess(List<Genre> genres);

    void onError();
}
