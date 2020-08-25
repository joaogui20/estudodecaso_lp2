package academico.vo;

import academico.vo.enums.Sexo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40, nullable = false)
    private String nome;
    private LocalDate dataNascimento;

    @Enumerated
    private Sexo sexo;

    @Embedded
    private Endereco endereco;

    @CollectionTable
    @ElementCollection
    private List<Telefone> telefone;

    public Pessoa(){}

    public Pessoa(String nome, LocalDate dataNascimento, Sexo sexo, Endereco endereco){
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.sexo = sexo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString(){
        return this.nome + " - " + this.dataNascimento;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if(this.id != other.id){
            return false;
        }
        return true;
    }
}
