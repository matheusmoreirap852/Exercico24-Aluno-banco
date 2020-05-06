package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ViewControler implements Initializable {

	@FXML
	private TextField txtID;

	@FXML
	private TextField txtCNPJ;

	@FXML
	private Button btTest;

	@FXML
	private TextField txtRazaoSocial;

	@FXML
	private TextField txtStatus;

	@FXML
	private TextField txtPagamento;

	@FXML
	private TextField txtEstado;

	@FXML
	private TextField txtCidade;

	public static class Alerts {

		public static void showAlert(String title, String header, String content, AlertType type) {
			Alert alert = new Alert(type);
			alert.setTitle(title);
			alert.setHeaderText(header);
			alert.setContentText(content);
			alert.show();
		}
	}

	@FXML
	void onBtTestAction(ActionEvent event) {
		try {
			Locale.setDefault(Locale.US);
			String id = (txtID.getText());
			String cnpj = (txtID.getText());
			String razaoSocial = (txtRazaoSocial.getText());
			String cidade = (txtCidade.getText());
			String estado = (txtEstado.getText());
			String pagamento = (txtPagamento.getText());
			String status = (txtStatus.getText());
			StringBuilder result = new StringBuilder();

			result.append(id).append(";").append(cnpj).append(";").append(razaoSocial).append(";").append(cidade)
					.append(";").append(estado).append(";").append(pagamento).append(";").append(status);

			// *************************************
			String[] lines = new String[] {"\n" ,result.toString(), "\n"};
			String path = "D:\\Java-Eclipse\\PessoaJuridica.csv";
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
				for (String line : lines) {
					bw.write(line);
					bw.newLine();
			}
			} catch (IOException e) {
				e.printStackTrace();
			}

			// *************************************

		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
			// TODO: handle exception
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		MascarasFX.mascaraData(txtID);
		MascarasFX.mascaraCNPJ(txtCNPJ);
	}

}
