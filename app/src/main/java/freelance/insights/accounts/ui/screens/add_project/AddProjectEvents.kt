package freelance.insights.accounts.ui.screens.add_project

sealed class AddProjectEvents{
    data class ShowSnackBar(val message: String): AddProjectEvents()
    object NavigateToHome: AddProjectEvents()
}
