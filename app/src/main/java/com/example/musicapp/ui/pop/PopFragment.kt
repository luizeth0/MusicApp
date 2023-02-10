package com.example.musicapp.ui.pop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.musicapp.databinding.FragmentPopBinding
import com.example.musicapp.viewmodel.MusicAppViewModel

class PopFragment : Fragment() {

    private val binding by lazy {
        FragmentPopBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val popViewModel =
            ViewModelProvider(this).get(PopViewModel::class.java)


        val textView: TextView = binding.textNotifications
        popViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}