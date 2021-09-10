package io.github.blendthink.style

import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.selectors.CSSSelector
import org.jetbrains.compose.web.css.selectors.id
import org.jetbrains.compose.web.css.selectors.type

object AppStylesheet : StyleSheet() {
    init {

        CSSSelector.Universal style {
            margin(0.px)
            backgroundColor(rgb(50, 50, 54))
        }

        id("root") style {
            display(DisplayStyle.Flex)
            flexFlow(FlexDirection.Column, FlexWrap.Wrap)
            minHeight(100.vh)

            type("main") style {
                flex(1)
            }
        }

        media(mediaMaxWidth(640.px)) {

        }
    }
}