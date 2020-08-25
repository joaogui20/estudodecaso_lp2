package academico.vo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Municipio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40, nullable = false)
    private String nome;

    @ManyToOne
    private Estado estado;

    public Municipio(){}

    public Municipio(String nome, Estado estado){
        this.nome = nome;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString(){
        return this.nome + " - " + this.estado;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        final Municipio other = (Municipio) obj;
        if(this.id != other.id){
            return false;
        }
        return true;
    }
}
