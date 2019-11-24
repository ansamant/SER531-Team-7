package semanticWeb;

/**
 * Queries the Artwork, Artist and Location dataset through sparql and collects artwork details
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.util.FileManager;

public class MuseumHelper {
	
	static String service1Endpoint = "http://ec2-3-14-9-68.us-east-2.compute.amazonaws.com:3030/Location/";

	public String createQuery(String latitude, String longitude) {
		String str = "\n" +
			"PREFIX artwork: <http://www.semanticweb.org/leharbhatt/ontologies/2019/9/Artwork#>\n"+
				"PREFIX artist: <http://www.semanticweb.org/leharbhatt/ontologies/2019/9/artist#>\n"+
				"prefix location: <http://www.semanticweb.org/leharbhatt/ontologies/2019/9/location#>\n"+

				"SELECT *  WHERE {\n"+
				        "?subject location:OWLDataProperty_67fd5e2e_4179_4fd7_aef7_d8a39337bdf0 '"+latitude+"';\n"+
				                 "location:OWLDataProperty_de57441b_abfb_4133_bb3d_facc47fd90e8 '"+longitude+"';\n"+
				                 "location:OWLDataProperty_67031aff_da2d_4ea3_a6d2_e88390760b12 ?locationArtworkID.\n"+
				  		  "SERVICE <http://ec2-18-222-129-224.us-east-2.compute.amazonaws.com:3030/Artwork>{\n"+
				    		"SELECT * WHERE{\n"+
				    		"?subjectArtwork artwork:OWLDataProperty_c254d80f_3c67_49db_8718_f1c4cc8370d2 ?locationArtworkID;\n"+
				                      		"artwork:OWLDataProperty_9b22a56b_e31f_4b88_9ba9_1c36fc6758f5 ?artistId;\n"+
				                        	"artwork:OWLDataProperty_8830e8a3_260b_4b84_9832_0b488b54331f ?acquisitionDate;\n"+
				                         	"artwork:OWLDataProperty_a9b5c360_cfe3_4741_bef3_9b9117ca7e8f ?classification;\n"+
				                        	"artwork:OWLDataProperty_fd31c1a7_5c20_4dca_ba1c_d81f0e5cc660 ?creationDate;\n"+
				                            "artwork:OWLDataProperty_073e9179_49ee_4c71_8557_2f407f607984 ?credit;\n"+
				                            "artwork:OWLDataProperty_386b6ba7_a275_4111_bc09_c8166bc1214d ?department;\n"+
				                            "artwork:OWLDataProperty_292de7be_75a7_48b7_a6d6_109460f7ecda ?dimension;\n"+
				                            "artwork:OWLDataProperty_ee84f0f0_ae88_4623_b57e_1e0c36d65271 ?height;\n"+
				                            "artwork:OWLDataProperty_95b20f47_45d3_46fc_95e1_0ec473321094 ?medium;\n"+
				                            "artwork:OWLDataProperty_d188deb5_7ba1_4add_a734_89018485825d ?width;\n"+
				    						"artwork:OWLDataProperty_4d42d4f0_16a9_4541_b5d4_123bd5869720 ?artworkTitle.\n"+	
							"}\n"+
						"}\n"+
				  		  "SERVICE <http://ec2-18-218-20-176.us-east-2.compute.amazonaws.com:3030/Artist>{\n"+
				                 "SELECT * WHERE{\n"+
				                         "?artistObject artist:OWLDataProperty_650f6b5b_66e6_4af0_bf2b_5145af87b939 ?artistId;\n"+
				                                       "artist:OWLDataProperty_9f40d9f1_336d_44e5_9bb7_0804220f79ee ?gender;\n"+
				                                       "artist:OWLDataProperty_7e2740ad_f11b_4bcf_90e4_60163b80230d ?nationality;\n"+
				                                       "artist:OWLDataProperty_59f8302f_6533_450a_96e5_2ffc2f651610 ?birthYear;\n"+
				                                       "artist:OWLDataProperty_bfc7c752_fab9_40c0_ac3d_713cdb231b11 ?deathYear;\n"+
				                                       "artist:OWLDataProperty_933e0fc4_0c24_4ac7_a4c3_3e186344c9e4 ?name.\n"+
				          							
				                              "}\n"+
				                            "}\n"+

				"}\n"+
				"LIMIT 1";
		return str;
	}
	
//	public static void main(String[] args) throws IOException {
//		MuseumHelper hello = new MuseumHelper();
//		StringBuilder sb = new StringBuilder();
//		String query = hello.createQuery("40.78044586", "-73.96331672");
//		sb.append(query);
//		ArtworkDetails details = hello.loadArtwork(service1Endpoint, sb.toString());
//		//return details;
//	}
	
	
	public ArtworkDetails getDetails(String lat, String lon) {
		MuseumHelper hello = new MuseumHelper();
		StringBuilder sb = new StringBuilder();
		String query = createQuery(lat, lon);
		sb.append(query);
		ArtworkDetails details = hello.loadArtwork(service1Endpoint, sb.toString());
		return details;
	}
	
	/**
	 * Loads the artwork details. Returns null if the reut set is empty
	 * @param uri
	 * @param query
	 * @return
	 */
	private ArtworkDetails loadArtwork(String uri, String query) {
		
		QueryExecution qexec = QueryExecutionFactory.sparqlService(uri, query);
		ResultSet result = qexec.execSelect();
		//ResultSetFormatter.out(System.out, result);
	    List<String> columns = new ArrayList<String>();
	    for (String col: result.getResultVars()) {
	    	columns.add(col);
	    }
	    ArtworkDetails details = new ArtworkDetails();
	    for ( ; result.hasNext() ; ) {
		      QuerySolution soln = result.nextSolution() ;
		      details.setClassification(soln.getLiteral("classification").toString());
		      details.setArtistId((int) soln.getLiteral("artistId").getValue());
		      details.setHeight((float) soln.getLiteral("height").getValue());
		      details.setAcquisitionDate(soln.getLiteral("acquisitionDate").toString());
		      details.setArtworkTitle(soln.getLiteral("artworkTitle").toString());
		      details.setBirthYear((int) soln.getLiteral("birthYear").getValue());
		      details.setCreationDate(soln.getLiteral("creationDate").toString());
		      details.setCredit(soln.getLiteral("credit").toString());
		      details.setDeathYear((int) soln.getLiteral("deathYear").getValue());
		      details.setDepartment(soln.getLiteral("department").toString());
		      details.setDimension(soln.getLiteral("dimension").toString());
		      details.setGender(soln.getLiteral("gender").toString());
		      details.setLocationArtworkID((int) soln.getLiteral("locationArtworkID").getValue());
		      details.setMedium(soln.getLiteral("medium").toString());
		      details.setName(soln.getLiteral("name").toString());
		      details.setNationality(soln.getLiteral("nationality").toString());
		      details.setWidth((float) soln.getLiteral("width").getValue());
		      
		      
//		      System.out.println(details.getAcquisitionDate());
//		      System.out.println(details.getArtistId());
//		      System.out.println(details.getArtworkTitle());
//		      System.out.println(details.getBirthYear());
//		      System.out.println(details.getClassification());
//		      System.out.println(details.getCreationDate());
//		      System.out.println(details.getCredit());
//		      System.out.println(details.getDepartment());
//		      System.out.println(details.getDeathYear());
//		      System.out.println(details.getDimension());
//		      System.out.println(details.getGender());
//		      System.out.println(details.getHeight());
//		      System.out.println(details.getLocationArtworkID());
//		      System.out.println(details.getMedium());
//		      System.out.println(details.getName());
//		      System.out.println(details.getNationality());
//		      System.out.println(details.getWidth());
		      
		      
		    }
	    
	    return details;
	}
}