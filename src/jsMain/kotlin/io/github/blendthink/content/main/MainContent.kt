package io.github.blendthink.content.main

import androidx.compose.runtime.Composable
import io.github.blendthink.content.main.components.Name
import io.github.blendthink.content.main.components.ProfileIcon
import io.github.blendthink.content.main.components.SocialLinks
import io.github.blendthink.content.main.components.Thinking
import io.github.blendthink.style.AppStyle
import org.jetbrains.compose.web.dom.*

@Composable
fun MainContent() {
    Div({
        classes(AppStyle.mainContent)
    }) {

        ProfileIcon()

        Name()

        Thinking()

        SocialLinks()
    }
}
