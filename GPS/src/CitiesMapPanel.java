//Name:Netanel Gabay
//I.D:303095228
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class CitiesMapPanel<E> extends JPanel implements ActionListener,MouseListener{
	private CitiesMap gps;
	private Vector<City> path;
	private JButton clearMap;
	private JButton clearPath;
	private JButton findPath;
	private JButton addWay;
	private JTextField from;
	private JTextField to;
	private JLabel f;
	private JLabel t;



	public CitiesMapPanel(){

		/////
		JPanel Buttoms=new JPanel();
		path=new Vector<City>();
		gps=new CitiesMap();
		//////
		addMouseListener(this);
		//////
		addWay=new JButton("add way");
		clearMap=new JButton("clear map");
		findPath=new JButton("find path");
		clearPath=new JButton("clear Path");
		///////
		JLabel f= new JLabel("from:         ");
		JLabel t= new JLabel("to:            ");
		from=new JTextField();
		to=new JTextField();
		////

		Buttoms.setLayout(new GridLayout(2,4));
		///////
		Buttoms.add(f);
		Buttoms.add(from);
		Buttoms.add(t);
		Buttoms.add(to);
		/////

		Buttoms.add(addWay);
		Buttoms.add(findPath);
		Buttoms.add(clearMap);
		Buttoms.add(clearPath);
		////
		from.addActionListener(this);
		to.addActionListener(this);
		addWay.addActionListener(this);
		clearMap.addActionListener(this);
		findPath.addActionListener(this);
		clearPath.addActionListener(this);
		/////
		setLayout(new BorderLayout());


		this.add(Buttoms,BorderLayout.SOUTH);
	}




	//method for dealing with mouse clicks
	public void mouseClicked(MouseEvent e) {

		String msg=JOptionPane.showInputDialog("please inter city:");

		if(msg==null|| msg.equals("")){
			return;
		}
		City c=new  City(msg, e.getX(), e.getY());
		try {
			gps.addCity(c);
		} 
		catch (CityExistException e1) {
			JOptionPane.showMessageDialog(null,"the city already exists" );
		}

		repaint();
	}



	//method for dealing with buttons clicks
	public void actionPerformed(ActionEvent e5) throws NullPointerException  {

		Vector<City> cities=new Vector<City>();
		cities=gps.getCities();

		if(e5.getSource()==clearMap){

			gps=new CitiesMap();
			path.clear();
		}


		/////////add way
		if(e5.getSource()==addWay){



			if(cities==null||cities.size()<2){
				JOptionPane.showMessageDialog(null,"please draw two cities:" );
				return;
			}
			if(to.getText().isEmpty()^from.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"please inter one more city" );
				return;
			}
			if(to.getText().contentEquals(from.getText())){
				JOptionPane.showMessageDialog(null,"please inter two diffrecnt cities" );
				return;
			}
			if(to.getText().isEmpty()&&from.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"please inter two cities" );
				return;
			}

			try {
				if (getIndex(from.getText()) == -1 || getIndex(to.getText()) == -1)
					throw new CityNotFoundException("addition failled-city not found");
				gps.addWay(gps.getCities().elementAt(getIndex(from.getText())),gps.getCities().elementAt(getIndex(to.getText())));

			}
			catch (CityNotFoundException e) {

				JOptionPane.showMessageDialog(null,"addition failled-city not found" );
			}
		}





		////////findpath
		if(e5.getSource()==findPath){
			if(cities==null||cities.size()<2){
				JOptionPane.showMessageDialog(null,"please draw two cities:" );
				return;
			}
			if(to.getText().isEmpty()^from.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"please inter one more city" );
				return;
			}
			if(to.getText().isEmpty()&&from.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"please inter two cities" );
				return;
			}
			if(to.getText().contentEquals(from.getText())){
				JOptionPane.showMessageDialog(null,"please inter two diffrent cities" );
				return;
			}

			try{

				if (getIndex(from.getText()) == -1 || getIndex(to.getText()) == -1){
					throw new CityNotFoundException("Can not find path-city not found");
				}

				gps.findPath(gps.getCities().elementAt(getIndex(from.getText())),gps.getCities().elementAt(getIndex(to.getText())));
				path=gps.findPath(gps.getCities().elementAt(getIndex(from.getText())),gps.getCities().elementAt(getIndex(to.getText())));
			
			}
			catch (CityNotFoundException e) {

				JOptionPane.showMessageDialog(null,"Can not find path-city not found");
			}
			catch ( NoPathException e1) {

				JOptionPane.showMessageDialog(null,"there is no path between this cities" );
			}

		}




		//////////clear path
		if(e5.getSource()==clearPath){
			path.clear();
		}

		repaint();
	}



	//method for painting on the panel
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		this.setBackground(Color.white);
		Vector<City> cities=new Vector<City>();

		////draw line
		g.setColor(Color.BLACK);
		if(gps.getCities()!=null){
			for(City i:gps.getCities()){

				if(gps.getWays(i)!=null){

					for(City j:gps.getWays(i)){

						g.drawLine(i.getCenterX(), i.getCenterY(), j.getCenterX(), j.getCenterY());

					}}}
		}



		///////draw path

		if(!path.isEmpty()){
			for(int i=0;i<path.size()-1;i++){
				g.setColor(Color.RED);
				g.drawLine(path.elementAt(i).getCenterX(), path.elementAt(i).getCenterY(),path.elementAt(i+1).getCenterX(), path.elementAt(i+1).getCenterY());  
			}}




		///clear map
		cities=gps.getCities();
		if(cities==null){
			gps=new CitiesMap();
		}





		////draw city
		g.setColor(Color.black);
		if(cities!=null){
			for(City c: cities){


				g.fillOval(c.getCenterX(),c.getCenterY(), 3,3);
				g.drawString(c.getName(),c.getCenterX()+3 , c.getCenterY()+3);
			}}

	}





	//this method gets the City object's index by it's name
	private int getIndex(String str){
		for (int i=0;i<gps.getCities().size();i++){
			if (gps.getCities().elementAt(i).getName().equals(str)){
				return i;
			}}
		return -1;

	}



	/////
	public void mouseEntered(MouseEvent arg0) {	
	}
	public void mouseExited(MouseEvent arg0) {	
	}
	public void mousePressed(MouseEvent arg0) {	
	}
	public void mouseReleased(MouseEvent arg0) {	
	}
	/////






}
