## Besinler Kitabı Uygulamam
kod satırlarını açık olarak paylaşmış bulunmaktayım .incelemek isteyen bakabilir. Arayüzü geliştirilebilir.
Mvvm, Retrofit, Glide or picasso, RecyclerView,Room,DataBındıng teknolojileri kullanarak besinlerin besin özelliklerine ait uygulama yaptım.Detaya girmem gerekirse ;

Besinlerimiz bir API'den gelmektedir.Retrofit yardımıyla bu API'yi işledim.Ve uygulamama ROOM teknolojisini entegre ederek kendimi geliştirmek istedim.Uygulamam ilk başladığında verileri API'den çekiyor ve bunu database'e kaydediyor.Uygulumama zamanlayıcı koyarak 10 dk da bir API'den verileri tekrar çeker 10 dk dolmadıysa eğer verileri Room'dan çekmektedir. <br><br>
Ugulamama bir SwipeRefreshLayout ekleyerek kullanıcı sayfayı yenilediğinde uygulamam anlayacak ve verileri tekrardan API'den çekecektir.Kullanıcıya verilerin nereden çekildiğine dair bir uyarı mesajı oluşturdum.
**********
## kullandığım Teknolojiler

### - MVVM (Model, View, ViewModel)
### - LiveData
### - DataBinding
### - Retrofit ([Source](https://square.github.io/retrofit/))
### - Navigation Component(NavGraph, BottomNav)
### - Glide ([Source](https://github.com/bumptech/glide))
### - ROOM 
### - RecyclerView 


**********

<img width="200" height="320" src="https://github.com/musasoydas/BesinlerKitabi/blob/main/BesinlerKitabi/ekranG%C3%B6r%C3%BCnt%C3%BCleri/Screenshot_1677784369.png">
<img width="200" height="320" src="https://github.com/musasoydas/BesinlerKitabi/blob/main/BesinlerKitabi/ekranG%C3%B6r%C3%BCnt%C3%BCleri/Screenshot_1677784379.png">
<img width="200" height="320" src="https://github.com/musasoydas/BesinlerKitabi/blob/main/BesinlerKitabi/ekranG%C3%B6r%C3%BCnt%C3%BCleri/Screenshot_1677784383.png">
<img width="200" height="320" src="https://github.com/musasoydas/BesinlerKitabi/blob/main/BesinlerKitabi/ekranG%C3%B6r%C3%BCnt%C3%BCleri/Screenshot_1677784396.png">
<img width="200" height="320" src="https://github.com/musasoydas/BesinlerKitabi/blob/main/BesinlerKitabi/ekranG%C3%B6r%C3%BCnt%C3%BCleri/Screenshot_1677784402.png">
<img width="200" height="320" src="https://github.com/musasoydas/BesinlerKitabi/blob/main/BesinlerKitabi/ekranG%C3%B6r%C3%BCnt%C3%BCleri/Screenshot_1677784461.png">
