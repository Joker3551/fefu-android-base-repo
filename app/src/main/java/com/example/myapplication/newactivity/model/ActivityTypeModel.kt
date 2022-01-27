package com.example.myapplication.newactivity.model

class ActivityTypeModel(activityType: ActivityType) {
    var typeStr: String = when (activityType) {
        ActivityType.BIKING -> "Велосипед"
        ActivityType.RUNNING -> "Бег"
        ActivityType.SWIMMING -> "Плавание"
    }
}