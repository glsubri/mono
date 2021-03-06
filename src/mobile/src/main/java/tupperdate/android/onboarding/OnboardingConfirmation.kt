package tupperdate.android.onboarding

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.AmbientEmphasisLevels
import androidx.compose.material.ProvideEmphasis
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import tupperdate.android.R
import tupperdate.android.appbars.onlyReturnTopBar
import tupperdate.android.ui.TupperdateTheme
import tupperdate.android.ui.TupperdateTypography
import tupperdate.android.ui.material.BrandedButton
import tupperdate.android.ui.material.BrandedTextField

@Composable
fun OnboardingConfirmation(
    onButtonClick: () -> Unit,
    onReturnClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val (code, setCode) = remember { mutableStateOf("") }

    onlyReturnTopBar(onReturnClick)

    Column(
        modifier.padding(top = 102.dp, bottom = 42.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = stringResource(R.string.onboardingConfirmation_title),
            style = TupperdateTypography.h5,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = stringResource(R.string.onboardingConfirmation_reception_text),
            modifier = Modifier.padding(bottom = 38.dp)
        )

        codeInput(code = code, onCodeChanged = setCode)

        // TODO Check code with database

        Spacer(modifier = Modifier.weight(1f, true))

        BrandedButton(
            value = stringResource(R.string.onboardingConfirmation_button_text),
            onClick = onButtonClick,
            modifier = Modifier
                .fillMaxWidth()
        )

        ProvideEmphasis(emphasis = AmbientEmphasisLevels.current.disabled) {
            Text(
                text = stringResource(R.string.onboardingConfirmation_bottom_text),
                style = TupperdateTypography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp)
            )
        }
    }
}

@Composable
private fun codeInput(
    code: String,
    onCodeChanged: ((String)) -> Unit,
    modifier: Modifier = Modifier,
) {
    BrandedTextField(
        value = code,
        label = { Text(stringResource(R.string.onboardingConfirmation_code_label)) },
        onValueChange = onCodeChanged,
        placeholder = { Text(stringResource(R.string.onboardingConfirmation_code_placeholder)) },
        keyboardType = KeyboardType.Number,
        modifier = modifier.fillMaxWidth(),
    )
}

@Preview(showBackground = true)
@Composable
private fun OnboardingConfirmationPreview() {
    TupperdateTheme {
        OnboardingConfirmation(
            {}, {},
            Modifier.background(Color.White)
                .fillMaxSize()
        )
    }
}