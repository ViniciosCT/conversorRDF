package br.ufsm.csi.tcc2.vocabulary;

import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;

public class Propriedades {
	
	protected static final String NS = "http://swrc.ontoware.org/ontology#";

    public static final String getURI(){ return NS; }
    
    public final static Property  inXSDataTime = ResourceFactory.createProperty("http://www.w3.org/2006/time#inXSDDateTime");  
    public final static Property  hasDataValue = ResourceFactory.createProperty("http://www.loa.istc.cnr.it/ontologies/DUL.owl#hasDataValue");
    public final static Property  observationSamplingTime = ResourceFactory.createProperty("http://purl.oclc.org/NET/ssnx/ssn#observationSamplingTime");
    
    public final static Resource  Instant = ResourceFactory.createResource("http://www.w3.org/2006/time#Instant");
    
}
