package com.example.testwarkopin.ui

import android.view.View
import android.view.View.OnClickListener
import com.example.testwarkopin.R
import com.google.android.material.tabs.TabLayout

interface MainActivityContract : TabLayout.OnTabSelectedListener {

    override fun onTabSelected(tab: TabLayout.Tab?) {}
    override fun onTabUnselected(tab: TabLayout.Tab?) {}
    override fun onTabReselected(tab: TabLayout.Tab?) {}

    fun gotoTabOne()
    fun gotoTabTwo()
    fun gotoTabThree()

}