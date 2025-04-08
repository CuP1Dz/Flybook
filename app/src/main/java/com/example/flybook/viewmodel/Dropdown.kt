import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dropdown() {
    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("1 Пассажир","2 Пассажир","3+ Пассажир")
    var selectedText by remember { mutableStateOf(suggestions[0]) }

    var dropDownWidth by remember { mutableStateOf(0) }

    val icon = if (expanded)
        Icons.Filled.ArrowDropDown
    else
    Icons.Filled.ArrowDropDown


    Column() {
        TextField(
            shape = RoundedCornerShape(
                topStart = 10.dp,
                topEnd = 10.dp,
                bottomEnd = 10.dp,
                bottomStart = 10.dp,
            ),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            readOnly = true,
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier.fillMaxWidth()
                .onSizeChanged {
                    dropDownWidth = it.width
                }
                .clickable{expanded = !expanded },
            trailingIcon = {
                Icon(icon,"contentDescription", Modifier.clickable { expanded = !expanded })
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){dropDownWidth.toDp()})
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(
                    onClick = {
                    selectedText = label
                    },
                    text = {Text(label)}
                )
            }
        }
    }
}