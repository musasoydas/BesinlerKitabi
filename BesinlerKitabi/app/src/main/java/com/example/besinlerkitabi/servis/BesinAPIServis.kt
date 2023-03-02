package com.example.besinlerkitabi.servis

import com.example.besinlerkitabi.model.Besin
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class BesinAPIServis {

    // https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json
    //@GET VERİ ÇEKECEĞİ URL ancak ikiye bölüyoruz
    //Base Url=https://raw.githubusercontent.com/ ana url haricindeki yeri yapıştır

    private val BASE_URL="https://raw.githubusercontent.com/"
    private val api=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())//json formatını modele çevirmeye yarıyor
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //arixjava kullanacağımızı belirtiyoruz
        .build().create(BesinAPI::class.java)


    fun getData():Single<List<Besin>>
    {
        return api.getBesin()
    }

}