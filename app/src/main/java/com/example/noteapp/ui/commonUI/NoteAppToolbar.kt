package com.example.noteapp.ui.commonUI

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import com.example.noteapp.ui.state.NoteAppToolbarState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteAppToolbar(
    modifier: Modifier = Modifier,
    noteAppToolbarState: State<NoteAppToolbarState>,
    toolbarCallback: (String) -> Unit
) {

    TopAppBar(
        title =  {Text(text = noteAppToolbarState.value.title)},
        navigationIcon = {
        },
        actions = {
            IconButton(
                modifier = Modifier.layoutId("iconButtonView"),
                onClick = {
                    toolbarCallback("addTodo")
                }) {
                Text(text = "+todo")
            }
        },
        modifier = Modifier.fillMaxWidth(),
    )
}