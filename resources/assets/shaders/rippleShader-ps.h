varying vec4 v_fragmentColor;
varying vec2 v_texCoord;

uniform float u_gtime;
uniform vec4 u_color;

float easeOutCubic(float t, float b, float c, float d) {
    t /= d;
    t--;
    return c*(t*t*t + 1.0) + b;
}
float easeOutQuad(float t, float b, float c, float d)
{
    t /= d;
    return -c * t*(t-2.0) + b;
}
float easeInCubic(float t, float b, float c, float d) {
    t /= d;
    return c*t*t*t + b;
}

void main() {
    vec4 tex = texture2D(CC_Texture0, v_texCoord);
    
    float progress = 1.0 - easeOutCubic(mod(CC_Time[1], u_gtime), 0.0, 1.0, u_gtime);
    tex = tex + u_color * u_color.a * progress * tex.a;
    gl_FragColor = tex * v_fragmentColor;
}