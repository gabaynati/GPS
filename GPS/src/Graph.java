//Name:Netanel Gabay
//I.D:303095228
import java.util.Vector;




//this class represents graph that is junction is object from type E;
public class Graph<E> {
	private Vector<Vector<E>> vertices;






	public Graph(){
		vertices =new Vector<Vector<E>>();
	}





	//this method add junction vector to the graph
	public void addVertex(E ver) throws VertexExistException {

		if (!isExist(ver)){
			Vector<E> v=new Vector<E>();
			v.add(ver);
			vertices.addElement(v);

			return;
		}
		throw new VertexExistException("this juction already exists");


	}


	//this method gets two junction and make connection from 1 to 2 and from 2 to 1
	public void addEdge(E ver1, E ver2) throws VertexNotExistException {

		if(!isExist(ver1)||!isExist(ver2)){
			throw new VertexNotExistException("such junction not exists");
		}

		if(isExist(ver1) &&isExist(ver2)){
			for(Vector<E> i:vertices){

				if(i.firstElement().equals(ver1)){
					if(!i.contains(ver2)){
						i.add(ver2);
					}}
				if(i.firstElement().equals(ver2)){
					if(!i.contains(ver1)){
						i.add(ver1);
					}}
			}}
	}



	//this method gets junction 1 and return vector that contains all the junctions that have connection to 1;
	public Vector<E> getEdges(E ver) throws VertexNotExistException {
		if(!isExist(ver)){
			throw new VertexNotExistException("such junction not exists");
		}
		if(vertices==null){
			throw new VertexNotExistException("such junction not exists");
		}
		for(Vector<E> i:vertices){
			if(i.firstElement().equals(ver)){
				if(i.size()<=1){
					return null;
				}
				return i;

			}}
		return null;
	}






	//this method returns all the junctions in the graph (as a vector)
	public Vector<E> getVerteices() {
		if(vertices.isEmpty()){
			return null;
		}
		Vector<E> sum=new Vector<E>();
		for(Vector<E> i :vertices ){
			sum.addElement(i.firstElement());
		}
		return sum;
	}




	//this methods gets 2 junctions and returns the shortest path between them
	public Vector<E> bfs(E source, E target)  {

		/////tools
		Vector<Vector<E>> vBfs= new Vector<Vector<E>>();
		Vector<E> ways=new Vector<E>();
		Vector<E> first=new Vector<E>();
		Vector<E> newVec=new Vector<E>();
		E last=null;


		/////
		ways.add(source);
		vBfs.add(ways);
		///

		while(!vBfs.isEmpty()){
			first=vBfs.remove(0);
			if(!first.isEmpty())
				last=first.lastElement();
			try {
				ways=getEdges(last);
			} 
			catch (VertexNotExistException e) {
				return null;

			}
if(ways!=null){
			for(E i:ways){
				
				newVec.clear();

				if(!first.contains(i)){

					newVec.addAll(first);
					newVec.add(i);
					if(newVec.contains(target)){

						return newVec; 
					}

					vBfs.add(makeCopy(newVec));
				}
			}
		}}
		return null;

	}






	//this method checks if a junction is exist;
	private boolean isExist(E ver){
		Vector<E> manager=new Vector<E>();
		manager=this.getVerteices();
		if(manager==null){
			return false;
		}
		for(E i:manager){
			if (i.equals(ver))
				return true;
		}

		return false;

	}



	//this method gets a vector and returns copy of that vector by new vector
	private Vector<E> makeCopy(Vector<E> original){
		Vector<E> copy=new Vector<E>();
		for (E i:original){
			copy.add(i);
		}
		return copy;

	}
}
