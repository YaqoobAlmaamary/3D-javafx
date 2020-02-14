
public class Vector {
	public double x;
	public double y;
	public double z;
	public double w;
	
	public Vector( double x, double y, double z )
	{
		this.x = x;
		this.y = y;
		this.z = z;
		w = 1;
	}
	
	public Vector cross( Vector vector )
	{
		return new Vector( 
					y * vector.z - z * vector.y,
					-x * vector.z + z * vector.x,
					x * vector.y - y * vector.x 
				);
	}
	
	public Vector sub( Vector vector )
	{
		return new Vector( x - vector.x, y - vector.y, z - vector.z );
	}
	
	public double mag()
	{
		return Math.sqrt( x*x + y*y + z*z );
	}
	
	public void normalize()
	{
		double length = mag();
		x /= length;
		y /= length;
		z /= length;
		
	}
	
	public void print()
	{
		System.out.println( "(" + x + ", " + y + ", " + z + ")" );
	}
	
}
