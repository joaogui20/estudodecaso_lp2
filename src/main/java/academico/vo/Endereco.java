package academico.vo;

import academico.vo.enums.TipoLogradouro;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.ManyToOne;

@Embeddable
public class Endereco implements Serializable {
    @Enumerated(EnumType.STRING)
    private TipoLogradouro tipo;

    @Column(length = 40, nullable = false)
    private String logradouro;
    private int numero;
    private String bairro;

    @ManyToOne
    private Municipio municipio;

    public Endereco(){}

    public Endereco(String logradouro, int numero, String bairro){
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
    }

    public TipoLogradouro getTipo() {
        return tipo;
    }

    public void setTipo(TipoLogradouro tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString(){
        return this.logradouro + " - " + this.numero + " - " + this.bairro;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        final Endereco other = (Endereco) obj;
        if(this.tipo != other.tipo){
            return false;
        }
        return true;
    }
}
