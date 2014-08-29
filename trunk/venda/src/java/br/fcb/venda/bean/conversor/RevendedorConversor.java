/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fcb.venda.bean.conversor;

import br.fcb.venda.entidade.Revendedor;
import br.fcb.venda.rn.RevendedorRN;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ufrastic
 */
@FacesConverter(value = "revendedorConversor")
public class RevendedorConversor implements Converter{
    
    private RevendedorRN rn_revendedor;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Revendedor resposta = null;

        if (value == null || value.equals("")) {
            return null;
        } else {
            rn_revendedor = new RevendedorRN();
            try {
                resposta = rn_revendedor.obter(new Integer(value));
                return resposta;
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha de validação", "É preciso "
                        + "selecionar um ítem do campo de texto auto completável");
                FacesContext.getCurrentInstance().addMessage(value, fm);
                System.out.println(e);
                return null;
            }
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value == null) {
            return "";
        } else if (value instanceof Revendedor) {
            Integer id = ((Revendedor) value).getId();
            if (id != null) {
                return id.toString();
            } else {
                return "";
            }
        } else {
            return "";
        }
    }
}
