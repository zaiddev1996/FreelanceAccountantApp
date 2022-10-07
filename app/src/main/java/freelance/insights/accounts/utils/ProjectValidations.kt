package freelance.insights.accounts.utils

import freelance.insights.accounts.data.models.Either
import freelance.insights.accounts.data.models.ProjectFinancials

fun validateProject(projectFinancials: ProjectFinancials): Either<ProjectFinancials> {
    return if (projectFinancials.name.isBlank()) {
        Either.error("Please enter name")
    } else if (projectFinancials.projectStart.isNullOrBlank()) {
        Either.error("Please enter start date")
    } else if (projectFinancials.clientName.isBlank()) {
        Either.error("Please enter client name")
    } else if (projectFinancials.budget == null || projectFinancials.budget!! <= 0) {
        Either.error("Please enter budget")
    } else {
        Either.success(projectFinancials)
    }
}
