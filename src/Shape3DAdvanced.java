import processing.core.PGraphics;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by alex on 4/15/2015.
 */
public class Shape3DAdvanced {
	public float x, y, z, width, length, height;
	public ShapeType type;
	public ShapeFill fill;
	public Color color;
	public ArrayList<Shape3DAdvanced> contents;
	public ArrayList<TriangularPlane3D> geometry;

	public Shape3DAdvanced(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		fill = ShapeFill.PLAIN;
		contents = new ArrayList<Shape3DAdvanced>();
		geometry = new ArrayList<TriangularPlane3D>();
	}

	public void setType(ShapeType type) {
		this.type = type;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void generateGeometry() {
		ArrayList<TriangularPlane3D> planes = new ArrayList<TriangularPlane3D>();
		switch (type) {
			case BOX: {
				planes.add(new TriangularPlane3D() {{// 021
					this.bounds.add(new Point3D(length * 0.5f, height * 0.5f, width * 0.5f));
					this.bounds.add(new Point3D(length * 0.5f, -(height * 0.5f), width * 0.5f));
					this.bounds.add(new Point3D(length * 0.5f, height * 0.5f, -(width * 0.5f)));
					this.normal = new Point3D(1, 0, 0);
				}});
				planes.add(new TriangularPlane3D() {{
					this.bounds.add(new Point3D(-(length * 0.5f), height * 0.5f, width * 0.5f));
					this.bounds.add(new Point3D(-(length * 0.5f), -(height * 0.5f), width * 0.5f));
					this.bounds.add(new Point3D(-(length * 0.5f), height * 0.5f, -(width * 0.5f)));
					this.normal = new Point3D(-1, 0, 0);
				}});
				planes.add(new TriangularPlane3D() {{// 041
					this.bounds.add(new Point3D(length * 0.5f, height * 0.5f, width * 0.5f));
					this.bounds.add(new Point3D(-(length * 0.5f), height * 0.5f, width * 0.5f));
					this.bounds.add(new Point3D(length * 0.5f, height * 0.5f, -(width * 0.5f)));
					this.normal = new Point3D(0, 1, 0);
				}});
				planes.add(new TriangularPlane3D() {{
					this.bounds.add(new Point3D(length * 0.5f, -(height * 0.5f), width * 0.5f));
					this.bounds.add(new Point3D(-(length * 0.5f), -(height * 0.5f), width * 0.5f));
					this.bounds.add(new Point3D(length * 0.5f, -(height * 0.5f), -(width * 0.5f)));
					this.normal = new Point3D(0, -1, 0);
				}});
				planes.add(new TriangularPlane3D() {{// 042
					this.bounds.add(new Point3D(length * 0.5f, height * 0.5f, width * 0.5f));
					this.bounds.add(new Point3D(-(length * 0.5f), height * 0.5f, width * 0.5f));
					this.bounds.add(new Point3D(length * 0.5f, -(height * 0.5f), width * 0.5f));
					this.normal = new Point3D(0, 0, 1);
				}});
				planes.add(new TriangularPlane3D() {{
					this.bounds.add(new Point3D(length * 0.5f, height * 0.5f, -(width * 0.5f)));
					this.bounds.add(new Point3D(-(length * 0.5f), height * 0.5f, -(width * 0.5f)));
					this.bounds.add(new Point3D(length * 0.5f, -(height * 0.5f), -(width * 0.5f)));
					this.normal = new Point3D(0, 0, -1);
				}});
				planes.add(new TriangularPlane3D() {{// 756
					this.bounds.add(new Point3D(-(length * 0.5f), -(height * 0.5f), -(width * 0.5f)));
					this.bounds.add(new Point3D(-(length * 0.5f), height * 0.5f, -(width * 0.5f)));
					this.bounds.add(new Point3D(-(length * 0.5f), -(height * 0.5f), width * 0.5f));
					this.normal = new Point3D(-1, 0, 0);
				}});
				planes.add(new TriangularPlane3D() {{
					this.bounds.add(new Point3D(length * 0.5f, -(height * 0.5f), -(width * 0.5f)));
					this.bounds.add(new Point3D(length * 0.5f, height * 0.5f, -(width * 0.5f)));
					this.bounds.add(new Point3D(length * 0.5f, -(height * 0.5f), width * 0.5f));
					this.normal = new Point3D(1, 0, 0);
				}});
				planes.add(new TriangularPlane3D() {{// 736
					this.bounds.add(new Point3D(-(length * 0.5f), -(height * 0.5f), -(width * 0.5f)));
					this.bounds.add(new Point3D(length * 0.5f, -(height * 0.5f), -(width * 0.5f)));
					this.bounds.add(new Point3D(-(length * 0.5f), -(height * 0.5f), width * 0.5f));
					this.normal = new Point3D(0, -1, 0);
				}});
				planes.add(new TriangularPlane3D() {{
					this.bounds.add(new Point3D(-(length * 0.5f), height * 0.5f, -(width * 0.5f)));
					this.bounds.add(new Point3D(length * 0.5f, height * 0.5f, -(width * 0.5f)));
					this.bounds.add(new Point3D(-(length * 0.5f), height * 0.5f, width * 0.5f));
					this.normal = new Point3D(0, 1, 0);
				}});
				planes.add(new TriangularPlane3D() {{// 745
					this.bounds.add(new Point3D(-(length * 0.5f), -(height * 0.5f), -(width * 0.5f)));
					this.bounds.add(new Point3D(length * 0.5f, -(height * 0.5f), -(width * 0.5f)));
					this.bounds.add(new Point3D(-(length * 0.5f), height * 0.5f, -(width * 0.5f)));
					this.normal = new Point3D(0, 0, -1);
				}});
				planes.add(new TriangularPlane3D() {{
					this.bounds.add(new Point3D(-(length * 0.5f), -(height * 0.5f), width * 0.5f));
					this.bounds.add(new Point3D(length * 0.5f, -(height * 0.5f), width * 0.5f));
					this.bounds.add(new Point3D(-(length * 0.5f), height * 0.5f, width * 0.5f));
					this.normal = new Point3D(0, 0, 1);
				}});
				geometry = planes;
				break;}
			case SPHERE: {
				for (float a = 0f ; a < 6.28318530718f ; a += 1.57079632679f) {
					final float ang = a;
					final float ang2 = a + 1.57079632679f;
					planes.add(new TriangularPlane3D() {{
						this.bounds.add(new Point3D(0, height * 0.5f, 0));
						this.bounds.add(new Point3D((float) Math.cos(ang) * (width * 0.5f), 0, (float) Math.sin(ang) * (length * 0.5f)));
						this.bounds.add(new Point3D((float) Math.cos(ang2) * (width * 0.5f), 0, (float) Math.sin(ang2) * (length * 0.5f)));
					}});
					planes.add(new TriangularPlane3D() {{
						this.bounds.add(new Point3D(0, -(height * 0.5f), 0));
						this.bounds.add(new Point3D((float) Math.cos(ang) * (width * 0.5f), 0, (float) Math.sin(ang) * (length * 0.5f)));
						this.bounds.add(new Point3D((float) Math.cos(ang2) * (width * 0.5f), 0, (float) Math.sin(ang2) * (length * 0.5f)));
					}});
				}
				for (int i = 0 ; i < 4 ; i ++) {
					ArrayList<TriangularPlane3D> temp = new ArrayList<TriangularPlane3D>();
					while (planes.size() > 0) {
						TriangularPlane3D plane1 = planes.remove(planes.size() - 1);
						TriangularPlane3D centerPlane = new TriangularPlane3D();
						int j = 2;
						for (Point3D point1 : plane1.bounds) {
							TriangularPlane3D newPlane = new TriangularPlane3D();
							for (Point3D point2 : plane1.bounds) {
								float x = (point1.x + point2.x) * 0.5f;
								float y = (point1.y + point2.y) * 0.5f;
								float z = (point1.z + point2.z) * 0.5f;
								float dist = (float) Math.abs(Math.sqrt((x * x) + (y * y) + (z * z)));
								if (dist != 0) {
									x = (x / dist) * width;
									y = (y / dist) * width;
									z = (z / dist) * width;
								}
								newPlane.bounds.add(new Point3D(x, y, z));
							}
							temp.add(newPlane);
							centerPlane.bounds.add(newPlane.bounds.get((j ++) % 3));
						}
						temp.add(centerPlane);
					}
					planes = temp;
				}
				for (TriangularPlane3D plane : planes) {
					for (Point3D point : plane.bounds) {
						plane.normal.x += point.x;
						plane.normal.y += point.y;
						plane.normal.z += point.z;
					}
					plane.normal.x /= plane.bounds.size();
					plane.normal.y /= plane.bounds.size();
					plane.normal.z /= plane.bounds.size();
					float dist = (float) Math.abs(Math.sqrt((plane.normal.x * plane.normal.x) + (plane.normal.y * plane.normal.y) + (plane.normal.z * plane.normal.z)));
					plane.normal.x /= dist;
					plane.normal.y /= dist;
					plane.normal.z /= dist;
				}
				geometry = planes;
				break;}
			case CYLINDER: {
				for (float a = 0.0f ; a < 6.28318530718f ; a += 0.2f) { // 2 * PI
					final float x1 = (float) (Math.cos(a) * (width * 0.5f));
					final float z1 = (float) (Math.sin(a) * (length * 0.5f));
					final float x2 = (float) (Math.cos(a + 0.2f) * (width * 0.5f));
					final float z2 = (float) (Math.sin(a + 0.2f) * (length * 0.5f));
					float xn = (x1 + x2) * 0.5f;
					float yn = height * 0.5f;
					float zn = (z1 + z2) * 0.5f;
					float dist = (float) Math.abs(Math.sqrt((xn * xn) + (yn * yn) + (zn * zn)));
					xn = xn / dist;
					yn = yn / dist;
					zn = zn / dist;
					final Point3D outerNormal = new Point3D(xn, yn, zn);
					planes.add(new TriangularPlane3D() {{
						this.bounds.add(new Point3D(x1, 0, z1));
						this.bounds.add(new Point3D(x1, height, z1));
						this.bounds.add(new Point3D(x2, height, z2));
						try {
							this.normal = outerNormal.clone();
						} catch (CloneNotSupportedException e) {
							e.printStackTrace();
						}
					}});
					planes.add(new TriangularPlane3D() {{
						this.bounds.add(new Point3D(x1, 0, z1));
						this.bounds.add(new Point3D(x2, 0, z2));
						this.bounds.add(new Point3D(x2, height, z2));
						try {
							this.normal = outerNormal.clone();
						} catch (CloneNotSupportedException e) {
							e.printStackTrace();
						}
					}});
				}
				geometry = planes;
				break;}
			case VORONIS: {
				//
				break;}
		}
		switch (fill) {
			case PLAIN: {
				//
				break;}
			case HOLLOW: {
				ArrayList<TriangularPlane3D> innerSurface = new ArrayList<TriangularPlane3D>();
				for (TriangularPlane3D plane : planes) {
					TriangularPlane3D newPlane = new TriangularPlane3D();
					newPlane.normal.x = -plane.normal.x;
					newPlane.normal.y = -plane.normal.y;
					newPlane.normal.z = -plane.normal.z;
					for (Point3D point : plane.bounds) {
						newPlane.bounds.add(new Point3D(point.x + newPlane.normal.x, point.y + newPlane.normal.y, point.z + newPlane.normal.z));
					}
					innerSurface.add(newPlane);
				}
				planes.addAll(innerSurface);
				geometry = planes;
				break;}
			case VORONIS: {
				//
				break;}
		}
	}

	public void draw(PGraphics g) {
		g.pushMatrix();
		g.translate(x, y, z);
		for (TriangularPlane3D plane : geometry) {
			g.beginShape(g.TRIANGLE);
			g.fill(color.getRGB());
			g.stroke(0);
			for (Point3D point : plane.bounds) {
				g.vertex(point.x, point.y, point.z);
			}
			g.endShape(g.TRIANGLE);
			for (Point3D point : plane.bounds) {
				g.pushMatrix();
				g.stroke(255, 0, 0);
				g.line(point.x, point.y, point.z, point.x + plane.normal.x, point.y + plane.normal.y, point.z + plane.normal.z);
				g.popMatrix();
			}
		}
		g.popMatrix();
	}

	public void setFill(ShapeFill fill) {
		this.fill = fill;
	}
}
