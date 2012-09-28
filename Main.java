import java.util.*;
import java.io.*;
import edt.ply.*;
public class Main{
        public static void main(String [] args) throws Exception {
            Ply plydata = new Ply(args[0]);
            Float x  = (Float) plydata.getVertices().get(0).getX();
            System.out.println(x.floatValue());
    }
}
