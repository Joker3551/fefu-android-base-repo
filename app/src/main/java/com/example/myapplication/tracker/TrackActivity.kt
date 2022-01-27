package com.example.myapplication.tracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityTrackerBinding
import com.example.myapplication.R
import com.example.myapplication.tracker.fragment.ActivityFragment
import com.example.myapplication.tracker.fragment.MetaFragment
import com.example.myapplication.tracker.fragment.ProfileFragment


class TrackerActivity : AppCompatActivity(R.layout.activity_tracker) {
    private lateinit var binding: ActivityTrackerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTrackerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActivity(savedInstanceState)
        setupNavbarHandling()
    }

    private fun setupActivity(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(
                    R.id.fragment_view_tracker,
                    ActivityFragment.newInstance(),
                    ActivityFragment.tag
                )
                commit()
            }
        }
    }

    private fun setupNavbarHandling() {
        val metaFragments = listOf(
            MetaFragment(R.id.action_activity_tracker, getFragment(ActivityFragment.tag),
                ActivityFragment.tag),
            MetaFragment(R.id.action_profile_tracker, getFragment(ProfileFragment.tag),
                ProfileFragment.tag)
        )

        val navbarHandler = NavbarHandler(metaFragments, supportFragmentManager)

        binding.navbarTracker.setOnNavigationItemSelectedListener { item ->
            navbarHandler.switchFragments(item.itemId)
            true
        }
    }

    private fun getFragment(tag: String) : Fragment {
        return supportFragmentManager.findFragmentByTag(tag)
            ?: when (tag) {
                ActivityFragment.tag -> ActivityFragment.newInstance()
                ProfileFragment.tag -> ProfileFragment.newInstance()
                else -> return Fragment()
            }
    }
}