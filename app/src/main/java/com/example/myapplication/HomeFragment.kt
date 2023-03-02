package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.viewmodel.LoveViewModel


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val viewModel: LoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calculateLottie.setOnClickListener {
            viewModel.getLiveLove(binding.outlinedTextFieldFname.editText?.text.toString(), binding.outlinedTextFieldSname.editText?.text.toString() )
                .observe(viewLifecycleOwner, Observer {loveModel->
                    findNavController().navigate(R.id.scoreFragment, bundleOf(
                        "model" to loveModel
                    ))
                })
        }
    }
}