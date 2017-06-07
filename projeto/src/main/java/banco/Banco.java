/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Banco {

    private static Banco instancia;
    private EntityManager em;

    private Banco() {
        em = Persistence.createEntityManagerFactory("ProjetoTcc").createEntityManager();
    }

    public synchronized static Banco getInstancia() {
        if (instancia == null) {
            instancia = new Banco();
          System.out.println("Entrou ");
        }
        return instancia;
    }

    public EntityManager getEm() {
        return em;
    }

}
