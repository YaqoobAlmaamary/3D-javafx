
public class Matrix {

	public double matrix[][] = new double[4][4];

	public void multiply( Vector vertex )
	{	
		double result[] = new double[4];
		for( int row = 0; row < 4; row++ )
		{
			result[row] = matrix[row][0] * vertex.x + matrix[row][1] * vertex.y + matrix[row][2] * vertex.z + matrix[row][3] * vertex.w;
		}
		
		vertex.x = result[0];
		vertex.y = result[1];
		vertex.z = result[2];
		vertex.w = result[3];
	}
	
	public Matrix multiply( Matrix matrix )
	{
		Matrix result = new Matrix();
		
		for( int row = 0; row < 4; row++ )
		{
			for( int column_1 = 0; column_1 < 4; column_1++ )
			{
				for( int column = 0, row_1 = 0; column < 4; column++, row_1++ )
				{
					result.matrix[row][column_1] += this.matrix[row][column] * matrix.matrix[row_1][column_1];
				}
				
			}
		}
		
		
		return result;
	}
	
	public void print()
	{
		for( int row = 0; row < 4; row++ )
		{
			System.out.print( "row " + ( row + 1 ) + ": ");
			for( int column = 0; column < 4; column ++ )
			{
				System.out.printf( "%.2f\t", matrix[row][column] );
			}
			System.out.println();
			
		}
	}
	
}
