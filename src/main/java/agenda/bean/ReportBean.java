package agenda.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.StreamedContent;

import agenda.util.RelatorioUtil;

@ManagedBean
@SessionScoped
public class ReportBean extends AbstractBean{
	
	private StreamedContent	arquivoRetorno;
	
	public StreamedContent getArquivoRetorno() {
        FacesContext context = FacesContext.getCurrentInstance();
        String nomeRelatorioJasper = "relQuantidadeDeServicos";
        String nomeRelatorioSaida =  "Quantidade de Serviços"; 
        HashMap parametrosRelatorio = new HashMap(); 
        parametrosRelatorio.put("codigoUsuario", "Texto");
        RelatorioUtil relatorioUtil = new RelatorioUtil();
        try {
                this.arquivoRetorno = relatorioUtil.geraRelatorio(null, nomeRelatorioJasper,
                        nomeRelatorioSaida, RelatorioUtil.RELATORIO_PDF);
                System.out.println("ERA PRA TER DADO CERTO");
        } catch (Exception e) {
                context.addMessage(null, new FacesMessage(e.getMessage()));
                System.out.println("DEU MUITO ERRADO");
                return null;
        } 
        return this.arquivoRetorno;
    }
	
	public StreamedContent getArquivoRetornoOutro() {
        FacesContext context = FacesContext.getCurrentInstance();
        String nomeRelatorioJasper = "relHorariosServicosFuncionarios";
        String nomeRelatorioSaida =  "Quantidade de Serviços"; 
        HashMap parametrosRelatorio = new HashMap(); 
        parametrosRelatorio.put("codigoUsuario", "Texto");
        RelatorioUtil relatorioUtil = new RelatorioUtil();
        try {
                this.arquivoRetorno = relatorioUtil.geraRelatorio(null, nomeRelatorioJasper,
                        nomeRelatorioSaida, RelatorioUtil.RELATORIO_PDF);
                System.out.println("ERA PRA TER DADO CERTO");
        } catch (Exception e) {
                context.addMessage(null, new FacesMessage(e.getMessage()));
                System.out.println("DEU MUITO ERRADO");
                return null;
        } 
        return this.arquivoRetorno;
    }
}
