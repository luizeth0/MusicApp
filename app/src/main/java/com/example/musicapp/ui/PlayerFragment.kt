package com.example.musicapp.ui



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.musicapp.databinding.FragmentPlayerBinding
import com.example.musicapp.viewmodel.MusicAppViewModel
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem


class PlayerFragment (): Fragment() {

    private val binding by lazy {
        FragmentPlayerBinding.inflate(layoutInflater)
    }

    private val musicAppViewModel: MusicAppViewModel by activityViewModels()

    private var uriTrack = ""
    private var exoPlayer: ExoPlayer? = null
    private var playBackPosition = 0L
    private var playWhenReady = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        uriTrack = musicAppViewModel.songUri
        preparePlayer()

        // Inflate the layout for this fragment
        return binding.root
    }


    //ExoPlayer settings
    private fun preparePlayer() {

        try {
            exoPlayer = context?.let { ExoPlayer.Builder(it).build() }
            exoPlayer?.playWhenReady = true
            binding.playerView.player = exoPlayer
            val mediaItem = MediaItem.fromUri(uriTrack)
            exoPlayer?.setMediaItem(mediaItem)
            exoPlayer?.seekTo(playBackPosition)
            exoPlayer?.playWhenReady = playWhenReady
            exoPlayer?.mediaMetadata


            exoPlayer?.prepare()
        } catch (e: java.lang.Exception) {
            e.message
        }

    }

    //Stop exoplayer buffering
    private fun releaseExoPlayer() {
        exoPlayer?.let {
            playBackPosition = it.currentPosition
            playWhenReady = it.playWhenReady
            it.release()
            exoPlayer = null
        }
    }

    override fun onStop() {
        super.onStop()
        releaseExoPlayer()
    }

    override fun onPause() {
        super.onPause()
        releaseExoPlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        releaseExoPlayer()
    }


}

