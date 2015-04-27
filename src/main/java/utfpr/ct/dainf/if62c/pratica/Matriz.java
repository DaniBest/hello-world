package utfpr.ct.dainf.if62c.pratica;

/**
 * Representa uma matriz de valores {@code double}.
 * @author Daniel Anderson de Freitas
 */
public class Matriz {
    
    // a matriz representada por esta classe
    private final double[][] mat;
    
    /**
     * Construtor que aloca a matriz.
     * @param m O número de linhas da matriz.
     * @param n O número de colunas da matriz.
     */
    public Matriz(int m, int n) {
        mat = new double[m][n];
    }
    
    /**
     * Retorna a matriz representada por esta classe.
     * @return A matriz representada por esta classe
     */
    public double[][] getMatriz() {
        return mat;
    }
    
/*    public void setMatriz(double m[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[j][i] = m[i][j];
            }
        }
    }
*/    
    /**
     * Retorna a matriz transposta.
     * @return A matriz transposta.
     */
    public Matriz getTransposta() {
        Matriz t = new Matriz(mat[0].length, mat.length);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                t.mat[j][i] = mat[i][j];
            }
        }
        return t;
    }
    
    /**
     * Retorna a soma desta matriz com a matriz recebida como argumento.
     * @param m A matriz a ser somada
     * @return A soma das matrizes
     */
    public Matriz soma(Matriz m) {
        Matriz soma = new Matriz(mat.length, mat[0].length);
        for (int i=0; i<soma.mat.length; i++) {
            for (int j=0; j<soma.mat[i].length; j++) {
                soma.mat[i][j] = m.mat[i][j] + mat[i][j];
            }
        }
        return soma;
    }

    /**
     * Retorna o produto desta matriz com a matriz recebida como argumento.
     * @param m A matriz a ser multiplicada
     * @return O produto das matrizes
     */
    public Matriz prod(Matriz m) {
        Matriz produto = new Matriz(mat.length, m.mat[0].length);
        double soma = 0;
        for (int i=0; i<produto.mat.length; i++) {
            for (int j=0; j<produto.mat[i].length; j++) {
                for (int k=0; k<mat[i].length; k++) {
                    soma += (mat[i][k]*m.mat[k][j]);
                }
                produto.mat[i][j] = soma;
                soma = 0;
            }
        }
        return produto;
    }

    /**
     * Retorna uma representação textual da matriz.
     * Este método não deve ser usado com matrizes muito grandes
     * pois não gerencia adequadamente o tamanho do string e
     * poderia provocar um uso excessivo de recursos.
     * @return Uma representação textual da matriz.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (double[] linha: mat) {
            s.append("[ ");
            for (double x: linha) {
                s.append(x).append(" ");
            }
            s.append("]");
        }
        return s.toString();
    }
    
}
