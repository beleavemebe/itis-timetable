package com.senex.timetable.ui.fragments.schedule.recycler

class DayItem(
    val name: String,
) : ScheduleListItem {

    override fun getViewType(): Int {
        return ScheduleListItemType.Day.value
    }
}