package jet.pack.compose.masterdetails.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme
import java.util.*

@Composable
fun PokemonButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        ),
        modifier = modifier
    ) {
        Text(
            text = text.toUpperCase(Locale.getDefault()),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.button,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}


@Preview
@Composable
fun PokemonButtonLightPreview() {
    MasterDetailsTheme {
        PokemonButton(text = "Click me", onClick = { /* */ })
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonButtonDarkPreview() {
    MasterDetailsTheme(darkTheme = true) {
        PokemonButton(text = "Click me", onClick = { /* */ })
    }
}