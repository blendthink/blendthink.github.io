package io.github.blendthink

import org.jetbrains.compose.web.css.Style
import io.github.blendthink.content.PageFooter
import io.github.blendthink.content.PageHeader
import io.github.blendthink.content.PageMain
import io.github.blendthink.style.AppStylesheet
import org.jetbrains.compose.web.renderComposable

fun main() {

    renderComposable(rootElementId = "root") {
        Style(AppStylesheet)

        PageHeader()
        PageMain()
        PageFooter()
    }
}
