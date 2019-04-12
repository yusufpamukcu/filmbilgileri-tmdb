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

### Recyclerview - Cardview Tasarım Araçları kullanıldı.

## Eklenebilecek Detaylar
- film detay sayfasında kullanıcı yorumu eklenerek daha işlevsel bir yapı sunulabilir.
- kullanıcının favori film seçmesi sağlanarak bu film kategorilerinden kullanıcıya film önerisi sunulabilir.
- uygulama içerisinden fragman izleme eklenebilir.
- TMDB'nin sunmuş olduğu get/movie/{movie_id}/videos metodu kullanılabilir.
