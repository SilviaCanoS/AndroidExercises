package com.solera.pokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheet: BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottom_sheet, container, false)
        val btClose = view.findViewById<Button>(R.id.btClose)
        val tvName = view.findViewById<TextView>(R.id.tvName)


        btClose.setOnClickListener{
            dismiss()
        }

        return view
    }
}