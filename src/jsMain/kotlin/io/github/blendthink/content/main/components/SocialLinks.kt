package io.github.blendthink.content.main.components

import androidx.compose.runtime.Composable
import io.github.blendthink.style.AppStyle
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.I

@Composable
fun SocialLinks() {
    Div({
        classes(AppStyle.socialLinks)
    }) {
        SocialMedia.values().forEach {
            SocialLink(it)
        }
    }
}

@Composable
fun SocialLink(socialMedia: SocialMedia) {
    Div({
        classes(AppStyle.socialLink)
    }) {
        A(
            href = socialMedia.link,
            attrs = { target(ATarget.Blank) },
        ) {
            I({
                classes("fa-brands", "fa-${socialMedia.awesomeName}", "fa-3x")
            })
        }
    }
}

enum class SocialMedia(
    val link: String,
    val awesomeName: String,
) {
    Twitter("https://twitter.com/blendthink", "twitter"),
    Github("https://github.com/blendthink", "github"),
    SpeakerDeck("https://speakerdeck.com/blendthink", "speaker-deck"),
}
