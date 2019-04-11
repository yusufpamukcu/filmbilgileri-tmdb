package com.yusuf.filmbilgileri;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesRepository {

    public static final String SEARCH = "query";
    public static final String POPULAR = "popular";
    public static final String TOP_RATED = "top_rated";
    public static final String UPCOMING = "upcoming";
    public static final String NOWAY = "now_playing";

    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String LANGUAGE = "TR-tr";

    private static MoviesRepository repository;

    private TMDbApi api;

    private MoviesRepository(TMDbApi api) {
        this.api = api;
    }

    public static MoviesRepository getInstance() {
        if (repository == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            repository = new MoviesRepository(retrofit.create(TMDbApi.class));
        }

        return repository;
    }

    public void getMovies(int page, String sortBy,String searchname, final OnGetMoviesCallback callback) {
        Callback<MoviesResponse> call = new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if (response.isSuccessful()) {
                    MoviesResponse moviesResponse = response.body();
                    if (moviesResponse != null && moviesResponse.getMovies() != null) {
                        callback.onSuccess(moviesResponse.getPage(), moviesResponse.getMovies());
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                callback.onError();
            }
        };

        switch (sortBy) {
            case SEARCH:
                api.getSearchMovies("686ee415b37bc3d915b95ac041f1916f", LANGUAGE, page,searchname)
                        .enqueue(call);
                break;
            case TOP_RATED:
                api.getTopRatedMovies("686ee415b37bc3d915b95ac041f1916f", LANGUAGE, page)
                        .enqueue(call);
                break;
            case UPCOMING:
                api.getUpcomingMovies("686ee415b37bc3d915b95ac041f1916f", LANGUAGE, page)
                        .enqueue(call);
                break;
            case NOWAY:
                api.getNowMovies("686ee415b37bc3d915b95ac041f1916f", LANGUAGE, page)
                        .enqueue(call);
                break;
            case POPULAR:
                api.getPopularMovies("686ee415b37bc3d915b95ac041f1916f", LANGUAGE, page)
                        .enqueue(call);
                break;
            default:
                api.getPopularMovies("686ee415b37bc3d915b95ac041f1916f", LANGUAGE, page)
                        .enqueue(call);
                break;
        }
    }

    public void getGenres(final OnGetGenresCallback callback) {
        api.getGenres("686ee415b37bc3d915b95ac041f1916f", LANGUAGE)
                .enqueue(new Callback<GenresResponse>() {
                    @Override
                    public void onResponse(Call<GenresResponse> call, Response<GenresResponse> response) {
                        if (response.isSuccessful()) {
                            GenresResponse genresResponse = response.body();
                            if (genresResponse != null && genresResponse.getGenres() != null) {
                                callback.onSuccess(genresResponse.getGenres());
                            } else {
                                callback.onError();
                            }
                        } else {
                            callback.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<GenresResponse> call, Throwable t) {
                        callback.onError();
                    }
                });
    }

    public void getMovie(int movieId, final OnGetMovieCallback callback) {
        api.getMovie(movieId, "686ee415b37bc3d915b95ac041f1916f", LANGUAGE)
                .enqueue(new Callback<Movie>() {
                    @Override
                    public void onResponse(Call<Movie> call, Response<Movie> response) {
                        if (response.isSuccessful()) {
                            Movie movie = response.body();
                            if (movie != null) {
                                callback.onSuccess(movie);
                            } else {
                                callback.onError();
                            }
                        } else {
                            callback.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<Movie> call, Throwable t) {
                        callback.onError();
                    }
                });
    }




}
