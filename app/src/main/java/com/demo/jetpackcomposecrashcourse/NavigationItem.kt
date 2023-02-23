package com.demo.jetpackcomposecrashcourse

sealed class NavigationItem(var route: String, var icon: Int, var title: String){
    object Home : NavigationItem("home", R.drawable.ic_home, "Welcome back!")
    object Meds : NavigationItem("medication", R.drawable.ic_medication, "Current Medicine")
    object Metrics : NavigationItem("metrics", R.drawable.ic_pie_chart, "Metrics")
    object UserProfile : NavigationItem("user_profile", R.drawable.ic_person, "UserProfile")
}
