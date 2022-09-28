package freelance.insights.accounts.ui.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun AppSingleLineInput(
    placeHolder: String = "Placeholder",
    value: String,
    onValueChange: (value: Any) -> Unit = {},
    keyboardType: KeyboardType
) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        label = { Text(text = placeHolder) },
        textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true
    )
}
