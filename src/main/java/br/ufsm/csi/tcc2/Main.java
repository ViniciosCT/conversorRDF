package br.ufsm.csi.tcc2;

import br.ufsm.csi.tcc2.Service.TomadaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static br.ufsm.csi.tcc2.Util.UtilTomada.enviarParaDataSet;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run( Main.class , args );

        TomadaService tomadaService = new TomadaService();

        while (true){

            enviarParaDataSet( tomadaService.getTemperatura() , "http://localhost:3030/temperature" );
            enviarParaDataSet( tomadaService.getUmidade()     , "http://localhost:3030/humidity"    );
            enviarParaDataSet( tomadaService.getVoltagem()    , "http://localhost:3030/voltage"     );
            enviarParaDataSet( tomadaService.getCorrente()    , "http://localhost:3030/current"     );

            Thread.sleep(10000);
        }

    }

}



