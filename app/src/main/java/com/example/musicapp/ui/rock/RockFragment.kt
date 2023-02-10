package com.example.musicapp.ui.rock

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicapp.R
import com.example.musicapp.databinding.FragmentRockBinding
import com.example.musicapp.model.MusicResponse
import com.example.musicapp.model.Result
import com.example.musicapp.ui.adapter.MusicAdapter
import com.example.musicapp.utils.BaseFragment
import com.example.musicapp.utils.UIState

class RockFragment : BaseFragment() {

    private val binding by lazy {
        FragmentRockBinding.inflate(layoutInflater)
    }

    private val musicAdapter by lazy {
        MusicAdapter {
            Log.d(TAG, "Item Clicked. Preview URL: $it")
            musicViewModel.songUri = it
            findNavController().navigate(R.id.action_home_fragment_to_player_fragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        /*val rockViewModel =
            ViewModelProvider(this).get(MusicAppViewModel::class.java)
*/
        /*_binding = FragmentRockBinding.inflate(inflater, container, false)
        val root: View = binding.root*/

        /*val textView: TextView = binding.textHome
        rockViewModel.fragrock.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        binding.rvRock.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            setHasFixedSize(true) // this is to see if it doesn't matter what happens to the
            adapter = musicAdapter
        }
        Log.d(TAG, "onCreateView: ")
        musicViewModel.rock.observe(viewLifecycleOwner) { state ->
            when(state){
                is UIState.LOADING -> {}
                is UIState.SUCCESS<MusicResponse> -> {
                    Log.d(TAG, "onCreateView: ${state.response}")
                    musicAdapter.updateItems((state.response.results ?: emptyList()) as List<Result>)
                }
                is UIState.ERROR -> {
                    showError(state.error.localizedMessage) {

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