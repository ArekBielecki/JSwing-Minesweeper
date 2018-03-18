import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseActionHandler implements MouseListener {
    private GameGUI gameGUI;
    private GameLogics gameLogics;
    private GameBoard gameBoard;
    private int verticalPos;
    private int horizontalPos;

    public MouseActionHandler(int verticalPos, int horizontalPos, GameBoard gameBoard) {
        super();
        this.gameBoard = gameBoard;
        this.verticalPos = verticalPos;
        this.horizontalPos = horizontalPos;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
            if(!gameLogics.checkWinningCondition(gameBoard)&&!gameLogics.checkLosingCondition(gameBoard)){
                if (SwingUtilities.isLeftMouseButton(e)) {
                    gameBoard.leftMouseButtonAction(verticalPos, horizontalPos);
                }
                if (SwingUtilities.isRightMouseButton(e)) {
                    gameBoard.rightMouseButtonAction(verticalPos, horizontalPos);
                }
                if (SwingUtilities.isMiddleMouseButton(e)) {
                    gameBoard.middleMouseButtonAction(verticalPos, horizontalPos);
                }
                if(gameLogics.checkWinningCondition(gameBoard)){
                    gameGUI.setGameStatusInfo("You won!", Color.green);
                }
                if(gameLogics.checkLosingCondition(gameBoard)){
                    gameGUI.setGameStatusInfo("You lost!", Color.red);
                    gameBoard.revealAllMinedTiles();
                }
            }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
