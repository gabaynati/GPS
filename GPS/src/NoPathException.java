//Name:Netanel Gabay
//I.D:303095228
//class that represents exception class which it's exception objects can be thrown by methods.
//this class refers to situations that path between two cities not exists
public class NoPathException extends Exception {
	public NoPathException(String msg){
		super(msg);
	}
}
