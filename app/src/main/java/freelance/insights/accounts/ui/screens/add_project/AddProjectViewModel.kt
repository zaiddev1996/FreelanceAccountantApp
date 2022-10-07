package freelance.insights.accounts.ui.screens.add_project

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import freelance.insights.accounts.data.localRepo.FinancialsDataSource
import freelance.insights.accounts.data.models.ProjectFinancials
import freelance.insights.accounts.di.LocalDataSource
import freelance.insights.accounts.utils.validateProject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddProjectViewModel
@Inject constructor(
    @LocalDataSource val financialsDataSource: FinancialsDataSource
) : ViewModel() {

    private val _oneTimeEvents = MutableSharedFlow<AddProjectState>()
    val oneTimeEvents: SharedFlow<AddProjectState> = _oneTimeEvents

    private val _loading = mutableStateOf(false)
    val loading: State<Boolean> = _loading

    private val _project = mutableStateOf(
        ProjectFinancials()
    )
    val project: State<ProjectFinancials> = _project

    fun onTriggerEvents(events: AddProjectEvents) {
        when (events) {
            is AddProjectEvents.AddProjectEvent -> {
                addProjectFinancials()
            }
            is AddProjectEvents.UserInputChangerEvent -> {
                _project.value = events.projectFinancials
            }
        }
    }

    private fun addProjectFinancials() {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.value = true
            validateProject(_project.value).onSuccess {
                financialsDataSource.addProject(it).onSuccess {
                    _oneTimeEvents.emit(AddProjectState.ShowSnackBar("Project Financials Added"))
                    _oneTimeEvents.emit(AddProjectState.NavigateToHome)
                    _loading.value = false
                }.onFailure { error ->
                    _oneTimeEvents.emit(AddProjectState.ShowSnackBar(error))
                    _loading.value = false
                }
            }.onFailure {
                _oneTimeEvents.emit(AddProjectState.ShowSnackBar(it))
                _loading.value = false
            }
        }
    }


}