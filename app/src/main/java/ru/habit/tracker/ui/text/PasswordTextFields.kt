package ru.habit.tracker.ui.text


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.habit.tracker.R
import ru.habit.tracker.ui.theme.actionBarTitleColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFields(
    hintName: String,
) {
    var isShowingPass by remember {
        mutableStateOf(false)
    }

    var passwordVisibility =
        if (isShowingPass) VisualTransformation.None else PasswordVisualTransformation()


    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        visualTransformation = passwordVisibility,
        textStyle = TextStyle.Default.copy(fontSize = 14.sp),
        trailingIcon = {
            IconButton(onClick = { isShowingPass = !isShowingPass }) {
                Icon(
                    painter = painterResource(id = if (isShowingPass) R.drawable.ic_hide_pass else R.drawable.ic_show_pass),
                    tint = actionBarTitleColor,
                    contentDescription = null,
                )

            }
        },
        onValueChange = {
            text = it
        },
        placeholder = {
            Text(
                text = hintName,
                color = Color(0xFFD7EBE9),
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = actionBarTitleColor,
            containerColor = Color.Transparent,
            focusedLabelColor = Color.Transparent,
            unfocusedLabelColor = Color.Transparent,
            disabledLabelColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(
                width = 1.dp, color = Color(0xFFD7EBE9), shape = RoundedCornerShape(8.dp)
            )
    )
}
