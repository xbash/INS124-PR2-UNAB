/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author jsepulveda
 */
public class Carrera_FileHandler  {
    private String archivo;
    String[][] Arr_Carrera;
   

    public Carrera_FileHandler(String archivo) {
        this.archivo = archivo;
        File f = new File(this.archivo);
        try{
            if(!f.exists())
                f.createNewFile();
        } catch (Exception e){System.out.println(e.getMessage());}
        
    }
    
    public void EscribirCarrera(String N_Carrera,String V_Carrera){
        try{            
            FileWriter fw = new FileWriter(this.archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.print(N_Carrera);
            out.print(",");
            out.print(V_Carrera);
            out.println();
            out.close();
            
        }catch (Exception e) {System.out.println(e.getMessage());}
    }
    
    public String[][] LeerCarrera(){
        try{
        Scanner scanner = new Scanner(new File(this.archivo));
        //scanner.useDelimiter(",");
        String tmp;
        String[] tmp2;
        int i = 0;
        int lineas = ContarLineas();
        String[][] Arr_Carrera = new String[lineas][2];
        this.Arr_Carrera = Arr_Carrera;
        
        while(scanner.hasNext()){
            tmp = scanner.next();
            tmp2 = tmp.split(",");
            Arr_Carrera[i][0]=tmp2[0];
            Arr_Carrera[i][1]=tmp2[1];
            i+=1;
        }
        scanner.close();
        return Arr_Carrera;
        }catch (Exception e) {System.out.println(e.getMessage());}
        return null;
    }
    public void MostrarCarrera(){
        for (int i=0;i<Arr_Carrera.length;i++){
            System.out.print("Carrera:"+Arr_Carrera[i][0]+" ");
            System.out.print("Valor: "+Arr_Carrera[i][1]+"\n");
        }
    }
    private int ContarLineas(){
        try{
        LineNumberReader  lnr = new LineNumberReader(new FileReader(new File(this.archivo)));
        lnr.skip(Long.MAX_VALUE);
        //System.out.println(lnr.getLineNumber()); 
        lnr.close();
        return lnr.getLineNumber();} catch(Exception e ){return 0;}
    }
}