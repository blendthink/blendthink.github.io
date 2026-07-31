#!/usr/bin/env bash

set -euo pipefail

failures=0

check_link() {
  local link="$1"
  local expected="$2"

  if [[ ! -L "$link" ]]; then
    printf 'MISSING symlink: %s\n' "$link" >&2
    failures=$((failures + 1))
    return
  fi

  if [[ "$(readlink "$link")" != "$expected" || ! -e "$link" ]]; then
    printf 'INVALID symlink: %s -> %s (expected %s)\n' \
      "$link" "$(readlink "$link")" "$expected" >&2
    failures=$((failures + 1))
  fi
}

check_link CLAUDE.md AGENTS.md
check_link GEMINI.md AGENTS.md
check_link .github/copilot-instructions.md ../AGENTS.md

while IFS= read -r skill; do
  name="$(basename "$skill")"
  if [[ ! -f "$skill/SKILL.md" ]]; then
    printf 'MISSING SKILL.md: %s\n' "$skill" >&2
    failures=$((failures + 1))
  fi
  check_link ".claude/skills/$name" "../../.agents/skills/$name"
  check_link ".cursor/skills/$name" "../../.agents/skills/$name"
  check_link ".windsurf/skills/$name" "../../.agents/skills/$name"
done < <(find .agents/skills -mindepth 1 -maxdepth 1 -type d ! -name '.*' | sort)

if ((failures > 0)); then
  printf 'Agent SSoT validation failed: %d issue(s)\n' "$failures" >&2
  exit 1
fi

printf 'Agent SSoT validation passed.\n'
