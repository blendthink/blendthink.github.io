package io.github.blendthink.style

import io.github.blendthink.extension.Tag
import io.github.blendthink.extension.tag
import org.jetbrains.compose.web.css.*

object AppStyle : StyleSheet() {
    init {
        tag(Tag.Body) style {
            display(DisplayStyle.Flex)
            flexFlow(FlexDirection.Column, FlexWrap.Wrap)
            minHeight(100.vh)
            backgroundColor(Color.black)

            tag(Tag.Main) style {
                flex(1)
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.Center)
            }
        }
    }

    val mainContent by style {
        textAlign("center")
    }

    val profileIcon by style {
        tag(Tag.Img) style {
            width(16.cssRem)
            borderRadius(50.percent)
            padding(2.cssRem)
        }
    }

    val name by style {
        marginBottom(1.5.cssRem)
        color(Color.white)
    }

    val thinking by style {
        color(Color.dimgray)
    }

    val socialLinks by style {
        padding(1.cssRem)
    }

    val socialLink by style {
        display(DisplayStyle.InlineBlock)
        padding(1.cssRem)

        tag(Tag.Svg) style {
            color(Color.dimgray)
        }
    }

    val footerContent by style {
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        padding(1.cssRem)
    }

    val copyright by style {
        color(Color.dimgray)
        fontSize(0.75.cssRem)
    }
}
