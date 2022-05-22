package io.github.blendthink.content.main

import androidx.compose.runtime.Composable
import io.github.blendthink.content.main.widgets.Name
import io.github.blendthink.content.main.widgets.ProfileIcon
import io.github.blendthink.content.main.widgets.SocialLinks
import io.github.blendthink.content.main.widgets.Thinking
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
