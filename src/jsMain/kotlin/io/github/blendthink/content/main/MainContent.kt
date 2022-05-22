package io.github.blendthink.content.main

import androidx.compose.runtime.Composable
import io.github.blendthink.content.main.widgets.Name
import io.github.blendthink.content.main.widgets.ProfileIcon
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

        ProfileIcon()

        Name()

        Thinking()

        SocialLinks()
    }
}
