package br.ufsm.csi.tcc2.Util;

import br.ufsm.csi.tcc2.vocabulary.Propriedades;
import org.apache.jena.rdf.model.*;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFactory;
import org.apache.jena.system.Txn;
import org.apache.jena.vocabulary.RDF;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilTomada {

    public static String tomadaURI = "http://localhost:3030/ontology-outlet-001#";

    public static Model gerarParaRDFModel(String data, String type){
        Date dateN = new Date();
        String dataT = "dd-MM-yyyy";
        String dataZ = "HH:mm:ss";
        SimpleDateFormat formatas = new SimpleDateFormat(dataT);
        SimpleDateFormat formatas2 = new SimpleDateFormat(dataZ);
        String dataF = formatas.format(dateN);
        String timeF = formatas2.format(dateN);
        String dataXSD = dataF + "Z" + timeF + "T";

        // create an empty Model
        Model model = ModelFactory.createDefaultModel();

        //Set Name Space Prefix of model:
        model.setNsPrefix( "rdf", RDF.getURI());
        model.setNsPrefix( "time", "http://www.w3.org/2006/time#");

        model.createResource(tomadaURI + type + "_" + dataXSD).addLiteral(Propriedades.inXSDataTime, dataXSD)
                .addProperty(Propriedades.hasDataValue, data);

        return model;
    }

    public static String gerarStringRDFModel(Model model){
        // now write the model in RDF/XML form to a file
        StringWriter writer = new StringWriter();
        model.write( writer, "RDF/XML-ABBREV" );

        return writer.toString();
    }

    public static boolean enviarParaDataSet(Model model, String uri){

        System.out.println( " >> Teste " + uri + ": \n" + gerarStringRDFModel(model) );
        try (RDFConnection conn = RDFConnectionFactory.connect(uri) ) {
            Txn.executeWrite(conn, () -> {
                conn.load( model );
            });
            System.out.println(" >> Dados inseridos no servidor! -- Local: " + uri + " << ");
            conn.close();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

}
