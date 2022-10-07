package freelance.insights.accounts.ui.screens.add_project

sealed class AddProjectState{
    data class ShowSnackBar(val message: String): AddProjectState()
    object NavigateToHome: AddProjectState()
}
