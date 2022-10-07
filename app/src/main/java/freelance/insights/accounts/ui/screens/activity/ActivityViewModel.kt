package freelance.insights.accounts.ui.screens.activity

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import freelance.insights.accounts.data.localRepo.FinancialsDataSource
import freelance.insights.accounts.data.models.ProjectFinancials
import freelance.insights.accounts.di.LocalDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel
@Inject constructor(
    @LocalDataSource val financialsDataSource: FinancialsDataSource
) : ViewModel() {

    private val _projectsList = mutableStateOf<List<ProjectFinancials>>(emptyList())
    val projectList: State<List<ProjectFinancials>> = _projectsList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            financialsDataSource.getAllProject().onSuccess {
                withContext(Dispatchers.Main){
                    _projectsList.apply {
                        value = it
                    }
                }

            }.onFailure {

            }
        }

    }
}