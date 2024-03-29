package ru.habit.tracker.ui.screens.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.habit.tracker.R
import ru.habit.tracker.ui.text.LoginTextFields
import ru.habit.tracker.utils.AppSwitcher
import ru.habit.tracker.utils.ColorsItem
import ru.habit.tracker.utils.ColorsRadioGroup
import ru.habit.tracker.utils.DayQuantityRadioGroup
import ru.habit.tracker.utils.IconsItem
import ru.habit.tracker.utils.IconsRadioGroup
import ru.habit.tracker.utils.TimeSettingTool
import ru.habit.tracker.utils.WeekdaysItem
import ru.habit.tracker.utils.WeekdaysRadioGroup

@Composable
fun AddNewHabitScreen(menuNavHostController: NavHostController) {
    val habitText = remember { mutableStateOf(TextFieldValue("")) }
    val scrollState = rememberScrollState()
    val weekdaysItems = remember {
        mutableListOf<WeekdaysItem>(
            WeekdaysItem("Пн", mutableStateOf(true)),
            WeekdaysItem("Вт", mutableStateOf(false)),
            WeekdaysItem("Ср", mutableStateOf(false)),
            WeekdaysItem("Чт", mutableStateOf(false)),
            WeekdaysItem("Пт", mutableStateOf(false)),
            WeekdaysItem("Сб", mutableStateOf(false)),
            WeekdaysItem("Вс", mutableStateOf(false)),
        )
    }
    val iconsItems = remember {
        mutableListOf<IconsItem>(
            IconsItem(R.drawable.ic_icon_1, mutableStateOf(true)),
            IconsItem(R.drawable.ic_icon_2, mutableStateOf(false)),
            IconsItem(R.drawable.ic_icon_3, mutableStateOf(false)),
            IconsItem(R.drawable.ic_icon_4, mutableStateOf(false)),
        )
    }
    val colorsItem = remember {
        mutableListOf<ColorsItem>(
            ColorsItem(
                id = 0,
                color = Color(0xFF89CCC5),
                borderColor = Color.Black,
                isSelected = mutableStateOf(true)
            ),
            ColorsItem(
                id = 1,
                color = Color(0xFFEFE2FF),
                borderColor = Color.Black,
                isSelected = mutableStateOf(false)
            ),
            ColorsItem(
                id = 2,
                color = Color(0xFFFFE3D7),
                borderColor = Color.Black,
                isSelected = mutableStateOf(false)
            ),
            ColorsItem(
                id = 3,
                color = Color(0xFFCFEBF7),
                borderColor = Color.Black,
                isSelected = mutableStateOf(false)
            ),
            ColorsItem(
                id = 4,
                color = Color(0xFFFEEEB7),
                borderColor = Color.Black,
                isSelected = mutableStateOf(false)
            ),
        )
    }


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(bottom = 40.dp),
        color = Color(0xFFF8F8F8)
    ) {
        Column(Modifier.padding(start = 16.dp, end = 16.dp, bottom = 45.dp)) {
            ActionBar(menuNavHostController =menuNavHostController )
            Spacer(modifier = Modifier.height(11.dp))

            LoginTextFields(hintName = "Привычкa", text = habitText)
            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Я смогу привыкнуть за:",
                color = Color(0xff272727),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
            )
            Spacer(modifier = Modifier.height(18.dp))

            DayQuantityRadioGroup()
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Как часто повторять:",
                color = Color(0xff272727),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
            )
            Spacer(modifier = Modifier.height(16.dp))

            WeekdaysRadioGroup(weekdaysItems)
            Spacer(modifier = Modifier.height(16.dp))


            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .shadow(elevation = 1.dp, shape = RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(color = Color.White)
                    .clickable {
                        weekdaysItems.forEach {
                            it.isSelected.value = true
                        }
                    }) {
                Text(
                    text = "Каждый день",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 14.sp
                    ),
                    modifier = Modifier
                        .padding(vertical = 7.dp)
                        .height(22.dp)
                )
            }
            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Как часто повторять:",
                color = Color(0xff272727),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Включить уведомления",
                    color = Color(0xff272727),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 13.sp
                    ),
                    modifier = Modifier.fillMaxWidth(0.4f)
                )

                Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                    AppSwitcher(defValue = true)
                }
            }
            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "В какое время:",
                color = Color(0xff272727),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
            )
            Spacer(modifier = Modifier.height(18.dp))

            Row(
                Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(
                    24.dp, alignment = Alignment.CenterHorizontally
                )
            ) {
                TimeSettingTool(Modifier, "14:00")
                TimeSettingTool(Modifier, "30 минут")
            }



            Text(
                text = "Иконка:",
                color = Color(0xff272727),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
            )
            Spacer(modifier = Modifier.height(18.dp))

            IconsRadioGroup(options = iconsItems)
            Spacer(modifier = Modifier.height(18.dp))


            Text(
                text = "Цвет:",
                color = Color(0xff272727),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
            )
            Spacer(modifier = Modifier.height(18.dp))

            ColorsRadioGroup(options = colorsItem)

        }
    }
}

@Composable
private fun ActionBar(menuNavHostController: NavHostController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 9.dp)
    ) {
        Text(
            text = "Создать новую привычку",
            color = Color(0xff272727),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 22.sp, fontWeight = FontWeight.Bold, letterSpacing = (-0.5).sp
            )
        )
        IconButton(onClick = { menuNavHostController.popBackStack() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_remove_field_text),
                contentDescription = "email_icons",
                tint = Color(0xff272727)
            )
        }
    }

}