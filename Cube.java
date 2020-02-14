import javafx.scene.shape.Line;

public class Cube {
	
	public Triangle triangles[];
	public Line lines[];
	public void initLines()
	{
		lines = new Line[ 3 * triangles.length ];
	}
	// creates triangles by drawing lines for each triangle
	public void startLines()
	{
		int lc = 0;
		for( int i = 0; i < triangles.length; i++, lc += 3 )
		{
			// creates a triangle
			lines[lc] = new Line( 
					triangles[i].vertex_1.x, triangles[i].vertex_1.y,
					triangles[i].vertex_2.x, triangles[i].vertex_2.y 
					);
			lines[lc + 1] = new Line( 
					triangles[i].vertex_2.x, triangles[i].vertex_2.y,
					triangles[i].vertex_3.x, triangles[i].vertex_3.y 
					);
			lines[lc + 2] = new Line( 
					triangles[i].vertex_3.x, triangles[i].vertex_3.y,
					triangles[i].vertex_1.x, triangles[i].vertex_1.y 
					);
		}
	}
	
	public void updateConnections()
	{
		int lc = 0;
		for( int i = 0; i < triangles.length; i++, lc += 3 )
		{
			// updates lines between triangle
			lines[lc].setStartX( triangles[i].vertex_1.x );
			lines[lc].setStartY( triangles[i].vertex_1.y );
			lines[lc].setEndX( triangles[i].vertex_2.x );
			lines[lc].setEndY( triangles[i].vertex_2.y );

       		lines[lc + 1].setStartX( triangles[i].vertex_2.x );
			lines[lc + 1].setStartY( triangles[i].vertex_2.y );
			lines[lc + 1].setEndX( triangles[i].vertex_3.x );
			lines[lc + 1].setEndY( triangles[i].vertex_3.y );
			
      		lines[lc + 2].setStartX( triangles[i].vertex_3.x );
			lines[lc + 2].setStartY( triangles[i].vertex_3.y );
			lines[lc + 2].setEndX( triangles[i].vertex_1.x );
			lines[lc + 2].setEndY( triangles[i].vertex_1.y );
					
		}
	}
	
	// the triangles array represent triangles for the cube
	// each triangle consists of 3 vertices and each vertex has
	// 3 coordinates (x, y, z)
	
	public void restartCube()
	{
		// 1
		triangles[0] = new Triangle(
				new Vector( 0, 0, 0 ),
				new Vector( 1, 0, 0 ),
				new Vector( 1, 1, 0 )
			);
		
		// 2
		triangles[1] = new Triangle(
				new Vector( 1, 1, 0 ),
				new Vector( 0, 1, 0 ),
				new Vector( 0, 0, 0 )
			);
		
		// 3
		triangles[2] = new Triangle(
				new Vector( 0, 1, 0 ),
				new Vector( 0, 0, 0 ),
				new Vector( 0, 0, 1 )				
			);
		
		// 4
		triangles[3] = new Triangle(
				new Vector( 0, 0, 1 ),
				new Vector( 0, 1, 1 ),
				new Vector( 0, 1, 0 )
			);
		
		// 5
		triangles[4] = new Triangle(
				new Vector( 1, 0, 1 ),
				new Vector( 0, 0, 1 ),
				new Vector( 0, 1, 1 )
			);
		
		// 6
		triangles[5] = new Triangle(
				new Vector( 0, 1, 1 ),
				new Vector( 1, 1, 1 ),
				new Vector( 1, 0, 1 )
			);
		
		// 7
		triangles[6] = new Triangle(
				new Vector( 1, 0, 0 ),
				new Vector( 1, 0, 1 ),
				new Vector( 1, 1, 1 )
			);
		
		// 8
		triangles[7] = new Triangle(
				new Vector( 1, 1, 1 ),
				new Vector( 1, 1, 0 ),
				new Vector( 1, 0, 0 )
			);
		
		// 9
		triangles[8] = new Triangle(
				new Vector( 1, 0, 1 ),
				new Vector( 1, 0, 0 ),
				new Vector( 0, 0, 0 )
			);
		
		// 10
		triangles[9] = new Triangle(
				new Vector( 0, 0, 0 ),
				new Vector( 0, 0, 1 ),
				new Vector( 1, 0, 1 )
			);
		
		// 11
		triangles[10] = new Triangle(
				new Vector( 0, 1, 0 ),
				new Vector( 1, 1, 0 ),
				new Vector( 1, 1, 1 )
			);
		
		// 12
		triangles[11] = new Triangle(
				new Vector( 1, 1, 1 ),
				new Vector( 0, 1, 1 ),
				new Vector( 0, 1, 0 )
			);
				
			
	}
	
	public Cube()
	{
		
		triangles = new Triangle[12];
		lines = new Line[ 3 * triangles.length ];
		
		// 1
		triangles[0] = new Triangle(
				new Vector( 0, 0, 0 ),
				new Vector( 1, 0, 0 ),
				new Vector( 1, 1, 0 )
			);
		
		// 2
		triangles[1] = new Triangle(
				new Vector( 1, 1, 0 ),
				new Vector( 0, 1, 0 ),
				new Vector( 0, 0, 0 )
			);
		
		// 3
		triangles[2] = new Triangle(
				new Vector( 0, 1, 0 ),
				new Vector( 0, 0, 0 ),
				new Vector( 0, 0, 1 )				
			);
		
		// 4
		triangles[3] = new Triangle(
				new Vector( 0, 0, 1 ),
				new Vector( 0, 1, 1 ),
				new Vector( 0, 1, 0 )
			);
		
		// 5
		triangles[4] = new Triangle(
				new Vector( 1, 0, 1 ),
				new Vector( 0, 1, 0 ),
				new Vector( 0, 1, 1 )
			);
		
		// 6
		triangles[5] = new Triangle(
				new Vector( 0, 1, 1 ),
				new Vector( 1, 1, 1 ),
				new Vector( 1, 0, 1 )
			);
		
		// 7
		triangles[6] = new Triangle(
				new Vector( 1, 0, 0 ),
				new Vector( 1, 0, 1 ),
				new Vector( 1, 1, 1 )
			);
		
		// 8
		triangles[7] = new Triangle(
				new Vector( 1, 1, 1 ),
				new Vector( 1, 1, 0 ),
				new Vector( 1, 0, 0 )
			);
		
		// 9
		triangles[8] = new Triangle(
				new Vector( 1, 0, 1 ),
				new Vector( 1, 0, 0 ),
				new Vector( 0, 0, 0 )
			);
		
		// 10
		triangles[9] = new Triangle(
				new Vector( 0, 0, 0 ),
				new Vector( 0, 0, 1 ),
				new Vector( 1, 0, 1 )
			);
		
		// 11
		triangles[10] = new Triangle(
				new Vector( 0, 1, 0 ),
				new Vector( 1, 1, 0 ),
				new Vector( 1, 1, 1 )
			);
		
		// 12
		triangles[11] = new Triangle(
				new Vector( 1, 1, 1 ),
				new Vector( 0, 1, 1 ),
				new Vector( 0, 1, 0 )
			);
		
	}
}
