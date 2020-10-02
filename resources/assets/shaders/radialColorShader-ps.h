#ifdef GL_ES
precision lowp float;
#endif

varying vec4 v_fragmentColor;
varying vec2 v_texCoord;

void main(void)
{
    vec4 texColor = texture2D(CC_Texture0, v_texCoord);
   
    vec2 center = vec2(0.5,0.5);
    
    float dist = distance(center, v_texCoord);
    
    dist = dist - 0.2;
    
    if(dist<0.0) dist=0.0;
    
    float factor = 1.0 - 0.8 * (dist/0.55);
    
    gl_FragColor = vec4(texColor.r*factor,texColor.g*factor,texColor.b*factor,1.0);
}

