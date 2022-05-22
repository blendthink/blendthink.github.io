package io.github.blendthink.contents.footer.components

import androidx.compose.runtime.Composable
import io.github.blendthink.styles.AppStyle
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Small
import org.jetbrains.compose.web.dom.Text

@Composable
fun Copyright() {
    Div {
        Small({ classes(AppStyle.copyright) }) {
            Text("Copyright © 2022 blendthink")
        }
    }
}
