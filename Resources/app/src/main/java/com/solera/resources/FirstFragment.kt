package com.solera.resources

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.solera.resources.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Toast.makeText(context, "First Fragment Attached", Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        Toast.makeText(requireContext(), "First Fragment Resumed", Toast.LENGTH_SHORT).show()
    }
    override fun onStart() {
        super.onStart()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
       Toast.makeText(requireContext(), "First Fragment Created", Toast.LENGTH_SHORT).show()
        return binding.root
    }
}