package freelance.insights.accounts.ui.screens.add_project

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import freelance.insights.accounts.data.localRepo.FinancialsDataSource
import freelance.insights.accounts.data.models.ProjectFinancials
import freelance.insights.accounts.di.LocalDataSource
import freelance.insights.accounts.utils.validateProject
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddProjectViewModel
@Inject constructor(
    @LocalDataSource financialsDataSource: FinancialsDataSource
) : ViewModel() {

    private val _oneTimeEvents = MutableSharedFlow<AddProjectEvents>()
    val oneTimeEvents: SharedFlow<AddProjectEvents> = _oneTimeEvents

    fun onAddProjectFinancials(projectFinancials: ProjectFinancials) {
        viewModelScope.launch {
            validateProject(projectFinancials).onSuccess {
            }.onFailure {
                _oneTimeEvents.emit(AddProjectEvents.ShowSnackBar(it))
            }
        }
    }


}