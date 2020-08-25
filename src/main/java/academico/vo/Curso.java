package academico.vo;

import academico.vo.enums.TipoCurso;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Curso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40, nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoCurso tipo;

    @ManyToMany(mappedBy = "curso")
    private List<Professor> listaProfessor;

    @ManyToMany(mappedBy = "curso")
    private List<Aluno> listaAluno;

    public Curso(){}

    public Curso(String nome, TipoCurso tipo){
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCurso getTipo() {
        return tipo;
    }

    public void setTipo(TipoCurso tipo) {
        this.tipo = tipo;
    }

    public List<Professor> getListaProfessor() {
        return listaProfessor;
    }

    public void setListaProfessor(List<Professor> listaProfessor) {
        this.listaProfessor = listaProfessor;
    }

    public List<Aluno> getListaAluno() { return listaAluno; }

    public void setListaAluno(List<Aluno> listaAluno) { this.listaAluno = listaAluno; }

    @Override
    public String toString(){
        return this.nome + " - " + this.tipo;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Curso other = (Curso) obj;
        if (this.id != other.id){
            return false;
        }
        return true;
    }
}
