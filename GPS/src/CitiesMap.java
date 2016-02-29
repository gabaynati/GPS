//Name:Netanel Gabay
//I.D:303095228
import java.util.Vector;


public class CitiesMap{
	private Graph<City> map;
	//this class represents a map for cities



	public CitiesMap(){
		map=new Graph<City>();
	}




	//this method add city
	public void addCity(City c) throws CityExistException{
		try {
			map.addVertex(c);
		} 
		catch (VertexExistException e) {
			throw new CityExistException("such city already exists");
		}
	}



	//this method set a connection between to cities
	public void addWay(City c1,City c2) throws CityNotFoundException{
		try {
			map.addEdge(c1, c2);
		} catch (VertexNotExistException e) {

			throw new CityNotFoundException("city not founds");
		}
	}



	//this method returns all the city that exists on the map
	public Vector<City> getCities(){
		if (map.getVerteices()==null){
			return new Vector<City>();
		}
		return map.getVerteices();
	}




	//this method gets  city 1 and return ,as a vector, all the other cities that have connection to city 1
	public Vector<City> getWays(City c) {
		try {
			return map.getEdges(c);
		} catch (VertexNotExistException e) {
			return new  Vector<City>();
		}


	}



	//this method find the shortest path between two cities
	public Vector<City> findPath(City c1, City c2) throws CityNotFoundException, NoPathException {
		if(!isExists(c1)||!isExists(c2)){
			throw new CityNotFoundException("city not exists");
		}
		if(!isExists(c1)&&!isExists(c2)){
			throw new CityNotFoundException("city not exists");
		}


		if(map.bfs(c1, c2)==null){
			throw new NoPathException ("no path found");
		}


		return map.bfs(c1, c2);




	}





	//this method checks if a city exists
	private boolean isExists(City c){
		for(City i:map.getVerteices()){
			if (i.equals(c)){
				return true;
			}}
		return false;

	}



}
