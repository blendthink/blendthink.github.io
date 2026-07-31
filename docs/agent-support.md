# AI agent support

## Single source of truth

Repository-specific Agent Skills live only in `.agents/skills/`. Never copy a
Skill into a tool-specific directory. Tools that do not discover the shared
location receive a relative symbolic link to the canonical Skill.

The always-on repository instructions live in `AGENTS.md`. Compatibility files
such as `CLAUDE.md` and `GEMINI.md` are symbolic links to it.

## Supported entry points

| Agent | Instructions | Skills |
| --- | --- | --- |
| Codex | `AGENTS.md` | `.agents/skills/` |
| Claude Code | `CLAUDE.md` | `.claude/skills/` symlinks |
| Gemini CLI | `GEMINI.md` | `.agents/skills/` |
| Cursor | `AGENTS.md` | `.cursor/skills/` symlinks |
| GitHub Copilot | `.github/copilot-instructions.md` | `.agents/skills/` |
| Windsurf | `AGENTS.md` | `.windsurf/skills/` symlinks |

Compatibility paths are bridges, not additional sources of truth.

## Adding a Skill

1. Create `<name>/SKILL.md` under `.agents/skills/`.
2. Use lowercase hyphenated names and include only `name` and `description` in
   the portable frontmatter.
3. Add relative compatibility symlinks only for agents that need them.
4. Run `mise run agent-check` and the Skill validator.
5. Deliver one Skill per pull request unless multiple Skills are inseparable.

Review every third-party Skill before adding it. Do not grant broad shell access
through Skill metadata, and pin an external source when an update mechanism is
introduced.
