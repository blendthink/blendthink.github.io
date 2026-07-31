import 'package:jaspr/dom.dart';
import 'package:jaspr/jaspr.dart';

import 'components/exploration_room.dart';

class App extends StatelessComponent {
  const App({super.key});

  @override
  Component build(BuildContext context) {
    return div(classes: 'site-shell', [
      header(classes: 'site-header', [
        a(href: '/', classes: 'brand', [.text('blendthink')]),
        div(classes: 'header-actions', [
          a(
            href: 'https://github.com/blendthink',
            target: Target.blank,
            attributes: const {'aria-label': 'GitHubを開く'},
            [.text('GitHub ↗')],
          ),
          a(
            href: 'https://blendthink.notion.site/d9624d9360544b3bbf97074ec1706ce7',
            target: Target.blank,
            attributes: const {'aria-label': '詳しい履歴書を開く'},
            [.text('Resume ↗')],
          ),
        ]),
      ]),
      main_([
        const ExplorationRoom(),
        Component.element(
          tag: 'noscript',
          children: [
            section(classes: 'fallback-panel', [
              h1([.text('Tatsuya Okayama / blendthink')]),
              p([.text('Dart・Flutter・OSSを中心に活動するソフトウェアエンジニアです。')]),
            ]),
          ],
        ),
      ]),
    ]);
  }
}
