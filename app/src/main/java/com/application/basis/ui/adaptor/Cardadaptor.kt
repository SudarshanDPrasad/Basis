package com.application.basis.ui.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.application.basis.R
import com.application.basis.databinding.ItemLayoutBinding
import com.application.basis.local.data.Data

class cardadaptor(
    val viewPager2: ViewPager2,
    val list: ArrayList<Data>,
) : RecyclerView.Adapter<cardadaptor.cardholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardholder {

        val itemLayoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_layout, parent, false)

        return cardholder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: cardholder, position: Int) {
        val listdata = list[position]
        holder.setData(listdata)
        if (position == list.size - 2) {
            viewPager2.post(run)
        }
    }

    val run = object : Runnable {
        override fun run() {
            list.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class cardholder(
        val itemLayoutBinding: ItemLayoutBinding,
    ) : RecyclerView.ViewHolder(itemLayoutBinding.root) {

        fun setData(data: Data) {
            itemLayoutBinding.Responsetext.text = data.text
            itemLayoutBinding.ResponseId.text = data.id
        }
    }
}

