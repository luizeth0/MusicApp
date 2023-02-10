package com.example.musicapp.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.example.musicapp.databinding.FragmentPlayerBinding
import com.example.musicapp.utils.BaseFragment

class PlayerFragment (): BaseFragment() {

    private var songUri = ""
    private var player : ExoPlayer? = null
    private var playWhenReady = true
    private var currentItem = 0
    private var playBackPosition = 0L

    private val binding by lazy {
        FragmentPlayerBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        getSongUri()
        initializePlayer()
    }

    private fun getSongUri() {
        songUri = musicViewModel.songUri
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
    }



    private fun initializePlayer() {
        player = ExoPlayer.Builder(this.requireContext())
            .build()
            .also {
                binding.videoView.player = it
                if (songUri.isNotEmpty()) {
                    it.setMediaItem(MediaItem.fromUri(songUri.toUri()))

                    it.playWhenReady = playWhenReady
                    it.seekTo(currentItem, playBackPosition)
                    it.prepare()
                } else {
                    Log.d(TAG, "initializePlayer: songUri value is an empty String")
                }
            }
    }

    private fun releasePlayer() {
        player?.let {
            playWhenReady = it.playWhenReady
            currentItem = it.currentMediaItemIndex
            playBackPosition = it.currentPosition
            it.release()
        }
        player = null
    }

}