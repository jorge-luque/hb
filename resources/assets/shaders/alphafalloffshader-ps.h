#ifdef GL_ES
precision lowp float;
#endif

uniform float u_ctime;
uniform float u_baseOpacity;
uniform vec3 u_tint;
uniform float u_alpha;

varying vec4 v_fragmentColor;
varying vec2 v_texCoord;

void main()
{
    gl_FragColor = (u_baseOpacity + (1.0 - u_baseOpacity) * u_ctime) * v_fragmentColor * vec4(texture2D(CC_Texture0, v_texCoord).rgb * u_tint, texture2D(CC_Texture0, v_texCoord).a * texture2D(CC_Texture0, v_texCoord).a * u_alpha);
}
