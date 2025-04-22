import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener {

    private BrickLayout layout;

    public DrawPanel() {
        this.addMouseListener(this);
        layout = new BrickLayout("src/bricks", 40, false);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        int[][] grid = layout.getBrickLayout();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                int x = 10 + c * 25;
                int y = 10 + r * 25;
                g.drawRect(x, y, 20, 20);
                if (grid[r][c] == 1) {
                    g2.setColor(Color.RED);
                    g2.fillRect(x, y, 20, 20);
                    g2.setColor(Color.BLACK);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        layout.doOneBrick();
        repaint();
    }

    @Override public void mousePressed(MouseEvent e) {

    }

    @Override public void mouseReleased(MouseEvent e) {

    }

    @Override public void mouseEntered(MouseEvent e) {

    }

    @Override public void mouseExited(MouseEvent e) {

    }
}
