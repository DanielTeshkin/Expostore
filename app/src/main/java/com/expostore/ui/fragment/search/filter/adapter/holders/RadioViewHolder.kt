package com.expostore.ui.fragment.search.filter.adapter.holders

import android.R
import android.content.Context
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import com.expostore.databinding.RadioFilterItemBinding
import com.expostore.model.category.CategoryCharacteristicModel
import com.expostore.ui.fragment.search.filter.adapter.utils.FilterState

class RadioViewHolder(private val binding:RadioFilterItemBinding, private val ourContext: Context,private  val state: FilterState?):BaseFilterHolder(binding.root,ourContext,state) {
    override fun bind(categoryCharacteristicModel: CategoryCharacteristicModel) {
        val list=ArrayList<String>()
        binding.etCity.hint=categoryCharacteristicModel.name
        val hashMap=LinkedHashMap<String,String>()
        categoryCharacteristicModel.listValue.map {
            list.add(it.value?:"")
            hashMap.put(it.value?:"",it.id?:"")
        }
        val array =list.toTypedArray()
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(ourContext, R.layout.simple_dropdown_item_1line, array)
        binding.etCity.setAdapter(adapter)
        binding.etCity.addTextChangedListener {
            state?.radioListener(hashMap.getValue(it.toString()),categoryCharacteristicModel.name)
        }
    }
}