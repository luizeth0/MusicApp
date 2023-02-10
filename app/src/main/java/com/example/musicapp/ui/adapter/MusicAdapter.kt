package com.example.musicapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicapp.R
import com.example.musicapp.databinding.MusicViewItemBinding

class MusicAdapter(
    private val itemSet: MutableList<com.example.musicapp.model.Result> = mutableListOf(),
    private val onItemClick: (itemId: String) -> Unit
) :  RecyclerView.Adapter<MusicViewHolder>() {

    fun updateItems(newItems: List<com.example.musicapp.model.Result>) {
        if (itemSet != newItems) {
            itemSet.clear()
            itemSet.addAll(newItems)

            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder =
        MusicViewHolder(
            MusicViewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) =
        holder.bind(itemSet[position], onItemClick)

    override fun getItemCount(): Int = itemSet.size
}

class MusicViewHolder(
    private val binding: MusicViewItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun Double.format(digits: Int) = "%.${digits}f".format(this)

    fun bind(item: com.example.musicapp.model.Result, onItemClick: (String) -> Unit) {
        binding.songImageItem.setImageResource(R.drawable.ic_launcher_foreground)
        binding.songArtistItem.text = item.artistName
        binding.songCollectionItem.text = item.trackName ?: item.collectionName
        val songPrice = if (item.trackName != null)
            "${item.trackPrice?.format(2).toString()} USD"
        else
            "${item.collectionPrice?.format(2).toString()} USD"

        binding.songPriceItem.text = songPrice
        Glide
            .with(binding.root)
            .load(item.artworkUrl60)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_notifications_black_24dp)
            .into(binding.songImageItem)

        itemView.setOnClickListener {
            item.previewUrl?.let(onItemClick)

        }

    }
}