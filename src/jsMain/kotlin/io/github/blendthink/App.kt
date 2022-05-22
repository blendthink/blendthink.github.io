package io.github.blendthink

import io.github.blendthink.content.header.HeaderContent
import org.jetbrains.compose.web.css.Style
import io.github.blendthink.content.footer.FooterContent
import io.github.blendthink.content.main.MainContent
import io.github.blendthink.style.AppStyle
import org.jetbrains.compose.web.dom.Footer
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Main
import org.jetbrains.compose.web.renderComposableInBody

fun main() {
    renderComposableInBody {
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
