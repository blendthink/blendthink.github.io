package io.github.blendthink.content

import androidx.compose.runtime.Composable
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
                        width(8.em)
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
                    padding(40.px)
                    listStyle("none")
                }
            }) {
                Li({
                    style {
                        padding(20.px)
                        display(DisplayStyle.InlineBlock)
                    }
                }) {
                    A(href = "https://twitter.com/blendthink") {
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
                    A(href = "https://github.com/blendthink") {
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