
public class Viewport extends Matrix{
	
	public Viewport( double width, double height )
	{
		matrix[0][0] = width /2;
		matrix[1][1] = height/2;
	}

	public void multiply( Vector vertex )
	{
		vertex.x += 1;
		vertex.y *= -1;
		vertex.y += 1;
		super.multiply( vertex );
	}
}
