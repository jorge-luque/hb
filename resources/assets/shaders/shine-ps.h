varying vec2 v_texCoord;
uniform float u_gtime;

void main() {
    vec4 tex = texture2D(CC_Texture0, v_texCoord);
    float repeatedValue = mod(CC_Time[1], u_gtime) ;
    
    float progress = repeatedValue / (u_gtime / 2.0);
    if (progress > 1.0) progress = 2.0 - progress;
    gl_FragColor = tex + vec4((0.8 - tex.r) * progress, (0.8 - tex.g) * progress, (0.8 - tex.b) * progress, 0.3) * tex.a * 0.4;
}