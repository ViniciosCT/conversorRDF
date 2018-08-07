package br.ufsm.csi.tcc2.Service;

import br.ufsm.csi.tcc2.Util.ConectaTomada;
import org.apache.jena.rdf.model.Model;

import java.util.Date;

import static br.ufsm.csi.tcc2.Util.UtilTomada.gerarParaRDFModel;

public class TomadaService {

    private String ip = "192.168.0.30";
    private String port = "1000";

    public Model getTemperatura() {
        String method = "temperatura";

        //Conetca e traz o retorno
        ConectaTomada conetaTomada = new ConectaTomada();
        String retorno = conetaTomada.getDadosTomada(ip, port, method);

        if (retorno.isEmpty() || retorno == null) {
            String erro = " =========== Error: Could not connect! Verify that the hardware is connected to" +
                    " the network with the ip \"" + ip + "\" and pot: \"" + port + "\" ========== ";
            System.out.println(erro);
            return null;
        } else {
            //String retorno = "25.82"; // Só para testar!!
            System.out.println(" =========== >> Temperatura consultada: " + retorno + " - Data: " + (new Date()) + " << ========== ");

            //Transformar em RDF com Jena:
            Model dadosRDF = gerarParaRDFModel(retorno, "temperature");

            return dadosRDF;
        }
    }

    public Model getUmidade() {
        String method = "umidade";

        //Conetca e traz o retorno
        ConectaTomada conetaTomada = new ConectaTomada();
        String retorno = conetaTomada.getDadosTomada(ip, port, method);

        if (retorno.isEmpty() || retorno == null) {
            String erro = " =========== Error: Could not connect! Verify that the hardware is connected to" +
                    " the network with the ip \"" + ip + "\" and pot: \"" + port + "\" ========== ";
            System.out.println(erro);
            return null;
        } else {
            //String retorno = "50"; // Só para testar!!
            System.out.println(" =========== >> Umidade consultada: " + retorno + " - Data: " + (new Date()) + " << ========== ");

            //Transformar em RDF com Jena:
            Model dadosRDF = gerarParaRDFModel(retorno, "humidity");

            return dadosRDF;
        }
    }

    public Model getVoltagem() {
        String method = "voltagem";

        //Conetca e traz o retorno
        ConectaTomada conetaTomada = new ConectaTomada();
        String retorno = conetaTomada.getDadosTomada(ip, port, method);

        if (retorno.isEmpty() || retorno == null) {
            String erro = " =========== Error: Could not connect! Verify that the hardware is connected to" +
                    " the network with the ip \"" + ip + "\" and pot: \"" + port + "\" ========== ";
            System.out.println(erro);
            return null;
        } else {
           // String retorno = "220"; // Só para testar!!
            System.out.println(" =========== >> Voltagem consultada: " + retorno + " - Data: " + (new Date()) + " << ========== ");

            //Transformar em RDF com Jena:
            Model dadosRDF = gerarParaRDFModel(retorno, "voltage");

            return dadosRDF;
        }
    }

    public Model getCorrente() {
        String method = "corrente";

        //Conetca e traz o retorno
        ConectaTomada conetaTomada = new ConectaTomada();
        String retorno = conetaTomada.getDadosTomada(ip, port, method);

        if (retorno.isEmpty() || retorno == null) {
            String erro = " =========== Error: Could not connect! Verify that the hardware is connected to" +
                    " the network with the ip \"" + ip + "\" and pot: \"" + port + "\" ========== ";
            System.out.println(erro);
            return null;
        } else {
    //        String retorno = "110"; // Só para testar!!
            System.out.println(" =========== >> Corrente consultada: " + retorno + " - Data: " + (new Date()) + " << ========== ");

            //Transformar em RDF com Jena:
            Model dadosRDF = gerarParaRDFModel(retorno, "current");

            return dadosRDF;
        }
    }

}
