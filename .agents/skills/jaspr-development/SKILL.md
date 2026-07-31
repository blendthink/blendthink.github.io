---
name: jaspr-development
description: Implement and review Dart/Jaspr changes for this interactive portfolio. Use when changing Jaspr components, client/server boundaries, static rendering, browser interactions, CSS, WebGL integration, routing, or Dart dependencies in this repository.
---

# Jaspr Development

Preserve static content and accessible controls while adding client-side exploration behavior.

## Inspect the source of truth

- Read `AGENTS.md` first.
- Read `docs/renewal-plan.md` for experience and accessibility requirements.
- Read `docs/3d-architecture.md` before changing WebGL or exploration state boundaries.
- Read versions and dependencies from `mise.toml` and `pubspec.yaml`; do not repeat them here.

## Place responsibilities

- Keep page structure, content, navigation, accessibility, and interaction state in Jaspr.
- Use client components only where browser APIs or interactive state require them.
- Keep WebGL code under `lib/three_d/` and treat it as a projection of Jaspr-owned state.
- Keep semantic DOM controls usable when WebGL2 is missing or motion is reduced.
- Keep global presentation in `web/styles.css` until a deliberate styling architecture change is approved.
- Avoid adding Flutter dependencies or a JavaScript runtime bridge solely for rendering.

## Implement safely

- Guard browser-only APIs so static rendering remains valid.
- Dispose timers, listeners, and WebGL resources with the component lifecycle.
- Preserve keyboard and touch paths when adding pointer interaction.
- Make content discoverable without completing hidden interactions.
- Keep assets lightweight and avoid blocking initial static rendering.

## Verify

1. Format changed Dart files with `mise exec -- dart format <paths>`.
2. Run `mise run check`.
3. Run `git diff --check`.
4. For visual or interactive changes, serve the production build and verify the affected behavior in a browser.
5. Confirm the semantic fallback still exposes the same information and controls.

If a framework behavior is uncertain or version-dependent, consult current official Jaspr or Dart documentation before implementing it.
