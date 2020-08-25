package academico.consulta;

import academico.persistencia.EntityManagerUtil;
import academico.vo.Professor;
import academico.vo.Curso;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ConsultaProfessor {
    public static void main(String[] args) {
        try{
            EntityManager entityManager = EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT professor FROM academico.vo.Professor professor ORDER BY professor.nome");
            List<Professor> listaProfessor = query.getResultList();
            for(Professor professor : listaProfessor){
                System.out.println("Titulacao: " + professor.getTitulacao());
                System.out.println("Nome Professor: " + professor.getNome());
                System.out.println("Data Nascimento: " + professor.getDataNascimento());
                System.out.println("Sexo: " + professor.getSexo());
                System.out.println("Formacao: " + professor.getFormacao());

                for(Curso curso : professor.getListaCurso()){
                    System.out.println("\tTipo: " + curso.getTipo());
                    System.out.println("\tNome: " + curso.getNome());
                }
                System.out.println("-------------------------");
            }
            entityManager.getTransaction().commit();
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
