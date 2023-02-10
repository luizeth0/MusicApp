package com.example.musicapp.ui.pop

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicapp.R
import com.example.musicapp.databinding.FragmentPopBinding
import com.example.musicapp.model.MusicResponse
import com.example.musicapp.model.Result
import com.example.musicapp.ui.adapter.MusicAdapter
import com.example.musicapp.utils.BaseFragment
import com.example.musicapp.utils.UIState

class PopFragment : BaseFragment() {

    private val binding by lazy {
        FragmentPopBinding.inflate(layoutInflater)
    }

    private val musicAdapter by lazy {
        MusicAdapter {
            Log.d(ContentValues.TAG, "Item Clicked. Preview URL: $it")
            musicViewModel.songUri = it
            findNavController().navigate(R.id.action_navigation_pop_to_player_fragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.rvPop.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
             adapter = musicAdapter
        }
        Log.d(ContentValues.TAG, "onCreateView: ")
        musicViewModel.pop.observe(viewLifecycleOwner) { state ->
            when(state){
                is UIState.LOADING -> {}
                is UIState.SUCCESS<MusicResponse> -> {
                    Log.d(ContentValues.TAG, "onCreateView: ${state.response}")
                    musicAdapter.updateItems((state.response.results ?: emptyList()) as List<Result>)
                }
                is UIState.ERROR -> {
                    state.error.localizedMessage?.let {
                        showError(it) {

                        }
                    }
                }
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}