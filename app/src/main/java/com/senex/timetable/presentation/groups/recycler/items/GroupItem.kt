package com.senex.timetable.presentation.groups.recycler.items

import com.senex.timetable.data.models.Group

class GroupItem(
    val group: Group,
) : GroupListItem {
    override fun getViewType() = GroupListItemType.GROUP.value
}