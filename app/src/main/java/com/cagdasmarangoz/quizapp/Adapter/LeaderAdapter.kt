package com.cagdasmarangoz.quizapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cagdasmarangoz.quizapp.Adapter.LeaderAdapter.ViewHolder
import com.cagdasmarangoz.quizapp.domain.UserModel
import com.cagdasmarangoz.quizapp.databinding.ViewholderLeaderBinding

class   LeaderAdapter : RecyclerView.Adapter<ViewHolder>() {
    private lateinit var binding: ViewholderLeaderBinding

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ViewholderLeaderBinding.inflate(inflater, parent, false)
        return ViewHolder()

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = ViewholderLeaderBinding.bind(holder.itemView)
        binding.titleTxt.text = differ.currentList[position].name
        val drawableResourceId: Int = binding.root.resources.getIdentifier(
            differ.currentList[position].pic,
            "drawable",
            binding.root.context.packageName
        )
        Glide.with(binding.root.context).load(drawableResourceId).load(binding.pic)
        binding.rowTxt.text = (position + 4).toString()
        binding.scoreTx.text = differ.currentList[position].score.toString()
    }

    override fun getItemCount() = differ.currentList.size


    private val differCallback = object : DiffUtil.ItemCallback<UserModel>() {
        override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)
}