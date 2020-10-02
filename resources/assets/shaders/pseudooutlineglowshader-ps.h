#ifdef GL_ES
precision mediump float;
#endif

 
varying vec4 v_fragmentColor;
varying vec2 v_texCoord;
uniform float u_outlineSize;
uniform vec2 u_textureSize;

uniform float u_sins[36];
uniform float u_coss[36];

uniform int u_pixelStep;
uniform int u_angleStep;


vec4 cropTex(vec2 _cord)
{
    return texture2D(CC_Texture0, _cord) * step(_cord.x, 1.0) * step(0.0, _cord.x) * step(_cord.y, 1.0) * step(0.0, _cord.y);
    //return texture2D(CC_Texture0, _cord);
}

float getIsStrokeWithAngle(in int angleIteration, in vec2 coord, in vec2 unit, in float precisionUnit)
{
    float xDist = u_coss[angleIteration] * unit.x * u_outlineSize;
    float yDist = u_sins[angleIteration] * unit.y * u_outlineSize;
    
    for(float i = precisionUnit; i <= 1.0; i += precisionUnit)
    {
        vec2 offset = vec2(i * xDist, i * yDist);
        float a = cropTex(coord + offset).a;
        if (a >= 0.5)
        {
            return 1.0 + precisionUnit - i;
        }
    }

    return 0.0;
}

void main()
{
    
    float excess = max(u_outlineSize / u_textureSize.x, u_outlineSize / u_textureSize.y);

    vec2 nv_texCoord = -1.0 * excess + (1.0 + excess * 2.0) * v_texCoord;

    //nv_texCoord = vec2(nv_texCoord.x, (1.0 - nv_texCoord.y)); //flip

    vec4 myC = cropTex(nv_texCoord);
    
    float strokeCount = 0.0;
    
    /*
    if (myC.a >= 0.5)
    {
        strokeCount = myC.a;
    }

    else
    {

        vec2 unit = 1.0 / u_textureSize.xy;

        float precisionUnit = 1.0 / u_outlineSize * float(u_pixelStep); // *4.0 better performance
        
        for(int i = 0; i < 36; i=i+u_angleStep)
        {
            strokeCount = max(getIsStrokeWithAngle(i, nv_texCoord, unit, precisionUnit), strokeCount);
        }
    }
          */
    
    vec2 unit = 1.0 / u_textureSize.xy;
    
    float precisionUnit = 1.0 / u_outlineSize * float(u_pixelStep); // *4.0 better performance
    
    for(int i = 0; i < 36; i=i+u_angleStep)
    {
        strokeCount = max(getIsStrokeWithAngle(i, nv_texCoord, unit, precisionUnit), strokeCount);
    }
    
    myC.rgb = vec3(1.0);
    myC.a = strokeCount;
    
    gl_FragColor = myC * myC.a;
}
