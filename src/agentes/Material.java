/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import jade.core.*;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CIEDUCAR
 */
public class Material extends Agent{
    
    static int numero = -1;
    Form frame = new Form();
    static Persona p; 
    /**
     */
    @Override
    public void setup(){
        // TODO code application logic here
        frame.setVisible(true);
        
        System.out.println("Iniciando "+getAID().getName()+" : "+getAID());
       
                
        // Añade un comportamiento
        addBehaviour(new Disparar());
        
    }
    
   /* public void takeDown(){
        System.out.println("Termine...fui asesinado "+getAID().getName());
    }*/
    
    // Definición de un comportamiento
    private class Disparar extends Behaviour{
        private int estado = 0;
 
        // Función que realiza MiComportamiento
        @Override
        public void action(){            
            switch(estado){
                case 0: /*System.out.println("Esperando")*/; break;
                case 1: addBehaviour(new Comunicar());break;
                //default:
                //    addBehaviour(new Comunicar());break;
                   
            }
            if(numero != -1){
                estado++;
            }
        }
 
        // Comprueba si el comportamiento ha finalizado.
        public boolean done(){
            return estado < 0;
        }
        
        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        } 
        
    }
    class Comunicar extends SimpleBehaviour
    {
        boolean fin = false;
        
        public void action()
        {
            //System.out.println(getLocalName() +": marcando al celular del jefe");
            AID id = new AID();
            id.setLocalName("jefe");
 
        // Creación del objeto ACLMessage
            ACLMessage mensaje = new ACLMessage(ACLMessage.REQUEST);
 
        //Rellenar los campos necesarios del mensaje
            mensaje.setSender(getAID());
            mensaje.setLanguage("Español");
            mensaje.addReceiver(id);
            try {
                mensaje.setContentObject(p); //String.valueOf(numero) "5"
            } catch (IOException ex) {
                Logger.getLogger(Material.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        //Envia el mensaje a los destinatarios
            send(mensaje);
            
            addBehaviour(new Disparar());
            //System.out.println(getLocalName() +": Enviando a jefe");
            //System.out.println(mensaje.toString());
            fin = true;
        }
 
        public boolean done()
        {
            return fin;
        }
    }
}

