package com.example.myapplication.tracker.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.database.Activity
import com.example.myapplication.databinding.FragmentMyActivityBinding
import com.example.myapplication.tracker.Adapter.MyActivityAdapter
import com.example.myapplication.tracker.model.DateActivityHandler

class MyActivityFragment : Fragment(R.layout.fragment_my_activity) {
    private var _binding: FragmentMyActivityBinding? = null
    private val binding get() = _binding!!
    private val dateHandler = DateActivityHandler()

    companion object {
        const val tag = "my_activity_fragment"

        fun newInstance(): MyActivityFragment {
            val fragment = MyActivityFragment()
            fragment.arguments = Bundle()
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycleView = binding.myActivityRecyclerView
        recycleView.layoutManager = LinearLayoutManager(activity)

        recycleView.adapter = parentFragment?.let {
            MyActivityAdapter(it.parentFragmentManager)
        }

        MainActivity.INSTANCE.db.activityDao().getAll().observe(viewLifecycleOwner) {
            val adapter = (recycleView.adapter as MyActivityAdapter)
            setDBItems(adapter, it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setDBItems(adapter: MyActivityAdapter, dbList: List<Activity>) {
        if (dbList.isEmpty()) enableWelcomeViews()
        else disableWelcomeViews()

        for (item in dbList) dateHandler.addItem(item)

        adapter.submitList(dateHandler.getCardList())
    }

    private fun disableWelcomeViews() {
        binding.welcomeText.visibility = View.GONE
        binding.welcomeSubText.visibility = View.GONE
    }

    private fun enableWelcomeViews() {
        binding.welcomeText.visibility = View.VISIBLE
        binding.welcomeSubText.visibility = View.VISIBLE
    }
}