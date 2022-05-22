package io.github.blendthink.content.footer

import androidx.compose.runtime.Composable
import io.github.blendthink.content.footer.widgets.Copyright
import io.github.blendthink.style.AppStyle
import org.jetbrains.compose.web.dom.Div

@Composable
fun FooterContent() {
    Div({
        classes(AppStyle.footerContent)
    }) {
        Copyright()
    }
}