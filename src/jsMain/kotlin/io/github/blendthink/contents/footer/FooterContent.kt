package io.github.blendthink.contents.footer

import androidx.compose.runtime.Composable
import io.github.blendthink.contents.footer.components.Copyright
import io.github.blendthink.styles.AppStyle
import org.jetbrains.compose.web.dom.Div

@Composable
fun FooterContent() {
    Div({
        classes(AppStyle.footerContent)
    }) {
        Copyright()
    }
}