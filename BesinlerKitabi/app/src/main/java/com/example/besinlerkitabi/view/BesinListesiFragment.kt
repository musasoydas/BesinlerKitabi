package com.example.besinlerkitabi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.besinlerkitabi.R
import com.example.besinlerkitabi.adapter.BesinRecyclerAdapter
import com.example.besinlerkitabi.viewmodel.BesinListesiViewModel
import kotlinx.android.synthetic.main.fragment_besin_listesi.*





class BesinListesiFragment : Fragment() {
 //34
    private lateinit var viewModel: BesinListesiViewModel
    private val recyclerBesinAdapter=BesinRecyclerAdapter(arrayListOf())


    // 6 fragmenlere bak
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_besin_listesi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//35
        viewModel=ViewModelProvider(this).get(BesinListesiViewModel::class.java)
        viewModel.refreshData()
//36
        besinListRecyclerView.layoutManager=LinearLayoutManager(context)
        besinListRecyclerView.adapter=recyclerBesinAdapter
        swipeRefreshLayout.setOnRefreshListener {
            besinYukleniyor.visibility=View.VISIBLE
            besinHataMesaji.visibility=View.INVISIBLE
            besinListRecyclerView.visibility=View.INVISIBLE
            viewModel.refreshFromInternet()
            swipeRefreshLayout.isRefreshing=false
        }

        observeLiveData()

    }
    //37
    fun observeLiveData()
    {
        viewModel.besinler.observe(viewLifecycleOwner, Observer { besinler ->
             besinler?.let {
                 besinListRecyclerView.visibility= View.VISIBLE
                 recyclerBesinAdapter.besinListesiniGuncelle(besinler)

             }
        })
        viewModel.besinHataMesaji.observe(viewLifecycleOwner, Observer {hata ->
            hata?.let {
                if(it==true)
                {
                    besinHataMesaji.visibility=View.VISIBLE
                    besinListRecyclerView.visibility=View.INVISIBLE
                    besinYukleniyor.visibility=View.INVISIBLE
                }
                else
                    besinHataMesaji.visibility=View.INVISIBLE
            }

        })

       viewModel.besinYukleniyor.observe(viewLifecycleOwner, Observer { yukleniyor ->
            yukleniyor?.let {
                if(it==true)
                {
                    besinListRecyclerView.visibility=View.INVISIBLE
                    besinHataMesaji.visibility=View.INVISIBLE
                    besinYukleniyor.visibility=View.VISIBLE
                }
                else
                    besinYukleniyor.visibility=View.INVISIBLE
            }

        })
    }



}