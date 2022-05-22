@file:Suppress("unused")

package io.github.blendthink.extensions

import org.jetbrains.compose.web.css.SelectorsScope

fun SelectorsScope.tag(tag: Tag) = type(tag.name)

enum class Tag {
    /**
     * Main root
     * see https://developer.mozilla.org/en-US/docs/Web/HTML/Element#main_root
     */
    Html,

    /**
     * Document metadata
     * see https://developer.mozilla.org/en-US/docs/Web/HTML/Element#document_metadata
     */
    Base,
    Head,
    Link,
    Meta,
    Style,
    Title,

    /**
     * Sectioning root
     * see https://developer.mozilla.org/en-US/docs/Web/HTML/Element#sectioning_root
     */
    Body,

    /**
     * Content sectioning
     * see https://developer.mozilla.org/en-US/docs/Web/HTML/Element#content_sectioning
     */
    Address,
    Article,
    Aside,
    Footer,
    Header,
    H1,
    H2,
    H3,
    H4,
    H5,
    H6,
    Main,
    Nav,
    Section,

    /**
     * Text content
     * see https://developer.mozilla.org/en-US/docs/Web/HTML/Element#text_content
     */
    Blockquote,
    Dd,
    Div,
    Dl,
    Dt,
    Figcaption,
    Figure,
    Hr,
    Li,
    Menu,
    P,
    Pre,
    Ul,

    /**
     * Inline text semantics
     * see https://developer.mozilla.org/en-US/docs/Web/HTML/Element#inline_text_semantics
     */
    A,
    Abbr,
    B,
    Bdi,
    Bdo,
    Br,
    Cite,
    Code,
    Data,
    Dfn,
    Em,
    I,
    Kbd,
    Mark,
    Q,
    Rp,
    Rt,
    Ruby,
    S,
    Samp,
    Small,
    Strong,
    Sub,
    Sup,
    Time,
    U,
    Var,
    Wbr,

    /**
     * Image and multimedia
     * see https://developer.mozilla.org/en-US/docs/Web/HTML/Element#image_and_multimedia
     */
    Area,
    Audio,
    Img,
    Map,
    Track,
    Video,

    /**
     * Embedded content
     * see https://developer.mozilla.org/en-US/docs/Web/HTML/Element#embedded_content
     */
    Embed,
    Iframe,
    Object,
    Picture,
    Portal,
    Source,

    /**
     * SVG and MathML
     * see https://developer.mozilla.org/en-US/docs/Web/HTML/Element#svg_and_mathml
     */
    Svg,
    Math,

    /**
     * Scripting
     * see https://developer.mozilla.org/en-US/docs/Web/HTML/Element#scripting
     */
    Canvas,
    Noscript,
    Script,

    /**
     * Demarcating edits
     * see https://developer.mozilla.org/en-US/docs/Web/HTML/Element#demarcating_edits
     */
    Del,
    Ins,

    /**
     * Table content
     * see https://developer.mozilla.org/en-US/docs/Web/HTML/Element#table_content
     */
    Caption,
    Col,
    Colgroup,
    Table,
    Tbody,
    Td,
    Tfoot,
    Th,
    Thead,
    Tr,

    /**
     * Forms
     * see https://developer.mozilla.org/en-US/docs/Web/HTML/Element#forms
     */
    Button,
    Datalist,
    Fieldset,
    Form,
    Input,
    Label,
    Legend,
    Meter,
    Optgroup,
    Option,
    Output,
    Progress,
    Select,
    Textarea,

    /**
     * Interactive elements
     * see https://developer.mozilla.org/en-US/docs/Web/HTML/Element#interactive_elements
     */
    Details,
    Dialog,
    Summary,

    /**
     * Web Components
     * see https://developer.mozilla.org/en-US/docs/Web/HTML/Element#web_components
     */
    Slot,
    Template,
}
