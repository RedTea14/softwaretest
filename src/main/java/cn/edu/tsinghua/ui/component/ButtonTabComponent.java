package cn.edu.tsinghua.ui.component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicButtonUI;

public class ButtonTabComponent extends JPanel {
	private static final long serialVersionUID = -2114200136808378037L;
	private final JTabbedPane pane;
	
	public ButtonTabComponent(JTabbedPane pane) {
		this.pane = pane;
		if (pane == null) {
			throw new NullPointerException("TabbedPane is null");
		}
		setOpaque(false);
		
		JLabel label = new JLabel() {
			private static final long serialVersionUID = -816499339552945328L;

			public String getText() {
				int i = ButtonTabComponent.this.pane.indexOfTabComponent(ButtonTabComponent.this);
				if (i != -1) {
					return ButtonTabComponent.this.pane.getTitleAt(i);
				}
				return null;
			}
		};
		add(label);
		
		JButton button = new TabButton();
		add(button);
	}
	
	private class TabButton extends JButton implements ActionListener {
		private static final long serialVersionUID = -3771727238789269079L;

		public TabButton() {
			int size = 17;
			setPreferredSize(new Dimension(size, size));
			setToolTipText("Close this tab");
			setUI(new BasicButtonUI());
			setContentAreaFilled(false);
			setFocusable(false);
			setBorder(BorderFactory.createEtchedBorder());
			setBorderPainted(false);
			addMouseListener(buttonMouseListener);
			setRolloverEnabled(true);
			addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int i = pane.indexOfTabComponent(ButtonTabComponent.this);
			if (i != -1) {
				pane.remove(i);
			}
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g.create();
			if (getModel().isPressed()) {
				g2.translate(1, 1);
			}
			g2.setStroke(new BasicStroke(2));
			g2.setColor(Color.BLACK);
			
			if (getModel().isRollover()) {
				g2.setColor(Color.MAGENTA);
			}
			
            int delta = 5;
            g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
            g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
			g2.dispose();
 		}
		
	}
	
	private final static MouseListener buttonMouseListener = new MouseAdapter() {
		public void mouseEntered(MouseEvent e) {
			Component component = e.getComponent();
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton)component;
				button.setBorderPainted(true);
			}
		}
		
		public void mouseExited(MouseEvent e) {
			Component component = e.getComponent();
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton)component;
				button.setBorderPainted(false);
			}
		}
	};
}
	
