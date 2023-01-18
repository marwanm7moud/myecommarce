package com.example.myecommarce.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myecommarce.R
import com.example.myecommarce.adapters.BannersAdapter
import com.example.myecommarce.adapters.CategoryAdapter
import com.example.myecommarce.adapters.OnClickListener
import com.example.myecommarce.data.models.main.Categories.Category
import com.example.myecommarce.data.models.main.banner.BannersData
import com.example.myecommarce.ui.main.MainViewModel
import com.example.myecommarce.ui.main.interfaces.LoadDataValidation
import kotlinx.android.synthetic.main.fragment_home_screen.view.*
import java.util.Timer
import java.util.TimerTask

class HomeScreen : Fragment() ,LoadDataValidation{
    private var mainViewModel: MainViewModel?=null
    var bannersList:List<BannersData>?=null
    var categorylList:List<Category>?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        val view =inflater.inflate(R.layout.fragment_home_screen, container, false)
       loadData(view)












        return view
    }


    private fun setBannerRv(view: View, list: List<BannersData>){
        val layoutInflater= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val bannerAdapter = BannersAdapter(list)
        view.bannerRv.apply {
            layoutManager = layoutInflater
            adapter =  bannerAdapter
            setHasFixedSize(true)
            setItemViewCacheSize(20);

        }
       Timer().schedule(object :TimerTask(){
            override fun run() {
                if (layoutInflater.findLastCompletelyVisibleItemPosition()<bannerAdapter.itemCount-1)
                {
                    layoutInflater.smoothScrollToPosition(view.bannerRv ,RecyclerView.State() , layoutInflater.findLastVisibleItemPosition()+1 )

                }else if(layoutInflater.findLastCompletelyVisibleItemPosition()==bannerAdapter.itemCount-1){
                    layoutInflater.smoothScrollToPosition(view.bannerRv ,RecyclerView.State() , 0 )
                }
            }

        } , 0 , 3000)

    }
    private fun setCategoryRv(view: View, list: List<Category>){
        val layoutInflater= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val categoryAdapter = CategoryAdapter(list , OnClickListener {
            Toast.makeText(requireActivity() , it.name , Toast.LENGTH_SHORT).show()
        })
        view.categoryRV.apply {
            layoutManager = layoutInflater
            adapter = categoryAdapter
            setHasFixedSize(true)
            setItemViewCacheSize(20);
        }



    }


    override fun loadData(view: View){
        loading(view)
        mainViewModel!!.banners.observe(viewLifecycleOwner , Observer{
            if (it!=null){
               setBannerRv(view , it.data)
                bannersList= it.data
            }
        })
        mainViewModel!!.category.observe(viewLifecycleOwner , Observer{
            if (it!=null){
                setCategoryRv(view , it.data.data)
                categorylList = it.data.data
                loaded(view)
            }
        })

    }

    override fun loading(view: View) {
        view.progress_circular_Home.visibility = View.VISIBLE
        view.scrollView.visibility = View.GONE
    }

    override fun loaded(view: View) {
        view.progress_circular_Home.visibility = View.GONE
        view.scrollView.visibility = View.VISIBLE
    }

}