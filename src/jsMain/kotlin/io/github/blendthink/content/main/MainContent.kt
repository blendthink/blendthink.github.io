package io.github.blendthink.content.main

import androidx.compose.runtime.Composable
import io.github.blendthink.content.main.widgets.Name
import io.github.blendthink.content.main.widgets.SocialLinks
import io.github.blendthink.content.main.widgets.Thinking
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun MainContent() {
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

        Name()

        Thinking()

        SocialLinks()
    }
}
