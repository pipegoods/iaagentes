/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import static agentes.Material.p;
import conectar.conectar;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author CIEDUCAR
 */
public class Intelectual extends Agent
{
    Persona persona;
    conectar conn = new conectar();
    Persona ultimoMensaje = new Persona("", "", "", "");
    class ReceptorComportaminento extends SimpleBehaviour
    {
            private boolean fin = false;
           
            public void action()
            {
                //System.out.println(" Preparandose para recibir");
 
            //Obtiene el primer mensaje de la cola de mensajes
                ACLMessage mensaje = blockingReceive ();
 
                if (mensaje!= null)
                {
                    try {
                        if (!comparar(ultimoMensaje, (Persona) mensaje.getContentObject())) {
                            try {
                                ultimoMensaje = (Persona) mensaje.getContentObject();
                            } catch (UnreadableException ex) {
                                Logger.getLogger(Intelectual.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                System.out.println(mensaje.getContentObject());
                                
                                
                                persona = (Persona) mensaje.getContentObject();
                                
                                if (verificaFecha(persona.getFecnac())) {
                                    boolean bandera = true;
                                    System.out.println(conn.crearConexion());
                                    String sqlS = "SELECT * FROM personas";
                                    ResultSet rs = conn.ejecutarSQLSelect(sqlS);
                                    try {
                                        while(rs.next()){
                                            
                                            if (rs.getString(rs.findColumn("id")) == null ? String.valueOf(persona.getId()) == null : rs.getString(rs.findColumn("id")).equals(String.valueOf(persona.getId()))) {
                                                bandera = false;
                                                break;
                                            }
                                        }                   } catch (SQLException ex) {
                                            Logger.getLogger(Intelectual.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    
                                    if (bandera) {
                                        
                                        addBehaviour(new Intelectual.Comunicar());
                                    } else {
                                        System.out.println("Identificacion ya existe!");
                                        JOptionPane.showMessageDialog(null, "La identificacion ya existe!");
                                    }
                                    
                                } else {
                                    System.out.println("Fecha no valida");
                                    JOptionPane.showMessageDialog(null, "Fecha no es valida!");
                                }
                            } catch (UnreadableException ex) {
                                Logger.getLogger(Intelectual.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            

                        }
                    } catch (UnreadableException ex) {
                        Logger.getLogger(Intelectual.class.getName()).log(Level.SEVERE, null, ex);
                    } 
       
                    
                    
                }
            }
            public boolean done()
            {
                return fin;
            }
            private boolean verificaFecha(String fecha) {
         try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (java.text.ParseException ex) {
                        return false;
        }
        return true;
    }
            
            private boolean comparar(Persona a, Persona b){
                return (a.getId() == null ? b.getId() == null : a.getId().equals(b.getId())) && a.getNombre().equals(b.getNombre()) && a.getFecnac().equals(b.getFecnac());
            }
    }
    protected void setup()
    {
        addBehaviour(new ReceptorComportaminento());
    }
    public void takeDown(){
        System.out.println("Enterado "+getAID().getName());
        
        
    }
    
    class Comunicar extends SimpleBehaviour
    {
        boolean fin = false;
        
        public void action()
        {
            //System.out.println(getLocalName() +": marcando al celular del jefe");
            AID id = new AID();
            id.setLocalName("pro");
 
        // Creación del objeto ACLMessage
            ACLMessage mensaje = new ACLMessage(ACLMessage.REQUEST);
 
        //Rellenar los campos necesarios del mensaje
            mensaje.setSender(getAID());
            mensaje.setLanguage("Español");
            mensaje.addReceiver(id);
            try {
                mensaje.setContentObject(persona); //String.valueOf(numero) "5"
            } catch (IOException ex) {
                Logger.getLogger(Intelectual.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        //Envia el mensaje a los destinatarios
            send(mensaje);
        }
 
        public boolean done()
        {
            return fin;
        }
    }
}
