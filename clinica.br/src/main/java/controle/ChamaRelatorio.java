package controle;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import banco.Banco;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Colaborador
 */
public class ChamaRelatorio {

	/**
	 * Colocar os relat�rios dentro de uma pasta chamada relatorio, dentro do
	 * WEB-INF. O caminhoRelatorio � o seu nome e a extens�o. O param � o
	 * par�metro, do tipo HashMap. O nomeRelatorio � o nome do relat�rio que
	 * ser� gerado, o que o usu�rio ir� ver.
	 *
	 */
	public static void imprimeRelatorio(String caminhoRelatorio, HashMap param, String nomeRelatorio){

		Connection con = Banco.getInstancia().getConnection();

		try {

			FacesContext facesContext = FacesContext.getCurrentInstance();

			facesContext.responseComplete();

			ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();

			JasperPrint jasperPrint = JasperFillManager.fillReport(scontext.getRealPath("/WEB-INF/relatorios/" + caminhoRelatorio), param, con);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			JasperExportManager.exportReportToPdfStream(jasperPrint, baos);

			byte[] bytes = baos.toByteArray();

			if (bytes != null && bytes.length > 0) {

				HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

				response.setContentType("application/pdf");

				response.setHeader("Content-disposition", "inline; filename=\"" + nomeRelatorio + ".pdf\"");
				//response.setHeader("Content-disposition", "attachment; filename=\"" + nomeRelatorio + ".pdf\"");

				response.setContentLength(bytes.length);

				ServletOutputStream outputStream = response.getOutputStream();

				outputStream.write(bytes, 0, bytes.length);

				outputStream.flush();

				outputStream.close();

				baos.close();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
