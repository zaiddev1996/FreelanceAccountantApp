package freelance.insights.accounts.ui.screens.add_project

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import freelance.insights.accounts.data.models.ProjectFinancials
import freelance.insights.accounts.ui.components.AppSingleLineInput
import freelance.insights.accounts.ui.components.CircularIndeterminateProgressBar
import freelance.insights.accounts.utils.showDateDialog
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun AddProjectScreen(
    scaffoldState: SnackbarHostState,
    viewModel: AddProjectViewModel = hiltViewModel(),
    onAddSuccess: () -> Unit
) {

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val newProject = viewModel.project

    LaunchedEffect(key1 = Unit) {
        viewModel.oneTimeEvents.collectLatest {
            when (it) {
                is AddProjectState.ShowSnackBar -> {
                    GlobalScope.launch {
                        scaffoldState.showSnackbar(
                            message = it.message
                        )
                    }
                }

                is AddProjectState.NavigateToHome -> {
                    onAddSuccess()
                }
            }
        }
    }

    val t = Column(modifier = Modifier.padding(5.dp)) {
        AppSingleLineInput(
            placeHolder = "Name",
            value = newProject.value.name,
            onValueChange = {
                viewModel.onTriggerEvents(
                    AddProjectEvents.UserInputChangerEvent(
                        newProject.value.copy(
                            name = it.toString()
                        )
                    )
                )
            },
            keyboardType = KeyboardType.Text
        )

        ClickableText(
            text = AnnotatedString(
                text = (newProject.value.projectStart ?: "Please select end date"),
                spanStyles = listOf(
                    AnnotatedString.Range(
                        SpanStyle(color = MaterialTheme.colors.primary),
                        0,
                        (newProject.value.projectStart ?: "Please select end date").length
                    )
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            style = MaterialTheme.typography.button,
            onClick = {
                showDateDialog(context) {
                    viewModel.onTriggerEvents(
                        AddProjectEvents.UserInputChangerEvent(
                            newProject.value.copy(
                                projectStart = it
                            )
                        )
                    )
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
                    viewModel.onTriggerEvents(
                        AddProjectEvents.UserInputChangerEvent(
                            newProject.value.copy(
                                projectEnd = it
                            )
                        )
                    )
                }
            }
        )

        AppSingleLineInput(
            placeHolder = "Client Name",
            value = newProject.value.clientName,
            onValueChange = {
                viewModel.onTriggerEvents(
                    AddProjectEvents.UserInputChangerEvent(
                        newProject.value.copy(
                            clientName = it.toString()
                        )
                    )
                )
            },
            keyboardType = KeyboardType.Text

        )



        AppSingleLineInput(
            placeHolder = "Budget",
            value = (newProject.value.budget ?: "").toString(),
            onValueChange = {
                viewModel.onTriggerEvents(
                    AddProjectEvents.UserInputChangerEvent(
                        newProject.value.copy(
                            budget = it.toString().toLongOrNull()
                        )
                    )
                )

            },
            keyboardType = KeyboardType.Number
        )

        AppSingleLineInput(
            placeHolder = "Outsourcing Cost",
            value = (newProject.value.outsourcingBudget ?: "").toString(),
            onValueChange = {
                viewModel.onTriggerEvents(
                    AddProjectEvents.UserInputChangerEvent(
                        newProject.value.copy(
                            outsourcingBudget = it.toString().toLongOrNull()
                        )
                    )
                )

            },
            keyboardType = KeyboardType.Number
        )

        AppSingleLineInput(
            placeHolder = "Tip",
            value = (newProject.value.tip ?: "").toString(),
            onValueChange = {
                viewModel.onTriggerEvents(
                    AddProjectEvents.UserInputChangerEvent(
                        newProject.value.copy(
                            tip = it.toString().toLongOrNull()
                        )
                    )
                )

            },
            keyboardType = KeyboardType.Number
        )

        Button(
            onClick = {
                viewModel.onTriggerEvents(AddProjectEvents.AddProjectEvent)
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

        CircularIndeterminateProgressBar(isDisplayed = viewModel.loading.value)
    }


}

