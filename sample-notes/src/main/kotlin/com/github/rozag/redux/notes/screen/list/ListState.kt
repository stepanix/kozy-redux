package com.github.rozag.redux.notes.screen.list

import com.github.rozag.redux.notes.model.Note

data class ListState(val notes: List<Note>) {
    companion object {
        val EMPTY: ListState = ListState(emptyList())
    }
}