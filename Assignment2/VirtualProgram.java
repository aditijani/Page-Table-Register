package operatingSystem.Assignment2;

import java.util.Scanner;

/**
 * Created by parthgodhani on 12/5/17.
 */
public class VirtualProgram {
    Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        VirtualProgram virtualProgram=new VirtualProgram();
        virtualProgram.startSystem();
    }
    public void startSystem(){
        System.out.println("System Started...\n");
        Program program=null;
        String input="";
        do{
            program=new Program();
            program.init();
            System.out.println("\n Do you want to continue? ('yes' to continue...)");
            input=sc.next();
        }while(input.toUpperCase().equals("YES"));

    }
}
