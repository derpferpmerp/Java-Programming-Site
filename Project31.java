import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.util.List;
import java.util.stream.IntStream;
import java.util.*;

import static javax.swing.JOptionPane.*;
import static javax.swing.JOptionPane.YES_OPTION;

class Ball {

	private double xCoord;
	private double yCoord;
	private final double xVel;
	private final double yVel;
	private final double radius;
	private final Color col;
	private double xAcc;
	private double yAcc;
	private int timesMoved = 0;
	public static double GRAVITY = 9.81;
	public boolean bouncing = false;
	public static double conserveAmount = 0.95;
	private int timesBounced = 0;

	public Ball(double xCoordI, double yCoordI, double xVelI, double yVelI, double radiusI, int f, int g) {
		xCoord = xCoordI;
		yCoord = yCoordI;
		xVel = xVelI;
		yVel = yVelI;
		radius = radiusI;
		col = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
	}

	public void move() {
		xCoord = xCoord + xVel;
		timesMoved++;
		double len = 600.0;
		if (bouncing) {
			//yVel = -Math.abs(yVel);
			double vNew = -1.0 * yVel * conserveAmount;
			//double totalTime = (2.0*vNew*Math.sin(Math.atan(vNew/xVel)))/(2.0*GRAVITY);
			//timesMoved = (int) (yVel + Math.sqrt((yVel * yVel) - (2.0 * GRAVITY * totalTime)));
			//System.out.println(vNew);

			if (yCoord < len - (5.0 * radius)) {
				// y = h - v_0t - 1/2gt^2
				double frameDelay = 10.0;
				double t = (frameDelay / 1000.0) * timesMoved;
				yCoord -= ((yVel * t) - (0.5 * GRAVITY * t * t));
			} else {
				timesMoved = 1;
				bouncing = false;
				//System.out.println("Colliding Stage 2");
			}
		} else {
			if (yCoord < len - (5.0 * radius)) {
				// y = h - v_0t - 1/2gt^2
				double frameDelay = 10.0;
				double t = (frameDelay / 1000.0) * timesMoved;
				yCoord += ((yVel * t) + (0.5 * GRAVITY * t * t));
				//System.out.println(yCoord);
			} else {
				timesBounced++;
				double sin = Math.sin(Math.atan(yVel / xVel));
				double nVel = 100 * yVel * (Math.pow(conserveAmount,timesBounced));
				double maxHeight = (nVel * nVel * sin * sin) / (2.0 * GRAVITY);
				yCoord = (len - maxHeight) * (1+(timesBounced*(1-conserveAmount)));
				timesMoved = 1;
				bouncing = true;
				//System.out.println("Colliding Stage 1");
			}
		}
	}

	public Map<String, Double> currentInfo() {
		Map<String, Double> cInfo = new HashMap<>();
		cInfo.put("xCoord",xCoord);
		cInfo.put("yCoord",yCoord);
		cInfo.put("xVel",xVel);
		cInfo.put("yVel",yVel);
		return cInfo;
	}

	public void draw(Graphics g) {
		g.setColor(col);
		g.fillOval(
				(int) (xCoord - radius),
				(int) (yCoord - radius),
				(int) (radius * 2),
				(int) (radius * 2)
		);
	}

	public void erase(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(
				(int) (xCoord - radius),
				(int) (yCoord -radius),
				(int) (radius *2),
				(int) (radius *2)
		);
	}


}

class BallPanel extends JPanel  {

	Ball b1;

	int wid;
	int len;
	int numBalls;
	Ball[] ballGroup;

	public BallPanel(int w, int l, int nBalls, int RADIUS) throws InterruptedException {
		this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		wid = w;
		len = l;
		numBalls = nBalls;

		ballGroup = new Ball[numBalls];
		Random rand = new Random();
		// + (wid / 4.0);
		double yCoord = 0;
		for (int i = 0; i < numBalls; i++)  {
			double xCoord = rand.nextInt((int) (l - (4*RADIUS)));
			ballGroup[i] = new Ball(
					xCoord,//Math.random() * (wid - 2 * 10),
					yCoord,//Math.random() * (len - 2 * 10),
					0.1 * Math.random(),//Math.random(),
					2 * Math.random(),//yVelocity,
					RADIUS, wid, len
			);
		}


		setBackground(Color.DARK_GRAY);
		setVisible(true);


	}
	public void moveAll() {
		while (true) {
			try { Thread.sleep(10); }
			catch (Exception e) { e.printStackTrace(); }
			repaint();
		}
	}

	public void update(Graphics window) {
		paint(window);
	}


	public void paint(Graphics window) {

		IntStream.range(0, numBalls).forEach(i -> {
			ballGroup[i].erase(window);
			ballGroup[i].move();
			ballGroup[i].draw(window);
		});

	}
}

class BallFrame extends JFrame {

	private static int WIDTH = 0;
	private static int HEIGHT = 0;
	private static int NBALLS = 0;
	private static int RADIUS = 0;

	public BallFrame(int width, int height, int nballs, int radius) throws InterruptedException {
		super("Ball Physics Simulation");
		WIDTH = width;
		HEIGHT = height;
		NBALLS = nballs;
		RADIUS = radius;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH,HEIGHT);
		setBackground(Color.BLACK);
		BallPanel bp = new BallPanel(WIDTH,HEIGHT,NBALLS,RADIUS);
		bp.setBackground(Color.DARK_GRAY);
		getContentPane().add(bp);


		setVisible(true);
		bp.moveAll();

	}


}

public class Project31 {

	public static JSlider newSlider(Integer min, Integer max, Integer sValue, Integer minorTicks) {
		double sValueDouble = Double.parseDouble(String.valueOf(sValue));
		JSlider numBaseStartString = new JSlider(min,max,sValue);
		Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
		for (int i = 0; i <= max; i++) {
			int g = i * minorTicks;
			labelTable.put(g, new JLabel(String.valueOf(Integer.parseInt(String.valueOf(g)))));
		}


		numBaseStartString.setLabelTable( labelTable );
		numBaseStartString.setSnapToTicks(true);
		numBaseStartString.setPaintTicks(true);
		numBaseStartString.setPaintLabels(true);
		//numBaseStartString.setMinorTickSpacing(1);
		return numBaseStartString;
	}

	public static Map<String,String> mainScreen(int WIDTH, int HEIGHT) throws InterruptedException {
		JSlider amountOfBalls = newSlider(1,100,20, 10);
		JSlider gravitySlider = newSlider(1,100,98, 10);
		JSlider conserveAmount = newSlider(1,10,7, 1);
		JSlider radiusSlider = newSlider(10,50,10, 5);
		Object[] mainScreenData = {
				"Amount of Objects:", amountOfBalls,
				"Gravity (10x):", gravitySlider,
				"K.E Collision Coefficient:", conserveAmount,
				"Object Radius:", radiusSlider
		};
		int confirm = showConfirmDialog(null, mainScreenData, "Number Base Converter", YES_NO_OPTION, PLAIN_MESSAGE, null);
		if (confirm != YES_OPTION) { return new HashMap<String,String>(); }
		System.out.println(amountOfBalls.getValue());
		Map<String,String> outValues = new HashMap<>();
		outValues.put("Gravity", String.valueOf((double) gravitySlider.getValue() / 10.0));
		outValues.put("Balls", String.valueOf((Integer) Math.round(amountOfBalls.getValue())));
		outValues.put("ConsAmount", String.valueOf(((double) conserveAmount.getValue() / 100.0)+0.9));

		Ball.GRAVITY = Double.parseDouble(outValues.get("Gravity"));
		Ball.conserveAmount = Double.parseDouble(outValues.get("ConsAmount"));
		int RADIUS = radiusSlider.getValue();
		BallFrame run = new BallFrame(WIDTH, HEIGHT, Integer.parseInt(outValues.get("Balls")), RADIUS);

		return outValues;
	}


	public static void main(String[] args) throws InterruptedException {
		Map<String, String> res = mainScreen(600,800);

		System.out.println(res);



	}
}