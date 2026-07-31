# 3D exploration architecture

## Decision

The first WebGL implementation uses the browser's WebGL2 API directly from Dart.

Jaspr owns navigation, content, interaction state, accessibility, and static rendering. The WebGL renderer is an isolated client-side projection of the same state. If WebGL2 is unavailable, the existing semantic DOM and CSS room remain usable.

## Why not use `three_js` now

`three_js` 0.3.0 is currently a Flutter package. Using it from this Jaspr site would introduce the Flutter web runtime and an additional JavaScript binding solely for the renderer. That cost is difficult to justify for the initial room.

The custom renderer is intentionally small and dependency-free. It supports primitive geometry now and leaves a narrow boundary where a glTF/GLB loader or another renderer can be introduced later.

## Boundaries

- `ExplorationRoom`: movement, discoveries, panels, and accessible controls.
- `EngineerHouseCanvas`: canvas lifecycle and synchronization with Jaspr state.
- `WebGlHouseRenderer`: WebGL resources and drawing only.
- Semantic DOM/CSS scene: server-rendered fallback and interactive hit targets.

The renderer must not become the source of truth for content or navigation.
