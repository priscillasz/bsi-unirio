package ed1priscilla;


public class Blob {
    protected double x, y; // Variáveis das coordenadas x e y do ponto
    protected double r = 5; // Variável do raio
    protected double dx, dy, dr; // velocidade e crescimento

    // Construtor do blob sem parâmetros
    public Blob() {

    }

    // Construtor do blob com parâmetros x, y e raio
    public Blob(double initX, double initY, double initR) {
        this.x = initX;
        this.y = initY;
        this.r = initR;
    }

    // Getter do x: retorna o valor da coordenada x
    public double getX() {
        return x;
    }

    // Setter do x: Possibilita a troca do valor da coordenada x
    public void setX(double x) {
        this.x = x;
    }

    // Getter do y: retorna o valor da coordenada y
    public double getY() {
        return y;
    }

    // Setter do y: Possibilita a troca do valor da coordenada y
    public void setY(double y) {
        this.y = y;
    }

    // Setter do r: Possibilita a troca do valor do raio
    public void setR(double newR) {
        this.r = newR;
    }

    // Getter do r: retorna o valor do Raio
    public double getR() {
        return this.r;
    }

    // setter da velocidade do blob: permite alterar as coordenadas do blob.
    public void setVelocidade(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    // setter do crescimento do blob: permite alterar o tamanho do blob.
    public void setCrescimento(double dr) {
        this.dr = dr;
    }

    // método que atualiza a posição e o raio de acordo com a velocidade e o crescimento
    public void step() {
        x += dx;
        y += dy;
        r += dr;
    }

    // método que checa se o ponto está dentro do raio do centro do blob
    public void contains(double x2, double y2) {
        dx = x - x2;
        dy = y - y2;

        double diff; // variável que mantém o valor da distância do ponto ao centro
        diff = (dx * dx) + (dy * dy);

        // verifica se o ponto está dentro ou fora do círculo
        // se a distância do ponto ao centro for menor que o raio, está dentro. Se for maior ou igual, está fora.
        if (diff < r) {
            System.out.println("O ponto está dentro do raio.");
        } else {
            System.out.println("O ponto não está dentro do raio.");
        }
    }

    public static void main(String[] args) {

        // instância 1
        Blob bob = new Blob();
        bob.x = 10;
        bob.y = 20;

        System.out.println("bob is at ("+bob.x+","+bob.y+")");

        // settando o raio da instância bob
        bob.setR(10);

        System.out.println("bob's size is " + bob.getR());

        // instância 2
        Blob blob = new Blob(100, 50, 10);

        // checar se está dentro do raio do círculo do blob
        bob.contains(3, 4);

        // instância 3
        Blob alice = new Blob(33, 44, 5);
        // checar se está dentro do raio do círculo do blob
        alice.contains(3, 4);
    }
}