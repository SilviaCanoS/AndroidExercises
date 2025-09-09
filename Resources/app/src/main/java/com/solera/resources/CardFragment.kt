package com.solera.resources

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class CardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.card_item, container, false)
        val message = arguments?.getString("message") ?: ""
        val imageRes = arguments?.getInt("image") ?: 0
        val imgView = view.findViewById<ImageView>(R.id.iv)
        val textView = view.findViewById<TextView>(R.id.tv)
        imgView.setImageResource(imageRes)
        textView.text = message
        return view
    }

    companion object {
        fun newInstance(message: String, image: Int): CardFragment {
            val fragment = CardFragment()
            val args = Bundle()
            args.putString("message", message)
            args.putInt("image", image)
            fragment.arguments = args
            return fragment
        }
    }
}

