package io.github.blendthink

import io.github.blendthink.contents.header.HeaderContent
import org.jetbrains.compose.web.css.Style
import io.github.blendthink.contents.footer.FooterContent
import io.github.blendthink.contents.main.MainContent
import io.github.blendthink.styles.AppStyle
import org.jetbrains.compose.web.dom.Footer
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Main
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable("root") {
        Style(AppStyle)

        Header {
            HeaderContent()
        }
        Main {
            MainContent()
        }
        Footer {
            FooterContent()
        }
    }
}
