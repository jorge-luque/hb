#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_fragmentColor;
varying vec2 v_texCoord;

uniform vec2 resolution;
uniform float blurRadius;
uniform float sampleNum;

void main(void)
{
    vec4 col = vec4(0);
    vec2 unit = 1.0 / resolution.xy;
    
    float r = blurRadius;
    float sampleStep = r / sampleNum;
    
    float count = 0.0;
    
    for(float x = -r; x < r; x += sampleStep)
    {
        for(float y = -r; y < r; y += sampleStep)
        {
            float weight = (r - abs(x)) * (r - abs(y));
            col += texture2D(CC_Texture0, v_texCoord + vec2(x * unit.x, y * unit.y)) * weight;
            count += weight;
        }
    }
    
    gl_FragColor = vec4(col / count) * v_fragmentColor;
}
