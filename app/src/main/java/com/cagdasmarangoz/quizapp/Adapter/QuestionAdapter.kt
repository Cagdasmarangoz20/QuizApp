package com.cagdasmarangoz.quizapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cagdasmarangoz.quizapp.R
import com.cagdasmarangoz.quizapp.databinding.ViewholderQuestionBinding


data class QuestionAnswer(
    val answer: String,
    val position: Int,
    val type: QuestionAnswerType
)

enum class QuestionAnswerType {
    NONE,
    CORRECT,
    WRONG
}

class QuestionAdapterr(
    private val onItemClick: (QuestionAnswer) -> Unit
) : ListAdapter<QuestionAnswer, QuestionAnswerViewHolder>(
    object : DiffUtil.ItemCallback<QuestionAnswer>() {
        override fun areItemsTheSame(oldItem: QuestionAnswer, newItem: QuestionAnswer): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: QuestionAnswer, newItem: QuestionAnswer): Boolean =
            oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionAnswerViewHolder {
        return QuestionAnswerViewHolder(
            ViewholderQuestionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ) {
            onItemClick.invoke(getItem(it))
        }
    }

    override fun onBindViewHolder(holder: QuestionAnswerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class QuestionAnswerViewHolder(
    private val binding: ViewholderQuestionBinding,
    onItemClick: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {


    init {
        itemView.setOnClickListener {
            onItemClick.invoke(adapterPosition)
        }
    }

    fun bind(item: QuestionAnswer) {
        binding.answerTxt.text = item.answer
        val (bg, icon) = when(item.type){
            QuestionAnswerType.NONE -> Pair(R.drawable.answer_white,null)
            QuestionAnswerType.CORRECT -> Pair(R.drawable.green_bg,R.drawable.tick)
            QuestionAnswerType.WRONG -> Pair(R.drawable.red_bg,R.drawable.thieves)
        }
        binding.answerTxt.setBackgroundResource(bg)
        binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(
            0, 0, icon ?: 0, 0
        )

    }
}