package com.senex.timetable.presentation.ui.groups.recycler

import com.senex.timetable.domain.model.group.Group

/**
 * Works properly only if the list is sorted by the course number.
 */
fun List<Group>.toGroupsRecyclerItemList() = buildList {
    var currentCourseNumber = -1
    for (group in this@toGroupsRecyclerItemList) {
        if (group.courseNumber != currentCourseNumber) {
            currentCourseNumber = group.courseNumber
            add(GroupsRecyclerItem.CourseItem(currentCourseNumber))
        }
        add(GroupsRecyclerItem.GroupItem(group))
    }
}
