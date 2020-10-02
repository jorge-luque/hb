#ifdef GL_ES
precision lowp float;
#endif

varying vec4 v_fragmentColor;
varying vec2 v_texCoord;

uniform float colorFactor;

void main(void)
{
    vec4 texColor = texture2D(CC_Texture0, v_texCoord);
   
    float factor = 0.5;
    
    gl_FragColor = vec4(texColor.r*colorFactor + (1.0-colorFactor)*texColor.a,texColor.g*colorFactor + (1.0-colorFactor)*texColor.a,texColor.b*colorFactor + (1.0-colorFactor)*texColor.a,texColor.a);
}

