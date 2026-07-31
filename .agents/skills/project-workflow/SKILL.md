---
name: project-workflow
description: Deliver small, safe pull requests for this Dart and Jaspr portfolio. Use when implementing a repository change through branch creation, focused editing, verification, pull request creation, CI monitoring, and rebase merge.
---

# Project Workflow

Deliver one reviewable outcome without mixing unrelated work.

## Prepare

- Read `AGENTS.md` and only the linked source-of-truth documents relevant to the task.
- Update local `main` and create a short-lived branch from it.
- Define the PR outcome in one sentence. Split work if the sentence needs “and” for unrelated outcomes.

## Implement

- Preserve existing user changes and keep edits within the stated outcome.
- Update the canonical file instead of copying facts into compatibility files.
- Keep content and interaction state in Jaspr; keep WebGL limited to rendering.
- Add or update tests and documentation only when they belong to the same outcome.

## Verify

- Run `mise run check`.
- Run `mise run agent-check` when agent instructions, Skills, or symlinks change.
- Inspect `git diff --check` and the complete scoped diff.
- Perform browser verification when behavior or presentation changes.

## Deliver

- Commit with an outcome-oriented message.
- Push the branch and open a non-draft pull request with summary and verification.
- Wait for required CI and confirm the PR is mergeable.
- Rebase merge and delete the remote branch.
- Update local `main` before starting the next branch.
