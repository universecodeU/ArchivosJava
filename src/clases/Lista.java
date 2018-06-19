package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author I.S.C. Cruz Medinilla Martin codemcmg@gmail.com
 */
public class Lista {
    Nodo head;
    public Lista(){
       head=null;
    }
    
    public void addNodo(Alumno a){
        Nodo n= new Nodo(a);
        if(head==null){
            head=n;
        }else{
            n.sig=head;
            head=n;
        }
        
    }
        
    public String listarAlumnos(){
        String lista="ALUMNOS \n";
        Nodo help=head;
        
        while(help!=null){
        lista += help.info.clave +" "+help.info.nombre+ " \n";
        help= help.sig;
        }
        return lista;
    }
    
    public Alumno buscar(int clave){
        Alumno alEncontrado=null;
        Nodo help=head;
        
        while(help!=null){
        if(clave==help.info.clave){
            alEncontrado= help.info;
            break;
        }
        help= help.sig;
        }
        return alEncontrado;
    }

    public  void guardarArchivo() throws IOException {
    FileWriter fichero = null;
    PrintWriter pw = null;

    Nodo auxiliar=head;
    fichero = new FileWriter("Alumnos.txt");
    pw = new PrintWriter(fichero);
    
    while(auxiliar!=null){
        pw.println(auxiliar.info.clave +" "+ auxiliar.info.nombre);
        auxiliar= auxiliar.sig;
    }
    
    
    fichero.close();
  }
    
    public void leerArchivos() throws IOException{
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null; 
      String cadena;
      int clave;
      String nombre;
      
       archivo = new File ("Alumnos.txt");

       fr = new FileReader (archivo);
       br = new BufferedReader(fr);
    
       while((cadena = br.readLine())!=null) {
          String subcadena[]=cadena.split(" ");
          clave=Integer.parseInt(subcadena[0]);
          nombre=subcadena[1];
          //System.out.print("clave: "+subcadena[0]+"Nombre: "+subcadena[1]+" \n" ) ;
          Alumno a= new Alumno(clave,nombre);
          this.addNodo(a);
      }  
            
      fr.close();       
  }    
        
}
