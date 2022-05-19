package io.github.blendthink.style

import org.jetbrains.compose.web.css.*

object AppStyle : StyleSheet() {
    init {

        universal style {
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