@file:Suppress("unused")

package io.github.blendthink.extension

import org.jetbrains.compose.web.css.StyleScope
import org.jetbrains.compose.web.css.textAlign

fun StyleScope.textAlign(textAlign: TextAlign) = textAlign(textAlign.value)

enum class TextAlign(val value: String) {
    Start("start"),
    End("end"),
    Left("left"),
    Right("right"),
    Center("center"),
    Justify("justify"),
    JustifyAll("justify-all"),
    MatchParent("match-parent"),
}
