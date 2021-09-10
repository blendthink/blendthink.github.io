package io.github.blendthink.content

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun PageMain() {
    Main {
        Div({
            style {
                textAlign("center")
            }
        }) {

            A(href = "https://blendthink.notion.site/blendthink/d9624d9360544b3bbf97074ec1706ce7", attrs = {
                target(ATarget.Blank)
            }) {
                Img(src = "blendthink.png", alt = "blendthink") {
                    style {
                        width(8.em)
                        borderRadius(50.percent)
                        padding(40.px)
                    }
                }
            }

            Ul({
                style {
                    paddingLeft(0.px)
                    listStyle("none")
                }
            }) {
                Li({
                    style {
                        padding(20.px)
                        display(DisplayStyle.InlineBlock)
                    }
                }) {
                    A(href = "https://twitter.com/blendthink", attrs = {
                        target(ATarget.Blank)
                    }) {
                        I({
                            classes("fab", "fa-twitter", "fa-3x")
                            style {
                                color(rgba(255, 255, 255, 0.3))
                            }
                        })
                    }
                }
                Li({
                    style {
                        padding(20.px)
                        display(DisplayStyle.InlineBlock)
                    }
                }) {
                    A(href = "https://github.com/blendthink", attrs = {
                        target(ATarget.Blank)
                    }) {
                        I({
                            classes("fab", "fa-github", "fa-3x")
                            style {
                                color(rgba(255, 255, 255, 0.3))
                            }
                        })
                    }
                }
            }
        }
    }
}