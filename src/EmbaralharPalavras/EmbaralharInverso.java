package EmbaralharPalavras;

public class EmbaralharInverso implements Embaralhador{

    @Override
    public String embaralhar(String palavra) {
        return new StringBuilder(palavra).reverse().toString();
    }

}
