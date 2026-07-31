# Project instructions

## Mission

Build an interactive personal portfolio in Dart and Jaspr. Visitors explore an
engineer's house, inspect objects, and discover information without relying on
generic scroll-triggered reveals.

## Sources of truth

- Product direction and experience principles: `docs/renewal-plan.md`
- Current 3D rendering boundaries: `docs/3d-architecture.md`
- GitHub Actions security policy: `docs/github-actions-security.md`
- Agent compatibility and Skill layout: `docs/agent-support.md`
- Dart version and repeatable commands: `mise.toml`
- Dart dependencies and Jaspr mode: `pubspec.yaml`
- Reusable agent workflows: `.agents/skills/`

Do not duplicate version numbers, commands, or detailed architectural decisions
here. Update their source of truth instead.

## Engineering constraints

- Keep Jaspr responsible for content, navigation, accessibility, and state.
- Keep WebGL rendering isolated from the semantic DOM fallback.
- Preserve keyboard, touch, reduced-motion, and non-WebGL access to content.
- Do not make Notion or another external service required at runtime.
- Pin third-party GitHub Actions to full commit SHAs with version comments.

## Workflow

- Start each change from the latest `main` on a short-lived branch.
- Keep one reviewable outcome per pull request.
- Do not mix feature work, refactoring, and policy changes without a clear need.
- Run `mise run check` before committing.
- Open a pull request, wait for required CI, then rebase merge.
- Start the next task from the newly updated `main`.

Use the `project-workflow` Skill for the complete delivery sequence.
