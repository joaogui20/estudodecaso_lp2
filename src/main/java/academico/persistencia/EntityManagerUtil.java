package academico.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    private static EntityManagerFactory factory;

    private EntityManagerUtil(){}

    static{ factory = Persistence.createEntityManagerFactory("academico");}

    public static EntityManager getEntityManager(){
        if(factory == null) throw new IllegalStateException("Unidade de persistencia nao iniciada");
        return factory.createEntityManager();
    }
}
