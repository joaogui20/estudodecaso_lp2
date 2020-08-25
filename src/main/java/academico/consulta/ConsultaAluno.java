package academico.consulta;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import academico.persistencia.EntityManagerUtil;
import academico.vo.Aluno;
import academico.vo.Curso;

public class ConsultaAluno {
    public static void main(String[] args) {
        try{
            EntityManager entityManager = EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT aluno FROM academico.vo.Aluno aluno ORDER BY aluno.nome");
            List<Aluno> listaAluno = query.getResultList();
            for(Aluno aluno : listaAluno){
                System.out.println("Matricula: " + aluno.getMatricula());
                System.out.println("Nome Aluno: " + aluno.getNome());
                System.out.println("Data Nascimento: " + aluno.getDataNascimento());
                System.out.println("Sexo: " + aluno.getSexo());

                for(Curso curso : aluno.getListaCurso()){
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
