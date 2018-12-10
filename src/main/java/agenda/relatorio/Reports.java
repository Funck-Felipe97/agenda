package agenda.relatorio;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;

public class Reports {
			
	public void GetReport() throws JRException{
		JasperFillManager.fillReportToFile("reports/relatorioTeste.jasper", 
				null, new JREmptyDataSource(1));
	}	
	public void GetPDFReport() throws JRException{
		JasperExportManager.exportReportToPdfFile("reports/relatorioTeste.jrprint");
	}	
		
}
