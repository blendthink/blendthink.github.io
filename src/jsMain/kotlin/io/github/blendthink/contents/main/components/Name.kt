package io.github.blendthink.contents.main.components

import androidx.compose.runtime.Composable
import io.github.blendthink.styles.AppStyle
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text

@Composable
fun Name() {
    H2({
        classes(AppStyle.name)
    }) {
        Text("Tatsuya Okayama")
    }
}
