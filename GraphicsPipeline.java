
public class GraphicsPipeline {
	
	public void rasterize( Camera camera, Matrix projection, Matrix viewport, Cube cube, int index )
	{
		camera.lookAt.multiply( cube.triangles[index].vertex_1 );
		camera.lookAt.multiply( cube.triangles[index].vertex_2 );
		camera.lookAt.multiply( cube.triangles[index].vertex_3 );
	
		projection.multiply( cube.triangles[index].vertex_1 );
		projection.multiply( cube.triangles[index].vertex_2 );
		projection.multiply( cube.triangles[index].vertex_3 );
		
		
		cube.triangles[index].vertex_1.x = cube.triangles[index].vertex_1.x / cube.triangles[index].vertex_1.w;
		cube.triangles[index].vertex_1.y = cube.triangles[index].vertex_1.y / cube.triangles[index].vertex_1.w;
		cube.triangles[index].vertex_1.z = cube.triangles[index].vertex_1.z / cube.triangles[index].vertex_1.w;
		
		cube.triangles[index].vertex_2.x = cube.triangles[index].vertex_2.x / cube.triangles[index].vertex_2.w;
		cube.triangles[index].vertex_2.y = cube.triangles[index].vertex_2.y / cube.triangles[index].vertex_2.w;
		cube.triangles[index].vertex_2.z = cube.triangles[index].vertex_2.z / cube.triangles[index].vertex_2.w;
		
		cube.triangles[index].vertex_3.x = cube.triangles[index].vertex_3.x / cube.triangles[index].vertex_3.w;
		cube.triangles[index].vertex_3.y = cube.triangles[index].vertex_3.y / cube.triangles[index].vertex_3.w;
		cube.triangles[index].vertex_3.z = cube.triangles[index].vertex_3.z / cube.triangles[index].vertex_3.w;
		
		
		viewport.multiply( cube.triangles[index].vertex_1 );
		viewport.multiply( cube.triangles[index].vertex_2 );
		viewport.multiply( cube.triangles[index].vertex_3 );
	}
	
	

}
