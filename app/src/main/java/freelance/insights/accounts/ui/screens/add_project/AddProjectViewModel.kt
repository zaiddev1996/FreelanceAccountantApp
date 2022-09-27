package freelance.insights.accounts.ui.screens.add_project

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import freelance.insights.accounts.data.localRepo.FinancialsDataSource
import freelance.insights.accounts.di.LocalDataSource
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class AddProjectViewModel
@Inject constructor(
    @LocalDataSource financialsDataSource: FinancialsDataSource
) : ViewModel() {

    private val _startDate = MutableStateFlow("Select Start Date")
    val startDate: StateFlow<String> = _startDate

    fun addProjectFinancials() {

    }

    fun setStartDate(date: Long) {
        _startDate.value = date.toString()
    }

}