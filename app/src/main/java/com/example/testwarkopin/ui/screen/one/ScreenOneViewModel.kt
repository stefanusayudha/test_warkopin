package com.example.testwarkopin.ui.screen.one

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testwarkopin.domain.UserRepository
import com.example.testwarkopin.domain.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ScreenOneViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    private var _userListState: MutableStateFlow<List<User>> = MutableStateFlow(listOf())
    val userListState: StateFlow<List<User>>
        get() = _userListState

    fun getUserList() {
        viewModelScope.launch {
            val list = userRepository.getUserList()
            _userListState.emit(list)
        }
    }
}