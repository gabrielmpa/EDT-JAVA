package edt.ply.elements;
public class Vertice{
    private Object x;
    private Object y;
    private Object z;

    private String cordType;
    
    
    public Vertice(String xt,String yt,String zt,String type){
        if(type.equals("double")){
            this.x = new Double( (Double.parseDouble(xt)) );
            this.y = new Double( (Double.parseDouble(yt)) );
            this.z = new Double( (Double.parseDouble(zt)) );
        }else if(type.equals("char") || type.equals("uchar")){
            this.x = new Character( xt.charAt(0) );
            this.y = new Character( yt.charAt(0) );
            this.z = new Character( zt.charAt(0) ); 
        }else if(type.equals("ushort") || type.equals("short")){
            this.x = new Short( (Short.parseShort(xt)) );
            this.y = new Short( (Short.parseShort(yt)) );
            this.z = new Short( (Short.parseShort(zt)) ); 
        }else if(type.equals("uint") || type.equals("int")){
            this.x = new Integer( (Integer.parseInt(xt)) );
            this.y = new Integer( (Integer.parseInt(yt)) );
            this.z = new Integer( (Integer.parseInt(zt)) ); 
        }else if(type.equals("float")){
            this.x = new Float( (Float.parseFloat(xt)) );
            this.y = new Float( (Float.parseFloat(yt)) );
            this.z = new Float( (Float.parseFloat(zt)) ); 
        }

        this.cordType = type;
    }
   
    public String getType(){ return this.cordType; }

    public Object getX(){ return this.x; }
    public Object getY(){ return this.y; }
    public Object getZ(){ return this.z; }

}
