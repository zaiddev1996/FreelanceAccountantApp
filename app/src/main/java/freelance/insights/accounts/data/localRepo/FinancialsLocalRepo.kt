package freelance.insights.accounts.data.localRepo

import freelance.insights.accounts.data.models.ProjectFinancials
import javax.inject.Inject

class FinancialsLocalRepo @Inject constructor(private val projectFinancialsDao: ProjectFinancialsDao) :
    FinancialsDataSource {

    override fun addProject(projectFinancials: ProjectFinancials) {
        projectFinancialsDao.insertAll(projectFinancials)
    }
}