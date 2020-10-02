varying vec4 v_fragmentColor;
varying vec2 v_texCoord;

uniform float u_ctime;
//uniform float u_threshold;
uniform float u_iterations;
uniform float u_precision;
uniform float u_baseOpacity;
uniform vec4 u_outlineColor;

//const float pi = 3.14159265;
const float samples = 6.0;

vec4 cropTex(vec2 _cord)
{
    /*
    if(_cord.x > 1.0 || _cord.x < 0.0 || _cord.y > 1.0 || _cord.y < 0.0)
    {
        return vec4(0.0);
    }
    else
    {
        return texture2D(CC_Texture0, _cord);
    }
     
     */
    return texture2D(CC_Texture0, _cord) * step(_cord.x, 1.0) * step(0.0, _cord.x) * step(_cord.y, 1.0) * step(0.0, _cord.y);
}

void main() {
    
    vec4 normal = vec4(0.0);
    vec2 nv_texCoord = vec2(0.0);

    float excess = u_iterations * u_precision;
    nv_texCoord = -1.0 * excess + (1.0 + excess * 2.0) * v_texCoord;
    normal = cropTex(nv_texCoord);
    

    if(normal.a <= 0.5)
    {
        vec4 accum = vec4(0.0);
        
        
        float rightSlide = 0.0;
        float leftSlide = 0.0;
        float topSlide = 0.0;
        float botSlide = 0.0;
        
        
        for(float i = 1.0; i <= u_iterations; i += 1.0) {
         
            rightSlide = nv_texCoord.x + u_precision * i;
            leftSlide = nv_texCoord.x - u_precision * i;
            topSlide = nv_texCoord.y + u_precision * i;
            botSlide = nv_texCoord.y - u_precision * i;

         
            accum += cropTex(vec2(leftSlide, topSlide));
            accum += cropTex(vec2(rightSlide, topSlide));
            accum += cropTex(vec2(leftSlide, botSlide));
            accum += cropTex(vec2(rightSlide, botSlide));
         
         
            accum += cropTex(vec2(leftSlide, nv_texCoord.y));
            accum += cropTex(vec2(rightSlide, nv_texCoord.y));
            accum += cropTex(vec2(nv_texCoord.x, botSlide));
            accum += cropTex(vec2(nv_texCoord.x, topSlide));
         
        }
        
        //accum.a = ((u_ctime / 1.0) * u_iterations + accum.a) * 0.5 * step(0.05, accum.a);
        accum.rgb =  u_outlineColor.rgb * accum.a * 0.95;
        normal = (1.0 - normal.a) * (accum / u_iterations) * ((u_ctime / 1.0) + u_baseOpacity) * u_outlineColor.a;
        
        
        //float opacity = step(normal.a, 0.05) * ((u_ctime / 1.0) + u_baseOpacity) * u_outlineColor.a / iterations;
        
        //normal = (accum * opacity) + (normal * normal.a);
        
    }
    else
    {
        normal = normal * normal.a;
    }
    
    gl_FragColor = v_fragmentColor * normal;
    
}
