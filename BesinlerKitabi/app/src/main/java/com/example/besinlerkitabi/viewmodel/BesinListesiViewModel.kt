package com.example.besinlerkitabi.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.besinlerkitabi.model.Besin
import com.example.besinlerkitabi.servis.BesinAPIServis
import com.example.besinlerkitabi.servis.BesinDatabase
import com.example.besinlerkitabi.util.OzelSharedPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

//31 oluştur aşağı satırı
class BesinListesiViewModel(application: Application) : BaseViewModel(application) {
    //32
    val besinler = MutableLiveData<List<Besin>>() //MutableLiveData değiştirilebilir data demek
    val besinHataMesaji = MutableLiveData<Boolean>()
    val besinYukleniyor = MutableLiveData<Boolean>()

    private var guncellemeZamani = 10 * 60 * 1000 * 1000 * 1000L

    private val besinApiServis = BesinAPIServis()
    private val disposable = CompositeDisposable()
    private val ozelSharedPreferences = OzelSharedPreferences(getApplication())

    //33 veri çekme ve veri indirme işlemlerini de viewmodel içersinde yapacaz -34 besinListesifragment
    fun refreshData() {
        val kaydedilmeZamani = ozelSharedPreferences.zamaniAl()
        if (kaydedilmeZamani != null && kaydedilmeZamani != 0L && System.nanoTime() - kaydedilmeZamani < guncellemeZamani) {
            verileriSqlLitedanAl()
        } else {
            verileriInternettenAl()
        }
    }

    fun refreshFromInternet() {
        verileriInternettenAl()
    }

    private fun verileriSqlLitedanAl() {
        launch {
            val besinListesi = BesinDatabase(getApplication()).besinDao().getAllBesin()
            besinleriGoster(besinListesi)
            Toast.makeText(getApplication(), "Besinleri Roomdan Aldık", Toast.LENGTH_LONG).show()
        }

    }

    private fun verileriInternettenAl() {
        besinYukleniyor.value = true

        disposable.add(
            besinApiServis.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Besin>>() {
                    override fun onSuccess(t: List<Besin>) {
                        sqliteSakla(t)
                        Toast.makeText(
                            getApplication(),
                            "Besinleri İnternetten Aldık",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    override fun onError(e: Throwable) {
                        //başarısız olursa
                        besinHataMesaji.value = true
                        besinYukleniyor.value = false
                        e.printStackTrace()

                    }

                })
        )
    }

    private fun besinleriGoster(besinlerListesi: List<Besin>) {
        //başarılı olursa
        besinler.value = besinlerListesi
        besinHataMesaji.value = false
        besinYukleniyor.value = false
    }

    private fun sqliteSakla(besinListesi: List<Besin>) {
        launch {
            val dao = BesinDatabase(getApplication()).besinDao()
            dao.deleteAllBesin()
            val uuidListesi = dao.insertAll(*besinListesi.toTypedArray())
            var i = 0
            while (i < besinListesi.size) {
                besinListesi[i].uuid = uuidListesi[i].toInt()
                i = i + 1
            }
            besinleriGoster(besinListesi)

        }
        ozelSharedPreferences.zamaniKaydet(System.nanoTime())
    }

}