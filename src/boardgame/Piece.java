package boardgame;

public abstract class Piece {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return board;
    }

    // retorna uma matriz booleana com os movimentos possíveis
    public abstract boolean[][] possibleMoves();

    // hook methods - gancho com a subclasse concreta da classe Piece
    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j]) {
                    return true; // se existir um true na matriz de movimentos possíveis, retorna true
                }
            }
        }
        return false;
    }

}
