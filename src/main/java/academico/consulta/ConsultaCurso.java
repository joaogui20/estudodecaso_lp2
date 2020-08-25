package academico.consulta;

import academico.persistencia.EntityManagerUtil;
import academico.vo.Curso;
import academico.vo.Professor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ConsultaCurso {
    public static void main(String[] args) {
        try{
            EntityManager entityManager = EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT curso FROM academico.vo.Curso curso ORDER BY curso.nome");
            List<Curso> listaCurso = query.getResultList();
            for(Curso curso : listaCurso){
                System.out.println("Nome: " + curso.getNome());
                System.out.println("Tipo: " + curso.getTipo());

                for(Professor professor : curso.getListaProfessor()){
                    System.out.println("\tNome: " + professor.getNome());
                    System.out.println("\tFormacao: " + professor.getFormacao());
                    System.out.println("\tTitulacao: " + professor.getTitulacao());
                }
                System.out.println("-------------------------");
            }
            entityManager.getTransaction().commit();
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
