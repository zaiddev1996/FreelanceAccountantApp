package freelance.insights.accounts.ui.screens.add_project

import freelance.insights.accounts.data.models.ProjectFinancials

sealed class AddProjectEvents{
    object AddProjectEvent : AddProjectEvents()
    data class UserInputChangerEvent(val projectFinancials: ProjectFinancials): AddProjectEvents()
}
