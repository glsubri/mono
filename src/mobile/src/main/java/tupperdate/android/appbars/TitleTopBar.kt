package tupperdate.android.appbars

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import tupperdate.android.R
import tupperdate.android.home.BarButton
import tupperdate.android.home.NormalButtonSize
import tupperdate.android.ui.TupperdateTypography

@Composable
fun TitleTopBar(
    onChatClick: () -> Unit,
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            BarButton(
                size = NormalButtonSize,
                onClick = { onChatClick() },
                backgroundColor = Color.Transparent,
                contentColor = Color.Black,
                content = { Icon(vectorResource(id = R.drawable.ic_chat_24px)) }
            )
            Column(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "tupper.date", // TODO colorize title
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = TupperdateTypography.h5
                )
            }
            BarButton(
                size = NormalButtonSize,
                onClick = { onProfileClick() },
                backgroundColor = Color.Transparent,
                contentColor = Color.Black,
                content = {
                    Icon(vectorResource(id = R.drawable.ic_account_circle_black_18dp))
                })
        }
    }

}
