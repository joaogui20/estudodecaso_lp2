package academico.vo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Table(name = "aluno")
public class Aluno extends Pessoa implements Serializable {
    @Column(length = 40, nullable = false)
    private int matricula;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "aluno_curso", joinColumns = {@JoinColumn(name = "aluno_id")}, inverseJoinColumns = {@JoinColumn(name = "curso_id")})
    private List<Curso> listaCurso;

    public Aluno(){}

    public Aluno(int matricula){
        this.matricula = matricula;
    }

    public int getMatricula() { return matricula; }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public List<Curso> getListaCurso() {
        return listaCurso;
    }

    public void setListaCurso(List<Curso> listaCurso) {
        this.listaCurso = listaCurso;
    }
}
