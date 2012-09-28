package edt.exceptions;


public class InvalidPlyFile extends Exception{

    private String message;

    public InvalidPlyFile(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
