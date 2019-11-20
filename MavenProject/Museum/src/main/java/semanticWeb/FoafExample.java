package semanticWeb;

import java.io.IOException;
import java.io.InputStream;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.util.FileManager;

public class FoafExample {
	static String defaultNameSpace = "http://org.semweb/assign4/people#";
	
	static String service1Endpoint = "http://localhost:3030/FOAF/query";
	static String strQuery1 = "\n" + 
			"SELECT ?subject ?predicate ?object\n" + 
			"WHERE {\n" + 
			"  ?subject ?predicate ?object\n" + 
			"}\n" + 
			"LIMIT 25";
	Model _friends = null;
	Model schema = null;
	InfModel inferredFriends = null;
	
	public static void main(String[] args) throws IOException {
		FoafExample hello = new FoafExample();//Load my FOAF friends
//		System.out.println("Load my FOAF Friends");
//		hello.populateFOAFFriends();
//		System.out.println("\nSay Hello to Myself");
//		hello.mySelf(hello._friends);
//		// Say Hello to my FOAF Friends
//		System.out.println("\nSay Hello to my FOAF Friends");
//		hello.myFriends(hello._friends);
		hello.loadFriends(service1Endpoint, strQuery1);
	}
	
	private void loadFriends(String uri, String query) {
		QueryExecution qexec = QueryExecutionFactory.sparqlService(uri, query);
		ResultSet result = qexec.execSelect();
		ResultSetFormatter.out(System.out, result);
	}
	
	private void populateFOAFFriends(){
		_friends = ModelFactory.createOntologyModel();
		InputStream inFoafInstance = getClass()
				.getClassLoader().getResourceAsStream("FOAFFriends.rdf");             
				//FileManager.get().open("FOAFFriends.rdf");
		_friends.read(inFoafInstance,defaultNameSpace);
		System.out.println("Success");
		try {
			inFoafInstance.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void mySelf(Model model){
		//Hello to Me - focused search
		runQuery(" select DISTINCT ?name where    { people:me foaf:name ?name}", model);
		//add the query string
		}
	
	private void runQuery(String queryRequest, Model model){  
		StringBuffer queryStr = new StringBuffer();  
		// Establish Prefixes  
		//Set default Name space first  
		queryStr.append("PREFIX people" + ": <" + defaultNameSpace + "> ");  
		queryStr.append("PREFIX rdfs" + ": <" +
				"http://www.w3.org/2000/01/rdf-schema#" + "> ");  
		queryStr.append("PREFIX rdf" + ": <" + "http://www.w3.org/1999/02/22-"
				+ "rdf-syntax-ns#" + "> ");  
		queryStr.append("PREFIX foaf" + ": <" + "http://xmlns.com/foaf/0.1/"                    
				+ "> ");  
		//Now add query  
		queryStr.append(queryRequest);  
		Query query = QueryFactory.create(queryStr.toString());  
		QueryExecution qexec = QueryExecutionFactory.create(query, model);  
		try   {
			ResultSet response = qexec.execSelect();
			while(response.hasNext()){
				QuerySolution soln = response.nextSolution();
				RDFNode name = soln.get("?name");
				if( name != null )
					System.out.println( "Hello to " + name.toString() );
				else
					System.out.println("No Friends found!");
				} 
		}
		finally { 
			qexec.close();
		}
	}
	
	private void myFriends(Model model)
	{
		//Hello to just my friends - navigation
		runQuery(" select DISTINCT ?name where{  people:me foaf:knows ?friend. ?friend foaf:name ?name } ", model); //add querystring 
	} 


}