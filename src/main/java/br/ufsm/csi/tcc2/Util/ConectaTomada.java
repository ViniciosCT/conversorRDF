package br.ufsm.csi.tcc2.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ConectaTomada {

    public String getDadosTomada(String ip, String port, String comando) {
        String retorno = "";

        if (!ip.equals("")) {
            try {
                URL url = new URL("http://" + ip + ":" + port + "/" + comando);
                URLConnection connection = url.openConnection();

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                connection.getInputStream()));

                String inputLine;
                StringBuffer sb = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    sb.append(inputLine);
                }

                if (!sb.toString().equals("")) {
                    retorno = sb.toString();
                }
                System.out.println("--> " + retorno);
                in.close();
                if(comando.equals("ligar") || comando.equals("desligar")){
                    retorno = "ok";
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return retorno;
    }

}
