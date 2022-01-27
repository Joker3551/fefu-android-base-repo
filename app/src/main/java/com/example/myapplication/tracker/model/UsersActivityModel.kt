package com.example.myapplication.tracker.model

class UsersActivityModel(activityInfo: ActivityInfo) : ActivityModel(activityInfo) {
    val user = activityInfo.getUsername()
}