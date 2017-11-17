/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipo;


import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.util.List;
import prototipo.model.CriterioHasProyecto;
import prototipo.model.Criterios;
import prototipo.model.Proyectos;

    
/**
 *
 * @author GusAPC
 */
public class SaveAndRead {
    
    public void saveCriterios(List<Criterios> obj){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("./Criterios.xml");
            XMLEncoder xMLEncoder =  new XMLEncoder(fileOutputStream);
            xMLEncoder.writeObject(obj);
            xMLEncoder.close();
            fileOutputStream.close();
        }catch(IOException iOException){
            System.out.println(iOException);
        }
    }
    public void saveProyectos(List<Proyectos> obj){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("./Proyectos.xml");
            XMLEncoder xMLEncoder =  new XMLEncoder(fileOutputStream);
            xMLEncoder.writeObject(obj);
            xMLEncoder.close();
            fileOutputStream.close();
        }catch(IOException iOException){
            System.out.println(iOException);
        }
    }
    public void saveCriterioHasProyecto(List<CriterioHasProyecto> obj){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("./CriterioHasProyecto.xml");
            XMLEncoder xMLEncoder =  new XMLEncoder(fileOutputStream);
            xMLEncoder.writeObject(obj);
            xMLEncoder.close();
            fileOutputStream.close();
        }catch(IOException iOException){
            System.out.println(iOException);
        }
    }
    public List<Criterios> readCriterios(){
        List<Criterios> allObjs = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(new File("./Criterios.xml"));
            XMLDecoder xMLDecoder =  new XMLDecoder(fileInputStream);
            allObjs = (List<Criterios>) xMLDecoder.readObject() ;
            xMLDecoder.close();
            fileInputStream.close();
        }catch(IOException iOException){
            System.out.println(iOException);
        }
        return allObjs;
    }
    public List<Proyectos> readProyectos(){
        List<Proyectos> allObjs = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(new File("./Proyectos.xml"));
            XMLDecoder xMLDecoder =  new XMLDecoder(fileInputStream);
            allObjs = (List<Proyectos>) xMLDecoder.readObject() ;
            xMLDecoder.close();
            fileInputStream.close();
        }catch(IOException iOException){
            System.out.println(iOException);
        }
        return allObjs;
    }
    public List<CriterioHasProyecto> readCriterioHasProyecto(){
        List<CriterioHasProyecto> allObjs = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(new File("./CriterioHasProyecto.xml"));
            XMLDecoder xMLDecoder =  new XMLDecoder(fileInputStream);
            allObjs = (List<CriterioHasProyecto>) xMLDecoder.readObject() ;
            xMLDecoder.close();
            fileInputStream.close();
        }catch(IOException iOException){
            System.out.println(iOException);
        }
        return allObjs;
    }
    public void deleteFileCriterios(){
        File file = new File("./Criterios.xml");
        file.delete();
    }
    public void deleteFileProyectos(){
        File file = new File("./Proyectos.xml");
        file.delete();
    }
    public void deleteFileCriterioHasProyecto(){
        File file = new File("./CriterioHasProyecto.xml");
        file.delete();
    }
}
