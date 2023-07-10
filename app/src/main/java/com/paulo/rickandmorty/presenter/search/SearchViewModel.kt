package com.paulo.rickandmorty.presenter.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulo.rickandmorty.core.BaseEvent
import com.paulo.rickandmorty.domain.entities.Character
import com.paulo.rickandmorty.domain.usecases.GetByFilter
import com.paulo.rickandmorty.domain.utils.DomainResult
import com.paulo.rickandmorty.presenter.main.HomeUICharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val useCase: GetByFilter
): ViewModel() {

    private val _stateSearch = MutableStateFlow(SearchUI())
    val stateSearch = _stateSearch



     fun onSearchTextChange(name: String, status: String) {
        _stateSearch.update {
            it.copy(
                event = BaseEvent.LOADING
            )
        }
         viewModelScope.launch {
            when(val res = useCase(name, status) ){
                is DomainResult.Error ->{
                    errorUpdate(res)
                }
                is DomainResult.Exception -> {
                    exceptionUpdate()
                }
                is DomainResult.Success -> {
                    successUpdate(res)
                }
            }
         }
    }

    private fun successUpdate(res: DomainResult.Success<List<Character>>) {
        _stateSearch.update {
            it.copy(
                event = BaseEvent.REGULAR,
                success = res.data
            )
        }
    }

    private fun exceptionUpdate() {
        _stateSearch.update {
            it.copy(
                event = BaseEvent.ERROR,
                errorMessage = "Ops, por favor tente mais tarde."
            )
        }
    }

    private fun errorUpdate(res: DomainResult.Error<List<Character>>) {
        _stateSearch.update {
            it.copy(
                event = BaseEvent.ERROR,
                errorMessage = "Ops, obtivemos um erro: ${res.message} #${res.code}"
            )
        }
    }

}
