/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopoo;

import java.io.Serializable;

/**
 *
 * @author Filipe
 */
public class Data implements Serializable{
    int ano, mes, dia, horaInicio, horaFim, minutos;

    public Data(int ano, int mes, int dia, int horaInicio, int horaFim) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.minutos = (horaFim-horaInicio)*60;
    }

    @Override
    public String toString() {
        return "Data{" + "ano=" + ano + ", mes=" + mes + ", dia=" + dia + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim + ", minutos=" + minutos + '}';
    }
    
}
