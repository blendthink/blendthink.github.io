package io.github.blendthink.style

import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.media
import org.jetbrains.compose.web.css.mediaMaxWidth
import org.jetbrains.compose.web.css.px

object AppStylesheet : StyleSheet() {
    init {
        media(mediaMaxWidth(640.px)) {

        }
    }
}