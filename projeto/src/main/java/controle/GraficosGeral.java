package controle;


import javax.annotation.PostConstruct;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartSeries;

import com.ibm.icu.text.SimpleDateFormat;

import banco.DAOGenerico;
import entidades.Leite;
import entidades.Producao;
import entidades.Venda;

@ManagedBean
@ViewScoped
public class GraficosGeral implements Serializable {
     
     
    private LineChartModel dateModelProducao;
    private LineChartModel dateModelVenda;
    private LineChartModel dateModelLeite;
    private DAOGenerico dao = new DAOGenerico();
    private List<Producao> lista = new ArrayList<>();
    private List<Venda> listaVenda = new ArrayList<>();
    private Date dataInicial = new Date();
    private Date dataFinal = new Date();
    public String novaData, novaData2;
    private Producao producao = new Producao();
    private Venda venda = new Venda();
    private Leite leite = new Leite();
    private List<Leite> listaLeite = new ArrayList<Leite>();
   
    public GraficosGeral() {
    	createdateModelProducao();
    	createdateModelVenda();
    	createdateModelLeite();
   }
    
//    @PostConstruct
//    public void init() {
//       createdateModelProducao();
//       createdateModelVenda();
//       createdateModelLeite();
//       
//    }
     private void createdateModelProducao() {
    	
    	lista = dao.lista(Producao.class);
    
    	FacesContext faces = FacesContext.getCurrentInstance();
    	
    		 
    		 dateModelProducao = new LineChartModel();
             LineChartSeries series1 = new LineChartSeries();
             series1.setLabel("Series 1");
             int  n = 5;
             
             for (int i = lista.size() -1; i > -1; i--) {  
            	 if(n>=0){
            		 
                 
               	 Object valor =	lista.get(i).getDataOrdenha().toString();
          		 series1.set(valor, lista.get(i).getValorTotalProDiaria());
          		 dateModelProducao.addSeries(series1);
          			
          		
                	
            	 n--;
            	 }
           }  
       
             dateModelProducao.getAxis(AxisType.Y).setLabel("Valor em R$");
             DateAxis axis = new DateAxis("Curva de variação da produção");
             axis.setTickAngle(-80);
            
             axis.setTickCount(10);
             
             dateModelProducao.getAxis(AxisType.Y).setTickCount(20);
             dateModelProducao.getAxis(AxisType.Y).setMin(0);
             axis.setTickFormat("%#d, %b %y");
             
              
             dateModelProducao.getAxes().put(AxisType.X, axis);
         	System.out.println("no GRAFICO");
     
     	
    }
 private void createdateModelLeite() {
    	
    	listaLeite = (List<Leite>) dao.lista(Leite.class);
    	
    		 
    		 dateModelLeite = new LineChartModel();
             LineChartSeries series3 = new LineChartSeries();
             series3.setLabel("Series 1");
             int  n = 5;  
             
             for (int i = listaLeite.size()-1 ; i > -1; i--) {  
             if(n>=0){
            		 
                 
               	 Object valor =	listaLeite.get(i).getDataDoValor().toString();
          		 series3.set(9, 9);
          		 dateModelLeite.addSeries(series3);
          		 n--;
            	 System.out.println("Numero N"+n);
            	
             }
           }  
          
             dateModelLeite.getAxis(AxisType.Y).setLabel("Valor em R$");
             DateAxis axis3 = new DateAxis("Curva de variação do Litro do Leite");
             axis3.setTickAngle(-80);
            
             axis3.setTickCount(10);
             
             dateModelLeite.getAxis(AxisType.Y).setTickCount(20);
             dateModelLeite.getAxis(AxisType.Y).setMin(0);
             axis3.setTickFormat("%#d, %b %y");
             
              
             dateModelLeite.getAxes().put(AxisType.X, axis3);
         	System.out.println("no GRAFICO");
     
     	
    }
  private void createdateModelVenda() {
    	
    	listaVenda = dao.lista(Venda.class);
    
    	FacesContext faces = FacesContext.getCurrentInstance();
    	
    		 
    		 dateModelVenda = new LineChartModel();
             LineChartSeries series2 = new LineChartSeries();
             series2.setLabel("Series 1");
             int  n = 5;
             
             for (int i = listaVenda.size() - 1; i > -1; i--) {  
            	if(n>=0){
            		 
                 
               	 Object valor =	listaVenda.get(i).getDataVenda().toString();
          		 series2.set(valor, listaVenda.get(i).getValorTotal());
          		dateModelVenda.addSeries(series2);

	
            	 n--;
            	 }
           }  
             


             dateModelVenda.getAxis(AxisType.Y).setLabel("Valor em R$");
             DateAxis axis2 = new DateAxis("Curva de variação de Venda");
             axis2.setTickAngle(-80);
            
             axis2.setTickCount(10);
             
             dateModelVenda.getAxis(AxisType.Y).setTickCount(20);
             dateModelVenda.getAxis(AxisType.Y).setMin(0);
             axis2.setTickFormat("%#d, %b %y");
             
              
             dateModelVenda.getAxes().put(AxisType.X, axis2);
         	 System.out.println("no GRAFICO");
         	
     	
    }
  
  public LineChartModel getdateModelProducao() {
      return dateModelProducao;
  }
	public Leite getLeite() {
	return leite;
}

public void setLeite(Leite leite) {
	this.leite = leite;
}

public List<Leite> getListaLeite() {
	return listaLeite;
}

public void setListaLeite(List<Leite> listaLeite) {
	this.listaLeite = listaLeite;
}

	public Date getDataFinal() {
		return dataFinal;
	}
	

	public LineChartModel getDateModelVenda() {
		return dateModelVenda;
	}

	public void setDateModelVenda(LineChartModel dateModelVenda) {
		this.dateModelVenda = dateModelVenda;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public Producao getProducao() {
		return producao;
	}

	public void setProducao(Producao producao) {
		this.producao = producao;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getNovaData() {
		return novaData;
	}

	public void setNovaData(String novaData) {
		this.novaData = novaData;
	}

	public String getNovaData2() {
		return novaData2;
	}

	public void setNovaData2(String novaData2) {
		this.novaData2 = novaData2;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public List<Producao> getLista() {
		return lista;
	}

	public void setLista(List<Producao> lista) {
		this.lista = lista;
	}

	public List<Venda> getListaVenda() {
		return listaVenda;
	}

	public void setListaVenda(List<Venda> listaVenda) {
		this.listaVenda = listaVenda;
	}

	public LineChartModel getDateModelLeite() {
		return dateModelLeite;
	}

	public void setDateModelLeite(LineChartModel dateModelLeite) {
		this.dateModelLeite = dateModelLeite;
	}
    
    
}