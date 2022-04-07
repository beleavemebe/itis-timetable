package com.senex.timetable.presentation.ui.groups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentGroupsBinding
import com.senex.timetable.domain.util.toast
import com.senex.timetable.presentation.common.inflateBinding
import com.senex.timetable.presentation.ui.groups.recycler.GroupsRecyclerItem
import com.senex.timetable.presentation.ui.groups.recycler.GroupsRecyclerItemDiffCallback
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class GroupsFragment : DaggerFragment() {
    private var _binding: FragmentGroupsBinding? = null
    private val binding
        get() = _binding!!

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: GroupsViewModel by viewModels(factoryProducer = { factory })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflateBinding(FragmentGroupsBinding::inflate, inflater, container) {
        _binding = it
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) = with(binding) {
        groupsToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_open_schedule_fragment -> {
                    navigateToScheduleFragment()
                    true
                }
                else -> false
            }
        }

        groupsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        groupsRecyclerView.adapter = AsyncListDifferDelegationAdapter(
            GroupsRecyclerItemDiffCallback,
            GroupsRecyclerItem.GroupItem.getDelegate(onGroupItemClick),
            GroupsRecyclerItem.CourseItem.getDelegate(),
        ).apply {
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.groups.collect {
                    items = it
                }
            }
        }
    }

    private val onGroupItemClick: (Long) -> Unit = {
        requireContext().toast("GroupEntity with id: $it selected")
        viewModel.setPrimaryGroup(it)
        navigateToScheduleFragment()
    }

    private fun navigateToScheduleFragment() = findNavController().navigate(
        GroupsFragmentDirections.actionGroupsFragmentToScheduleFragment()
    )
}