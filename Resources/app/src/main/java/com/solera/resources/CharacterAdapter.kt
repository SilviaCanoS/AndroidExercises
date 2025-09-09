package com.solera.resources

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CharacterAdapter(activity: FragmentActivity, private val count: Int)
    : FragmentStateAdapter(activity) {

    // Example image resource IDs. Replace/add your own drawable resources as needed.
    private val imageResIds = listOf(
        R.drawable.diane_sanchez,
        R.drawable.bar_girl,
        R.drawable.jacqueline,
        R.drawable.jessica,
        R.drawable.spatial_beth,
        R.drawable.unity
    )

    private val characterNames = listOf(
        "Diane Sanchez",
        "A girl in a bar",
        "Jacqueline",
        "Jessica",
        "Spatial Beth",
        "Unity"
    )
    override fun getItemCount(): Int = count
    override fun createFragment(position: Int): Fragment {
        val imageResId = imageResIds.getOrNull(position) ?: R.drawable.diane_sanchez
        val characterName = characterNames.getOrNull(position) ?: "Character Name"
        return CharacterFragment.newInstance(imageResId, characterName)
    }
}