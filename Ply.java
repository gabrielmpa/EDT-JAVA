import java.util.*;
import java.io.*;
import exceptions.*;

public class Ply{
    private String format;

    private int numVert;
    private int numFaces;

    private String faceSizeType;
    private String faceIndiceType;
    private HashMap<String,String> vertProperties;

    private ArrayList<Vertice> vertex;
    private ArrayList<Face> faces;

    public Ply(String filename) 
        throws InvalidPlyFile{
        this.vertProperties = new HashMap<String,String>();
        this.vertex = new ArrayList<Vertice>();
        this.faces = new ArrayList<Face>();
        try{
            FileInputStream f = new FileInputStream(filename);
            Scanner sc = new Scanner(f);
            String filetype = sc.next();
            if( filetype.equals("ply") ){
                format = "";
                String curr = sc.next();
                while( curr.equals("end_header") == false ){
                    if( curr.equals("format") ){
                        format = sc.next();
                        format.concat( " " );
                        format.concat( sc.next() );
                        curr = sc.next();
                    }
                    if( curr.equals("comment") ){
                        sc.nextLine();
                        curr = sc.next();
                    }
                    while( curr.equals("element") ){
                        String elem = sc.next();
                        if( elem.equals("vertex") ){
                            this.numVert = Integer.parseInt(sc.next());
                            curr = sc.next();
                            while( curr.equals("property") ){
                                String tempProp;
                                String type = sc.next();
                                String tempKey;
                                if( type.contains("uchar") )
                                    tempProp = "uchar";
                                else if( type.contains("char") )
                                    tempProp = "char";
                                else if( type.contains("ushort") )
                                    tempProp = "ushort";
                                else if( type.contains("short") )
                                    tempProp = "short";
                                else if( type.contains("uint") )
                                    tempProp = "uint";
                                else if( type.contains("int") )
                                    tempProp = "int";
                                else if( type.equals("float32") || type.equals("float") )
                                    tempProp = "float";
                                else
                                    tempProp = "double";
                                tempKey = sc.next();
                                    this.vertProperties.put(tempKey,tempProp);
                                curr = sc.next();
                                if(curr.equals("end_header"))
                                    break;
                            }
                        }else if( elem.equals("face") ){
                            this.numFaces = Integer.parseInt(sc.next());
                            curr = sc.next();
                            if( curr.equals("property") ){
                                if( sc.next().equals("list") ){
                                    this.faceSizeType = sc.next();
                                    this.faceIndiceType = sc.next();
                                    sc.next();
                                }
                                curr = sc.next();
                                if(curr.equals("end_header"))
                                    break;
                            }
                        }
                    }
                }
                for(int i = 0 ; i < this.numVert ; i++){
                    String type = this.vertProperties.get("x");
                    String elem1 = sc.next();
                    String elem2 = sc.next();
                    String elem3 = sc.next();
                    if(this.vertProperties.size() > 3)
                        sc.nextLine();
                    vertex.add(new Vertice(elem1,elem2,elem3,type));
                }
                for(int i = 0 ; i < this.numFaces ; i++){
                    int sizeface = Integer.parseInt(sc.next());
                    Face fc = new Face("int",sizeface);
                    for(int j = 0 ; j < sizeface ; j++ ){
                        fc.addVertice(Integer.parseInt(sc.next()));
                    }
                    this.faces.add(fc);
                }
            }else{
                throw new InvalidPlyFile("This is not a Ply file!");
                //area para exception de arquivo  
            }
        }catch(Exception e){
            //passa a exception de arquivo errado para quem chamou.
            e.printStackTrace();
            System.exit(0);
        }
    }

    public ArrayList<Vertice> getVertices(){ return this.vertex; }
    public ArrayList<Face> getFaces(){ return this.faces; }
}
