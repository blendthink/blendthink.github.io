package io.github.blendthink.style

import org.jetbrains.compose.web.css.*

object AppStyle : StyleSheet() {
    init {
        type("body") style {
            display(DisplayStyle.Flex)
            flexFlow(FlexDirection.Column, FlexWrap.Wrap)
            minHeight(100.vh)
            backgroundColor(Color.black)

            type("main") style {
                flex(1)
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.Center)
            }
        }
    }
}
