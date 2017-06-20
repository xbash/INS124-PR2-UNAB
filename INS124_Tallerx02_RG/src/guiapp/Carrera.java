/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapp;

/**
 *
 * @author jsepulveda
 */
public class Carrera {
    String Carrera;
    int Valor_Matricula;

    public Carrera(String Carrera, int Valor_Matricula) {
        this.Carrera = Carrera;
        this.Valor_Matricula = Valor_Matricula;
    }
    public Carrera(){}

    public String getCarrera() {
        return Carrera;
    }

    public int getValor_Matricula() {
        return Valor_Matricula;
    }
    public boolean GuardarEnArchivo(){
        Carrera_FileHandler fh = new Carrera_FileHandler("Carreras.csv");
        String[][] Arr = fh.LeerCarrera();
        if (!VerificarMatricula(Arr, Carrera)){
            System.out.println("Carrera ya existe.");
            return false;
        }
        String str_VMatricula = String.valueOf(Valor_Matricula);
        fh.EscribirCarrera(Carrera, str_VMatricula);
        System.out.println("Datos guardados en Archivo");
        return true;
    }
    private boolean VerificarMatricula(String[][] Arr,String Carrera){
        for (int i =0;i<Arr.length;i++){
            String c_arr = Arr[i][0];
            System.out.println("Campo a comparar: "+c_arr);
            System.out.println("Carrera a comparar: "+Carrera);
            System.out.println("Compare: "+c_arr.equals(Carrera));
           if ( c_arr.equals(Carrera) == true){
               return false;
           }
        }
        return true;
    }
    
}
