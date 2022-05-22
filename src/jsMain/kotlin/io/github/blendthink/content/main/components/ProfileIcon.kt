package io.github.blendthink.content.main.components

import androidx.compose.runtime.Composable
import io.github.blendthink.style.AppStyle
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Img

@Composable
fun ProfileIcon() {
    A(
        href = "https://blendthink.notion.site/blendthink/d9624d9360544b3bbf97074ec1706ce7",
        attrs = { classes(AppStyle.profileIcon) }
    ) {
        Img(src = "blendthink.png", alt = "blendthink")
    }
}
