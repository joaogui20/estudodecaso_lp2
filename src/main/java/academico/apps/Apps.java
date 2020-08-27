package org.joaogui.academico.apps;

import javax.persistence.EntityManager;

import org.joaogui.academico.persistencia.EntityManagerUtil;
import org.joaogui.academico.vo.Curso;
import org.joaogui.academico.vo.Estado;
import org.joaogui.academico.vo.Municipio;

public class Apps {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();

        Municipio municipio = new Municipio("municipio1");
        em.persist(municipio);
        municipio = new Municipio("municipio2");
        em.persist(municipio);
        municipio = new Municipio("municipio3");
        em.persist(municipio);
        municipio = new Municipio("municipio4");
        em.persist(municipio);
        municipio = new Municipio("municipio5");
        em.persist(municipio);

        Estado estado = new Estado("estado1");
        em.persist(estado);
        estado = new Estado("estado2");
        em.persist(estado);
        estado = new Estado("estado3");
        em.persist(estado);
        estado = new Estado("estado4");
        em.persist(estado);
        estado = new Estado("estado5");
        em.persist(estado);

        Curso curso = new Curso("curso1");
        em.persist(curso);
        curso = new Curso("curso2");
        em.persist(curso);
        curso = new Curso("curso3");
        em.persist(curso);
        curso = new Curso("curso4");
        em.persist(curso);
        curso = new Curso("curso5");
        em.persist(curso);

        em.getTransaction().commit();
    }
}
