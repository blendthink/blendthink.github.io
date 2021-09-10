package io.github.blendthink.content

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Main

@Composable
fun PageMain() {
    Main {
        Div({
            style {
                textAlign("center")
            }
        }) {
            Img(src = "okayaman.png", alt = "おかやまん") {
                style {
                    width(8.em)
                    borderRadius(50.percent)
                }
            }

        }
    }
}