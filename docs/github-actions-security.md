# GitHub Actions security

The workflows in this repository follow these rules:

- Default workflow permissions are empty and each job receives only the permissions it needs.
- Every third-party action is pinned to a full commit SHA.
- The version represented by each SHA is kept as an inline comment for maintainability.
- Checkout does not persist the GitHub token in the local Git configuration.
- Deploy credentials are available only to the deploy job.
- Dependency installation must match the committed lockfile.
- Pull requests are checked for vulnerable dependencies and disallowed strong-copyleft licenses.
- Dependabot monitors Dart packages and GitHub Actions.
- Jobs have explicit timeouts.

## Applied repository settings

The following settings were applied through the GitHub API on 2026-07-31:

- Actions are limited to GitHub-owned actions and `jdx/mise-action`.
- Full-length commit SHA pinning is required by repository policy.
- The default workflow token is read-only and cannot approve pull requests.
- Dependabot alerts and security updates are enabled.
- Secret scanning and push protection are enabled.
- `main` requires pull requests, applies protection to administrators, requires resolved conversations and linear history, and rejects force pushes and deletion.

Secret scanning for non-provider patterns and validity checks remain disabled because GitHub did not enable those capabilities for this repository. Required signed commits also remain disabled until a signing workflow is established for every contributor and automation identity.

## Repository settings checklist

Some protections cannot be expressed in repository files. Configure them in GitHub:

1. In **Settings → Actions → General**, retain the current allowlist of GitHub-owned actions and `jdx/mise-action`.
2. Retain **Require actions to be pinned to a full-length commit SHA**.
3. Set the default workflow token permission to **Read repository contents and packages permissions**.
4. Disable permission for GitHub Actions to create or approve pull requests unless it is explicitly needed.
5. Require approval for workflows from first-time external contributors.
6. Protect `main` with required pull requests, required status checks, resolved conversations, and no force pushes.
7. Protect the `github-pages` environment and allow deployment only from `main`.
8. Enable Dependabot alerts, Dependabot security updates, secret scanning, and push protection.

When Dependabot updates an action SHA, review that the inline version comment is updated in the same pull request.

The intended `main` branch protection payload is stored in `.github/branch-protection.json` and can be reapplied with:

```sh
gh api --method PUT \
  repos/blendthink/blendthink.github.io/branches/main/protection \
  --input .github/branch-protection.json
```
