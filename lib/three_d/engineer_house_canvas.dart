import 'dart:async';

import 'package:jaspr/jaspr.dart';
import 'package:universal_web/web.dart' as web;

import 'webgl_house_renderer.dart';

final class EngineerHouseCanvas extends StatefulComponent {
  const EngineerHouseCanvas({required this.characterX, required this.characterY, super.key});
  final int characterX;
  final int characterY;

  @override
  State<EngineerHouseCanvas> createState() => _EngineerHouseCanvasState();
}

final class _EngineerHouseCanvasState extends State<EngineerHouseCanvas> {
  final _canvasKey = GlobalNodeKey<web.HTMLCanvasElement>();
  WebGlHouseRenderer? _renderer;
  Timer? _attachTimer;

  @override
  void initState() {
    super.initState();
    if (kIsWeb) {
      _attachTimer = Timer(Duration.zero, _attach);
    }
  }

  void _attach() {
    final canvas = _canvasKey.currentNode;
    if (canvas == null) return;
    _renderer = WebGlHouseRenderer.attach(canvas);
    _render();
  }

  void _render() =>
      _renderer?.render(characterX: component.characterX, characterY: component.characterY);

  @override
  void didUpdateComponent(covariant EngineerHouseCanvas oldComponent) {
    super.didUpdateComponent(oldComponent);
    if (oldComponent.characterX != component.characterX ||
        oldComponent.characterY != component.characterY) {
      _render();
    }
  }

  @override
  void dispose() {
    _attachTimer?.cancel();
    _renderer?.dispose();
    super.dispose();
  }

  @override
  Component build(BuildContext context) => Component.element(
    tag: 'canvas',
    key: _canvasKey,
    classes: 'webgl-house-canvas',
    attributes: const {'aria-hidden': 'true'},
  );
}
