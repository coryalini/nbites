package nbtool.gui.utilitypanes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import nbtool.data.calibration.ColorParam;
import nbtool.gui.logviews.images.ImageDisplay;
import nbtool.gui.logviews.images.ImageDisplay.ImageDisplayAnnotator;
import nbtool.images.YUYV8888Image;
import nbtool.util.Debug;

public class YUVColorUtility extends UtilityParent {

	public YUVPixel lastClicked = null;

	public class YUVPixel {
		int y,u,v;
		YUVPixel(int y, int u, int v) {
			this.y = y;
			this.u = u;
			this.v = v;
		}

		@Override
		public String toString() {
			return String.format("{y%d,u%d,v%d}",y & 0xFF,u & 0xFF, v & 0xFF);
		}
	}

	private class YUVDisplay extends JFrame implements ImageDisplayAnnotator, ColorCalibrationListener {

		private YUVPixel[][] pixels = null;

		private ColorParam.Set set  = null;

		private BufferedImage create(int sliderVal) {
			BufferedImage bi = new BufferedImage(512, 512, BufferedImage.TYPE_4BYTE_ABGR);
			pixels = new YUVPixel[256][256];

	        for (int x = 0; x < 512; ++x) {
	        	for (int y = 0; y < 512; ++y) {
	        		byte Y = (byte) (sliderVal & 0xFF);
	        		byte U = (byte) (x / 2);
	        		byte V = (byte) (256 - (y / 2));

	        		pixels[x / 2][y / 2] = new YUVPixel(Y,U,V);
	        		bi.setRGB(x, y, YUYV8888Image.yuv444ToARGB888Pixel(Y, U, V));
	        	}
	        }

	        return bi;
		}

		@Override
		public void imageDisplayAnnotate(ImageDisplay source, Graphics g, BufferedImage bi) {

		}

		@Override
		public void utilityChanged(UtilityProvider<ColorParam.Set, ?> who, ColorParam.Set what) {

			Debug.print("utility changed");

			repaint();
		}

		public YUVDisplay() {
	        initComponents();

	        imageDisplay.setImage(create(0));
	        ySlider.addChangeListener(new ChangeListener(){

				@Override
				public void stateChanged(ChangeEvent e) {

					int y = ySlider.getValue();
					imageDisplay.setImage(create(y));

				}

	        });

	        imageDisplay.addMouseListener(new MouseAdapter(){
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		Point p = e.getPoint();
	        		if (pixels != null) {
	        			YUVPixel chsn = pixels[p.x / 2][(p.y / 2)];
	        			clickedLabel.setText("clicked: " + chsn.toString());
	        			lastClicked = chsn;
	        		}
	        	}
	        });

	        imageDisplay.addMouseMotionListener(new MouseMotionAdapter(){
	        	@Override
	        	public void mouseMoved(MouseEvent e) {
	        		Point p = e.getPoint();
	        		if (pixels != null) {
	        			YUVPixel chsn = pixels[p.x / 2][(p.y / 2)];
	        			mouseOverLabel.setText("mouse: " + chsn.toString());
	        		}
	        	}
	        });

	        imageDisplay.ida = this;

	        UtilityManager.ColorCalibrationUtility.listen(this);
	    }

	    /**
	     * This method is called from within the constructor to initialize the form.
	     * WARNING: Do NOT modify this code. The content of this method is always
	     * regenerated by the Form Editor.
	     */
	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">
	    private void initComponents() {
	        imageDisplay = new ImageDisplay(null);

	        ySlider = new javax.swing.JSlider();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jLabel5 = new javax.swing.JLabel();
	        mouseOverLabel = new javax.swing.JLabel();
	        clickedLabel = new javax.swing.JLabel();

	        setMinimumSize(new java.awt.Dimension(865, 600));
	        setPreferredSize(new java.awt.Dimension(865, 600));

	        imageDisplay.setBackground(new java.awt.Color(153, 255, 0));
	        imageDisplay.setForeground(new java.awt.Color(51, 255, 0));
	        imageDisplay.setMaximumSize(new java.awt.Dimension(512, 512));
	        imageDisplay.setMinimumSize(new java.awt.Dimension(512, 512));
	        imageDisplay.setPreferredSize(new java.awt.Dimension(512, 512));

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(imageDisplay);
	        imageDisplay.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 512, Short.MAX_VALUE)
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 0, Short.MAX_VALUE)
	        );

	        ySlider.setMajorTickSpacing(1);
	        ySlider.setMaximum(255);
	        ySlider.setMinorTickSpacing(1);
	        ySlider.setSnapToTicks(true);
	        ySlider.setValue(0);

	        jLabel1.setText("Y value [0,255]");

	        jLabel2.setText("U 0");

	        jLabel3.setText("U 255");

	        jLabel4.setText("V 255");

	        jLabel5.setText("V 0");

	        mouseOverLabel.setText("mouse");

	        clickedLabel.setText("click");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(20, 20, 20)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jLabel4)
	                    .addComponent(jLabel5))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel2)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(jLabel3))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel1)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(ySlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                    .addComponent(imageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(48, 48, 48)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(clickedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(mouseOverLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(ySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel1))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                        .addComponent(imageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGroup(layout.createSequentialGroup()
	                            .addComponent(jLabel4)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jLabel5)))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(mouseOverLabel)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(clickedLabel)))
	                .addGap(5, 5, 5)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel2)
	                    .addComponent(jLabel3))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        pack();
	    }// </editor-fold>

	    // Variables declaration - do not modify
	    private javax.swing.JLabel clickedLabel;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private ImageDisplay imageDisplay;
	    private javax.swing.JSlider ySlider;
	    private javax.swing.JLabel mouseOverLabel;
	}

	private YUVDisplay display = null;

	@Override
	public JFrame supplyDisplay() {
		if (display == null) {
			return (display = new YUVDisplay());
		}

		return display;
	}



	@Override
	public String purpose() {
		return "Show YUV colorspace";
	}


	@Override
	public char preferredMemnonic() {
		return 'y';
	}
}
