package freelance.insights.accounts.data.localRepo

import freelance.insights.accounts.data.models.ProjectFinancials

interface FinancialsDataSource {
    fun addProject(projectFinancials: ProjectFinancials)
}