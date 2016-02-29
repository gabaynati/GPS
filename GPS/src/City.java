
//Name:Netanel Gabay
//I.D:303095228
public class City {
private String name;
private int centerX;
private int centerY;
//this class represents a city that is actually a vector in the graph



public City(String name,int x,int y ){
	this.name=name;
	centerX	=x;
	centerY=y;
}




//this method checks if 2 cities has the same name
public boolean equals(Object other){
	
	return (this.name.equals(((City)other).getName()));
	
}






//this methods are to set and get the value if the class members
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getCenterX() {
	return centerX;
}

public void setCenterX(int centerX) {
	this.centerX = centerX;
}

public int getCenterY() {
	return centerY;
}

public void setCenterY(int centerY) {
	this.centerY = centerY;
}



	
	




}
