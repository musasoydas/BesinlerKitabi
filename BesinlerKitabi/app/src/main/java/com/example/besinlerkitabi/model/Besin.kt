package com.example.besinlerkitabi.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
// 25  data sınıfını veri çekeceksek veya verilerle işlemler yapcaksak data class yapabiliriz
//https://github.com/atilsamancioglu/BTK20-JSONVeriSeti/blob/master/besinler.json adresinden gelen json dosyasını bur   a işleyeceğimizden dolayı değerleri buldan aldık
//gelen değişken adlarıyla aynıda yazabiliriz. -26 BesinRecyclerAdapter git
@Entity
data class Besin(
    @ColumnInfo(name="isim")
    @SerializedName("isim")
    val isim: String?,

    @ColumnInfo(name="kalori")
    @SerializedName("kalori")
    val kalori: String?,

    @ColumnInfo(name="karbonhidrat")
    @SerializedName("karbonhidrat")
    val karbonhidrat: String?,

    @ColumnInfo(name="protein")
    @SerializedName("protein")
    val protein: String?,

    @ColumnInfo(name="yag")
    @SerializedName("yag")
    val yag: String?,

    @ColumnInfo(name="gorsel")
    @SerializedName("gorsel")
    val gorsel: String?
) {
    @PrimaryKey(autoGenerate = true)
    var uuid:Int=0


}