
package br.edu.ifnmg.tads.as.GerenciadorLogistica.Controller;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess.CargoDAO;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Cargo;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named(value = "cargoConverter")
@SessionScoped
public class CargoConverter implements Serializable, Converter {
 
    @EJB
    CargoDAO dao;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            Long id = Long.parseLong(value);
            return dao.Abrir(id) ;
        }
        else {
            return null;
        }
    }
 
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return ((Cargo)object).getId().toString();
        }
        else {
            return null;
        }
    }
} 
