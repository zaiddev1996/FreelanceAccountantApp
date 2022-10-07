package freelance.insights.accounts.data.localRepo

import freelance.insights.accounts.data.models.Either
import freelance.insights.accounts.data.models.ProjectFinancials
import javax.inject.Inject

class FinancialsLocalRepo @Inject constructor(private val projectFinancialsDao: ProjectFinancialsDao) :
    FinancialsDataSource {

    override fun addProject(projectFinancials: ProjectFinancials): Either<String> {

        val responseLong = projectFinancialsDao.insertSingle(projectFinancials)
        return if (responseLong == (-1).toLong()) {
            Either.error("Error adding project!!")
        } else {
            Either.success("Project Added Successfully")
        }
    }

    override fun getAllProject(): Either<List<ProjectFinancials>> {
        val response = projectFinancialsDao.getAll()
        return Either.success(response)
    }

}