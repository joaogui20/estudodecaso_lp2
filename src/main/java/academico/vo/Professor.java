package academico.vo;

import academico.vo.enums.Titulacao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

public class Professor extends Pessoa implements Serializable {
    @Enumerated(EnumType.STRING)
    private Titulacao titulacao;

    @Column(length = 40, nullable = false)
    private String formacao;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "professor_curso", joinColumns = {@JoinColumn(name = "professor_id")}, inverseJoinColumns = {@JoinColumn(name = "curso_id")})
    private List<Curso> listaCurso;

    public Professor(){}

    public Professor(Titulacao titulacao, String formacao){
        this.formacao = formacao;
        this.titulacao = titulacao;
    }

    public Titulacao getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(Titulacao titulacao) {
        this.titulacao = titulacao;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public List<Curso> getListaCurso() {
        return listaCurso;
    }

    public void setListaCurso(List<Curso> listaCurso) {
        this.listaCurso = listaCurso;
    }

    @Override
    public String toString(){
        return this.formacao + " - " + this.titulacao;
    }
}
