import processing.core.PApplet;
import processing.core.PMatrix3D;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by alex on 4/8/2015.
 */
public class GameWindow extends PApplet {
	Camera camera = new Camera();

	ArrayList<Shape3DAdvanced> shapes = new ArrayList<Shape3DAdvanced>();

	@Override
	public void setup() {
		size(600, 600, P3D);
		camera.x = 5;
		camera.y = 5;
		camera.z = 5;
		Shape3DAdvanced shape = new Shape3DAdvanced(0f, 0f, 0f);
		shape.width = 5;
		shape.length = 5;
		shape.height = 5;
		shape.setType(ShapeType.CYLINDER);
		shape.setFill(ShapeFill.HOLLOW);
		shape.setColor(new Color(0, 255, 0, 40));
		shape.generateGeometry();
		shapes.add(shape);
	}

	@Override
	public void draw() {
		update();
//  Camera
		g.camera(0, 0, 0,
				0, 0, 1,
				0,-1, 0);
		float cameraZ = ((height/2.0f) / tan(PI*60.0f/360.0f));
		g.perspective(PI / 3.0f, width / height, 0.1f, 10000);
		g.rotateX(camera.ry);
		g.rotateY(camera.rx);
		g.rotateZ(camera.rz);
		g.translate(-camera.x, -camera.y, -camera.z);
//  Background
		g.fill(100, 100, 100);
		g.stroke(0);
		g.box(10000);
//  Guide
		g.pushMatrix();
		g.translate((int) camera.x, 0, (int) camera.z);
		g.stroke(0);
		g.strokeWeight(0.6f);
		for (int z = -100 ; z < 100 ; z ++) {
			g.line(-100, 0, z, 100, 0, z);
			g.line(z, 0, -100, z, 0, 100);
		}
		g.popMatrix();
		g.strokeWeight(1f);
//  Models
		for (Shape3DAdvanced shape : shapes) {
			shape.draw(g);
		}
	}

	int mx1 = 0, my1 = 0;
	boolean mouseDown = false;

	private void update() {
		if (mousePressed) {
			if (mouseButton == LEFT) {
				//
			} else if (mouseButton == RIGHT) {
				//
			} else {
				//
			}
			if (!mouseDown) {
				mouseDown = true;
				mx1 = mouseX;
				my1 = mouseY;
			} else {
				int mx2 = mouseX, my2 = mouseY;
				camera.rx += (mx2 - mx1) * 0.002f;
				camera.ry += (my2 - my1) * 0.002f;
				mx1 = mouseX;
				my1 = mouseY;
			}
		} else if (mouseDown) {
			mouseDown = false;
		}
		if (keyPressed) {
			if (key == CODED) {
				//
			} else {
				if (key == 'w') {
					PMatrix3D vec = new PMatrix3D();
					vec.translate(0, 0, -1.0f);
					vec.rotateX(camera.ry);
					vec.rotateY(camera.rx);
					vec.rotateZ(camera.rz);
					vec.invert();
					camera.x += vec.m03;
					camera.y += vec.m13;
					camera.z += vec.m23;
				} else if (key == 's') {
					PMatrix3D vec = new PMatrix3D();
					vec.translate(0, 0, 1.0f);
					vec.rotateX(camera.ry);
					vec.rotateY(camera.rx);
					vec.rotateZ(camera.rz);
					vec.invert();
					camera.x += vec.m03;
					camera.y += vec.m13;
					camera.z += vec.m23;
				} else if (key == 'd') {
					PMatrix3D vec = new PMatrix3D();
					vec.translate(-1.0f, 0, 0);
					vec.rotateX(camera.ry);
					vec.rotateY(camera.rx);
					vec.rotateZ(camera.rz);
					vec.invert();
					camera.x += vec.m03;
					camera.y += vec.m13;
					camera.z += vec.m23;
				} else if (key == 'a') {
					PMatrix3D vec = new PMatrix3D();
					vec.translate(1.0f, 0, 0);
					vec.rotateX(camera.ry);
					vec.rotateY(camera.rx);
					vec.rotateZ(camera.rz);
					vec.invert();
					camera.x += vec.m03;
					camera.y += vec.m13;
					camera.z += vec.m23;
				}
			}
		}
	}

	public static void main(String[] args) {
		PApplet.main("GameWindow");
	}
}
