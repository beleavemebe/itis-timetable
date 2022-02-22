package com.senex.timetable.presentation.groups

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentGroupsBinding
import com.senex.timetable.presentation.daggerAppComponent
import com.senex.timetable.presentation.groups.recycler.GroupsRecyclerAdapter
import com.senex.timetable.utils.toast
import javax.inject.Inject

class GroupsFragment : Fragment() {
    private var _binding: FragmentGroupsBinding? = null
    private val binding
        get() = _binding!!

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: GroupsViewModel by viewModels(factoryProducer = { factory })

    override fun onAttach(context: Context) {
        context.daggerAppComponent.inject(this)

        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentGroupsBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ): Unit = with(binding) {
        groupsToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_open_schedule_fragment -> {
                    //navigateToGroupsFragment()
                    true
                }
                else -> false
            }
        }

        groupsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        groupsRecyclerView.adapter = GroupsRecyclerAdapter().apply {
            viewModel.groups.observe(viewLifecycleOwner) {
                submitList(it)
            }
            onItemClickListener = onGroupItemClick
        }
    }

    private val onGroupItemClick: (Long) -> Unit = {
        requireContext().toast("Group with id: $it selected")
        viewModel.setPrimaryGroup(viewModel.getGroup(it).id)
    }
/*
    private fun navigateToGroupsFragment() {
        findNavController().navigate(
            R.id.action_groupsFragment_to_tableFragment
        )
    }*/
}