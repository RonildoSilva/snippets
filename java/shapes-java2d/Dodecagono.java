package dinovacao;

import java.awt.Polygon;

public class Dodecagono {

	private int n = 12;
	private int array_X[];
	private int array_Y[];
	private	Polygon polygon;
	
	public Dodecagono() {
		array_X = new int [] {123, 267, 374, 412, 374, 269, 125, -19, -125, -164, -126, -21};
		array_Y =  new int [] {369, 331, 226, 82, -62, -168, -207, -169,-64, 80, 224, 330};
		
		for (int i = 0; i < n; i++) {
			array_X[i] = array_X[i]+300;
			array_Y[i] = array_Y[i]+300;
		}
		polygon = new Polygon(array_X, array_Y, n);
	}

	public Polygon getPolygon() {
		return polygon;
	}

	public void setPolygon(Polygon polygon) {
		this.polygon = polygon;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int[] getArray_X() {
		return array_X;
	}

	public void setArray_X(int[] array_X) {
		this.array_X = array_X;
	}

	public int[] getArray_Y() {
		return array_Y;
	}

	public void setArray_Y(int[] array_Y) {
		this.array_Y = array_Y;
	}
	
	
	
}
