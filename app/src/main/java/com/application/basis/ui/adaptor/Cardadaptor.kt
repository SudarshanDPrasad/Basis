package com.application.basis.ui.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.application.basis.R
import com.application.basis.databinding.ItemLayoutBinding
import com.application.basis.local.data.Data

/**
 * Adapter and Holder Class where we assign the values for the item layout from the model class
 */
class CardAdapter(
    private val viewPager2: ViewPager2,
    val list: ArrayList<Data>,
) : RecyclerView.Adapter<CardAdapter.CardHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {

        val itemLayoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_layout, parent, false)

        return CardHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val listData = list[position]
        holder.setData(listData)
        if (position == list.size - 2) {
            viewPager2.post(run)
        }
    }

    /**
     * Function for the Restart of the card Holder
     */
    private val run = Runnable {
        list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class CardHolder(
        private val itemLayoutBinding: ItemLayoutBinding,
    ) : RecyclerView.ViewHolder(itemLayoutBinding.root) {

        fun setData(data: Data) {
            itemLayoutBinding.Responsetext.text = data.text
            itemLayoutBinding.ResponseId.text = data.id
        }
    }
}

