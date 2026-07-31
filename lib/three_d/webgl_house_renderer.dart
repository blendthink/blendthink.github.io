import 'dart:typed_data';

import 'package:universal_web/js_interop.dart';
import 'package:universal_web/web.dart' as web;

/// A dependency-free WebGL2 renderer for the exploration prototype.
///
/// It deliberately owns only rendering. Navigation, discoveries, content, and
/// accessibility remain regular Jaspr components.
final class WebGlHouseRenderer {
  WebGlHouseRenderer._(this.canvas, this.gl, this.program, this.buffer);

  static const _vertexShader = '''
    #version 300 es
    in vec3 a_position;
    in vec3 a_color;
    out vec3 v_color;
    void main() {
      float isoX = (a_position.x - a_position.z) * 0.115;
      float isoY = (a_position.x + a_position.z) * 0.057 + a_position.y * 0.13;
      float depth = (a_position.x + a_position.z) * 0.018 - a_position.y * 0.01;
      gl_Position = vec4(isoX, isoY - 0.34, depth, 1.0);
      v_color = a_color;
    }
  ''';

  static const _fragmentShader = '''
    #version 300 es
    precision mediump float;
    in vec3 v_color;
    out vec4 out_color;
    void main() { out_color = vec4(v_color, 1.0); }
  ''';

  final web.HTMLCanvasElement canvas;
  final web.WebGL2RenderingContext gl;
  final web.WebGLProgram program;
  final web.WebGLBuffer buffer;

  static WebGlHouseRenderer? attach(web.HTMLCanvasElement canvas) {
    final context = canvas.getContext('webgl2');
    if (context == null) return null;
    final gl = context as web.WebGL2RenderingContext;
    final vertex = _compile(gl, web.WebGL2RenderingContext.VERTEX_SHADER, _vertexShader);
    final fragment = _compile(gl, web.WebGL2RenderingContext.FRAGMENT_SHADER, _fragmentShader);
    if (vertex == null || fragment == null) return null;
    final program = gl.createProgram();
    if (program == null) return null;
    gl.attachShader(program, vertex);
    gl.attachShader(program, fragment);
    gl.linkProgram(program);
    if (!(gl.getProgramParameter(program, web.WebGL2RenderingContext.LINK_STATUS) as JSBoolean)
        .toDart) {
      return null;
    }
    final buffer = gl.createBuffer();
    if (buffer == null) return null;

    gl.useProgram(program);
    gl.bindBuffer(web.WebGL2RenderingContext.ARRAY_BUFFER, buffer);
    final position = gl.getAttribLocation(program, 'a_position');
    final color = gl.getAttribLocation(program, 'a_color');
    gl.enableVertexAttribArray(position);
    gl.enableVertexAttribArray(color);
    gl.vertexAttribPointer(position, 3, web.WebGL2RenderingContext.FLOAT, false, 24, 0);
    gl.vertexAttribPointer(color, 3, web.WebGL2RenderingContext.FLOAT, false, 24, 12);
    gl.enable(web.WebGL2RenderingContext.DEPTH_TEST);
    gl.enable(web.WebGL2RenderingContext.CULL_FACE);
    gl.clearColor(0.055, 0.047, 0.12, 0);
    return WebGlHouseRenderer._(canvas, gl, program, buffer);
  }

  static web.WebGLShader? _compile(web.WebGL2RenderingContext gl, int type, String source) {
    final shader = gl.createShader(type);
    if (shader == null) return null;
    gl.shaderSource(shader, source);
    gl.compileShader(shader);
    if (!(gl.getShaderParameter(shader, web.WebGL2RenderingContext.COMPILE_STATUS) as JSBoolean)
        .toDart) {
      return null;
    }
    return shader;
  }

  void render({required int characterX, required int characterY}) {
    _resize();
    final vertices = <double>[];
    _box(vertices, -4.7, -0.22, -3.3, 9.4, 0.18, 6.6, const _Rgb(0.16, 0.14, 0.3));
    _box(vertices, -4.4, 0, -3.0, 2.1, 1.1, 1.0, const _Rgb(0.16, 0.45, 0.58));
    _box(vertices, 2.8, 0, -2.8, 1.0, 2.2, 0.75, const _Rgb(0.72, 0.43, 0.36));
    _box(vertices, 2.7, 0, 2.0, 0.72, 0.7, 0.72, const _Rgb(0.95, 0.73, 0.25));
    _box(vertices, -0.25, 0, -2.7, 0.68, 1.25, 0.68, const _Rgb(0.22, 0.55, 0.4));
    final worldX = -3.8 + characterX * 0.92;
    final worldZ = -2.5 + characterY * 0.92;
    _box(vertices, worldX, 0, worldZ, 0.58, 0.75, 0.52, const _Rgb(0.4, 0.88, 1));
    _box(vertices, worldX + 0.05, 0.75, worldZ, 0.48, 0.48, 0.48, const _Rgb(1, 0.78, 0.67));

    gl.bindBuffer(web.WebGL2RenderingContext.ARRAY_BUFFER, buffer);
    gl.bufferData(
      web.WebGL2RenderingContext.ARRAY_BUFFER,
      Float32List.fromList(vertices).toJS,
      web.WebGL2RenderingContext.DYNAMIC_DRAW,
    );
    gl.viewport(0, 0, canvas.width, canvas.height);
    gl.clear(
      web.WebGL2RenderingContext.COLOR_BUFFER_BIT | web.WebGL2RenderingContext.DEPTH_BUFFER_BIT,
    );
    gl.drawArrays(web.WebGL2RenderingContext.TRIANGLES, 0, vertices.length ~/ 6);
  }

  void _resize() {
    final ratio = web.window.devicePixelRatio.clamp(1, 2);
    final width = (canvas.clientWidth * ratio).round();
    final height = (canvas.clientHeight * ratio).round();
    if (width > 0 && height > 0 && (canvas.width != width || canvas.height != height)) {
      canvas.width = width;
      canvas.height = height;
    }
  }

  void dispose() {
    gl.deleteBuffer(buffer);
    gl.deleteProgram(program);
  }

  static void _box(
    List<double> out,
    double x,
    double y,
    double z,
    double w,
    double h,
    double d,
    _Rgb color,
  ) {
    final x2 = x + w;
    final y2 = y + h;
    final z2 = z + d;
    _face(out, [x, y2, z, x2, y2, z, x2, y2, z2, x, y2, z2], color.lighten(0.14));
    _face(out, [x, y, z, x, y2, z, x, y2, z2, x, y, z2], color.darken(0.08));
    _face(out, [x2, y, z2, x2, y2, z2, x2, y2, z, x2, y, z], color.darken(0.18));
    _face(out, [x, y, z2, x, y2, z2, x2, y2, z2, x2, y, z2], color);
    _face(out, [x2, y, z, x2, y2, z, x, y2, z, x, y, z], color.darken(0.22));
  }

  static void _face(List<double> out, List<double> points, _Rgb color) {
    const indices = [0, 1, 2, 0, 2, 3];
    for (final index in indices) {
      final offset = index * 3;
      out.addAll([
        points[offset],
        points[offset + 1],
        points[offset + 2],
        color.r,
        color.g,
        color.b,
      ]);
    }
  }
}

final class _Rgb {
  const _Rgb(this.r, this.g, this.b);
  final double r;
  final double g;
  final double b;
  _Rgb lighten(double value) =>
      _Rgb((r + value).clamp(0, 1), (g + value).clamp(0, 1), (b + value).clamp(0, 1));
  _Rgb darken(double value) =>
      _Rgb((r - value).clamp(0, 1), (g - value).clamp(0, 1), (b - value).clamp(0, 1));
}
