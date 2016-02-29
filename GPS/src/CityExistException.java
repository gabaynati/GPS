//Name:Netanel Gabay
//I.D:303095228
//class that represents exception class which it's exception objects can be thrown by methods.
//this class refers to situations that city is already exists
public class CityExistException extends Exception {
	public CityExistException(String msg){
		super(msg);
	}

}
