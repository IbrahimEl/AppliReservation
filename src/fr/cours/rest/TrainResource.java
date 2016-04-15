package fr.cours.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/trains")
@Produces("application/xml")
public class TrainResource {

	public TrainResource() {
	}

	@GET

	public List<Train> getTrains() {
		System.out.println("La liste de trains :");
		return TrainBD.getTrains();
	}
	
	@GET
	@Path("numTrain-{id}")
	public Train getTrain(@PathParam("id") String numTrain) {
		
			for (Train t1  : TrainBD.getTrains()) {
				if(t1.getNumTrain().equals(numTrain) ){
					return t1;
				}
		}
			System.out.println("train introuvable");
			return null;
		
	
	 }

    @GET
	@Path("/search")
    public Train rechercheAvecCriteres(
    		
    	@QueryParam("depart") String villedepart,	
    	@QueryParam("arrivee") String villearrivee,	
    	@QueryParam("heuredepart") int heuredepart){
    	
    	for (Train t2  : TrainBD.getTrains()) {
			if( t2.getVilleDepart().equals("depart") && t2.getVilleArrivee().equals("arrivee") && t2.getHeureDepart() == heuredepart) {
				return t2;
			}

			
			
    	
    	//    	return "billet train départ " + depart + " " + arrivee + " " + heuredepart + "" ;
    	
    }
		
    	System.out.println("train introuvable");
		return null;
}
    
}
