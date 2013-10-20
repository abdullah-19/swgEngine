
package engine.utils;

public class Matriz {
    private int valor[][];
    
    /**
    * Construye una matriz del orden que se le indica
    * @param x
    * @param y 
    */
    
    public Matriz(int y, int x) {
        valor = new int[y][x];
    }

    public int getNumFilas(){
        return valor.length;
    }
    public int getNumColumnas(){
        return valor[0].length;
    }

    public int[][] getValor() {
        return valor;
    }
    
    public void asignarDatos(int[] vector) throws Matriz.MatrizException{  
        if (vector.length != getNumFilas()*getNumColumnas()) {
            throw new Matriz.MatrizException("El numero de valores pasados en el vector debe coincidir con el orden de la matriz");
        }
        
        int cont=0;
        for (int i = 0; i < getNumFilas(); i++) {
            for (int j = 0; j < getNumColumnas(); j++) {
                valor[i][j]=vector[cont++];
            }
        }
        
        
    }
    
    public void mostrar(){
        for (int i = 0; i < getNumFilas(); i++) {
            for (int j = 0; j < getNumColumnas(); j++) {
                System.out.print(" "+valor[i][j]);
                if(j==getNumColumnas()-1) 
                    System.out.println("");
            }
        }
    }
    /**
     * Suma la matriz con la pasada como argumento.
     * deben ser del mismo orden
     * @param x 
     */
    public void sumar(Matriz x) throws Matriz.MatrizException{
        if((this.getNumFilas()*this.getNumColumnas())!=(x.getNumFilas()*x.getNumColumnas())){
            throw new Matriz.MatrizException("No se pueden sumar matrices de distinto orden.");
        }
        for (int i = 0; i < getNumFilas(); i++) {
            for (int j = 0; j < getNumColumnas(); j++) {
                this.valor[i][j]+=x.getValor()[i][j];
            }
        }
    }
    /**
     * Transforma la matriz en su transpuesta.
     */
    public void transpuesta(){
        int aux[][]=valor.clone();
        valor= new int[getNumColumnas()][getNumFilas()];
        
        for(int j = 0; j < aux.length; j++){
            for(int i = 0; i < aux[0].length; i++){
                valor[i][j]=aux[j][i];
            }
        }
    }
    /**
     * Multiplica la propia matriz con la pasada como argumento.
     * @param x 
     */
    public void producto(Matriz x) throws Matriz.MatrizException{
        if(this.getNumColumnas() != x.getNumFilas()){
            throw new Matriz.MatrizException("No se puede multiplicar la matriz con la pasada como argumento. Comprueba el orden");
        }
        int suma = 0;
        int matProducto[][] = new int[this.getNumFilas()][x.getNumFilas()];
        for(int i = 0; i < this.getNumFilas(); i++){
            for(int j = 0; j < x.getNumFilas(); j++){
                suma = 0;
                for(int k = 0; k < x.getNumFilas(); k++){
                        suma += this.getValor()[i][k] * x.getValor()[k][j];
                }
                matProducto[i][j] = suma;
            }
        }
        this.valor=matProducto;
    }
    
    class MatrizException extends Exception{
        public MatrizException(String message) {
            super(message);
        }

        @Override
        public String getMessage() {
            return "Ocurrio un error en la Matriz:\n"+super.getMessage();
        }
        
        
    }
}
