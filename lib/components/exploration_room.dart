import 'dart:async';

import 'package:jaspr/dom.dart';
import 'package:jaspr/jaspr.dart';
import 'package:universal_web/web.dart' as web;

@client
class ExplorationRoom extends StatefulComponent {
  const ExplorationRoom({super.key});

  @override
  State<ExplorationRoom> createState() => _ExplorationRoomState();
}

enum _Direction { north, east, south, west }

enum _Discovery { computer, cat, bookshelf, secretDoor }

class _Point {
  const _Point(this.x, this.y);

  final int x;
  final int y;
}

class _ExplorationRoomState extends State<ExplorationRoom> {
  static const _minX = 0;
  static const _maxX = 8;
  static const _minY = 0;
  static const _maxY = 5;

  int _x = 4;
  int _y = 4;
  _Direction _direction = _Direction.north;
  String? _openPanel;
  bool _listMode = false;
  final Set<_Discovery> _discoveries = {};
  StreamSubscription<web.Event>? _keySubscription;

  @override
  void initState() {
    super.initState();
    if (kIsWeb) {
      _keySubscription = web.window.onKeyDown.listen(_handleKeyDown);
    }
  }

  @override
  void dispose() {
    _keySubscription?.cancel();
    super.dispose();
  }

  void _handleKeyDown(web.Event event) {
    final keyboardEvent = event as web.KeyboardEvent;
    switch (keyboardEvent.key.toLowerCase()) {
      case 'w':
      case 'arrowup':
        keyboardEvent.preventDefault();
        _move(0, -1, _Direction.north);
      case 'd':
      case 'arrowright':
        keyboardEvent.preventDefault();
        _move(1, 0, _Direction.east);
      case 's':
      case 'arrowdown':
        keyboardEvent.preventDefault();
        _move(0, 1, _Direction.south);
      case 'a':
      case 'arrowleft':
        keyboardEvent.preventDefault();
        _move(-1, 0, _Direction.west);
      case 'e':
      case 'enter':
        _inspectNearby();
      case 'escape':
        setState(() => _openPanel = null);
    }
  }

  void _move(int dx, int dy, _Direction direction) {
    final nextX = (_x + dx).clamp(_minX, _maxX);
    final nextY = (_y + dy).clamp(_minY, _maxY);

    setState(() {
      _x = nextX;
      _y = nextY;
      _direction = direction;
      _openPanel = null;
    });
  }

  bool _near(_Point point, {int distance = 1}) {
    return (_x - point.x).abs() + (_y - point.y).abs() <= distance;
  }

  String? get _nearbyObject {
    if (_near(const _Point(1, 1))) return 'computer';
    if (_near(const _Point(7, 4))) return 'cat';
    if (_near(const _Point(7, 1))) return 'bookshelf';
    if (_discoveries.contains(_Discovery.secretDoor) && _near(const _Point(8, 0), distance: 2)) {
      return 'secret';
    }
    return null;
  }

  void _inspectNearby() {
    final object = _nearbyObject;
    if (object == null) {
      setState(() => _openPanel = 'empty');
      return;
    }

    setState(() {
      _openPanel = object;
      switch (object) {
        case 'computer':
          _discoveries.add(_Discovery.computer);
        case 'cat':
          _discoveries.add(_Discovery.cat);
        case 'bookshelf':
          _discoveries.add(_Discovery.bookshelf);
          if (_discoveries.contains(_Discovery.computer) && _discoveries.contains(_Discovery.cat)) {
            _discoveries.add(_Discovery.secretDoor);
          }
      }
    });
  }

  @override
  Component build(BuildContext context) {
    final nearby = _nearbyObject;
    final progress = _discoveries.length;

    return section(classes: 'experience', [
      div(classes: 'experience-intro', [
        div([
          p(classes: 'eyebrow', [.text("BLENDTHINK'S ENGINEER HOUSE")]),
          h1([.text('小さなエンジニアと、'), br(), .text('大きなアイデアの家。')]),
        ]),
        div(classes: 'intro-copy', [
          p([.text('部屋を歩いて、気になるものを調べてみてください。')]),
          p(classes: 'key-help', [.text('移動: WASD / 矢印キー　調べる: E / Enter')]),
        ]),
      ]),
      div(classes: 'experience-toolbar', [
        div(classes: 'discovery-progress', [
          span(classes: 'status-dot', []),
          .text('発見 $progress / 4'),
        ]),
        button(
          classes: 'mode-button',
          attributes: {'aria-pressed': _listMode.toString()},
          onClick: () => setState(() => _listMode = !_listMode),
          [.text(_listMode ? '家に戻る' : '一覧で見る')],
        ),
      ]),
      if (_listMode) _buildListMode() else _buildRoom(nearby),
      if (_openPanel != null) _buildPanel(_openPanel!),
    ]);
  }

  Component _buildRoom(String? nearby) {
    final left = 12 + _x * 8.5;
    final top = 22 + _y * 9.5;

    return div(classes: 'room-frame', [
      div(classes: 'room-glow', []),
      div(
        classes: 'room',
        attributes: const {'aria-label': '3Dの開発部屋'},
        [
          div(classes: 'wall wall-left', []),
          div(classes: 'wall wall-right', []),
          div(classes: 'floor-grid', []),
          _roomObject('desk computer', 'PC', '💻', 12, 15),
          _roomObject('shelf bookshelf', '本棚', '▥', 75, 10),
          _roomObject('plant', '観葉植物', '♣', 46, 8),
          _roomObject('cat', '猫', '●', 75, 66),
          div(
            classes: 'character facing-${_direction.name}',
            styles: Styles(raw: {'left': '$left%', 'top': '$top%'}),
            attributes: const {'aria-label': 'エンジニアのキャラクター'},
            [
              div(classes: 'character-shadow', []),
              div(classes: 'character-body', [
                div(classes: 'character-hair', []),
                div(classes: 'character-face', [
                  span([.text('• ᴗ •')]),
                ]),
                div(classes: 'character-hoodie', [
                  span([.text('</>')]),
                ]),
                div(classes: 'character-legs', []),
              ]),
            ],
          ),
          if (_discoveries.contains(_Discovery.secretDoor))
            button(
              classes: 'secret-door',
              attributes: const {'aria-label': '見つけた隠し扉'},
              onClick: () {
                setState(() {
                  _openPanel = 'secret';
                  _discoveries.add(_Discovery.secretDoor);
                });
              },
              [
                span([.text('?')]),
              ],
            ),
          if (nearby != null)
            button(classes: 'inspect-prompt', onClick: _inspectNearby, [
              span(classes: 'key', [.text('E')]),
              .text('調べる'),
            ]),
        ],
      ),
      _buildControls(),
    ]);
  }

  Component _roomObject(
    String classes,
    String label,
    String symbol,
    num left,
    num top,
  ) {
    return button(
      classes: 'room-object $classes',
      styles: Styles(raw: {'left': '$left%', 'top': '$top%'}),
      attributes: {'aria-label': '$labelへ近づく'},
      onClick: () {
        final destination = switch (label) {
          'PC' => const _Point(1, 2),
          '本棚' => const _Point(7, 2),
          '猫' => const _Point(7, 4),
          _ => null,
        };
        if (destination != null) {
          setState(() {
            _x = destination.x;
            _y = destination.y;
          });
        }
      },
      [
        span([.text(symbol)]),
        small([.text(label)]),
      ],
    );
  }

  Component _buildControls() {
    return div(
      classes: 'movement-controls',
      attributes: const {'aria-label': '移動コントローラー'},
      [
        button(
          classes: 'control-up',
          attributes: const {'aria-label': '上へ移動'},
          onClick: () => _move(0, -1, _Direction.north),
          [.text('↑')],
        ),
        button(
          classes: 'control-left',
          attributes: const {'aria-label': '左へ移動'},
          onClick: () => _move(-1, 0, _Direction.west),
          [.text('←')],
        ),
        button(
          classes: 'control-action',
          attributes: const {'aria-label': '近くを調べる'},
          onClick: _inspectNearby,
          [.text('E')],
        ),
        button(
          classes: 'control-right',
          attributes: const {'aria-label': '右へ移動'},
          onClick: () => _move(1, 0, _Direction.east),
          [.text('→')],
        ),
        button(
          classes: 'control-down',
          attributes: const {'aria-label': '下へ移動'},
          onClick: () => _move(0, 1, _Direction.south),
          [.text('↓')],
        ),
      ],
    );
  }

  Component _buildPanel(String panel) {
    final content = switch (panel) {
      'computer' => (
        icon: '💻',
        eyebrow: 'WORKS / OSS',
        title: 'コードで、面倒を心地よく。',
        body: 'Dart・Flutterを中心に、開発者が気持ちよく使えるツールや仕組みを作っています。DVMの整備やOSS活動も継続中です。',
        link: 'https://github.com/blendthink',
        linkLabel: 'GitHubで活動を見る ↗',
      ),
      'cat' => (
        icon: '🐈',
        eyebrow: 'ABOUT',
        title: '猫と甘いものが好き。',
        body: '温厚、簡潔、マメ、そして慎重派。プログラミングと自動化で、みんなが心地よく暮らせる世界を作りたいと思っています。',
        link: 'https://blendthink.notion.site/d9624d9360544b3bbf97074ec1706ce7',
        linkLabel: 'もう少し詳しく知る ↗',
      ),
      'bookshelf' => (
        icon: '📚',
        eyebrow: 'THINKING',
        title: '違う考え方は、違う正しさ。',
        body:
            'People have different ways of feeling and thinking. All of those are right. 本棚の奥で、何かが動いた気がする……。',
        link: '',
        linkLabel: '',
      ),
      'secret' => (
        icon: '🚪',
        eyebrow: 'SECRET FOUND',
        title: '実験室への扉を発見！',
        body: 'ここには、開発中のものや遊び心のある実験を置く予定です。最初の秘密を見つけてくれてありがとう。',
        link: 'https://github.com/blendthink/blendthink.github.io',
        linkLabel: 'この家の設計図を見る ↗',
      ),
      _ => (
        icon: '…',
        eyebrow: 'NOTHING HERE?',
        title: '今は何もないみたい。',
        body: 'でも、部屋の物をいくつか調べてから戻ると、何か変わるかもしれません。',
        link: '',
        linkLabel: '',
      ),
    };

    return div(
      classes: 'panel-backdrop',
      events: {
        'click': (_) => setState(() => _openPanel = null),
      },
      [
        article(
          classes: 'info-panel',
          attributes: const {'role': 'dialog', 'aria-modal': 'true'},
          events: {'click': (event) => event.stopPropagation()},
          [
            button(
              classes: 'panel-close',
              attributes: const {'aria-label': '閉じる'},
              onClick: () => setState(() => _openPanel = null),
              [.text('×')],
            ),
            span(classes: 'panel-icon', [.text(content.icon)]),
            p(classes: 'eyebrow', [.text(content.eyebrow)]),
            h2([.text(content.title)]),
            p([.text(content.body)]),
            if (content.link.isNotEmpty)
              a(href: content.link, target: Target.blank, classes: 'panel-link', [
                .text(content.linkLabel),
              ]),
          ],
        ),
      ],
    );
  }

  Component _buildListMode() {
    return div(classes: 'list-mode', [
      h2([.text('この家で見つかるもの')]),
      p([.text('探索が難しい場合も、ここからすべての主要情報を確認できます。')]),
      div(classes: 'info-grid', [
        _listCard('💻', 'Works / OSS', 'Dart・Flutterを中心にした制作物とOSS活動。', 'computer'),
        _listCard('🐈', 'About', '大切にしていること、好きなもの、人柄。', 'cat'),
        _listCard('📚', 'Thinking', '仕事やものづくりで大切にしている考え方。', 'bookshelf'),
        _listCard('🚪', 'Secret Lab', '家のどこかに入口が隠されています。', 'secret'),
      ]),
    ]);
  }

  Component _listCard(String icon, String title, String body, String panel) {
    return button(
      classes: 'info-card',
      onClick: () => setState(() => _openPanel = panel),
      [
        span([.text(icon)]),
        strong([.text(title)]),
        small([.text(body)]),
      ],
    );
  }
}
