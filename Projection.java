
public class Projection extends Matrix {
	
	public Projection()
	{
		super();
	}
	
	public Projection( int screen_width, int screen_height, double fov_in_degree, float near, float far )
	{
		double ar = screen_width * 1.0 / screen_height;
		double angle = fov_in_degree * 3.141592365 / 180 / 2;
		matrix[0][0] = 1 / ( ar * Math.tan( angle ) );
		
		matrix[1][1] = 1 / ( Math.tan( angle ) );
		
		matrix[2][2] = -( near + far ) / ( near - far );
		matrix[2][3] = 2 * far * near / ( near - far );
				            
		matrix[3][2] = 1;
	}

}
