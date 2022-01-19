package com.application.basis.ui.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.application.basis.R
import com.application.basis.databinding.ItemLayoutBinding
import com.application.basis.local.data.Data

class cardadaptor(
    val list: List<Data>,
) : RecyclerView.Adapter<cardholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardholder {

        val itemLayoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_layout, parent, false)

        return cardholder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: cardholder, position: Int) {
        val listdata = list[position]
        holder.setData(listdata)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class cardholder(
    val itemLayoutBinding: ItemLayoutBinding,
) : RecyclerView.ViewHolder(itemLayoutBinding.root) {


    fun setData(data: Data) {
        itemLayoutBinding.Responsetext.text = data.text
        itemLayoutBinding.ResponseId.text = data.id
    }

}
