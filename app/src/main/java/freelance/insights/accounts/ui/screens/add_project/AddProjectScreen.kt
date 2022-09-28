package freelance.insights.accounts.ui.screens.add_project

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import freelance.insights.accounts.data.models.ProjectFinancials
import freelance.insights.accounts.ui.components.AppSingleLineInput
import freelance.insights.accounts.utils.showDateDialog
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun AddProjectScreen(
    scaffoldState: SnackbarHostState,
    viewModel: AddProjectViewModel = hiltViewModel()
) {
    val newProject = rememberSaveable {
        mutableStateOf(
            ProjectFinancials(),
            policy = neverEqualPolicy()
        )
    }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = Unit) {
        viewModel.oneTimeEvents.collectLatest {
            when (it) {
                is AddProjectEvents.ShowSnackBar -> {
                    coroutineScope.launch {
                        scaffoldState.showSnackbar(
                            message = it.message
                        )
                    }
                }

                is AddProjectEvents.NavigateToHome -> {

                }
            }
        }
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

        ClickableText(
            text = AnnotatedString(
                text = (newProject.value.projectStart ?: "Please enter end date"),
                spanStyles = listOf(
                    AnnotatedString.Range(
                        SpanStyle(color = MaterialTheme.colors.primary),
                        0,
                        (newProject.value.projectStart ?: "Please enter end date").length
                    )
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            style = MaterialTheme.typography.button,
            onClick = {
                showDateDialog(context) {
                    newProject.value.projectStart = it
                    newProject.value = newProject.value
                }
            }
        )

        ClickableText(
            text = AnnotatedString(
                text = (newProject.value.projectEnd ?: "Please enter end date"),
                spanStyles = listOf(
                    AnnotatedString.Range(
                        SpanStyle(color = MaterialTheme.colors.primary),
                        0,
                        (newProject.value.projectEnd ?: "Please enter end date").length
                    )
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            style = MaterialTheme.typography.button,
//            color = Color.White,
            onClick = {
                showDateDialog(context) {
                    newProject.value.projectEnd = it
                    newProject.value = newProject.value
                }
            }
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
//                Log.e("BUDGET", it.toString())
                newProject.value.budget = it.toString().toLongOrNull()
                newProject.value = newProject.value
            },
            keyboardType = KeyboardType.Number
        )

        AppSingleLineInput(
            placeHolder = "Outsourcing Cost",
            value = (newProject.value.outsourcingBudget ?: "").toString(),
            onValueChange = {
                newProject.value.outsourcingBudget = it.toString().toLongOrNull()
                newProject.value = newProject.value
            },
            keyboardType = KeyboardType.Number
        )

        AppSingleLineInput(
            placeHolder = "Tip",
            value = (newProject.value.tip ?: "").toString(),
            onValueChange = {
                newProject.value.tip = it.toString().toLongOrNull()
                newProject.value = newProject.value
            },
            keyboardType = KeyboardType.Number
        )

        Button(
            onClick = {
                viewModel.onAddProjectFinancials(newProject.value)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Add Project",
                modifier = Modifier.padding(8.dp)
            )
        }
    }

}

