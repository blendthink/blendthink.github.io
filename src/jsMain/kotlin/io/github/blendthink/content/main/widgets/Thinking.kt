package io.github.blendthink.content.main.widgets

import androidx.compose.runtime.Composable
import io.github.blendthink.style.AppStyle
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.I
import org.jetbrains.compose.web.dom.Small
import org.jetbrains.compose.web.dom.Text

@Composable
fun Thinking() {
    Small({
        classes(AppStyle.thinking)
    }) {
        I {
            Text("People have different ways of feeling and thinking.")
            Br()
            Text("All of those are right.")
        }
    }
}
