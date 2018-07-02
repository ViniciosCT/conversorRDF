package br.ufsm.csi.tcc2.Controller;

import br.ufsm.csi.tcc2.Util.ConectaTomada;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/outlet001")
public class TomadaController {

    private String ip = "192.168.0.113";
    private String port = "80";
    private boolean outletStateOn = false;

    @RequestMapping( value = "/test" ,method = RequestMethod.GET)
    public String testarTomada() {
        String method = "hello";

        //Conetca e traz o retorno
        ConectaTomada conetaTomada = new ConectaTomada();
        String retorno = conetaTomada.getDadosTomada(ip, port, method);

        if (retorno.equals("OKDSV2ENCPH@NTOM")) {
            String ok = " =========== >> Hardware connected successfully << ========== ";
            return ok;
        } else {
            String erro = " =========== Error: Could not connect! Verify that the hardware is connected to" +
                    " the network with the ip \"" + ip + "\" and pot: \"" + port + "\" ========== ";
            return erro;
        }
    }

    @RequestMapping(value = "/setOutletState", method = RequestMethod.GET)
    public String setOutletState() {
        String method;
        if(outletStateOn){
            method = "desligar";
        }else{
            method = "ligar";
        }

        //Conetca e traz o retorno
        ConectaTomada conetaTomada = new ConectaTomada();
        String retorno = "ok" ;//conetaTomada.getDadosTomada(ip, port, method);

        if (retorno.isEmpty() || retorno == null) {
            System.out.println( " =========== Error: Could not connect! Verify that the hardware is connected to" +
                    " the network with the ip \"" + ip + "\" and pot: \"" + port + "\" ========== " );
            return "400";
        } else {
            String ok;
            if(outletStateOn){
                outletStateOn = false;
                ok = " =========== >> Tomada Desligada! << ========== ";
            }else{
                outletStateOn = true;
                ok = " =========== >> Tomada Ligada! << ========== ";
            }
            System.out.println( ok );
            return "200";
        }
    }

}
