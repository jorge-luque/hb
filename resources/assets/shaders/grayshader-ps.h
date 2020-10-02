varying vec4 v_fragmentColor;
varying vec2 v_texCoord;

uniform float opacity;
uniform float grayness;


void main() {
    
    //float alpha = texture2D(CC_Texture0, v_texCoord).a;

    vec4 tex = texture2D(CC_Texture0, v_texCoord).rgba;
    
    float grey = dot(tex.rgb, vec3(0.299, 0.587, 0.114));
    gl_FragColor = vec4(
                        (tex.r * (1.0 - grayness) + grayness * grey ) * opacity,
    (tex.g * (1.0 - grayness) + grayness * grey ) * opacity,
    (tex.b * (1.0 - grayness) + grayness * grey ) * opacity,
    tex.a * opacity);

}
