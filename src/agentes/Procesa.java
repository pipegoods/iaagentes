/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import conectar.conectar;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pipem
 */
public class Procesa extends Agent{
  class ReceptorComportaminento extends SimpleBehaviour
    {
            private boolean fin = false;
            String ultimoMensaje = "";
            conectar conn = new conectar();

            Persona p;
            public void action()
            {
                //System.out.println(" Preparandose para recibir");
 
            //Obtiene el primer mensaje de la cola de mensajes
                ACLMessage mensaje = blockingReceive ();
 
                if (mensaje!= null)
                {
                    
                    if (ultimoMensaje == null ? mensaje.getContent() != null : !ultimoMensaje.equals(mensaje.getContent())) {
                        ultimoMensaje = mensaje.getContent();
                        try {
                            p = (Persona) mensaje.getContentObject();
                        } catch (UnreadableException ex) {
                            Logger.getLogger(Procesa.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println(conn.crearConexion());
                        String sql = "INSERT INTO personas (id, nombre, fecha, gen) VALUES "
                                + "('"+ p.getId() +"','"+ p.getNombre() +"','"+ p.getFecnac()+"','"+p.getGenero()+"')";
                        
                        if (conn.ejecutarSQL(sql)) {
                            System.out.println("Persona guardada con exito");
                            JOptionPane.showMessageDialog(null, "Persona guardada con exito");
                            Form.borrarFormulario();
                        } else {
                            System.out.println("Persona no guardada!");
                             JOptionPane.showMessageDialog(null, "Persona no guardada!");
                        }
                        p.getLista_telefonos().forEach((n) -> {
                            String sql_ = "INSERT INTO telefonos (id_persona, telefono) VALUES "
                                + "('"+ p.getId() +"','"+ n +"')";
                            if (conn.ejecutarSQL(sql_)) {
                            System.out.println("Telefono guardado con exito");
                            } else {
                            System.out.println("Telefono no guardada!");
                        }
                        });
                        
                    } 
                    
                    
                }
            }
            public boolean done()
            {
                return fin;
            }
    }
    protected void setup()
    {
        addBehaviour(new ReceptorComportaminento());
    }
    public void takeDown(){
        System.out.println("Enterado "+getAID().getName());
    }
}
