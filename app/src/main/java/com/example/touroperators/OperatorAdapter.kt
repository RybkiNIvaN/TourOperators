package com.example.touroperators

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.touroperators.databinding.OperatorItemBinding


class OperatorAdapter: RecyclerView.Adapter<OperatorAdapter.OperatorHolder>() {
    private var OperatorList = ArrayList<Operator>()

    class OperatorHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = OperatorItemBinding.bind(item)
        fun bind(operator: Operator) = with(binding) {
            im.setImageResource(operator.imageId)
            textTitle.text = operator.title


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperatorHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.operator_item, parent, false)
        return OperatorHolder(view)
    }

    override fun onBindViewHolder(holder: OperatorHolder, position: Int) {
        holder.bind(OperatorList[position])





    }
    override fun getItemCount(): Int {
        return OperatorList.size
    }

    fun addOperator(operator: Operator) {
        OperatorList.add(operator)
        notifyDataSetChanged()
    }


}