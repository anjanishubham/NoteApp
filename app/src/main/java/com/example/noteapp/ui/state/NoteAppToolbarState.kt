package com.example.noteapp.ui.state

import android.icu.text.CaseMap.Title

data class NoteAppToolbarState(
    val title: String = "",
    val  showBackArrow: Boolean = false,
    val  showMenu: Boolean = false,
    val menuList : List<String> = emptyList()
)
