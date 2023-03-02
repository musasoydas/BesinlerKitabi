package com.example.besinlerkitabi.servis

import com.example.besinlerkitabi.model.Besin
import io.reactivex.Single
import retrofit2.http.GET

interface BesinAPI {
     //GET / POST
    //GET VERİ ÇEKMEK, POST: VERİ GÖNDERMEK
    // https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json
    //@GET VERİ ÇEKECEĞİ URL ancak ikiye bölüyoruz
    //Base Url=https://raw.githubusercontent.com/ ana url haricindeki yeri yapıştır

    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    fun getBesin(): Single<List<Besin>>
}