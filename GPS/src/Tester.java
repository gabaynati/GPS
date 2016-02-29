import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;


public class Tester  {

	public static void main(String[] args) throws CityExistException, CityNotFoundException, NoPathException {
	CitiesMapPanel p=new CitiesMapPanel();
	JFrame j=new JFrame();
	j.add(p);
	j.setSize(700, 700);
	j.setVisible(true);
	j.show();
	}}

//	Vector<Vector<City>> vertices = new Vector<Vector<City>>();
//	Vector<City> manager = new Vector<City>(); 
//	City c1=new City("tel1",12, 12);
//	City c2=new City("tel1",12, 12);
//	manager.add(c1);
//	manager.add(c2);
//	vertices.add(manager);
//	for(Vector<City> i:vertices){
//		for(City j:i){
//		return i;
//		System.out.println(i);
//	}}
//	}
//		
//	CitiesMap cit=new CitiesMap();
//	Vector<City> v=new Vector<City>();
//	Vector<City> x=new Vector<City>();
//	Vector<City> y=new Vector<City>();
//	City a=new City("a",2, 2);
//	City b=new City("b",5, 4);
//	City c=new City("c",5, 4);
//	City d=new City("d",5, 4);
//	City e=new City("e",5, 4);
//	   cit.addCity(a);
//	   cit.addCity(b);
//		cit.addCity(c);
//		cit.addCity(d);
//		cit.addCity(e);
//		cit.addWay(a, b);
//		cit.addWay(a, d);
//		cit.addWay(b, a);
//		cit.addWay(b, c);
//		cit.addWay(b, e);
//		
//		cit.addWay(c, b);
//		cit.addWay(c, d);
//		cit.addWay(d, a);
//		cit.addWay(d, c);
//		cit.addWay(e, b);
//		v=cit.getWays(a);
//		x=cit.getCities();
//	
//		y=cit.findPath(a, e);
//	
//		Iterator<City> it=v.iterator();
//		Iterator<City> itr=x.iterator();
//		Iterator<City> itrr=y.iterator();
//	while(itrr.hasNext()){
//		System.out.println(itrr.next().getName());
//		
//			}
//	
//	
//	}
//	}


