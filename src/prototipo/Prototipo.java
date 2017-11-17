package prototipo;

import Jframe.Home;
import java.util.ArrayList;
import java.util.List;
import prototipo.model.CriterioHasProyecto;
import prototipo.model.Criterios;
import prototipo.model.Proyectos;

/**
 *
 * @author GusAPC
 */
public class Prototipo {

    public static void main(String[] args) {
        
        SaveAndRead s = new SaveAndRead();
        List<Criterios> criterios = new ArrayList<>();
        List<Proyectos> proyectos = new ArrayList<>();
        List<CriterioHasProyecto> criterioHasProyecto = new ArrayList<>();
        
        if(s.readCriterios() == null){
            criterios.add(new Criterios(1, "Duración(en meses)", true, true, 15, true));
            criterios.add(new Criterios(2, "VPN", true, false, 25, true));
            criterios.add(new Criterios(3, "PRI", true, true, 20, true));
            criterios.add(new Criterios(4, "Riesgo", false, true, 20, true));
            criterios.add(new Criterios(5, "Generación de tecnología propietaria", false, false, 15, true));
            s.saveCriterios(criterios);
        } else criterios = s.readCriterios();
        if(s.readProyectos() !=  null) proyectos = s.readProyectos();
        if(s.readCriterioHasProyecto() != null) criterioHasProyecto = s.readCriterioHasProyecto();
        
        Home home = new Home(criterios, proyectos, criterioHasProyecto);
        home.setTitle("suaj");
        home.setVisible(true);
    }
    
}
