package com.senex.timetable.presentation.ui.groups.recycler

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.senex.timetable.presentation.common.recycler.TypedRecyclerItem

class GroupsRecyclerDelegationAdapter(
    private val onItemClickListener: ((Long) -> Unit)? = null
) : AsyncListDifferDelegationAdapter<TypedRecyclerItem>(
    GroupDiffCallback
) {
    init {
        delegatesManager
            .addDelegate(GroupDelegate(onItemClickListener))
            .addDelegate(CourseDelegate())
    }
}