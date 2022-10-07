package freelance.insights.accounts.data.localRepo

import freelance.insights.accounts.data.models.Either
import freelance.insights.accounts.data.models.ProjectFinancials

interface FinancialsDataSource {
    fun addProject(projectFinancials: ProjectFinancials): Either<String>
    fun getAllProject(): Either<List<ProjectFinancials>>
}