package com.application.basis.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.application.basis.R
import com.application.basis.adaptor.cardadaptor
import com.application.basis.local.data.Data
import com.application.basis.viewmodel.CardViewModel
import com.application.sunstonekotlinassignment.data.Status
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import me.relex.circleindicator.CircleIndicator3


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var cardViewModel: CardViewModel
    private var list = emptyList<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardViewModel = ViewModelProviders.of(this).get(CardViewModel::class.java)

        cardViewModel.getData().observe(this, {
            when (it.status) {
                Status.SUCCESS -> {
                    list = it.data?.data!!
                    val adaptor = cardadaptor(list)
                    viewPager.adapter = adaptor
                    val indicator = findViewById<CircleIndicator3>(R.id.indicator)
                    indicator.setViewPager(viewPager)
                }
            }
        })
    }
}