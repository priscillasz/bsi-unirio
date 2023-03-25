package ed1priscilla;

public class BlobDriver2 {
    private Blob blob1, blob2;

    // construtor com 2 blobs como parâmetros
    public BlobDriver2(Blob blob1, Blob blob2) {
        this.blob1 = blob1;
        this.blob2 = blob2;
    }

    // Teste do driver
    public void teste() {
        blob1.setR(2 * blob2.getR());
        blob2.setVelocidade(3, 4);

        blob2.step();
        blob1.setCrescimento(10);
        blob1.step();

        System.out.println("Primeiro Blob: (" + blob1.getX() + "," +blob1.getY() + "); tamanho " + blob1.getR());
        System.out.println("Segundo Blob: (" + blob2.getX() + "," + blob2.getY()+ "); tamanho " + blob2.getR());
    }

    public static void main(String[] args) {
        // Criação de duas instâncias de blobs
        Blob bob = new Blob(10,20,15);
        Blob alice = new Blob(30,40,45);

        // Driver com os blobs
        BlobDriver2 driver = new BlobDriver2(bob, alice);

        // chamada do método que testa o driver
        driver.teste();
    }
}