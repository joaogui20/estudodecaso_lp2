package academico.vo;

import academico.vo.enums.TipoFone;

import java.io.Serializable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Embeddable;
import javax.persistence.Column;

@Embeddable
public class Telefone implements Serializable {
    @Enumerated(EnumType.ORDINAL)
    private TipoFone tipoFone;

    @Column(length = 3, nullable = false)
    private String numero;

    public Telefone(){}

    public Telefone(String numero, TipoFone tipoFone){
        this.numero = numero;
        this.tipoFone = tipoFone;
    }

    public TipoFone getTipoFone() {
        return tipoFone;
    }

    public void setTipoFone(TipoFone tipoFone) {
        this.tipoFone = tipoFone;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString(){
        return this.tipoFone + " - " + this.numero;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        final Telefone other = (Telefone) obj;
        if (this.numero != other.numero){
            return false;
        }
        return true;
    }
}
