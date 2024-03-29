package com.alya.youtubeapi.core.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alya.youtubeapi.data.remote.model.Item
import com.alya.youtubeapi.databinding.ItemPlaylistBinding
import com.alya.youtubeapi.data.remote.model.Playlists
import com.bumptech.glide.Glide
import kotlin.reflect.KFunction1

class PlaylistAdapter(
    val onItemClick: KFunction1<Item, Unit>
): RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {
    private val playlist= arrayListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind(playlist[position])

    }

    fun setItem(list: List<Item>) {
        playlist.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return playlist.size

    }

    inner class PlaylistViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(playlists: Item) {
            if (playlists.snippet.thumbnails.maxres?.url != null)
                Glide.with(binding.imgVideo).load(playlists.snippet.thumbnails.medium.url)
                .into(binding.imgVideo)
            binding.videoSeries.text = playlists.contentDetails.itemCount.toString().plus(" video series")
            binding.tvDesc.text = playlists.snippet.title
            itemView.setOnClickListener {
                onItemClick(playlists)
            }
        }
    }
}