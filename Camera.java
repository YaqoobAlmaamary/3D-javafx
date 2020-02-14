
public class Camera {
	
	public Vector position;
	public Vector direction;
	public Vector right;
	public Vector up;
	public Matrix lookAt;
	
	public Camera( Vector position, Vector target, Vector up )
	{
		this.position = position;
		direction = target.sub( position );
		direction.normalize();
		up.normalize();
		right = direction.cross( up );
		right.normalize();
		up = right.cross( direction );
		
		//System.out.println( "right is: " + right.x + " " + right.y + " " + right.z );
		//System.out.println( "direction is: " + direction.x + " " + direction.y + " " + direction.z );
		
		Matrix tmp = new Matrix();
		Matrix tmp_1 = new Matrix();
		tmp.matrix[0][0] = right.x;
		tmp.matrix[0][1] = right.y;
		tmp.matrix[0][2] = right.z;
		tmp.matrix[0][3] = 0;
		
		tmp.matrix[1][0] = up.x;
		tmp.matrix[1][1] = up.y;
		tmp.matrix[1][2] = up.z;
		tmp.matrix[1][3] = 0;
		
		tmp.matrix[2][0] = direction.x;
		tmp.matrix[2][1] = direction.y;
		tmp.matrix[2][2] = direction.z;
		tmp.matrix[2][3] = 0;
		
		tmp.matrix[3][0] = 0;
		tmp.matrix[3][1] = 0;
		tmp.matrix[3][2] = 0;
		tmp.matrix[3][3] = 1;
		
		tmp_1.matrix[0][0] = 1;
		tmp_1.matrix[0][1] = 0;
		tmp_1.matrix[0][2] = 0;
		tmp_1.matrix[0][3] = -this.position.x;
		
		tmp_1.matrix[1][0] = 0;
		tmp_1.matrix[1][1] = 1;
		tmp_1.matrix[1][2] = 0;
		tmp_1.matrix[1][3] = -this.position.y;
		
		tmp_1.matrix[2][0] = 0;
		tmp_1.matrix[2][1] = 0;
		tmp_1.matrix[2][2] = 1;
		tmp_1.matrix[2][3] = -this.position.z;
		
		tmp_1.matrix[3][0] = 0;
		tmp_1.matrix[3][1] = 0;
		tmp_1.matrix[3][2] = 0;
		tmp_1.matrix[3][3] = 1;
		
		this.lookAt = tmp.multiply( tmp_1 );
		
	}
	
	

}
