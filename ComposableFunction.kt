package com.autoroutesante.belocum.utils

import android.text.method.LinkMovementMethod
import android.view.Gravity
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.res.ResourcesCompat
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.autoroutesante.belocum.R
import com.autoroutesante.belocum.network.resources.CoroutineScopedViewModel
import com.filepicker.compressor.spToPx
import com.google.android.material.textview.MaterialTextView
import com.livinglifetechway.k4kotlin.core.orFalse
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


val helvetica_medium = FontFamily(Font(R.font.helvetica_medium))
val nunito_regular = FontFamily(Font(R.font.nunito_regular))
val helvetica_bold = FontFamily(Font(R.font.helvetica_bold))

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(headerText: String, actionButtonIcon: Painter? = null, onClick: () -> Unit, onActionButtonClick: (() -> Unit)? = null) {
    Row(modifier = Modifier
            .height(dimensionResource(id = R.dimen._42sdp))
            .background(colorResource(id = R.color.calendarBackground)), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        CenterAlignedTopAppBar(
                title = {
                    Text(
                            text = headerText, modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen._10sdp)), textAlign = TextAlign.Center, style = TextStyle(fontSize = dimensionResource(id = R.dimen._16ssp).value.sp, fontFamily = helvetica_bold),
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onClick() }) {
                        Icon(painter = painterResource(id = R.drawable.ic_arrow_back), "backIcon", tint = colorResource(id = R.color.lightDark))
                    }
                },
                actions = {
                    if (actionButtonIcon != null) {
                        Box(modifier = Modifier
                                .clip(CircleShape)
                                .clickable {
                                    if (onActionButtonClick != null) {
                                        onActionButtonClick()
                                    }
                                }) {
                            Icon(painter = actionButtonIcon, "actionIcon", tint = Color.Unspecified, modifier = Modifier.size(dimensionResource(id = R.dimen._34sdp)).padding(dimensionResource(id = R.dimen._5sdp)))
                        }
                    }
                },

                colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = colorResource(id = R.color.calendarBackground),
                        titleContentColor = colorResource(id = R.color.lightDark),
                ),
        )
    }
}

@Composable
fun MyTextLabel(modifier: Modifier, text: String, color: Color = colorResource(id = R.color.lightDark), textAlign: TextAlign = TextAlign.Start, fontSize: TextUnit = dimensionResource(id = R.dimen._12ssp).value.sp, fontFamily: FontFamily = helvetica_medium) {
    Text(modifier = modifier, text = text, style = TextStyle(color = color, fontSize = fontSize, fontFamily = fontFamily, textAlign = textAlign))
}

@Composable
fun MyNoteText(modifier: Modifier = Modifier.padding(dimensionResource(id = R.dimen._3sdp).value.dp), text: String) {
    Text(text = text, modifier = modifier, style = TextStyle(color = colorResource(id = R.color.note_color), fontSize = dimensionResource(id = R.dimen._10ssp).value.sp, fontFamily = helvetica_medium))
}

@Composable
fun MyButton(modifier: Modifier = Modifier, text: String, textColor: Color, backgroundColor: Color, roundedRadius: Dp = dimensionResource(id = R.dimen._5sdp).value.dp, onClick: () -> Unit) {
    Button(modifier = modifier, shape = RoundedCornerShape(roundedRadius), colors = ButtonDefaults.buttonColors(containerColor = backgroundColor), onClick = {
        onClick()
    }) {
        Text(text = text, modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen._5sdp)), textAlign = TextAlign.Center, color = textColor, style = TextStyle(fontSize = dimensionResource(id = R.dimen._12ssp).value.sp, fontFamily = helvetica_bold))
    }
}

@Composable
fun MyTextField(defaultValue: String = "", hintText: String, keyboardOptions: KeyboardOptions, visualTransformation: VisualTransformation = VisualTransformation.None, maxLength: Int = 0, pattern: Regex = Regex(""), enable: Boolean = false, onChangeValue: (text: String) -> Unit) {
    var changedText by remember {
        mutableStateOf(defaultValue)
    }

    if (defaultValue.isNotEmpty().orFalse()) {
        onChangeValue(changedText)
    }
    // This box just wraps the background and the OutlinedTextField
    TextField(value = changedText, enabled = !enable, keyboardOptions = keyboardOptions, colors = TextFieldDefaults.colors(disabledContainerColor = colorResource(id = R.color.text_field_bg), focusedContainerColor = colorResource(id = R.color.text_field_bg), focusedIndicatorColor = colorResource(id = R.color.lightDark), unfocusedIndicatorColor = colorResource(id = R.color.lightDark), unfocusedContainerColor = colorResource(id = R.color.text_field_bg), disabledTextColor = colorResource(id = R.color.lightDark)), textStyle = TextStyle(fontSize = dimensionResource(id = R.dimen._12ssp).value.sp, fontFamily = nunito_regular), visualTransformation = visualTransformation, onValueChange = { it1 ->
        if (maxLength == 0) {
            if (pattern.pattern == "") {
                changedText = it1
                onChangeValue(it1)
            } else {
                if (it1.isEmpty() || it1.matches(pattern)) {
                    changedText = it1
                    onChangeValue(it1)
                }
            }
        } else {
            if (it1.length <= maxLength) {
                if (pattern.pattern == "") {
                    changedText = it1
                    onChangeValue(it1)
                } else {
                    if (it1.isEmpty() || it1.matches(pattern)) {
                        changedText = it1
                        onChangeValue(it1)
                    }
                }
            }
        }
    }, label = { Text(text = hintText, style = TextStyle(fontSize = dimensionResource(id = R.dimen._12ssp).value.sp, fontFamily = nunito_regular), color = colorResource(id = R.color.light_gray)) }, modifier = Modifier
            .background(colorResource(id = R.color.darkLight), CircleShape)
            .requiredHeight(dimensionResource(id = R.dimen._43sdp).value.dp)
            .fillMaxWidth(), singleLine = true)
}

@Composable
fun MyTextFieldMultiline(textValue: String? = "", imeAction: ImeAction, maxLength: Int = 0, readOnly: Boolean = false, onValueChange: (value: String) -> Unit) {
    var changedText by remember {
        mutableStateOf(textValue.toString())
    }

    if (textValue?.isNotEmpty().orFalse()) {
        onValueChange(changedText)
    }

    OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = dimensionResource(id = R.dimen._80sdp)), readOnly = readOnly, value = changedText, textStyle = TextStyle(fontSize = dimensionResource(id = R.dimen._12sdp).value.sp, fontFamily = helvetica_medium), onValueChange = {
        if ((maxLength == 0 || it.length <= maxLength)) {
            changedText = it
            onValueChange(it)
        }
    }, keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words, keyboardType = KeyboardType.Text, imeAction = imeAction), singleLine = false)
}

@Composable
fun MySnackBarError(snackBarData: SnackbarData) {
    Snackbar(containerColor = colorResource(id = R.color.snackbar_error), snackbarData = snackBarData)
}

@Composable
fun MySnackBarGeneral(snackBarData: SnackbarData) {
    Snackbar(containerColor = colorResource(id = R.color.snackbar_general), snackbarData = snackBarData)
}

@Composable
fun MySnackBarSuccess(snackBarData: SnackbarData) {
    Snackbar(containerColor = colorResource(id = R.color.snackbar_success), snackbarData = snackBarData)
}

@Composable
fun ShowSnackBar(viewModel: Lazy<CoroutineScopedViewModel>, errorSnackState: SnackbarHostState, generalSnackState: SnackbarHostState, successSnackState: SnackbarHostState) {
    LaunchedEffect(Unit) {
        viewModel.value.isErrorMessageShownFlow.collectLatest {
            if (it) {
                errorSnackState.showSnackbar(viewModel.value._snackBarMessage)
            }
        }
    }
    LaunchedEffect(Unit) {
        viewModel.value.isSuccessMessageShownFlow.collectLatest {
            if (it) {
                successSnackState.showSnackbar(viewModel.value._snackBarMessage)
            }
        }
    }
    LaunchedEffect(Unit) {
        viewModel.value.isGeneralMessageShownFlow.collectLatest {
            if (it) {
                generalSnackState.showSnackbar(viewModel.value._snackBarMessage)
            }
        }
    }
}

fun Modifier.shimmerBackground(shape: Shape = RectangleShape): Modifier = composed {
    val transition = rememberInfiniteTransition(label = "")
    val translateAnimation by transition.animateFloat(
            initialValue = 0f,
            targetValue = 400f,
            animationSpec = infiniteRepeatable(tween(durationMillis = 1500, easing = LinearOutSlowInEasing), RepeatMode.Restart), label = "",
    )
    val shimmerColors = listOf(
            Color.LightGray.copy(alpha = 0.9f),
            Color.LightGray.copy(alpha = 0.4f),
    )
    val brush = Brush.linearGradient(
            colors = shimmerColors,
            start = Offset(translateAnimation, translateAnimation),
            end = Offset(translateAnimation + 100f, translateAnimation + 100f),
            tileMode = TileMode.Mirror,
    )
    return@composed this.then(background(brush, shape))
}

@Composable
fun ShowDataNotFoundView(message: String = stringResource(id = R.string.str_no_data_available)) {
    Column(Modifier
            .padding(start = dimensionResource(id = R.dimen._4sdp))
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Box(modifier = Modifier.background(color = colorResource(id = R.color.ic_not_found_bg_color), CircleShape), contentAlignment = Alignment.Center) {
            Image(modifier = Modifier
                    .padding(dimensionResource(id = R.dimen._30sdp))
                    .size(dimensionResource(id = R.dimen._70sdp)), painter = painterResource(id = R.drawable.ic_not_found), contentDescription = null)
        }

        Text(text = message, modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen._10sdp)), textAlign = TextAlign.Center, color = colorResource(id = R.color.lightDark), fontSize = dimensionResource(id = R.dimen._12ssp).value.sp, fontFamily = nunito_regular)
    }
}

@Composable
fun HtmlText(modifier: Modifier = Modifier, html: String, textStyle: TextStyle = TextStyle()) {
    AndroidView(modifier = modifier, update = { it.text = fromHtml(it.context, html) }, factory = { context ->
        val spacingReady = (textStyle.lineHeight.value - textStyle.fontSize.value - 3f).coerceAtLeast(0f)
        val extraSpacing = spToPx(spacingReady.toInt(), context)
        val gravity = when (textStyle.textAlign) {
            TextAlign.Center -> Gravity.CENTER
            TextAlign.End -> Gravity.END
            else -> Gravity.START
        }

        val fontResId = when (textStyle.fontFamily) {
            helvetica_medium -> R.font.helvetica_medium
            helvetica_bold -> R.font.helvetica_bold
            else -> R.font.nunito_regular
        }
        val font = ResourcesCompat.getFont(context, fontResId)

        MaterialTextView(context).apply {
            // general style
            textSize = textStyle.fontSize.value
            setLineSpacing(extraSpacing, 1f)
            setTextColor(textStyle.color.toArgb())
            setGravity(gravity)
            typeface = font
            //autoLinkMask = Linkify.WEB_URLS
            //linksClickable = true
            // links
            //setLinkTextColor(Color.Green.toArgb())
            movementMethod = LinkMovementMethod.getInstance()/*movementMethod = DefaultLinkMovementMethod(object : DefaultLinkMovementMethod.OnLinkClickedListener{
                        override fun onLinkClicked(url: String?): Boolean {
                            when (url) {
                                "link_1" -> onLink1Clicked?.invoke()
                                "link_2" -> onLink2Clicked?.invoke()
                            }
                            return true
                        }

                    })*/
        }
    })
}


@Composable
fun RadioGroupHorizontal(item: List<String>, itemValue: List<Boolean>, clickable: Boolean, onChangeValue: (text: String) -> Unit) {
    var selectedtext = ""
    itemValue.forEachIndexed { index, b ->
        if (b) {
            selectedtext = item[index]
            return@forEachIndexed
        }
    }
    var selectedOption by remember {
        mutableStateOf(selectedtext)
    }

    Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        item.forEach { option ->
            Row(modifier = Modifier.padding(start = dimensionResource(id = R.dimen._5sdp))) {
                RadioButton(modifier = Modifier.size(dimensionResource(id = R.dimen._20sdp)), enabled = clickable, selected = selectedOption == option, colors = RadioButtonDefaults.colors(selectedColor = colorResource(id = R.color.seekbar_km), unselectedColor = colorResource(id = R.color.seekbar_km), disabledSelectedColor = colorResource(id = R.color.seekbar_km), disabledUnselectedColor = colorResource(id = R.color.seekbar_km)), onClick = {
                    if (clickable) {
                        selectedOption = option
                        onChangeValue(selectedOption)
                    }
                })
                MyTextLabel(modifier = Modifier
                        .clickable {
                            if (clickable) {
                                selectedOption = option
                                onChangeValue(selectedOption)
                            }
                        }
                        .align(Alignment.CenterVertically)
                        .padding(dimensionResource(id = R.dimen._3sdp)), fontSize = dimensionResource(id = R.dimen._10ssp).value.sp, text = option)
            }
        }
    }
}

@Composable
fun RadioGroupVertical(item: List<String>, itemValue: List<Boolean>, clickable: Boolean, onChangeValue: (text: String) -> Unit) {
    var selectedtext = ""
    itemValue.forEachIndexed { index, b ->
        if (b) {
            selectedtext = item[index]
            return@forEachIndexed
        }
    }

    var selectedOption by remember {
        mutableStateOf(selectedtext)
    }

    Column(horizontalAlignment = Alignment.Start) {
        item.forEach { option ->
            Row(modifier = Modifier.padding(top = dimensionResource(id = R.dimen._5sdp))) {
                RadioButton(modifier = Modifier.size(dimensionResource(id = R.dimen._20sdp)), selected = selectedOption == option, colors = RadioButtonDefaults.colors(selectedColor = colorResource(id = R.color.seekbar_km), unselectedColor = colorResource(id = R.color.seekbar_km), disabledSelectedColor = colorResource(id = R.color.seekbar_km), disabledUnselectedColor = colorResource(id = R.color.seekbar_km)), onClick = {
                    if (clickable) {
                        selectedOption = option
                        onChangeValue(selectedOption)
                    }
                })
                MyTextLabel(modifier = Modifier
                        .clickable {
                            if (clickable) {
                                selectedOption = option
                                onChangeValue(selectedOption)
                            }
                        }
                        .align(Alignment.CenterVertically)
                        .padding(dimensionResource(id = R.dimen._3sdp)), fontSize = dimensionResource(id = R.dimen._10ssp).value.sp, text = option)
            }
        }
    }
}

@Composable
fun GroupedCheckbox(mItemsList: List<String>, mItemValue: ArrayList<Boolean>, readOnly: Boolean = false, onChangeValue: (index: Int, text: String) -> Unit) {
    mItemsList.forEachIndexed { indexMain, items ->
        var selectedtext = ""
        mItemsList.forEachIndexed { index, _ ->
            if (mItemValue[index]) {
                selectedtext = items
                return@forEachIndexed
            }
        }
        var checkedOption by remember {
            mutableStateOf(selectedtext)
        }

        Row(Modifier.padding(bottom = dimensionResource(id = R.dimen._10sdp))) {
            Checkbox(checked = checkedOption == items, enabled = !readOnly, onCheckedChange = {
                if (!readOnly) {
                    checkedOption = if (it) {
                        items
                    } else {
                        ""
                    }
                    onChangeValue(indexMain, checkedOption)
                }
            }, colors = CheckboxDefaults.colors(checkedColor = colorResource(id = R.color.seekbar_km), uncheckedColor = colorResource(id = R.color.seekbar_km), disabledCheckedColor = colorResource(id = R.color.seekbar_km), disabledUncheckedColor = colorResource(id = R.color.seekbar_km), checkmarkColor = colorResource(id = R.color.darkLight)))

            MyTextLabel(modifier = Modifier.padding(dimensionResource(id = R.dimen._2sdp).value.dp), text = items, fontFamily = helvetica_bold, color = colorResource(id = R.color.lightDark))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenuBox(defaultValue: String, hintText: String, dropdownList: ArrayList<String>, resetToFirst: Boolean = false, onSelectItem: (index: Int, text: String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var mSelectedText by remember { mutableStateOf(defaultValue) }

    if (resetToFirst) {
        mSelectedText = defaultValue
    }
    Box(modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.text_field_bg), CircleShape)) {
        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {
            expanded = !expanded
        }) {
            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                dropdownList.forEachIndexed { index, data ->
                    DropdownMenuItem(text = { Text(fontSize = dimensionResource(id = R.dimen._12ssp).value.sp, text = data, fontFamily = helvetica_medium) }, modifier = Modifier.fillMaxWidth(), onClick = {
                        expanded = false
                        mSelectedText = data
                        onSelectItem(index, mSelectedText)
                    })
                }
            }

            TextField(label = { Text(text = hintText, fontFamily = helvetica_bold) }, value = mSelectedText, onValueChange = { mSelectedText = it }, readOnly = true, colors = TextFieldDefaults.colors(focusedContainerColor = colorResource(id = R.color.text_field_bg), unfocusedContainerColor = colorResource(id = R.color.text_field_bg), focusedTextColor = colorResource(id = R.color.lightDark), unfocusedTextColor = colorResource(id = R.color.lightDark)), trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) }, modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth())
        }
    }
}


@Composable
fun AndroidSwitch(switchState: Boolean, modifier: Modifier, onChangeValue: (state: Boolean) -> Unit) {
    var switchStates by remember { mutableStateOf(switchState) }

    Switch(checked = switchStates, modifier = modifier, onCheckedChange = {
        switchStates = it
        onChangeValue(switchStates)
    }, colors = SwitchDefaults.colors(
            checkedThumbColor = colorResource(id = R.color.seekbar_km),
            uncheckedThumbColor = colorResource(id = R.color.divider_grey),
            checkedTrackColor = colorResource(id = R.color.switch_on_track_color),
            uncheckedTrackColor = colorResource(id = R.color.edit_grey_back),
    ))
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyTabLayout(tabTitle: List<String>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxWidth()) {

        if (tabTitle.size <= 3) {
            TabRow(modifier = Modifier.height(dimensionResource(id = R.dimen._50sdp)), selectedTabIndex = pagerState.currentPage, containerColor = colorResource(id = R.color.calendarBackground), contentColor = Color.Black, divider = { colorResource(id = R.color.darkLight) }, indicator = { tabPositions ->
                TabRowDefaults.Indicator(Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]), color = colorResource(id = R.color.lightDark), height = dimensionResource(id = R.dimen._2sdp))
            }) {
                tabTitle.forEachIndexed { index, title ->
                    Tab(text = { Text(text = title, fontFamily = helvetica_medium, color = colorResource(id = R.color.lightDark), fontSize = dimensionResource(id = R.dimen._12ssp).value.sp) }, selectedContentColor = colorResource(id = R.color.lightDark), unselectedContentColor = colorResource(id = R.color.lightDark), selected = pagerState.currentPage == index, onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    })
                }
            }
        }else{
            ScrollableTabRow (modifier = Modifier.fillMaxWidth().height(dimensionResource(id = R.dimen._50sdp)), edgePadding = 0.dp, selectedTabIndex = pagerState.currentPage, containerColor = colorResource(id = R.color.calendarBackground), contentColor = Color.Black, divider = { colorResource(id = R.color.darkLight) }, indicator = { tabPositions ->
                TabRowDefaults.Indicator(Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]), color = colorResource(id = R.color.lightDark), height = dimensionResource(id = R.dimen._2sdp))
            }) {
                tabTitle.forEachIndexed { index, title ->
                    Tab(text = { Text(text = title, fontFamily = helvetica_medium, color = colorResource(id = R.color.lightDark), fontSize = dimensionResource(id = R.dimen._12ssp).value.sp) }, selectedContentColor = colorResource(id = R.color.lightDark), unselectedContentColor = colorResource(id = R.color.lightDark), selected = pagerState.currentPage == index, onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    })
                }
            }
        }
    }
}


@Composable
fun CustomView(onSwipe: () -> Unit) {

    // Adds view to Compose
    AndroidView(modifier = Modifier.fillMaxSize(), factory = { context ->
        // Creates view
        SwipeRefreshLayout(context).apply {

            setOnRefreshListener {
                onSwipe()
            }
        }
    }, update = { view ->
        // onSwipe()/* view.selectedItem = selectedItem*/
    })
}

