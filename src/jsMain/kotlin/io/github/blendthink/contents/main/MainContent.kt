package io.github.blendthink.contents.main

import androidx.compose.runtime.Composable
import io.github.blendthink.contents.main.components.Name
import io.github.blendthink.contents.main.components.ProfileIcon
import io.github.blendthink.contents.main.components.SocialLinks
import io.github.blendthink.contents.main.components.Thinking
import io.github.blendthink.styles.AppStyle
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
