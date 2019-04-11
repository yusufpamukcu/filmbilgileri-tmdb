# Film Bilgileri 
## themoviedb api kullanılarak
- "Popüler" 
- "TMDB Top" 
- "Yakında" 
- "Vizyondakiler"
- "Arama" 
Araçları yer almaktadır.


## Kullanılan Teknolojiler
- TMDb API – Projenin ana amacının işleyişi için TMDB Apiden destek alındı.
- Retrofit – REST istemcisi kullanılarak api ile kesintisiz konuşmayı sağladım.
- Gson – Json -> JAVA -> Json dönüşümü için kullanıldı.
- Glide – Resimlerin yüklenmesi ve akan sayfa için ram sorununu düşünmemek için kullanıldı.

## Ek Olarak
- Açılış ekranı eklenmiştir.
- Sonsuz kaydırma aktiftir. (Film listesi bitene dek kaydırma devam eder)
### kaydırma işlemi detayı
- TMDB Apinin sayfalama özelliği kullnılmıştır her sayfa alta indirildiğinde sayfa değişkeni +1 artmaktadır bu sayede sonsuz kaydırma olanağı sunulmuştur.

[source,java]
----

        private void setupOnScrollListener() {
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        moviesList.setLayoutManager(manager);
        moviesList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int totalItemCount = manager.getItemCount();
                int visibleItemCount = manager.getChildCount();
                int firstVisibleItem = manager.findFirstVisibleItemPosition();
                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    if (!isFetchingMovies) {
                        getMovies(currentPage + 1,"");
                    }
                }
            }
        });
    }

----

- if (firstVisibleItem + visibleItemCount >= totalItemCount / 2)
- if yapısının sağlanması için kullanıcının listede yarıyı geçmiş olması beklenir bu koşul sağlandığında "True" döner ve sayfa değişkeni değişim için alt satırdaki kod çalışır.
- getMovies(currentPage + 1,""); kodu ile sayfa değişkeni +1 artarak devam eder.
