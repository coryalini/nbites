package nbtool.gui.logviews.images;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Vector;
import java.util.ArrayList;
import java.util.List;

import nbtool.util.Logger;
import nbtool.data.Log;
import nbtool.data.SExpr;
import nbtool.gui.logviews.misc.ViewParent;
import nbtool.images.EdgeImage;
import nbtool.io.CommonIO.IOFirstResponder;
import nbtool.io.CommonIO.IOInstance;
import nbtool.io.CrossIO;
import nbtool.io.CrossIO.CrossFunc;
import nbtool.io.CrossIO.CrossInstance;
import nbtool.io.CrossIO.CrossCall;
import nbtool.util.Utility;

public class Calibration3View extends ViewParent implements IOFirstResponder {
	private static final long serialVersionUID = 1L;

	int width;
	int height;

	int displayw;
	int displayh;

	final int fieldw = 640;
	final int fieldh = 554;

	final int buffer = 5;

	double resize = 1;

	// Starting size. The larger the number, the smaller the field ratio
	final int startSize = 1;

	boolean click = false;
	boolean drag = false;

	// Click and release values
	int clickX1 = 0;
	int clickY1 = 0;
	int clickX2 = 0;
	int clickY2 = 0;

	// Field coordinate image upper left hand corder
	int fx0;
	int fy0;

	// Center of field cordinate system
	int fxc = displayw + buffer + fieldw/2; 
	int fyc = fieldh;

	BufferedImage originalImage;
	BufferedImage edgeImage;
	Vector<Double> lines;

	boolean calibrationSuccess;

	@Override
	public void setLog(Log newlog) {
		CrossInstance ci = CrossIO.instanceByIndex(0);
		if (ci == null)
			return;
		CrossFunc func = ci.functionWithName("calibration3");
		assert(func != null);

		CrossCall cc = new CrossCall(this, func, newlog);

		assert(ci.tryAddCall(cc));

		Vector<SExpr> vec = newlog.tree().recursiveFind("width");
		if (vec.size() > 0) {
			SExpr w = vec.get(vec.size()-1);
			width =  w.get(1).valueAsInt() / 2;
		} else {
			System.out.printf("COULD NOT READ WIDTH FROM LOG DESC\n");
			width = 320;
		}

		vec = newlog.tree().recursiveFind("height");
		if (vec.size() > 0) {
			SExpr h = vec.get(vec.size()-1);
			height = h.get(1).valueAsInt() / 2;
		} else {
			System.out.printf("COULD NOT READ HEIGHT FROM LOG DESC\n");
			height = 240;
		}

		displayw = width*2;
		displayh = height*2;

		fx0 = displayw + buffer;
		fy0 = 0;

		fxc = displayw + buffer + fieldw/2; 
		fyc = fieldh;

		originalImage = Utility.biFromLog(newlog);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Font f = g.getFont();
		Font calFont = f.deriveFont( (float) f.getSize() * 1.5f);
		g.setFont(calFont);
		if (originalImage != null) {
			if (calibrationSuccess) {
				g.setColor(Color.GREEN);
				g.drawString("calibrationSuccess", originalImage.getWidth(), 10);
			} else {
				g.setColor(Color.RED);
				g.drawString("calibrationFailure", originalImage.getWidth(), 10);
			}
		}

		g.setFont(f);

		if (edgeImage != null) { 
			g.drawImage(originalImage, 0, 0, displayw, displayh, null);
			g.drawImage(edgeImage, 0, displayh + buffer, displayw, displayh, null);

			//            g.setColor(new Color(90, 130, 90));
			//            g.fillRect(displayw + buffer, 0, fieldw, fieldh);
			//
			//            int[] xPoints1 = {0 + fx0, 0 + fx0, fieldw/2 + fx0};
			//            int[] yPoints1 = {2, fieldh, fieldh};
			//            int[] xPoints2 = {fieldw + fx0, fieldw/2 + fx0, fieldw + fx0};
			//            int[] yPoints2 = {2, fieldh, fieldh};
			//            int n = 3;
			//            g.setColor(new Color(46, 99, 28));
			//            g.fillPolygon(xPoints1, yPoints1, n);
			//            g.fillPolygon(xPoints2, yPoints2, n);
			//
			//            g.setColor(Color.lightGray);
			//            g.fillOval(fxc - 30, fyc - 20, 60, 40);

			// Get hough line data from buffer
			for (int i = 0; i < lines.size(); i += 10) {
				double icR = lines.get(i);
				double icT = lines.get(i + 1);
				double icEP0 = lines.get(i + 2);
				double icEP1 = lines.get(i + 3);
				double houghIndex = lines.get(i + 4);
				double fieldIndex = lines.get(i + 5);
				double fcR = lines.get(i + 6);
				double fcT = lines.get(i + 7);
				double fcEP0 = lines.get(i + 8);
				double fcEP1 = lines.get(i + 9);

				// Draw it in image coordinates
				if (fieldIndex == -1)
					g.setColor(Color.red);
				else
					g.setColor(Color.blue);

				double x0 = 2*icR * Math.cos(icT) + originalImage.getWidth() / 2;
				double y0 = -2*icR * Math.sin(icT) + originalImage.getHeight() / 2;
				int x1 = (int) Math.round(x0 + 2*icEP0 * Math.sin(icT));
				int y1 = (int) Math.round(y0 + 2*icEP0 * Math.cos(icT));
				int x2 = (int) Math.round(x0 + 2*icEP1 * Math.sin(icT));
				int y2 = (int) Math.round(y0 + 2*icEP1 * Math.cos(icT));

				g.drawLine(x1, y1, x2, y2);

				// Image view line labels 
				double xstring = (x1 + x2) / 2;
				double ystring = (y1 + y2) / 2;

				double scale = 0;
				if (icR > 0)
					scale = 10;
				else
					scale = 3;
				xstring += scale*Math.cos(icT);
				ystring += scale*Math.sin(icT);

				g.drawString(Integer.toString((int) houghIndex) + "/" + Integer.toString((int) fieldIndex), 
						(int) xstring, 
						(int) ystring);


				// Calculate field coordinates to find resize value
				x0 =  startSize*fcR * Math.cos(fcT) + displayw + buffer + fieldw/2;
				y0 = -startSize*fcR * Math.sin(fcT) + fieldh;
				x1 = (int) Math.round(x0 + startSize*fcEP0 * Math.sin(fcT));
				y1 = (int) Math.round(y0 + startSize*fcEP0 * Math.cos(fcT));
				x2 = (int) Math.round(x0 + startSize*fcEP1 * Math.sin(fcT));
				y2 = (int) Math.round(y0 + startSize*fcEP1 * Math.cos(fcT));

				//Scale down if a line is outside the view, but not if its too far (false field line)
				// if (y1 < 0 && y1 > -2000) {
				//     resize = Math.min(resize, (double)fieldh/(-y1 + fieldh));
				// }
				// if (y2 < 0 && y2 > -2000) {
				//     resize = Math.min(resize, (double)fieldh/(-y2 + fieldh));
				// }

				// // TODO: Don't draw it if it's way out
				// if (y1 < -3500) {
				//     lines.set(i+4, -1.0);
				// }
				// if (y2 < -3500) {
				//     lines.set(i+4, -1.0);
				// }
			}

			List<Double> drawn = new ArrayList<Double>();

			// Loop through again to draw lines in field space with calucluated resize value
			for (int i = 0; i < lines.size(); i += 10) {
				double houghIndex = lines.get(i + 4);

				if (houghIndex != -1) {
					double fieldIndex = lines.get(i + 5);
					double fcR = lines.get(i + 6);
					double fcT = lines.get(i + 7);
					double fcEP0 = lines.get(i + 8);
					double fcEP1 = lines.get(i + 9);

					// Draw it in field coordinates
					if (fieldIndex >= 0)
						g.setColor(Color.white);
					else
						g.setColor(Color.red);

					// Recalculate with resize
					double x0 =  startSize*resize*fcR * Math.cos(fcT) + displayw + buffer + fieldw/2;
					double y0 = -startSize*resize*fcR * Math.sin(fcT) + fieldh;
					int x1 = (int) Math.round(x0 + startSize*resize*fcEP0 * Math.sin(fcT));
					int y1 = (int) Math.round(y0 + startSize*resize*fcEP0 * Math.cos(fcT));
					int x2 = (int) Math.round(x0 + startSize*resize*fcEP1 * Math.sin(fcT));
					int y2 = (int) Math.round(y0 + startSize*resize*fcEP1 * Math.cos(fcT));

					g.drawLine(x1, y1, x2, y2);

					// Draw line label
					if (fieldIndex >= 0 && !drawn.contains(fieldIndex)) {
						int xMid = (x1 + x2) / 2;
						int yMid = (y1 + y2) / 2;
						g.drawString(Integer.toString((int)fieldIndex), xMid, yMid + 10);
						drawn.add(fieldIndex);
					}
				}
			}

		}
	}

	public Calibration3View() {
		super();
		setLayout(null);
		lines = new Vector<Double>();
	}

	@Override
	public void ioFinished(IOInstance instance) {}

	@Override
	public void ioReceived(IOInstance inst, int ret, Log... out) {

		//Simple hack for now.
		calibrationSuccess = (ret == 7);

		EdgeImage ei = new EdgeImage(width, height,  out[5].bytes);
		edgeImage = ei.toBufferedImage();
		repaint();

		// TODO refactor. Protobuff?
		lines = new Vector<Double>();
		byte[] lineBytes = out[6].bytes;
		int numLines = lineBytes.length / (9 * 8);
		Logger.logf(Logger.INFO, "%d field lines expected.", numLines);
		try {
			DataInputStream dis = new DataInputStream(new ByteArrayInputStream(lineBytes));
			for (int i = 0; i < numLines; ++i) {
				lines.add(dis.readDouble()); // image coord r
				lines.add(dis.readDouble()); // image coord t
				lines.add(dis.readDouble()); // image coord ep0
				lines.add(dis.readDouble()); // image coord ep1
				lines.add((double)dis.readInt()); // hough index
				lines.add((double)dis.readInt()); // fieldline index
				lines.add(dis.readDouble()); // field coord r
				lines.add(dis.readDouble()); // field coord t
				lines.add(dis.readDouble()); // field coord ep0
				lines.add(dis.readDouble()); // field coord ep1
			}
		} catch (Exception e) {
			Logger.logf(Logger.ERROR, "Conversion from bytes to hough coord lines in LineView failed.");
			e.printStackTrace();
		}
	}

	@Override
	public boolean ioMayRespondOnCenterThread(IOInstance inst) {
		return false;
	}
}