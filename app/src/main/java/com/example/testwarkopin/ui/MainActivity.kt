package com.example.testwarkopin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testwarkopin.R
import com.example.testwarkopin.databinding.ActivityMainBinding
import com.example.testwarkopin.ui.screen.one.ScreenOne
import com.example.testwarkopin.ui.screen.three.ScreenThree
import com.example.testwarkopin.ui.screen.two.ScreenTwo
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity(), MainActivityContract {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupContentView()

        initAction()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding
            .inflate(
                layoutInflater
            )
    }

    private fun setupContentView() {
        val view = binding.root
        setContentView(view)
    }

    private fun initAction() {
        binding.tabLayout.addOnTabSelectedListener(this)
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        when(tab?.text) {
            getString(R.string.label_test_1) -> gotoTabOne()
            getString(R.string.label_test_2) -> gotoTabTwo()
            getString(R.string.label_test_3) -> gotoTabThree()
        }
    }

    override fun gotoTabOne() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, ScreenOne())
            .commit()
    }

    override fun gotoTabTwo() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, ScreenTwo())
            .commit()
    }

    override fun gotoTabThree() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, ScreenThree())
            .commit()
    }
}