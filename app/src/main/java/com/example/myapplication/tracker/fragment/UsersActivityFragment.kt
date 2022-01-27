package com.example.myapplication.tracker.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentUsersActivityBinding
import com.example.myapplication.tracker.Adapter.UsersActivityAdapter

class UsersActivityFragment : Fragment(R.layout.fragment_users_activity) {
    private var _binding: FragmentUsersActivityBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val tag = "users_activity_fragment"

        fun newInstance() : UsersActivityFragment {
            val fragment = UsersActivityFragment()
            fragment.arguments = Bundle()
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycleView = binding.userActivityRecyclerView
        recycleView.layoutManager = LinearLayoutManager(activity)

        recycleView.adapter = parentFragment?.let {
            UsersActivityAdapter(it.parentFragmentManager)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}