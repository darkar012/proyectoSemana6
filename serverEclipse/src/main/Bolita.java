package main;

import java.util.Random;

import processing.core.PApplet;

public class Bolita {
	int xBolita;
	int yBolita;
	int ancho, r, g, b;
	int alto;
	String llave;
	PApplet app;
	
	public Bolita (int xBolita, int yBolita, int ancho, int alto, int r, int g, int b, PApplet app) {
		this.xBolita = xBolita;
		this.yBolita = yBolita;
		this.ancho = ancho;
		this.alto = alto;
		this.r = r;
		this.g = g;
		this.b = b;
		this.app = app;
	}

	public void drawBolita() {
		app.fill(r, g, b);
		app.ellipse(xBolita, yBolita, 50, 50);
	}
	
	public void actions(String llave) {
		switch (llave) {
		case "abajo": 
			yBolita = yBolita + 40;
			break;
		case "arriba" : 
			yBolita -= 40;
			break;

		case "izquierda": 
			xBolita -= 40;
			break;
		case "derecha": 
			xBolita = xBolita + 40;
			break;
		case "color":
			r = (int) app.random(0,255);
			g = (int) app.random(0,255);
			b = (int) app.random(0,255);
			break;
		default:
			break;
		}
	}
	
}
