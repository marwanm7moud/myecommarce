package com.example.myecommarce.ui.starting.onboarding

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.myecommarce.R
import com.example.myecommarce.adapters.OnBoardingViewPagerAdapter
import com.example.myecommarce.ui.main.MainScreen
import com.example.myecommarce.ui.starting.onboarding.onboardingScreens.FirstScreen
import com.example.myecommarce.ui.starting.onboarding.onboardingScreens.SecondScreen
import com.example.myecommarce.ui.starting.onboarding.onboardingScreens.ThirdScreen
import com.example.myecommarce.utils.Components
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator


class onBoarding : Fragment() {
    private var dots: SpringDotsIndicator? = null
    private var viewpager: ViewPager2? = null
    private var getStarted:Button ?=null




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        checkOnBoarding()
        val view = inflater.inflate(R.layout.fragment_on_boarding, container, false)
        viewpager = view.findViewById(R.id.vp)
        val list = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )
        viewpager?.adapter =
            OnBoardingViewPagerAdapter(requireActivity().supportFragmentManager, lifecycle, list)
        dots = view.findViewById(R.id.dots_indicator)
        dots?.attachTo(viewpager!!)
        getStarted = view.findViewById(R.id.get_Started)
        getStarted?.setOnClickListener {
            getStaredClick()
        }
        return view
    }

    fun getStaredClick(){
        val sharedpref :SharedPreferences=Components.getSharedPref(requireContext())
        val editor = sharedpref.edit()
        editor.putBoolean(Components.ON_BOARDING , true)
        editor.commit()
        findNavController().navigate(R.id.action_onBoarding_to_login)
    }
    fun checkOnBoarding(){
        val sharedpref :SharedPreferences=Components.getSharedPref(requireContext())
        val onBoardingBool = sharedpref.getBoolean(Components.ON_BOARDING , false)
        val tokenBool = sharedpref.getString(Components.TOKEN , null)
        Log.d("marwan" , tokenBool.toString())
        if(tokenBool != null){
            Log.d("marwan" , tokenBool)
            startActivity(Intent(requireActivity() , MainScreen::class.java))
            activity?.finish()
        }else if(onBoardingBool){
            findNavController().navigate(R.id.action_onBoarding_to_login)
        }
    }

}