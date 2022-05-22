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

            A(href = "https://blendthink.notion.site/blendthink/d9624d9360544b3bbf97074ec1706ce7") {
                Img(src = "blendthink.png", alt = "blendthink") {
                    style {
                        width(16.cssRem)
                        borderRadius(50.percent)
                        padding(40.px)
                    }
                }
            }

            H2({
                style {
                    paddingBottom(20.px)
                    color(rgb(255, 255, 255))
                }
            }) {
                Text("Tatsuya Okayama")
            }

            Small({
                style {
                    color(rgba(255, 255, 255, 0.3))
                }
            }) {
                I {
                    Text("People have different ways of feeling and thinking. All of those are right.")
                }
            }

            Ul({
                style {
                    padding(1.cssRem)
                    listStyle("none")
                }
            }) {
                Li({
                    style {
                        display(DisplayStyle.InlineBlock)
                        padding(1.cssRem)
                    }
                }) {
                    A(
                        href = "https://twitter.com/blendthink",
                        attrs = {
                            target(ATarget.Blank)
                        },
                    ) {
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
                        display(DisplayStyle.InlineBlock)
                        padding(1.cssRem)
                    }
                }) {
                    A(
                        href = "https://github.com/blendthink",
                        attrs = {
                            target(ATarget.Blank)
                        },
                    ) {
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
