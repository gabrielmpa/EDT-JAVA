import java.util.*;
public class Face{
    
    private ArrayList<Integer> vertList;
    private int size;

    public Face(String ArrayType,int size){
        this.size = size;
        this.vertList = new ArrayList<Integer>();
    }
    
    public void addVertice(int a){
        this.vertList.add(a);
    }

    public ArrayList<Integer> getFace(){
        return this.vertList;
    }

    public int getSize(){
        return this.size;
    }

}
