varying vec4 v_fragmentColor;
varying vec2 v_texCoord;


const vec2 center = vec2(0.5, 0.5);
//float radius = 0.05;

uniform float u_radius;

void main() {
    
    float circleMask = step(distance(center, v_texCoord), u_radius);
   
    vec4 texColor = texture2D(CC_Texture0, v_texCoord);
    // if we've set a color on the sprite apply that as well
    gl_FragColor = vec4(texColor.r*circleMask, texColor.g*circleMask, texColor.b*circleMask, texColor.a * circleMask);
}