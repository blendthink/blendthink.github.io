library;

import 'package:jaspr/dom.dart';
import 'package:jaspr/server.dart';

import 'app.dart';
import 'main.server.options.dart';

void main() {
  Jaspr.initializeApp(options: defaultServerOptions);

  runApp(
    const Document(
      title: "blendthink's Engineer House",
      lang: 'ja',
      head: [
        meta(name: 'description', content: 'かわいいエンジニアと一緒に探検する、blendthinkのポートフォリオ。'),
        meta(name: 'theme-color', content: '#121126'),
        link(rel: 'stylesheet', href: '/styles.css'),
      ],
      body: App(),
    ),
  );
}
