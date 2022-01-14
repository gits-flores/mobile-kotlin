package com.example.course_online.data

import android.content.Context
import android.content.SharedPreferences
import hu.autsoft.krate.Krate
import hu.autsoft.krate.booleanPref
import hu.autsoft.krate.intPref
import hu.autsoft.krate.stringPref

class PrefsManagers(context: Context) : Krate {

    private val PREFS_IS_LOGIN = "prefs_is_login"
    private val PREFS_NAME = "prefs_name"
    private val PREFS_TOKEN = "prefs_token"
    private val PREFS_COURSE = "prefs_course"
    private val PREFS_MODUL = "pref_modul"
    private val PREFS_STATUS = "prefs_status"
    private val PREFS_MESSAGE = "prefs_message"

    override val sharedPreferences: SharedPreferences =
        context.applicationContext.getSharedPreferences("course-online", Context.MODE_PRIVATE)

    var prefsIsLogin by booleanPref(PREFS_IS_LOGIN, false)
    var prefsName by stringPref(PREFS_NAME, "")
    var prefsToken by stringPref(PREFS_TOKEN, "")
    var prefsCourse by intPref(PREFS_COURSE, 1)
    var prefsModul by intPref(PREFS_MODUL, 2)
    var prefsStatus by stringPref(PREFS_STATUS, "")
    val prefsMessage by stringPref(PREFS_MESSAGE, "")

    fun doLogout() {
        sharedPreferences.edit().clear().apply()
    }

}