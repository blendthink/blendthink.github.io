package io.github.blendthink.style

import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.selectors.CSSSelector

object AppStylesheet : StyleSheet() {
    init {

        CSSSelector.Universal style {
            margin(0.px)
        }

        media(mediaMaxWidth(640.px)) {

        }
    }
}