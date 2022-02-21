package com.example.teamup.view.features.launcher

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.teamup.R
import com.example.teamup.tools.Utils.initStatusBar
import com.example.teamup.view.features.launcher.adapter.IntroViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_intro_viewpager.*

class IntroViewPagerFragment : Fragment(R.layout.fragment_intro_viewpager) {


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initStatusBar(R.color.firstPage1, requireActivity())
        changeRootBackgroundColor(R.color.firstPage1)


        val fragmentList = arrayListOf(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment(),
            ForthScreenFragment()
        )

        val adapter = IntroViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        viewPager2.adapter = adapter

        TabLayoutMediator(intro_tab_layout, viewPager2)
        { tab, position -> }.attach()

        intro_tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        initStatusBar(R.color.firstPage1, requireActivity())
                        //changeRootBackgroundColor(R.color.firstPage1)
                    }
                    1 -> {
                        initStatusBar(R.color.firstPage2, requireActivity())
                        changeRootBackgroundColor(R.color.firstPage2)
                    }
                    2 -> {
                        initStatusBar(R.color.firstPage3, requireActivity())
                        changeRootBackgroundColor(R.color.firstPage3)
                    }
                    3 -> {
                        initStatusBar(R.color.firstPage4, requireActivity())
                        changeRootBackgroundColor(R.color.firstPage4)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    private fun changeRootBackgroundColor(color: Int) {
        rootIntroFragment.setBackgroundColor(ContextCompat.getColor(requireContext(), color))
    }
}