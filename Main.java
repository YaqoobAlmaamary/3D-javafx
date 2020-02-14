import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	
	public final int screen_width = 1280;
	public final int screen_height = 720;
	public boolean running = true;
	@Override
	public void start( Stage primaryStage )
	{
		Group root = new Group();	
		Scene scene = new Scene( root, Color.BLACK );
		
		Cube cube = new Cube();
		Camera camera = new Camera( new Vector( 2, 0.5, 2 ), new Vector( 0, 0, 0 ), new Vector( 0, 1, 0 ) );
		
		Matrix projection = new Projection( screen_width, screen_height, 90, 0.1f, 100f );
		Matrix viewport = new Viewport( screen_width, screen_height );
		
		GraphicsPipeline pipeline = new GraphicsPipeline();
		
		for( int i = 0; i < cube.triangles.length; i++ )
		{
			pipeline.rasterize( camera, projection, viewport, cube, i );
		}
		cube.startLines();
		
		for( int i = 1; i < cube.lines.length; i++ )
		{
			cube.lines[i].setStroke( Color.WHITE );
			root.getChildren().add( cube.lines[i] );
		}
		
		primaryStage.setScene( scene );
		primaryStage.setTitle( "3D Graphics" );
		primaryStage.setWidth( screen_width );
		primaryStage.setHeight( screen_height );
		primaryStage.show();
		
		// my Game loop 
		// javafx updates the scene periodically 
		Thread thread = new Thread( new Runnable() 
		{
			public Matrix rotation = new Matrix();
			
			public void update( double angle )
			{
				angle = angle * 3.14159265 / 180;
				rotation.matrix[0][0] = Math.cos( angle );
				rotation.matrix[0][2] = Math.sin( angle );
				rotation.matrix[1][1] = 1;
				rotation.matrix[2][0] = -Math.sin( angle );
				rotation.matrix[2][2] = Math.cos( angle );
				rotation.matrix[3][3] = 1;
				updateCube();
				
			}
			
			public void updateCube()
			{
				for( int i = 0; i < cube.triangles.length; i++ )
				{
					rotation.multiply( cube.triangles[i].vertex_1 );
					rotation.multiply( cube.triangles[i].vertex_2 );
					rotation.multiply( cube.triangles[i].vertex_3 );
				}
			}
			
			public void redrawCube()
			{
				for( int i = 0; i < cube.triangles.length; i++ )
				{
			pipeline.rasterize( camera, projection, viewport, cube, i );
			cube.updateConnections();
				}
			}
			public void run()
			{
				long start = System.currentTimeMillis();
				long end = System.currentTimeMillis();
				double rotationSpeed = 1;
				double angleOfRotation = 0;
				while( true )
				{
					if(!running )
					{
						break;
					}
					if( end - start > 1 / 40.0 * 1000 )
					{
						
						cube.restartCube();
						update( angleOfRotation );
						redrawCube();
						
						angleOfRotation += rotationSpeed;
						
						start = System.currentTimeMillis();
					}
					end = System.currentTimeMillis();
				}
			}
			
			
			
			
		});
		thread.start();
		
	}
	
	@Override
	public void stop()
	{
		running = false;
	}
	public static void main( String[] args )
	{
		Application.launch();
	}

}
