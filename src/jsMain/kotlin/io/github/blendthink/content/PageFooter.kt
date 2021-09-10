package io.github.blendthink.content

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Footer
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun PageFooter() {
    Footer({
        style {
            padding(20.px)
        }
    }) {
        Span({
            style {
                display(DisplayStyle.Block)
                textAlign("center")
                color(rgba(255, 255, 255, 0.3))
                fontSize(0.7.cssRem)
            }
        }) {
            Text("Copyright © 2021 blendthink All rights reserved.")
        }
    }
}