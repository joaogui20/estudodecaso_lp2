package org.joaogui.academico.visao;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.joaogui.academico.vo.Professor;
import org.joaogui.academico.vo.Curso;

public class ProfessorFXMLController implements Initializable {

    private Professor professor;
    private List<Curso> listaCurso;

    @FXML
    private TextField Nome;
    @FXML
    private TextField Titulacao;
    @FXML
    private TextField Formacao;
    @FXML
    private TextField Curso;
    @FXML
    private Label campoNome;
    @FXML
    private Label campoTitulacao;
    @FXML
    private Label campoFormacao;
    @FXML
    private Label campoCurso;
    @FXML
    private void botaoSalvarOnAction(ActionEvent event){
        System.exit(0);
    }
    @FXML
    private void botaoSairOnAction(ActionEvent event){
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){

    }
}
