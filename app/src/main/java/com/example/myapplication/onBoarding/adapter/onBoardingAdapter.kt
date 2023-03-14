package com.example.myapplication.onBoarding.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemOnBoardingBinding
import com.example.myapplication.models.onBoard

class onBoardingAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<onBoardingAdapter.onBoardingViewHolger>() {
    var data = arrayListOf(
        onBoard(
            "Скоро на свидание? Узнайте совместимость с партнёром!",
            R.raw.date
        ),
        onBoard(
            "Стоит выходить замуж, или же этот человек не для вас?",
            R.raw.marriage
        ),
        onBoard(
            "Удобный калькулятор у вас в телефоне!",
            R.raw.phone
        ),
        onBoard(
            "Внимание! Приложение не имеет связи с реальным миром. Все совпадения случайны!",
            R.raw.warning
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): onBoardingViewHolger {
        return onBoardingViewHolger(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: onBoardingViewHolger, position: Int) {
        holder.bind(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class onBoardingViewHolger(private val binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoard: onBoard) {
            binding.backgroundIv.setImageResource(onBoard.image)
            binding.messageTw.text = onBoard.message
            binding.getStartBtn.isVisible = adapterPosition == data.lastIndex
            binding.getStartBtn.setOnClickListener{
                onClick()
                Log.e("ololo", "Adapter")
            }
        }
    }

}