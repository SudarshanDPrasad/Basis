package com.application.basis.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.application.basis.R
import com.application.basis.ui.adaptor.cardadaptor
import com.application.basis.local.data.Data
import com.application.basis.ui.viewmodel.CardViewModel
import com.application.sunstonekotlinassignment.data.Status
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

        cardViewModel = ViewModelProvider(this).get(CardViewModel::class.java)

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