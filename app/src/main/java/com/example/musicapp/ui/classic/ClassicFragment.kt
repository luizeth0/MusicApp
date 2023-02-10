package com.example.musicapp.ui.classic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.musicapp.databinding.FragmentClassicBinding
import com.example.musicapp.viewmodel.MusicAppViewModel

class ClassicFragment : Fragment() {

    private val binding by lazy {
        FragmentClassicBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val classicViewModel =
            ViewModelProvider(this).get(ClassicViewModel::class.java)

        val textView: TextView = binding.textDashboard
        classicViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}