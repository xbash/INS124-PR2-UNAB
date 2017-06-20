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
public class Matricula extends Carrera{
    String Rut;
    String Nombre;

    public Matricula(String Rut, String Nombre, String Carrera, int Valor_Matricula) {
        super(Carrera, Valor_Matricula);
        this.Rut = Rut;
        this.Nombre = Nombre;
    }

    public String getRut() {
        return Rut;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getCarrera() {
        return Carrera;
    }

    public int getValor_Matricula() {
        return Valor_Matricula;
    }
    public boolean GuardarEnArchivo(){
        Matricula_FileHandler fh = new Matricula_FileHandler("Matriculas.csv");
        String[][] Arr = fh.LeerMatricula();
        if (!VerificarMatricula(Arr, Rut)){
            System.out.println("Rut ya existe.");
            return false;
        }
        String str_VMatricula = String.valueOf(Valor_Matricula);
        fh.EscribirMatricula(Rut, Nombre, Carrera, Valor_Matricula);
        System.out.println("Datos guardados en Archivo");
        return true;
    }
    private boolean VerificarMatricula(String[][] Arr,String Rut){
        for (int i =0;i<Arr.length;i++){
            String c_arr = Arr[i][0];
            System.out.println("Campo a comparar: "+c_arr);
            System.out.println("Carrera a comparar: "+Rut);
            System.out.println("Compare: "+c_arr.equals(Rut));
           if ( c_arr.equals(Rut) == true){
               return false;
           }
        }
        return true;
    }
    
}
