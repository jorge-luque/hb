varying vec4 v_fragmentColor;
varying vec2 v_texCoord;

uniform float u_ctime;

void main() {
    vec2 coord = v_texCoord;
    coord.y +=  (sin(coord.x * 30.0 + u_ctime * 30.0) * 0.01);
      
    gl_FragColor = texture2D(CC_Texture0, coord);

}