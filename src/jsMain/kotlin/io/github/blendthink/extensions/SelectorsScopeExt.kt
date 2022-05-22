@file:Suppress("unused")

package io.github.blendthink.extensions

import org.jetbrains.compose.web.css.SelectorsScope

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element
fun SelectorsScope.tag(tag: Tag) = type(tag.name)

enum class Tag {
    // Main root
    Html,

    // Document metadata
    Base,
    Head,
    Link,
    Meta,
    Style,
    Title,

    // Sectioning root
    Body,

    // Content sectioning
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

    // Text content
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

    // Inline text semantics
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

    // Image and multimedia
    Area,
    Audio,
    Img,
    Map,
    Track,
    Video,

    // Embedded content
    Embed,
    Iframe,
    Object,
    Picture,
    Portal,
    Source,

    // SVG and MathML
    Svg,
    Math,

    // Scripting
    Canvas,
    Noscript,
    Script,

    // Demarcating edits
    Del,
    Ins,

    // Table content
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

    // Forms
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

    // Interactive elements
    Details,
    Dialog,
    Summary,

    // Web Components
    Slot,
    Template,
}
