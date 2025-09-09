package com.solera.resources

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.solera.resources.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {
    private lateinit var binding: FragmentCharacterBinding
    companion object {
        private const val ARG_IMAGE_RES_ID = "imageResId"
        private const val ARG_TEXT = "characterText"
        fun newInstance(imageResId: Int, characterText: String): CharacterFragment {
            val fragment = CharacterFragment()
            val args = Bundle()
            args.putInt(ARG_IMAGE_RES_ID, imageResId)
            args.putString(ARG_TEXT, characterText)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?  {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        val imageResId = arguments?.getInt(ARG_IMAGE_RES_ID) ?: R.drawable.diane_sanchez
        val characterText = arguments?.getString(ARG_TEXT) ?: "Character Name"
        binding.imageViewCharacter.setImageResource(imageResId)
        binding.textViewCharacter.text = characterText
        return binding.root
    }
}
