package freelance.insights.accounts.ui.screens.add_project

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.neverEqualPolicy
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.KeyboardType
import freelance.insights.accounts.data.models.ProjectFinancials
import freelance.insights.accounts.ui.components.AppSingleLineInput

@Composable
fun AddProjectScreen() {
    val newProject = remember {
        mutableStateOf(
            ProjectFinancials(),
            policy = neverEqualPolicy()
        )
    }

    Column {
        AppSingleLineInput(
            placeHolder = "Name",
            value = newProject.value.name,
            onValueChange = {
                newProject.value.name = it.toString()
                newProject.value = newProject.value
            },
            keyboardType = KeyboardType.Text
        )
        AppSingleLineInput(
            placeHolder = "Client Name",
            value = newProject.value.clientName,
            onValueChange = {
                newProject.value.clientName = it.toString()
                newProject.value = newProject.value
            },
            keyboardType = KeyboardType.Text

        )
        AppSingleLineInput(
            placeHolder = "Budget",
            value = (newProject.value.budget ?: "").toString(),
            onValueChange = {
                newProject.value.budget = it.toString().toIntOrNull()
                newProject.value = newProject.value
            },
            keyboardType = KeyboardType.Number
        )
        AppSingleLineInput(
            placeHolder = "Outsourcing Cost",
            value = (newProject.value.outsourcingBudget ?: "").toString(),
            onValueChange = {
                newProject.value.outsourcingBudget = it.toString().toIntOrNull()
                newProject.value = newProject.value
            },
            keyboardType = KeyboardType.Number
        )
        AppSingleLineInput(
            placeHolder = "Tip",
            value = (newProject.value.tip ?: "").toString(),
            onValueChange = {
                newProject.value.tip = it.toString().toIntOrNull()
                newProject.value = newProject.value
            },
            keyboardType = KeyboardType.Number
        )
    }

}