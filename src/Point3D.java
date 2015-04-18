/**
 * Created by alex on 4/17/2015.
 */
public class Point3D implements Cloneable{
	public float x, y, z;

	public Point3D(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	protected Point3D clone() throws CloneNotSupportedException {
		return new Point3D(x, y, z);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point3D) {
			Point3D other = (Point3D) obj;
			return x == other.x && y == other.y && z == other.z;
		}
		return false;
	}
}
