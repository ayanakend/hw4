package com.example.myapplication.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.HistoryItemBinding
import com.example.myapplication.remote.LoveModel

class HistoryAdapter(): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    var models = arrayListOf <LoveModel>()
    fun addLoves(list: List<LoveModel>) {
        models.clear()
        models.addAll(list)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            HistoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int {
        return  models.size
    }
    inner class HistoryViewHolder(private val binding: HistoryItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel){
            with(binding){
                fnameTv.text = loveModel.firstName
                snameTv.text = loveModel.secondName
                percentageTv.text = loveModel.percentage
            }
        }
    }
}