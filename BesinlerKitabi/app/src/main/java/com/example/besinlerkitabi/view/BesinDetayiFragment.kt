package com.example.besinlerkitabi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.besinlerkitabi.R
import com.example.besinlerkitabi.databinding.FragmentBesinDetayiBinding
import com.example.besinlerkitabi.util.gorselIndir
import com.example.besinlerkitabi.util.placeHolderYap
import com.example.besinlerkitabi.viewmodel.BesinDetayiViewModel
import kotlinx.android.synthetic.main.fragment_besin_detayi.*

class BesinDetayiFragment : Fragment() {

    private lateinit var viewModel: BesinDetayiViewModel
    private var besinId = 0
    private lateinit var dataBinding:FragmentBesinDetayiBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_besin_detayi,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //eğer argümanlar vasa
        arguments?.let {
            besinId= BesinDetayiFragmentArgs.fromBundle(it).besinId

        }
        viewModel = ViewModelProvider(this).get(BesinDetayiViewModel::class.java)
        viewModel.roomVerisiniAlma(besinId)


        observeLiveData()

    }

    fun observeLiveData() {
        viewModel.besinLiveData.observe(viewLifecycleOwner, Observer { besin ->
            besin?.let {
                /*
                detay_isim.text = it.isim
                detay_kalori.text = it.kalori
                detay_karbonhidrat.text = it.karbonhidrat
                detay_yag.text = it.yag
                detay_protein.text = it.protein
                context?.let {
                    imageView2.gorselIndir(besin.gorsel, placeHolderYap(it))

                }*/
                dataBinding.secilenBesin=it

            }

        })
    }

}