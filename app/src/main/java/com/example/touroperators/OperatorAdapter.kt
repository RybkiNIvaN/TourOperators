package com.example.touroperators

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.touroperators.databinding.OperatorItemBinding


class OperatorAdapter(context: Context) : RecyclerView.Adapter<OperatorAdapter.OperatorHolder>() {
    private var OperatorList = ArrayList<Operator>()

    private var context: Context = context;

    class OperatorHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = OperatorItemBinding.bind(item)

        fun bind(operator: Operator) = with(binding) {
            im.setImageResource(operator.imgId)
            textTitle.text = operator.name
            rating.text = operator.rating
            phone.text = operator.phone
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperatorHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.operator_item, parent, false)
        return OperatorHolder(view)
    }

    override fun onBindViewHolder(holder: OperatorHolder, position: Int) {
        holder.bind(OperatorList[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(context, OperatorActivity::class.java)
            intent.putExtra("id", OperatorList[position].id)
            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return OperatorList.size
    }

    fun addOperator(operator: Operator) {
        OperatorList.add(operator)
        notifyDataSetChanged()
    }

    fun setList(list: ArrayList<Operator>) {
        OperatorList = list
        notifyDataSetChanged()
    }
}