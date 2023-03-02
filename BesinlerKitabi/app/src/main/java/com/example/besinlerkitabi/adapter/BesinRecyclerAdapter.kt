package com.example.besinlerkitabi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.besinlerkitabi.R
import com.example.besinlerkitabi.databinding.RecyclerRowBinding
import com.example.besinlerkitabi.model.Besin
import com.example.besinlerkitabi.util.gorselIndir
import com.example.besinlerkitabi.util.placeHolderYap
import com.example.besinlerkitabi.view.BesinListesiFragmentDirections
import kotlinx.android.synthetic.main.recycler_row.view.*
import java.util.ArrayList

//26
class BesinRecyclerAdapter(val besinlistesi: ArrayList<Besin>):RecyclerView.Adapter<BesinRecyclerAdapter.BesinViewHolder> () ,BesinClickListener{

    //27
    class BesinViewHolder(var view :RecyclerRowBinding):RecyclerView.ViewHolder(view.root){

    }
// 28 İMPLEMENT ile yapıldı fonksiyonlar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
    //30
    var inflater = LayoutInflater.from(parent.context)
   //  var view=inflater.inflate(R.layout.recycler_row, parent, false) //************** recylerrow bak bakalım
    val view=DataBindingUtil.inflate<RecyclerRowBinding>(inflater,R.layout.recycler_row,parent,false)
    return BesinViewHolder(view)
    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {


        holder.view.besin = besinlistesi[position]
        holder.view.listener=this
/*
     //31 verileri ekrana getiriyoruz
        holder.itemView.besinIsmiText.text=besinlistesi.get(position).isim
        holder.itemView.besinKaloriText.text=besinlistesi.get(position).kalori

         holder.itemView.setOnClickListener {
            val action=BesinListesiFragmentDirections.actionBesinListesiFragmentToBesinDetayiFragment(besinlistesi.get(position).uuid)
            Navigation.findNavController(it).navigate(action)

        }
        holder.itemView.imageView.gorselIndir(besinlistesi.get(position).gorsel, placeHolderYap(holder.itemView.context))*/
    }

    override fun getItemCount(): Int {
        return besinlistesi.size //29 kaç satır oluşturacağını buraya yazıyoruz
    }
//30 - 31 BesinlerListersiViewModel sınıfına git
    fun besinListesiniGuncelle(yeniBesinListesi: List<Besin>){
        besinlistesi.clear()
        besinlistesi.addAll(yeniBesinListesi)
        notifyDataSetChanged()

    }

    override fun besinTiklandi(view: View) {
        val uuids=view.recycler_view_uuid_numarası.text.toString().toIntOrNull ()
        uuids?.let {
            val action=BesinListesiFragmentDirections.actionBesinListesiFragmentToBesinDetayiFragment(it)
            Navigation.findNavController(view).navigate(action)
        }


    }

}